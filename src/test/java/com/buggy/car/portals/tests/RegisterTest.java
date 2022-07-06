package com.buggy.car.portals.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.buggy.car.portals.beans.RegisterBean;
import com.buggy.car.portals.pages.LoginPage;
import com.buggy.car.portals.pages.RegisterPage;

public class RegisterTest extends BuggyTestSetup {

    WebDriver webDriver;
    LoginPage loginPage;
    RegisterBean registerBean;
    RegisterPage registerPage;

    private void setDefaultValues(){
        registerBean = new RegisterBean();
        registerBean.setLogin("skodarapid"+ Math.random());
        registerBean.setFirstName("Skoda");
        registerBean.setLastName("Rapid");
        registerBean.setPassword("P@ssw0rd1");
        registerBean.setConfirmPassword("P@ssw0rd1");
    }

	@BeforeClass
    public void setUp(){
        webDriver = brew();
        loginPage = new LoginPage(webDriver);
        registerPage = new RegisterPage(webDriver);
    }

    @Test
    public void test_valid_register(){
        webDriver.get("https://buggy.justtestit.org/");
        setDefaultValues();
        loginPage.clickWebRegisterNavBtn();
        registerPage.setWebRegLoginTxt(registerBean.getLogin());
        registerPage.setWebRegFirstNameTxt(registerBean.getFirstName());
        registerPage.setWebRegLastNameTxt(registerBean.getLastName());
        registerPage.setWebRegPasswordTxt(registerBean.getPassword());
        registerPage.setWebRegConfirmPasswordTxt(registerBean.getConfirmPassword());
        registerPage.clickWebRegisterBtnSubmit();
        Assert.assertTrue(registerPage.validateValidRegister("Registration is successful"), "Register Failed");
    }

	@AfterClass
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
