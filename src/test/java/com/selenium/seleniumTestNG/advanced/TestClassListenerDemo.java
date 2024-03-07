package com.selenium.seleniumTestNG.advanced;

import com.selenium.seleniumTestNG.advanced.commons.BaseClassTest;
import org.testng.annotations.Test;

public class TestClassListenerDemo extends BaseClassTest {

    @Test
    public void launchApp(){
        driver.get("https://www.ebay.com/");
        //only for training
//        Assert.assertTrue(false);
    }
}
