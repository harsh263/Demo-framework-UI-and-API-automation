package com.testutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {
	
	private PropertiesFileHandle properties_file_handle;
	private WebDriver driver;
	
	public WebDriverManager() {
		properties_file_handle = new PropertiesFileHandle(Constants.CONFIG_FILE_PATH);
	}
	
	public WebDriver get_webdriver_object() {
		
		if(null == driver) {
			String browser = properties_file_handle.get_property("browser");
			boolean headless = Boolean.parseBoolean(properties_file_handle.get_property("headless"));
			switch (browser) {
			case "chrome":
				ChromeOptions option = new ChromeOptions();
				if (headless) {
					option.addArguments("--headless");
				}
				driver = new ChromeDriver(option);
				break;
			case "firefox":
				driver = new FirefoxDriver();
			case "edge":
				driver = new EdgeDriver();
			default:
				driver = new ChromeDriver();
				break;
			}
		}
		return driver;
	}
	
	public void clean_up() {
		driver.quit();
	}

}
