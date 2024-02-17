package com.selenium.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestSelectMethods {

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
    public void webDriverMethods(){
        driver.get("https://www.sugarcrm.com/uk/request-demo/");
        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
        driver.findElement(By.name("email")).sendKeys("blabla");
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("tjablonski1990@gmail.com");
        System.out.println("getAttribute " + driver.findElement(By.name("email")).getAttribute("class"));
        System.out.println("getCssValue " + driver.findElement(By.xpath("//input[@type='submit']")).getCssValue("background-color"));
        System.out.println("getSize " + driver.findElement(By.xpath("//input[@type='submit']")).getSize());
        System.out.println("getLocation " + driver.findElement(By.xpath("//input[@type='submit']")).getLocation());
        System.out.println("getText " + driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[1]/div[2]/div/div/div[2]/h4[1]")).getText());
        System.out.println("getTagName " + driver.findElement(By.xpath("//input[@type='submit']")).getTagName());
        System.out.println("isDisplayed " + driver.findElement(By.xpath("//input[@type='submit']")).isDisplayed());
        System.out.println("isEnabled " + driver.findElement(By.xpath("//input[@type='submit']")).isEnabled());
        System.out.println("isSelected " + driver.findElement(By.xpath("//input[@type='submit']")).isSelected());
    }

    @Test
    public void handleDropdownSelectTagAndOptions() throws InterruptedException{
        driver.get("https://www.sugarcrm.com/uk/request-demo/");
        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
        driver.findElement(By.name("email")).sendKeys("tjablonski1990@gmail.com");
        WebElement companySize = driver.findElement(By.xpath("//select[@name='employees_c']"));
        Select selectCompanySize = new Select(companySize);
        WebElement firstOption = selectCompanySize.getFirstSelectedOption();
        System.out.println("firstOption = " + firstOption.getText());
        selectCompanySize.selectByValue("level1");
        Thread.sleep(2000);
        selectCompanySize.selectByVisibleText("11 - 50 employees");
        Thread.sleep(2000);
        selectCompanySize.selectByIndex(3);
        Thread.sleep(2000);
    }

    @Test
    public void handleDropdownSelectDeselectMultipleOption() throws InterruptedException{
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        WebElement listBox = driver.findElement(By.id("multi-select"));
        Select multipleOptions = new Select(listBox);
        multipleOptions.selectByVisibleText("California");
        Thread.sleep(2000);
        multipleOptions.selectByIndex(5);
        Thread.sleep(2000);
        List<WebElement> allSelectedOptions = multipleOptions.getAllSelectedOptions();
        System.out.println("allSelectedOptions = " + allSelectedOptions.size());
        Thread.sleep(2000);
        multipleOptions.deselectAll();
        Thread.sleep(2000);
        multipleOptions.selectByVisibleText("California");
        Thread.sleep(2000);
        multipleOptions.selectByIndex(5);
        Thread.sleep(2000);
        multipleOptions.deselectByIndex(5);
        Thread.sleep(2000);
        List<WebElement> selectedAgain = multipleOptions.getAllSelectedOptions();
        System.out.println("selectedAgain.size() = " + selectedAgain.size());
        Thread.sleep(2000);
    }


}
