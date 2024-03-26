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

import java.time.Duration;

public class BaseClassTest {

    public static WebDriver driver = null;

    @Parameters({"browser"})
    @BeforeTest
    public void setup(String browser) {
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
        driver.get("https://www.zoho.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }


    public void loginInToZoho(String login, String password){
        driver.findElement(By.id("login_id")).click();
        driver.findElement(By.id("login_id")).sendKeys(login);
        driver.findElement(By.xpath("//span[text()='Dalej']")).click();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='nextbtn']")).click();
    }
}
