package com.selenium.seleniumTestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test(groups = "user-registration")
public class GroupDemoTest {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = WebDriverManager.edgedriver().create();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void closeBrowse(){
        driver.quit();
    }

    @Test(groups = "regression")
    public void aTest1(){
        System.out.println("Test1 - R");
    }

    @Test(groups = {"regression", "bvt"})
    public void aTest2(){
        System.out.println("Test2 - R and B");
    }

    @Test(groups = "bvt")
    public void bTest1(){
        System.out.println("Test1 - B");
    }

    @Test(groups = "bvt")
    public void bTest2(){
        System.out.println("Test2 - B");
    }
}
