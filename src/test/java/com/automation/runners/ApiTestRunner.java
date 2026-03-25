package com.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * TestNG Cucumber Runner for API tests only
 * This runner executes only API feature files with @api tag
 */
@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = {"com.automation.stepdefinitions"},
        tags = "@api",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/api-cucumber.html",
                "json:target/cucumber-reports/api-cucumber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        monochrome = true,
        dryRun = false
)
public class ApiTestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

