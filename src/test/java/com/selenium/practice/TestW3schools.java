package com.selenium.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

public class TestW3schools {

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
    public void framesByIndexAndAlertsPopup(){
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
        driver.findElement(By.xpath("//div[@id='accept-choices']")).click();
//        driver.switchTo().frame(0); index
//        driver.switchTo().frame("iframeResult"); nameOrId
        WebElement iframeResult = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(iframeResult);
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        String textAlert = driver.switchTo().alert().getText();
        System.out.println(textAlert);
        driver.switchTo().alert().accept();
//        driver.switchTo().alert().dismiss();
        driver.switchTo().parentFrame();
        System.out.println(driver.getTitle());
    }

    @Test
    public void alertsSendKeys() throws InterruptedException{
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
        driver.findElement(By.xpath("//div[@id='accept-choices']")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Jan Kowalski");
        Thread.sleep(2000);
        alert.accept();
        driver.switchTo().parentFrame();
        System.out.println(driver.getTitle());

    }
}
