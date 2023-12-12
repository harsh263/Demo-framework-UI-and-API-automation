package com.testcases;

import org.junit.Test;
import com.pageactions.HomePageActions;
import com.pageactions.LoginPageActions;

public class TestLoginSuccess extends BaseTestClassJunit{
	HomePageActions homepage_act;
	LoginPageActions loginpage_act;
	@Test
	public void test_login_successful() {
		
		homepage_act = got_to_baseurl();
		loginpage_act = homepage_act.navigate_to_login_page();
		
		System.out.println("Login success - " + loginpage_act.perform_login());	
		
		}

}
