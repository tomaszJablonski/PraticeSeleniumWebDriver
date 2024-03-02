package com.selenium.seleniumTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestEbayAndBATM {

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

    @Test(priority = 5)
    public void verifyTitle(){
        String expectedTitle = "Electronics, Cars, Fashion, Collectibles & More | eBay";
        driver.get("https://www.ebay.com/");
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
