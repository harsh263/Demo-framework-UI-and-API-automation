package com.automation.stepdefinitions;

import com.automation.config.ConfigFactory;
import com.automation.driver.DriverFactory;
import com.automation.driver.DriverManager;
import com.automation.enums.BrowserType;
import com.automation.utils.SeleniumUtils;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.Logger;

import static com.automation.utils.LoggerUtil.getLogger;

public class Hooks {

    private static final Logger logger = getLogger(Hooks.class);

    @Before("@ui")
    public void beforeUIScenario(Scenario scenario) {
        logger.info("Starting UI Scenario: {}", scenario.getName());

        String browserName = ConfigFactory.getConfig().browser().toUpperCase();
        BrowserType browserType = BrowserType.valueOf(browserName);
        DriverManager.setDriver(DriverFactory.createDriver(browserType));

        logger.info("Browser launched: {}", browserName);
    }

    @Before("@api")
    public void beforeAPIScenario(Scenario scenario) {
        logger.info("Starting API Scenario: {}", scenario.getName());
    }

    @AfterStep("@ui")
    public void afterUIStep(Scenario scenario) {
        if (scenario.isFailed() && ConfigFactory.getConfig().screenshotOnFailure()) {
            String screenshotPath = SeleniumUtils.takeScreenshot(scenario.getName());
            logger.info("Screenshot captured: {}", screenshotPath);
        }
    }

    @After("@ui")
    public void afterUIScenario(Scenario scenario) {
        logger.info("Completed UI Scenario: {} - Status: {}",
                scenario.getName(), scenario.getStatus());

        DriverManager.quitDriver();
        logger.info("Browser closed");
    }

    @After("@api")
    public void afterAPIScenario(Scenario scenario) {
        logger.info("Completed API Scenario: {} - Status: {}",
                scenario.getName(), scenario.getStatus());
    }
}

