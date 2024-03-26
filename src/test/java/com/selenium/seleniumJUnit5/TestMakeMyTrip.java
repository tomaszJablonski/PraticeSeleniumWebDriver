package com.selenium.seleniumJUnit5;

import com.selenium.seleniumJUnit5.common.BaseClassTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TestMakeMyTrip extends BaseClassTest {

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