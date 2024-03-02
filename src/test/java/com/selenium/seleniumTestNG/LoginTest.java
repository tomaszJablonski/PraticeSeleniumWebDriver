package com.selenium.seleniumTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    //https://testng.org/#_annotations

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = WebDriverManager.edgedriver().create();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void quitBrowser() {
        driver.quit();
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
}
