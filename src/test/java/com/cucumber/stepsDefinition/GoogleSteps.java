package com.cucumber.stepsDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class GoogleSteps {

    WebDriver driver;

    @Given("I am on the Google search page")
    public void i_am_on_the_google_search_page() {
//        url();
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.google.pl/");
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
    }

    @When("I enter any search keyword on search text box")
    public void i_enter_any_search_keyword_on_search_text_box() {
//        clickOnSearchFieldInGoogle();
        driver.findElement(By.xpath("//textarea[@aria-label='Szukaj']")).click();
        driver.findElement(By.xpath("//textarea[@aria-label='Szukaj']")).sendKeys("drzewa");
    }

    @When("I click on search button")
    public void i_click_on_search_button() {
//        pressEnterInSearchField();
        driver.findElement(By.xpath("//textarea[@aria-label='Szukaj']")).sendKeys(Keys.ENTER);
    }

    @Then("I should be redirect to search results page")
    public void i_should_be_redirect_to_search_results_page() {
//        isWikipediaVisible();
        WebElement wikipediaTree = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/span/a/h3"));
        Assertions.assertTrue(wikipediaTree.isDisplayed());
        driver.quit();
    }
}
