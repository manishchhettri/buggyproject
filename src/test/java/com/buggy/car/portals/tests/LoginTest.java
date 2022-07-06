package com.buggy.car.portals.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.buggy.car.portals.beans.LoginBean;
import com.buggy.car.portals.pages.LoginPage;

@Test()
public class LoginTest extends BuggyTestSetup {

    WebDriver webDriver;
    LoginBean loginBean;
    LoginPage loginPage;
    private void setDefaultValues(){
        loginBean = new LoginBean();
        loginBean.setName("midhunjose");
        loginBean.setPassword("P@ssw0rd1");

    }

	@BeforeClass
    public void setUp(){
        webDriver = brew();
        loginPage = new LoginPage(webDriver);
    }

    @Test
    public void test_valid_login(){
        webDriver.get("https://buggy.justtestit.org/");
        setDefaultValues();
        loginPage.setWebLoginTxt(loginBean.getName());
        loginPage.setWebPasswordTxt(loginBean.getPassword());
        loginPage.clickWebLoginBtn();
        
        Assert.assertTrue(loginPage.validateLoginGreeting("Midhun"), "Invalid login");
    }

    @Test
    public void test_invalid_password(){
        setDefaultValues();
        loginBean.setPassword("WrongPassword");
        loginPage.setWebLoginTxt(loginBean.getName());
        loginPage.setWebPasswordTxt(loginBean.getPassword());
        loginPage.clickWebLoginBtn();
        Assert.assertTrue(loginPage.validateInValidLogin("Invalid username/password"), "Invalid login");
    }
    @Test
    public void test_invalid_username(){
        setDefaultValues();
        loginBean.setName("WrongName");
        loginPage.setWebLoginTxt(loginBean.getName());
        loginPage.setWebPasswordTxt(loginBean.getPassword());
        loginPage.clickWebLoginBtn();
    }

    @Test
    public void test_blank_username(){
        setDefaultValues();
        loginBean.setName("");
        loginPage.setWebLoginTxt(loginBean.getName());
        loginPage.setWebPasswordTxt(loginBean.getPassword());
        loginPage.clickWebLoginBtn();
    }

	@AfterClass
    public void tearDown(){
        if (webDriver !=null) {
            webDriver.quit();
        }
    }
}
