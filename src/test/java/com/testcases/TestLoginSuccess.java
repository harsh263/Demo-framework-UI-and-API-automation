package com.testcases;

import org.junit.Test;
import com.pageactions.HomePageActions;
import com.pageactions.LoginPageActions;
import com.pageactions.RegisterPageActions;

public class TestLoginSuccess extends BaseTestClassJunit{
	HomePageActions homepage_act;
	LoginPageActions loginpage_act;
	RegisterPageActions regpage_act;
	@Test
	public void test_login_successful() {
		
		homepage_act = go_to_baseurl();
		loginpage_act = homepage_act.navigate_to_login_page();
		
		boolean login_success = loginpage_act.perform_login();	
		if (!login_success) {
			// Register user then Login again
			regpage_act = loginpage_act.navigate_to_register();
			regpage_act.fill_and_submit_reg_form();
			regpage_act.validate_registration_success();
		}
		else {
			logger.info("Login success: " + login_success);
		}
	}

}
