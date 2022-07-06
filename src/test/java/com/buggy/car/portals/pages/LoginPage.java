package com.buggy.car.portals.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    private WebDriver webDriver;

    @FindBy(xpath = "/html/body/my-app/header/nav/div/my-login/div/form/a")
    WebElement webRegNavBtn;

    @FindBy(xpath = "/html/body/my-app/header/nav/div/my-login/div/form/div/input[1]")
    WebElement webLoginTxt;

    @FindBy(xpath = "/html/body/my-app/header/nav/div/my-login/div/form/div/input[2]")
    WebElement webPasswordTxt;

    @FindBy(xpath = "/html/body/my-app/header/nav/div/my-login/div/form/button")
    WebElement webLoginBtn;

    @FindBy(xpath = "//my-login/div/ul/li[1]/span")
    WebElement webLoginGreeting;

    @FindBy(xpath = "//html/body/my-app/header/nav/div/my-login/div/form/div/span")
    WebElement webInValidWarningLogin;

    public LoginPage(WebDriver driver) {

        //Set the Web Driver for this class to use the existing webdriver created in buggytest to interact with the browser.
        this.webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }

    public void setWebLoginTxt(String webLoginTxt) {
        this.webLoginTxt.clear();
        this.webLoginTxt.sendKeys(webLoginTxt);
    }

    public void setWebPasswordTxt(String webPasswordTxt) {
        this.webPasswordTxt.clear();
        this.webPasswordTxt.sendKeys(webPasswordTxt);
    }

    public void clickWebLoginBtn() {
        this.webLoginBtn.click();
    }

    public boolean validateLoginGreeting(String firstName) {
        if(webLoginGreeting.getText().contains(firstName))
            return true;

        return false;
    }

    public boolean validateInValidLogin(String warningMessage) {
        if(webInValidWarningLogin.getText().contains(warningMessage))
            return true;

        return false;
    }

    public void clickWebRegisterNavBtn(){
        this.webRegNavBtn.click();
    }
}
