package com.selenium.seleniumTestNG.advanced;

import com.selenium.seleniumTestNG.advanced.commons.BaseClassTest;
import com.selenium.seleniumTestNG.advanced.commons.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClassListenerDemo extends BaseClassTest {

    //Retry for simple class use in Test
    //For retry for all tests use Listeners in testngADV.xml
    @Test(retryAnalyzer = Retry.class)
    public void launchApp(){
        driver.get("https://www.ebay.com/");
//        only for training
        Assert.assertTrue(false);
    }

    @Test()
    public void launchApp2(){
        driver.get("https://www.ebay.com/");
//        only for training
        Assert.assertTrue(false);
    }
}
