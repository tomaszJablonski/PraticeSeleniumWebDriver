package com.selenium.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestEbayAddImplicitWait {

    WebDriver driver;

    private final String EBAY_URL = "https://www.ebay.com/";

    @BeforeEach
    public void setup() {
        driver = WebDriverManager.edgedriver().create();
        driver.manage().window().maximize();

    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void mouseHover() {
        //Test dotyczy elementów na które najżdżamy myszką
        // i rozwija się coś innego pod nimi
        driver.get(EBAY_URL);
        WebElement electronicElement = driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[4]/a"));

        Actions actions = new Actions(driver);
        actions.moveToElement(electronicElement).perform();
    }

    @Test
    public void implicitWaits() {
        driver.get(EBAY_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement motors = driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[3]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(motors).perform();
        WebElement classics = driver.findElement(By.xpath("//a[text()='Classics']"));
        classics.click();

    }

    @Test
    public void explicitWait() {
        driver.get(EBAY_URL);
        WebElement motors = driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[3]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(motors).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[text()='Classics']"))).click();
    }

    @Test
    public void fluentWait() {
        driver.get(EBAY_URL);
        WebElement motors = driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[3]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(motors).perform();
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage("This message show when something gone wrong")
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[text()='Classics']"))).click();
    }
}
