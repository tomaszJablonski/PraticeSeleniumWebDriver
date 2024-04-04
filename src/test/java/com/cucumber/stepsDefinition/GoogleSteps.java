package com.cucumber.stepsDefinition;

import com.cucumber.pageObject.GooglePageElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;



public class GoogleSteps extends BaseClass {

    @Given("I launch the browser {string}")
    public void iLaunchTheBrowser(String browser) {
        logger = Logger.getLogger("Google");
        PropertyConfigurator.configure( System.getProperty("user.dir") +"\\src\\test\\resources\\cucumber\\log4j.properties");

        switch (browser) {
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--remote-allow-origins");
                driver = new EdgeDriver(options);
                logger.info("I launch Edge browser");
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--remote-allow-origins");
                driver = new FirefoxDriver(options);
                logger.info("I launch Firefox browser");
            }
        }
        driver.manage().window();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        googlePage = new GooglePageElements(driver);
    }

    @Given("I am on the Google search page with url {string}")
    public void i_am_on_the_google_search_page_with_url(String url) {
        logger.info("I launch url " + url);
        driver.get(url);
        googlePage.clickOnAcceptAll();
    }

    @When("I enter any search keyword on search text box")
    public void i_enter_any_search_keyword_on_search_text_box() {
        logger.info("I click to search and write keyword");
        googlePage.clickOnSearchFieldInGoogle();
    }

    @When("I click on search button")
    public void i_click_on_search_button() {
        logger.info("I click on search button");
        googlePage.pressEnterInSearchField();
    }

    @Then("I should be redirect to search results page")
    public void i_should_be_redirect_to_search_results_page() {
        logger.info("I check the redirect is correct");
        googlePage.isWikipediaVisible();
    }

    @Then("I close the browser")
    public void iCloseTheBrowser() {
        logger.info("I close the browser");
        googlePage.closeBrowser();
    }
}