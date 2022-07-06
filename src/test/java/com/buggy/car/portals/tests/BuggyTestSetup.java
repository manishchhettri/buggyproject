package com.buggy.car.portals.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BuggyTestSetup {

public WebDriver webDriver;
public WebDriver brew(){
    //Create a WebDriver to interact with the Chrome Browser
    WebDriverManager.chromedriver().setup();
    webDriver = new ChromeDriver();
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    webDriver.get("https://buggy.justtestit.org/");
    return webDriver;
}

}
