package com.buggy.car.portals.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.buggy.car.portals.pages.BuggyCarsRatingPage;

public class BuggyCarRatingSortTest extends BuggyTestSetup {
    WebDriver webDriver;
    BuggyCarsRatingPage buggyCarsRatingPage;

	@BeforeClass
    public void setUp(){
        webDriver = brew();
        buggyCarsRatingPage = new BuggyCarsRatingPage(webDriver);
    }

    @Test
    public void test_valid_rank_sort(){
        webDriver.get("https://buggy.justtestit.org/overall");
        buggyCarsRatingPage.clickWebRankBtn();

        BuggyUtil buggyUtil = new BuggyUtil();
        buggyUtil.buggySleep();

        List<WebElement> ratingList = webDriver.findElements(By.xpath("/html/body/my-app/div/main/my-overall/div/div/table/tbody/tr"));

        int rank = 1;
        for (WebElement row : ratingList) {
            String cellValue = row.findElement(By.xpath("/html/body/my-app/div/main/my-overall/div/div/table/tbody/tr[" + rank + "]/td[4]")).getText();
            Assert.assertTrue(Integer.parseInt(cellValue) == rank, "Sorting by rank did not sort correctly");
            rank++;
        }
    }

	@AfterClass
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
