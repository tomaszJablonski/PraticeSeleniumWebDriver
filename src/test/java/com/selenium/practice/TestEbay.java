package com.selenium.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestEbay {

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
    public void mouseHover(){
        //Test dotyczy elementów na które najżdżamy myszką
        // i rozwija się coś innego pod nimi
        driver.get("https://www.ebay.com/");
        WebElement electronicElement = driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[4]/a"));

        Actions actions = new Actions(driver);
        actions.moveToElement(electronicElement).perform();
    }
}
