package com.selenium.seleniumJUnit5;

import com.selenium.seleniumJUnit5.common.BaseClass;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

public class TestEbayAddWaits extends BaseClass {

    public static final String EBAY_URL = "https://www.ebay.com/";

    @Test
    public void mouseHover() {
        driver.get(EBAY_URL);
        //Test dotyczy elementów na które najżdżamy myszką
        // i rozwija się coś innego pod nimi
        WebElement electronicElement = driver.findElement(By.xpath("//*[@id=\"vl-flyout-nav\"]/ul/li[4]/a"));

        Actions actions = new Actions(driver);
        actions.moveToElement(electronicElement).perform();
    }

    @Test
    public void implicitWaits() {
        driver.get(EBAY_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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

    @Test
    public void captureScreenshot() throws IOException {
        driver.get(EBAY_URL);
        Date currentDate = new Date();
        System.out.println(currentDate);
        String screenShotCurrentDate = currentDate.toString().replace(" ", "-").replace(":", "-");
        System.out.println(screenShotCurrentDate);

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(".//screenshot/" + screenShotCurrentDate + ".png"));
    }
}