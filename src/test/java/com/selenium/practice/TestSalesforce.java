package com.selenium.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestSalesforce {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = WebDriverManager.edgedriver().create();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void printAllLinksOfAWebpageSugarcrm() {
        driver.get("https://www.sugarcrm.com/uk/request-demo/");
        List<WebElement> allTags = driver.findElements(By.tagName("a"));
        System.out.println("Total tags are: " + allTags.size());

        for (int i = 0; i < allTags.size(); i++) {
            System.out.println("Links on page are " + allTags.get(i).getAttribute("href"));
            System.out.println("Links on page are " + allTags.get(i).getText());
        }
    }

    @Test
    public void printAllOptionInSalesForce() {
        driver.get("https://www.salesforce.com/eu/form/starter/overview-demo/?d=pb");
        List<WebElement> allTags = driver.findElements(By.tagName("option"));
        System.out.println("Total tags are: " + allTags.size());

        for (int i = 0; i < allTags.size(); i++) {
            System.out.println("Links on page are " + allTags.get(i).getAttribute("value"));
            System.out.println("Links on page are " + allTags.get(i).getText());
        }
    }

    @Test
    public void printAllOptionInSalesForce1(){
        driver.get("https://www.salesforce.com/eu/form/starter/overview-demo/?d=pb");
        List<WebElement> allTags = driver.findElements(By.name("CompanyEmployees"));
        System.out.println("Total tags are: " + allTags.size());

        for (WebElement allTag : allTags) {
            System.out.println("Links on page are " + allTag.getAttribute("value"));
            System.out.println("Links on page are " + allTag.getText());
        }

    }
}
