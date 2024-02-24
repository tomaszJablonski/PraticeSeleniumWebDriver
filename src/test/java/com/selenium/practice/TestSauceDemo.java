package com.selenium.practice;

import com.selenium.practice.utils.ServiceSauceDemo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSauceDemo {

    Logger logger;

    WebDriver driver;

    ServiceSauceDemo serviceSauceDemo;

    public static String BROWSER = "edge";

    @BeforeEach
    void setup() {
        if (BROWSER.equals("chrome")) {
            driver = WebDriverManager.chromedriver().create();
        } else if (BROWSER.equals("edge")) {
            driver = WebDriverManager.edgedriver().create();
        }
        driver.manage().window().maximize();
        logger = Logger.getLogger(TestSauceDemo.class.getName());
        serviceSauceDemo = new ServiceSauceDemo();
    }

    @AfterEach
    void close() {
        driver.quit();
    }

    @Test
    void testLoginToSauceDemoSite() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name"))
                .sendKeys(serviceSauceDemo.getUSERNAME());
        driver.findElement(By.id("password"))
                .sendKeys(serviceSauceDemo.getPASSWORD());
        driver.findElement(By.id("login-button")).sendKeys(Keys.ENTER);
        boolean logo = driver.findElement(By.cssSelector(".app_logo")).isDisplayed();
        assertTrue(logo, "Swag Labs");
        List<WebElement> webElementList = driver.findElements(By.xpath("//div[@class='inventory_item']/div"));
        System.out.println(webElementList);

        driver.navigate().to("https://sugarcrm.com");
        String windowHandleSugarcrm = driver.getWindowHandle();
        System.out.println(windowHandleSugarcrm);
        driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")).click();
        driver.findElement(By.xpath("//div[contains(a,'Get A Demo')]")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);

    }
}
