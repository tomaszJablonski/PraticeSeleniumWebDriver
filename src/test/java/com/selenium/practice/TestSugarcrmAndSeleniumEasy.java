package com.selenium.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSugarcrmAndSeleniumEasy {

    WebDriver driver;

    private final String sugarcrmUrl = "https://www.sugarcrm.com/uk/request-demo/";

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
    public void webDriverMethods() {
        driver.get(sugarcrmUrl);
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
    public void handleDropdownSelectTagAndOptions() {
        driver.get(sugarcrmUrl);
        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
        driver.findElement(By.name("email")).sendKeys("tjablonski1990@gmail.com");
        WebElement companySize = driver.findElement(By.xpath("//select[@name='employees_c']"));
        Select selectCompanySize = new Select(companySize);
        WebElement firstOption = selectCompanySize.getFirstSelectedOption();
        System.out.println("firstOption = " + firstOption.getText());
        selectCompanySize.selectByValue("level1");
        selectCompanySize.selectByVisibleText("11 - 50 employees");
        selectCompanySize.selectByIndex(3);
    }

    @Test
    public void handleDropdownSelectDeselectMultipleOption() {
        driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
        WebElement listBox = driver.findElement(By.id("multi-select"));
        Select multipleOptions = new Select(listBox);
        multipleOptions.selectByVisibleText("California");
        multipleOptions.selectByIndex(5);
        List<WebElement> allSelectedOptions = multipleOptions.getAllSelectedOptions();
        System.out.println("allSelectedOptions = " + allSelectedOptions.size());
        multipleOptions.deselectAll();
        multipleOptions.selectByVisibleText("California");
        multipleOptions.selectByIndex(5);
        multipleOptions.deselectByIndex(5);
        List<WebElement> selectedAgain = multipleOptions.getAllSelectedOptions();
        System.out.println("selectedAgain.size() = " + selectedAgain.size());
    }

    @Test
    public void checkBox() {
        driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
        WebElement option1 = driver.findElement(By.xpath("//label[text()='Option 1']"));
        option1.click();
        boolean isSelected = driver.findElement(By.xpath("//div[1]/label/input")).isSelected();
        assertTrue(isSelected);
        option1.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(option1);
        actions.perform();
        option1.click();
        option1.click();
        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
    }

    @Test
    public void radioButton() {
        driver.get("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
        WebElement radioSex = driver.findElement(By.xpath("//input[@name='optradio' and @value='Male'] "));
        Actions actions = new Actions(driver);
        actions.moveToElement(radioSex);
        actions.perform();
        radioSex.click();
        boolean radioSexIsSelectedMale = radioSex.isSelected();
        assertTrue(radioSexIsSelectedMale);
        System.out.println(driver.findElements(By.xpath("//input[@type='radio']")).size());
    }


}
