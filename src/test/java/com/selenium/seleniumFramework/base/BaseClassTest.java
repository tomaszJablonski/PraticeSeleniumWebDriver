package com.selenium.seleniumFramework.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClassTest {

    public static WebDriver driver = null;
    public static Properties propertiesConfig = new Properties();
    public static Properties propertiesLocators = new Properties();
    public static FileReader fileReaderConfig;
    public static FileReader fileReaderLocators;

    static {
        try {
            fileReaderConfig = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\seleniumFrameworkConfigFiles\\config.properties");
            propertiesConfig.load(fileReaderConfig);
            fileReaderLocators = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\seleniumFrameworkConfigFiles\\locators.properties");
            propertiesLocators.load(fileReaderLocators);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browser) throws IOException {
        switch (browser) {
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.get(propertiesConfig.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }

    public void loginInToZoho(String login, String password) {
        driver.findElement(By.id("login_id")).click();
        driver.findElement(By.id("login_id")).sendKeys(login);
        driver.findElement(By.xpath("//span[text()='Dalej']")).click();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='nextbtn']")).click();
    }

    //from locators.properties
    public void loginInToZohoProperties(String login, String password) {
        driver.findElement(By.id(propertiesLocators.getProperty("login_id_field"))).click();
        driver.findElement(By.id(propertiesLocators.getProperty("login_id_field"))).sendKeys(login);
        driver.findElement(By.xpath(propertiesLocators.getProperty("next_button"))).click();
        driver.findElement(By.id(propertiesLocators.getProperty("password_field"))).sendKeys(password);
        driver.findElement(By.xpath(propertiesLocators.getProperty("login_next_button"))).click();
    }
}