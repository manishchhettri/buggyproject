package com.buggy.car.portals.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuggyCarsRatingPage {

    private WebDriver webDriver;

    @FindBy(xpath = "/html/body/my-app/div/main/my-overall/div/div/table/thead/tr/th[4]/a")
    WebElement webRankBtn;

    public BuggyCarsRatingPage(WebDriver driver) {

        //Set the Web Driver for this class to use the existing webdriver created in buggytest to interact with the browser.
        this.webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }
    public void clickWebRankBtn() {
        this.webRankBtn.click();
    }
}
