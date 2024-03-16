package com.selenium.seleniumJUnit5;

import com.selenium.seleniumJUnit5.common.BaseClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TestW3schools extends BaseClass {

    @Test
    public void framesByIndexAndAlertsPopup() {
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
    public void alertsSendKeys() {
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
        driver.findElement(By.xpath("//div[@id='accept-choices']")).click();
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//button[text()='Try it']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Jan Kowalski");
        alert.accept();
        driver.switchTo().parentFrame();
        System.out.println(driver.getTitle());
    }

    @Test
    public void javaScriptExecutor() {
        //Bardzo ważny temat - dowiedzieć się wszystkiego na ten temat
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        //print the title page
        String script = "return document.tittle;";
        String title = (String) javascriptExecutor.executeScript(script);
        System.out.println(title);

        //click button
        driver.switchTo().frame("iframeResult");
        javascriptExecutor.executeScript("myFunction()");
        driver.switchTo().alert().accept();

        //highlight element
        WebElement tryIt = driver.findElement(By.xpath("//button[text()='Try it']"));
        javascriptExecutor.executeScript("arguments[0].style.border='3px solid red'", tryIt);

        //scroll the page
        driver.navigate().to("https://www.w3schools.com/");
        WebElement learnHowTo = driver.findElement(By.xpath("//a[text()='Learn How To']"));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", learnHowTo);
    }
}