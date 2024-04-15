package com.cucumber.stepsDefinition;

import com.cucumber.pageObject.GooglePageElements;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Properties;


public class BaseClass {

    public WebDriver driver;

    public GooglePageElements googlePage;
    public Logger logger;

    public Properties configProperties;

    //Created for generating random String for unique something
    //use later
    public static String randomestring(){
        return RandomStringUtils.randomAlphabetic(5);
    }
}