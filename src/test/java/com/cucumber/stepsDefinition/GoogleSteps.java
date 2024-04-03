package com.cucumber.stepsDefinition;

import com.cucumber.pageObject.GooglePageElements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class GoogleSteps {

    public WebDriver driver;

    public GooglePageElements googlePage;

    @Given("I launch the browser {string}")
    public void iLaunchTheBrowser(String browser) {
        switch (browser) {
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
                options.addArguments("");
                driver = new EdgeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        driver.manage().window();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        googlePage = new GooglePageElements(driver);
    }

    @Given("I am on the Google search page with url {string}")
    public void i_am_on_the_google_search_page_with_url(String url) {
        driver.get(url);
        googlePage.clickOnAcceptAll();
    }

    @When("I enter any search keyword on search text box")
    public void i_enter_any_search_keyword_on_search_text_box() {
        googlePage.clickOnSearchFieldInGoogle();
    }

    @When("I click on search button")
    public void i_click_on_search_button() {
        googlePage.pressEnterInSearchField();
    }

    @Then("I should be redirect to search results page")
    public void i_should_be_redirect_to_search_results_page() {
        googlePage.isWikipediaVisible();
    }

    @Then("I close the browser")
    public void iCloseTheBrowser() {
        googlePage.closeBrowser();
    }
}