package com.selenium.seleniumTestNG.advanced.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClassTest {

    public static WebDriver driver = null;

    @BeforeSuite
    public void launchBrowser(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }

    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}
