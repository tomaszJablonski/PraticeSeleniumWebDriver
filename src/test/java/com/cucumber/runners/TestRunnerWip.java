package com.cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/cucumber/features/test1.feature",
        glue = "com.cucumber.stepsDefinition"
)
public class TestRunnerWip {
}
