package com.selenium.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TestJQuery {

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
    public void dragAndDrop(){
        driver.get("https://jqueryui.com/droppable/");
        WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frame);
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
    }

    @Test
    public void resizeWidget() throws InterruptedException{
        //rozszerzanie okna myszką
        driver.get("https://jqueryui.com/resizable/");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]"));
        driver.switchTo().frame(iframe);
        WebElement elementResize = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(elementResize,300,227).perform();
        Thread.sleep(5000);
    }
}
