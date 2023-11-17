package com.testcases;

import org.junit.After;
import org.junit.Before;

import com.testutils.WebDriverManager;

public class BaseTestClassJunit {
	
	private WebDriverManager webdriver_namager;
	
	@Before
	public void setup_method_junit() {
		webdriver_namager = new WebDriverManager();
		webdriver_namager.get_webdriver_object();
		System.out.println("This is the setup method of Junit annotation.");
		
	}
	
	@After
	public void teardown_method_junit() {
		webdriver_namager.clean_up();
		System.out.println("This is tear down method of Junit annotation.");
	}

}
