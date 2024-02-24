package com.selenium.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TestExtendsClass {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = WebDriverManager.edgedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void performKeyboardEvents() {
        driver.get("https://extendsclass.com/text-compare.html");
        WebElement areaText1 = driver.findElement(By.xpath("//*[@id=\"dropZone\"]/div[2]/div/div[6]/div[1]/div/div/div/div[1]"));
        Actions actions = new Actions(driver);
        //zaznaczamy cały tekst i go kopiujemy
        actions.keyDown(areaText1, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
        //wklejamy tekst do innego wskazanego miejsca
        WebElement areaTest2 = driver.findElement(By.xpath("//*[@id=\"dropZone2\"]/div[2]/div/div[6]/div[1]/div/div/div/div[5]"));
        actions.keyDown(areaTest2, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();
    }

}
