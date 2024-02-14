package com.selenium.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestABTesting {

    Logger logger;
    WebDriver driver;

    @BeforeEach
    void setup() {
        //Nie potrzebuje tego ponieważ mam WebDriverManagera
        //On automatycznie pobierze to co trzeba
        //        System.setProperty("webdriver.chrome.driver","X:\\NAUKA TESTOWANIA\\driver\\chromedriver.exe");
        driver = WebDriverManager.chromedriver().create();
        driver.manage()
                .window()
                .maximize();
        logger = Logger.getLogger(ABTesting.class.getName());

    }

    @AfterEach
    void closeBrowser() {
        driver.quit(); //wyłącze przeglądarke całkowice
//        driver.close(); wyłącz tylko aktualne okno lub jeżeli jest to ostatnie okno to kończy się test
    }

    @Test
    void searchTextInABTesting() {
        logger.log(Level.INFO, "***** I load the site *****");
        driver.get("https://the-internet.herokuapp.com/?ref=hackernoon.com");
        String title = driver.getTitle();
        logger.log(Level.INFO, title);
        String pageSource = driver.getPageSource();
        logger.log(Level.INFO, pageSource);
//        driver.navigate().back(); tak jak w przeglądarce są strzałki do przodu
//        driver.navigate().forward(); i cofanie strony
//        driver.navigate().to("url"); albo url podajemy
        logger.log(Level.INFO, "I am looking for a text A/B Testing");
        driver.findElement(By.linkText("A/B Testing")).isDisplayed();
        logger.log(Level.INFO, "I click on text A/B Testing");
        driver.findElement(By.linkText("A/B Testing")).click();
        logger.log(Level.INFO, "Text A/B Test Control is displayed");
        boolean h3 = driver.findElement(By.cssSelector("h3")).isDisplayed();
        assertTrue(h3, "A/B Test Variation 1");
        logger.log(Level.INFO, "The program is over");
    }
}