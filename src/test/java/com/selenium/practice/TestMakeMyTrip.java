package com.selenium.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestMakeMyTrip {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = WebDriverManager.edgedriver().create();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void handleAutoSuggestionDropdown() throws InterruptedException{
        //sleep is only to see action
        driver.get("https://www.makemytrip.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='From']")).click();
        WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
        Thread.sleep(2000);
        from.sendKeys("Sydney");
        Thread.sleep(2000);
        from.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        from.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }
}
