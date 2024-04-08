package com.testcases;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import com.pageactions.HomePageActions;
import com.testutils.Constants;
import com.testutils.PropertiesFileHandle;
import com.testutils.WebActions;
import com.testutils.WebDriverManager;

public class BaseTestClassJunit {
	
	private static WebDriverManager webdriver_namager;
	private PropertiesFileHandle properties_file_handle;
	private static WebDriver driver;
	private static WebActions actions;
	Logger logger = Logger.getLogger(BaseTestClassJunit.class);
	
	public BaseTestClassJunit() {
		// TODO Auto-generated constructor stub
		BasicConfigurator.configure();
		properties_file_handle = new PropertiesFileHandle(Constants.CONFIG_FILE_PATH);
		
	}
	
	@BeforeClass
	public static void setup_method_junit() {
		webdriver_namager = new WebDriverManager();
		driver = webdriver_namager.get_webdriver_object();
		actions = new WebActions(driver);
	}
	
	@AfterClass
	public static void teardown_method_junit() {
		webdriver_namager.clean_up();
	}
	
	protected HomePageActions go_to_baseurl() {
		String base_url = properties_file_handle.get_property("base_url");
		actions.open_application(base_url);
		logger.info("Application under test opened with baseurl: " + base_url);
		actions.maximize_browser_window();
		return new HomePageActions(driver);
	}

}
