package com.selenium.seleniumFramework.testCase;

import com.selenium.seleniumFramework.base.BaseClassTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseClassTest {

//    @Test
//    public void login(){
//        clickOnSignIn();
//        clickOnLoginId();
//        writeLoginId("tjablonski1990@gmail.com");
//    }

    @Parameters({"user","password"})
    @Test
    public void loginToZoho(String user,String password) {
        driver.findElement(By.xpath("//a[text()='Sign in']")).click();
        loginInToZoho(user,password);
        boolean viewSite = driver.findElement(By.xpath(" //p[text()=' Some of our most popular apps']")).isDisplayed();
        Assert.assertTrue(viewSite);
    }
}
