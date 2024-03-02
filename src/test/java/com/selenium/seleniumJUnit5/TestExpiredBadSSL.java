package com.selenium.seleniumJUnit5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestExpiredBadSSL {

    WebDriver driver;

    public static String browser = "edge"; // External configuration - XLS, CSV

    @BeforeEach
    public void setup() {
        switch (browser) {
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setAcceptInsecureCerts(true);
                driver = new EdgeDriver(edgeOptions);
            }
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setAcceptInsecureCerts(true);
                driver = new ChromeDriver(chromeOptions);
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setAcceptInsecureCerts(true);
                driver = new FirefoxDriver(firefoxOptions);
            }
        }
        driver.manage().window().maximize();
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void handleSSLCertificate() throws InterruptedException {
        driver.get("https://expired.badssl.com/");
        Thread.sleep(2000);
    }
}
