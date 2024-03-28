package com.selenium.seleniumFramework.testCase;

import com.selenium.seleniumFramework.base.BaseClassTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseClassTest {


    @Parameters({"user", "password"})
    @Test(enabled = false)
    public void loginToZoho(String user, String password) {
        driver.findElement(By.xpath("//a[text()='Sign in']")).click();
        loginInToZoho(user, password);
        boolean viewSite = driver.findElement(By.xpath("//p[text()=' Some of our most popular apps']")).isDisplayed();
        Assert.assertTrue(viewSite);
    }

    @Parameters({"user", "password"})
    @Test
    public void loginToZoho2(String user, String password) {
        driver.findElement(By.xpath(propertiesLocators.getProperty("sign_in"))).click();
        loginInToZohoProperties(user, password);
        boolean viewSite = driver.findElement(By.xpath(propertiesLocators.getProperty("viewSite"))).isDisplayed();
        Assert.assertTrue(viewSite);
    }

}