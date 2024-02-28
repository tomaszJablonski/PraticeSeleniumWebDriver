package com.selenium.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestTheInternet {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(TestTheInternet.class.getName());

        WebDriverManager.chromedriver().setup();

//        System.setProperty("webdriver.chrome.driver","X:\\NAUKA TESTOWANIA\\driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        logger.log(Level.INFO, "***** I load the site *****");
        driver.get("https://the-internet.herokuapp.com/?ref=hackernoon.com");
        logger.log(Level.INFO, "I am looking for a text A/B Testing");
        driver.findElement(By.linkText("A/B Testing")).isDisplayed();
        logger.log(Level.INFO, "I click on text A/B Testing");
        driver.findElement(By.linkText("A/B Testing")).click();
        logger.log(Level.INFO, "Text A/B Test Control is displayed");
        driver.findElement(By.cssSelector("h3")).isDisplayed();
        logger.log(Level.INFO, "The program is over");

        driver.close();
        driver.quit();
    }
}