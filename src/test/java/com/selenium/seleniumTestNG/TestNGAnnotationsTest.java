package com.selenium.seleniumTestNG;

import com.selenium.seleniumTestNG.commons.CommonDataSetup;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Test(groups = "user-registration")
public class TestNGAnnotationsTest extends CommonDataSetup {

    WebDriver driver;



    @BeforeClass
    public void beforeClass() {
        System.out.println("Run this before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Run this after class");
    }

    @BeforeTest
    public void setup() {
        System.out.println("Run driver");
        driver = WebDriverManager.edgedriver().create();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void closeBrowse() {
        System.out.println("Close driver");
        driver.quit();
    }

    @BeforeGroups(value = "regression")
    public void beforeGroupsR() {
        System.out.println("Starts groups regression");
    }

    @AfterGroups(value = "regression")
    public void afterGroupsR() {
        System.out.println("Stops groups regression");
    }

    @BeforeGroups(value = "bvt")
    public void beforeGroupBVT() {
        System.out.println("Starts groups BVT");
    }

    @AfterGroups(value = "bvt")
    public void afterGroupBVT() {
        System.out.println("Stops groups BVT");
    }

    @Test(groups = "regression")
    public void aTest1() {
        System.out.println("Test1 - R");
    }

    @Test(groups = {"regression", "bvt"})
    public void aTest2() {
        System.out.println("Test2 - R and B");
    }

    @Test(groups = "bvt")
    public void bTest1() {
        System.out.println("Test1 - B");
    }

    @Test(groups = "bvt")
    public void bTest2() {
        System.out.println("Test2 - B");
    }
}
