package com.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * TestNG Cucumber Runner for UI tests only
 * This runner executes only UI feature files with @ui tag
 */
@CucumberOptions(
        features = "src/test/resources/features/ui",
        glue = {"com.automation.stepdefinitions"},
        tags = "@ui",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/ui-cucumber.html",
                "json:target/cucumber-reports/ui-cucumber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        monochrome = true,
        dryRun = false
)
public class UiTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

