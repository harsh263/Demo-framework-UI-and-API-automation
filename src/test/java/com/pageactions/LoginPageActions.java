package com.pageactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testutils.Constants;
import com.testutils.PropertiesFileHandle;
import com.testutils.WebActions;

public class LoginPageActions {
	WebDriver driver;
	private WebActions action;
	private PropertiesFileHandle prop;
	
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
	
	String warning_css_selector = ".alert.alert-danger.alert-dismissible";
	
	public boolean perform_login() {
		action.enter_text_field(email_field, prop.get_property("email"));
		action.enter_text_field(password_field, prop.get_property("password"));
		action.click_on_element(login_btn);
		boolean login_failed = action.elemenet_visiblity_by_css_locator(warning_css_selector);
		return (!login_failed);
	}
}
