package com.selenium.seleniumTestNG.base;

import com.selenium.seleniumTestNG.base.commons.CommonDataSetup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestEbayAndBATM extends CommonDataSetup {

    //https://testng.org/#_annotations
    //Before/After Test - wykona się tylko raz na początku/końcu
    //Before/After Method - wykona sie za każdym razem gdy uruchomi się test case

    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.out.println("---Starts tests---");
        driver = WebDriverManager.edgedriver().create();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void quitBrowser() {
        driver.quit();
        System.out.println("---End the tests---");
    }

    @BeforeMethod
    public void exampleBeforeMethod(){
        System.out.println("****exampleBeforeMethod****");
    }

    @AfterMethod
    public void exampleAfterMethod(){
        System.out.println("****exampleAfterMethod****");
    }

    @Test(priority = 2, testName = "login1", description = "test case XRay login1")
    public void loginTest() {
        System.out.println("Login");
    }

    @Test(priority = 1, testName = "logout1", description = "test case XRay logout1")
    public void logoutTest(){
        System.out.println("Logout");
    }

    @Test(priority = 3, testName = "login2")
    public void loginTest2() {
        System.out.println("Login");
    }

    @Test(priority = 4, testName = "logout2")
    public void logoutTest2(){
        System.out.println("Logout");
    }

    @Test(priority = 5, testName = "Hard Assertion")
    public void verifyTitleHardAssertion(){
        //Hard-jak wywali się na pierwszym to już nie pójdzie dalej
        String expectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
        String expectedText = "Search";
        driver.get("https://www.ebay.com/");
        String actualTitle = driver.getTitle();
        String actualText = driver.findElement(By.xpath("//input[@value='Search']")).getAttribute("value");
        System.out.println("Verifying title");
        Assert.assertEquals(actualTitle, expectedTitle, "This message show when test fail");
        System.out.println("Verifying text");
        Assert.assertEquals(actualText, expectedText, "Text verification failed");
    }

    @Test(priority = 5, testName = "Soft Assertion")
    public void verifyTitleAndSearchSoftAssertion(){
        /* Soft - sprawdzi wszystkie asserty i wywali tylko te które faktycznie
        nie są dobre
         */

        SoftAssert softAssert = new SoftAssert();
        String expectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
        String expectedText = "Search";
        driver.get("https://www.ebay.com/");
        String actualTitle = driver.getTitle();
        String actualText = driver.findElement(By.xpath("//input[@value='Search']")).getAttribute("value");
        System.out.println("Verifying title");
        softAssert.assertEquals(actualTitle, expectedTitle, "This message show when test fail");
        System.out.println("Verifying text");
        softAssert.assertEquals(actualText, expectedText, "Text verification failed");
        softAssert.assertAll();
    }
}
