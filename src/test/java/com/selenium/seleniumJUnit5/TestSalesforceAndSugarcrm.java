package com.selenium.seleniumJUnit5;

import com.selenium.seleniumJUnit5.common.BaseClassTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestSalesforceAndSugarcrm extends BaseClassTest {
    private final String SALESFORCE_URL = "https://www.salesforce.com/eu/form/starter/overview-demo/?d=pb";

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
    public void printAllOptionInSalesForce1() {
        driver.get(SALESFORCE_URL);
        List<WebElement> allTags = driver.findElements(By.name("CompanyEmployees"));
        System.out.println("Total tags are: " + allTags.size());

        for (WebElement allTag : allTags) {
            System.out.println("Links on page are " + allTag.getAttribute("value"));
            System.out.println("Links on page are " + allTag.getText());
        }
    }

    @Test
    public void handleMultipleWindowsOrSwitchWindows() {
        driver.get("https://www.sugarcrm.com/uk/?utm_source=sugarcrm.com&utm_medium=referral");
        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
        driver.findElement(By.xpath("//a[text()='Get A Demo']")).click();
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);
        driver.get("https://www.sugarcrm.com/uk/?utm_source=sugarcrm.com&utm_medium=referral");
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu-item-22271\"]/a/span[1]"))).click();
        driver.findElement(By.name("email")).sendKeys("tjablonski1990@gmail.com");
        driver.switchTo().window(parentWindow);
        driver.findElement(By.name("email")).sendKeys("tjablonski1990@gmail.com");
        driver.switchTo().window(childWindow);
        driver.findElement(By.name("firstname")).sendKeys("Tomasz");
        driver.findElement(By.name("lastname")).sendKeys("Jabłoński");
    }
}