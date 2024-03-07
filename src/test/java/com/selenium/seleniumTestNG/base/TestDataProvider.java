package com.selenium.seleniumTestNG.base;


import com.selenium.seleniumTestNG.base.commons.DateProviders;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDataProvider {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = WebDriverManager.edgedriver().create();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

    @Test(dataProvider = "credentials", dataProviderClass = DateProviders.class)
    public void test(String username, String password) {
        System.out.println(username + " " + password);
    }

    @Test(dataProvider = "credentials", dataProviderClass = DateProviders.class)
    public void test1(String username, String password, String test) {
        System.out.println(username + " " + password + " " + test);
    }

    @Test(dataProvider = "credentials", dataProviderClass = DateProviders.class)
    public void test2(String username, String password, String test, String message) {
        System.out.println(username + " " + password + " " + test + " " + message);
    }

    @Test(dataProvider = "credentialsSwabLags", dataProviderClass = DateProviders.class)
    public void sauceLabsLogin(String username, String password) {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }
}