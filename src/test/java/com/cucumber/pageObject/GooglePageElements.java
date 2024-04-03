package com.cucumber.pageObject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePageElements {

    public WebDriver webDriver;

    public GooglePageElements(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    //locators

    @FindBy(xpath = "//textarea[@aria-label='Szukaj']")
    public WebElement searchField;

    @FindBy(xpath = "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/div/div/span/a/h3")
    public WebElement wikipediaTree;

    @FindBy(xpath = "//*[@id=\"L2AGLb\"]/div")
    public WebElement acceptAll;

    //methods

    public void clickOnAcceptAll() {
        acceptAll.click();
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
        webDriver.quit();
    }

    public void closeBrowser() {
        webDriver.quit();
    }
}