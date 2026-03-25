package com.automation.utils;

import com.automation.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public final class SeleniumUtils {

    private SeleniumUtils() {
    }

    public static WebElement waitForElementVisible(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementClickable(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void clickElement(By locator) {
        waitForElementClickable(locator, 10).click();
    }

    public static void enterText(By locator, String text) {
        WebElement element = waitForElementVisible(locator, 10);
        element.clear();
        element.sendKeys(text);
    }

    public static String getText(By locator) {
        return waitForElementVisible(locator, 10).getText();
    }

    public static String takeScreenshot(String screenshotName) {
        TakesScreenshot screenshot = (TakesScreenshot) DriverManager.getDriver();
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destination = "target/screenshots/" + screenshotName + "_" + System.currentTimeMillis() + ".png";
        File finalDestination = new File(destination);

        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return finalDestination.getAbsolutePath();
    }

    public static boolean isElementDisplayed(By locator) {
        try {
            return DriverManager.getDriver().findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void executeJavaScript(String script, Object... args) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(script, args);
    }

    public static void scrollToElement(By locator) {
        WebElement element = DriverManager.getDriver().findElement(locator);
        executeJavaScript("arguments[0].scrollIntoView(true);", element);
    }
}

