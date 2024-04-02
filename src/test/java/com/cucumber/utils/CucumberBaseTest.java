package com.cucumber.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class CucumberBaseTest {

    public static WebDriver driver = null;


    public static String browser = "edge";

    //locators
    @FindBy(xpath = "//textarea[@aria-label='Szukaj']")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/span/a/h3")
    private WebElement wikipediaTree;

    @FindBy(xpath = "//*[@id=\"L2AGLb\"]/div")
    private WebElement acceptAll;

    public void url() {
        switch (browser) {
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
                options.addArguments("");
                driver = new EdgeDriver();
            }
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
        }
        driver.manage().window();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.google.pl/");
    }

    public void clickOnSearchFieldInGoogle() {
        searchField.click();
        searchField.sendKeys("drzewa");
    }

    public void pressEnterInSearchField() {
        searchField.sendKeys(Keys.ENTER);
    }

    public void isWikipediaVisible() {
        Assertions.assertTrue(wikipediaTree.isDisplayed());
        driver.quit();
    }
}
