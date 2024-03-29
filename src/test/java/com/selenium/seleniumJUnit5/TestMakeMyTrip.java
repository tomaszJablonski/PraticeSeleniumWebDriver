package com.selenium.seleniumJUnit5;

import com.selenium.seleniumJUnit5.common.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class TestMakeMyTrip extends BaseClass {

    @Test
    public void handleAutoSuggestionDropdown() {
        driver.get("https://www.makemytrip.com/");
        driver.findElement(By.xpath("//span[text()='From']")).click();
        WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
        from.sendKeys("Sydney");
        from.sendKeys(Keys.ARROW_DOWN);
        from.sendKeys(Keys.ENTER);
    }
}