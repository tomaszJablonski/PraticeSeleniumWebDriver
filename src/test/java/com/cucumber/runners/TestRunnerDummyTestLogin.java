package com.cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/cucumber/features/dummyLoginTest.feature",
        glue = "com.cucumber.stepsDefinition"
)

public class TestRunnerDummyTestLogin {

}
