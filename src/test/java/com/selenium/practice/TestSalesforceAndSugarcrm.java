package com.selenium.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestSalesforceAndSugarcrm {

    WebDriver driver;
    private final String SALESFORCE_URL = "https://www.salesforce.com/eu/form/starter/overview-demo/?d=pb";

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
        driver.get(SALESFORCE_URL);
        List<WebElement> allTags = driver.findElements(By.tagName("option"));
        System.out.println("Total tags are: " + allTags.size());

        for (int i = 0; i < allTags.size(); i++) {
            System.out.println("Links on page are " + allTags.get(i).getAttribute("value"));
            System.out.println("Links on page are " + allTags.get(i).getText());
        }
    }

    @Test
    public void printAllOptionInSalesForce1(){
        driver.get(SALESFORCE_URL);
        List<WebElement> allTags = driver.findElements(By.name("CompanyEmployees"));
        System.out.println("Total tags are: " + allTags.size());

        for (WebElement allTag : allTags) {
            System.out.println("Links on page are " + allTag.getAttribute("value"));
            System.out.println("Links on page are " + allTag.getText());
        }
    }

    @Test
    public void handleMultipleWindowsOrSwitchWindows() throws InterruptedException{
        driver.get("https://www.sugarcrm.com/uk/?utm_source=sugarcrm.com&utm_medium=referral");
        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
        driver.findElement(By.xpath("//a[text()='Get A Demo']")).click();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.sugarcrm.com/uk/?utm_source=sugarcrm.com&utm_medium=referral");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Get A Demo']")).click();
        driver.findElement(By.name("email")).sendKeys("tjablonski1990@gmail.com");
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(parentWindow);
        driver.findElement(By.name("email")).sendKeys("tjablonski1990@gmail.com");
        driver.switchTo().window(childWindow);
        driver.findElement(By.name("firstname")).sendKeys("Tomasz");
        driver.findElement(By.name("lastname")).sendKeys("Jabłoński");
        Thread.sleep(5000);

    }
}