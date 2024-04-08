package com.pageactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testcases.BaseTestClassJunit;
import com.testutils.Constants;
import com.testutils.PropertiesFileHandle;
import com.testutils.WebActions;

public class LoginPageActions {
	WebDriver driver;
	private WebActions action;
	private PropertiesFileHandle prop;
	Logger logger = Logger.getLogger(LoginPageActions.class);
	
	public LoginPageActions(WebDriver driver) {
		this.driver = driver;
		action = new WebActions(driver);
		PageFactory.initElements(this.driver, this);
		prop = new PropertiesFileHandle(Constants.CONFIG_FILE_PATH);
	}
	
	@FindBy(css = "#input-email")
	WebElement email_field;
	
	@FindBy(css = "#input-password")
	WebElement password_field;
	
	@FindBy(css = "input[value='Login']")
	WebElement login_btn;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Register']")
	WebElement register_lnk;
	
	String warning_css_selector = ".alert.alert-danger.alert-dismissible";
	
	public boolean perform_login() {
		action.enter_text_field(email_field, prop.get_property("email"));
		action.enter_text_field(password_field, prop.get_property("password"));
		action.click_on_element(login_btn);
		logger.info("Try to login with standard username and password.");
		boolean login_failed = action.elemenet_visiblity_by_css_locator(warning_css_selector);
		return (!login_failed);
	}
	
	public RegisterPageActions navigate_to_register() {
		action.click_on_element(register_lnk);
		logger.info("As login failed. Navigate to Registration form page.");
		return new RegisterPageActions(driver);
	}
}
