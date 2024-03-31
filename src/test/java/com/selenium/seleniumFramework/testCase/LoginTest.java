package com.selenium.seleniumFramework.testCase;

import com.selenium.seleniumFramework.base.BaseClassTest;
import com.selenium.seleniumFramework.utilites.ReadXLSData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseClassTest {

    //not recommended because locator is hard coding
    @Parameters({"user", "password"})
    @Test(enabled = false)
    public void loginToZoho(String user, String password) {
        driver.findElement(By.xpath("//a[text()='Sign in']")).click();
        loginInToZoho(user, password);
        boolean viewSite = driver.findElement(By.xpath("//p[text()=' Some of our most popular apps']")).isDisplayed();
        Assert.assertTrue(viewSite);
    }

    //locator from properties - recommended *!!!*
    @Parameters({"user", "password"})
    @Test(enabled = false)
    public void loginToZoho2(String user, String password) {
        driver.findElement(By.xpath(propertiesLocators.getProperty("sign_in"))).click();
        loginInToZohoProperties(user, password);
        boolean viewSite = driver.findElement(By.xpath(propertiesLocators.getProperty("viewSite"))).isDisplayed();
        Assert.assertTrue(viewSite);
    }

    //Data Driven Testing
    @Test(enabled = false,dataProvider = "test data Login")
    public void loginToZoho3(String user, String password) {
        driver.findElement(By.xpath(propertiesLocators.getProperty("sign_in"))).click();
        loginInToZohoProperties(user, password);
        boolean viewSite = driver.findElement(By.xpath(propertiesLocators.getProperty("viewSite"))).isDisplayed();
        Assert.assertTrue(viewSite);
    }

    //only for training hard coding - not recommended
    @DataProvider(name = "test data Login")
    public Object[][] testDataLogin() {
        return new Object[][]
                {
                        {"tjablonskiasdom", "Test123testqwe#"},
                        {"tjablonski199assl.com", "Test12wdfv3test#"},
                        {"tjablonski1990@gmaidwel.com", "Test1asdwe23test#"},
                        {"tjablonski1990@gmail.com", "Test123test#"}
                };
    }

    //right test for Login !!!
    @Test(dataProviderClass = ReadXLSData.class, dataProvider = "Data Login from Xls")
    public void loginToZoho4(String user, String password) {
        driver.findElement(By.xpath(propertiesLocators.getProperty("sign_in"))).click();
        loginInToZohoProperties(user, password);
        boolean viewSite = driver.findElement(By.xpath(propertiesLocators.getProperty("viewSite"))).isDisplayed();
        Assert.assertTrue(viewSite);
    }
}