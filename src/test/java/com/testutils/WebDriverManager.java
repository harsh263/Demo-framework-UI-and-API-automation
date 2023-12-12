package com.testutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
			switch (browser) {
			case "chrome":
				driver = new ChromeDriver();
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
