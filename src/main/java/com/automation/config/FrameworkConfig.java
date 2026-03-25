package com.automation.config;

import org.aeonbits.owner.Config;

@Config.Sources({
    "classpath:config/config.properties"
})
public interface FrameworkConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("headless")
    @DefaultValue("false")
    boolean headless();

    @Key("browser.timeout")
    @DefaultValue("10")
    int browserTimeout();

    @Key("app.url")
    String appUrl();

    @Key("api.base.url")
    String apiBaseUrl();

    @Key("environment")
    @DefaultValue("qa")
    String environment();

    @Key("screenshot.on.failure")
    @DefaultValue("true")
    boolean screenshotOnFailure();

    @Key("screenshot.on.pass")
    @DefaultValue("false")
    boolean screenshotOnPass();

    @Key("retry.failed.tests")
    @DefaultValue("1")
    int retryFailedTests();

    @Key("extent.report.path")
    @DefaultValue("target/extent-reports")
    String extentReportPath();

    @Key("grid.enabled")
    @DefaultValue("false")
    boolean gridEnabled();

    @Key("grid.url")
    String gridUrl();
}

