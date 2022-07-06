package com.buggy.car.portals.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.buggy.car.portals.pages.BuggyCarsVotePage;
import com.buggy.car.portals.pages.LoginPage;

public class BuggyCarsVoteTest extends BuggyTestSetup {
    WebDriver webDriver;
    LoginPage loginPage;
    BuggyCarsVotePage buggyCarsVotePage;

	@BeforeClass
    public void setUp(){
       webDriver = brew();
        loginPage = new LoginPage(webDriver);
        buggyCarsVotePage = new BuggyCarsVotePage(webDriver);
    }

    @Test
    public void test_voting(){
        BuggyUtil buggyUtil = new BuggyUtil();
        buggyUtil.registerAndLogin(webDriver);

        buggyCarsVotePage.clickWebBuggyRatingBtn();
        buggyCarsVotePage.clickWebAllCarModelsImage();
        buggyCarsVotePage.clickWebViewMoreLink();
        String currentVoteCount = buggyCarsVotePage.getWebVotesCount().getText();
        buggyUtil.buggySleep();
        buggyCarsVotePage.setWebComments("Recent Vote" + currentVoteCount);
        buggyUtil.buggySleep();
        buggyCarsVotePage.clickWebVoteBtn();
        buggyUtil.buggySleep();
        String newVoteCount = buggyCarsVotePage.getWebVotesCount().getText();
        System.out.println(currentVoteCount);
        System.out.println(newVoteCount);
        Assert.assertTrue(Integer.parseInt(currentVoteCount)+1 == Integer.parseInt(newVoteCount));
    }
	@AfterClass
    public void tearDown(){
        if (webDriver !=null) {
            webDriver.quit();
        }
    }

}
