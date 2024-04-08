package com.testcases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.pageactions.HomePageActions;
import com.pageactions.LoginPageActions;

public class TestAddtoCart extends BaseTestClassJunit {
	HomePageActions homepage_act;
	LoginPageActions loginpage_act;
	
	@Before
	public void log_in_as_standard_user() {
		homepage_act = go_to_baseurl();
		loginpage_act = homepage_act.navigate_to_login_page();
		Assert.assertTrue(loginpage_act.perform_login());
	}
	
	@Test
	public void test_add_tocart_feature() {
		homepage_act.navigate_to_homepage();
		
	}
	

}
