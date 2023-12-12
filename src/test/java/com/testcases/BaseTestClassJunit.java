package com.testcases;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import com.pageactions.HomePageActions;
import com.testutils.Constants;
import com.testutils.PropertiesFileHandle;
import com.testutils.WebActions;
import com.testutils.WebDriverManager;

public class BaseTestClassJunit {
	
	private WebDriverManager webdriver_namager;
	private PropertiesFileHandle properties_file_handle;
	private WebDriver driver;
	private WebActions actions;
	
	public BaseTestClassJunit() {
		// TODO Auto-generated constructor stub
		properties_file_handle = new PropertiesFileHandle(Constants.CONFIG_FILE_PATH);
	}
	
	@Before
	public void setup_method_junit() {
		webdriver_namager = new WebDriverManager();
		driver = webdriver_namager.get_webdriver_object();
		actions = new WebActions(driver);
	}
	
	@After
	public void teardown_method_junit() {
		webdriver_namager.clean_up();
	}
	
	protected HomePageActions got_to_baseurl() {
		actions.open_application(properties_file_handle.get_property("base_url"));
		actions.maximize_browser_window();
		return new HomePageActions(driver);
	}

}
