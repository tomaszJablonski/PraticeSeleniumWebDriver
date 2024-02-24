package com.selenium.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TestJQuery {

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
    public void dragAndDrop() {
        driver.get("https://jqueryui.com/droppable/");
        WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(frame);
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop).perform();
    }

    @Test
    public void resizeWidget() {
        //rozszerzanie okna myszką
        driver.get("https://jqueryui.com/resizable/");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]"));
        driver.switchTo().frame(iframe);
        WebElement elementResize = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(elementResize, 300, 227).perform();
    }

    @Test
    public void automateSlider() {
        //slider - suwak
        driver.get("https://jqueryui.com/slider/#colorpicker");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]"));
        driver.switchTo().frame(iframe);
        WebElement red = driver.findElement(By.xpath("//*[@id=\"red\"]/span"));
        WebElement green = driver.findElement(By.xpath("//*[@id=\"green\"]/span"));
        WebElement blue = driver.findElement(By.xpath("//*[@id=\"blue\"]/span"));

        Actions actionMoveSlider = new Actions(driver);
        //do przodu
        actionMoveSlider.dragAndDropBy(red, 120, 300).perform();
        actionMoveSlider.dragAndDropBy(green, 250, 25).perform();
        actionMoveSlider.dragAndDropBy(blue, 150, 161).perform();

        //do tyłu, tylko x na minusie, y jest bez zmian
        actionMoveSlider.dragAndDropBy(green, -100, 125).perform();
    }

    @Test
    public void rightClickInSelenium() {
        driver.get("https://jqueryui.com/slider/#colorpicker");
        WebElement iframe = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iframe);

        WebElement squareColor = driver.findElement(By.xpath("//div[@id='swatch']"));

        /*
        zobaczyć w domu jak wykonać akcje po prawym kliknięciu
         */
        Actions actionsRightClick = new Actions(driver);
        //kliknie gdzie kolwiek
        actionsRightClick.contextClick();
        //kliknie w wybranym przez nas miejscu
        actionsRightClick.contextClick(squareColor).perform();
    }
}
