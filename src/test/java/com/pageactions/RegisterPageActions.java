package com.pageactions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.testcases.BaseTestClassJunit;
import com.testutils.Constants;
import com.testutils.PropertiesFileHandle;
import com.testutils.WebActions;

public class RegisterPageActions {
	private WebDriver driver;
	private WebActions action;
	private PropertiesFileHandle prop;
	Logger logger = Logger.getLogger(RegisterPageActions.class);
	
	
	public RegisterPageActions(WebDriver driver) {
		this.driver = driver;
		action = new WebActions(driver);
		PageFactory.initElements(this.driver, this);
		prop = new PropertiesFileHandle(Constants.CONFIG_FILE_PATH);
	}
	
	@FindBy(css = "#input-firstname")
	WebElement first_name_field;
	
	@FindBy(css = "#input-lastname")
	WebElement last_name_field;
	
	@FindBy(css = "#input-email")
	WebElement email_field;
	
	@FindBy(css = "#input-telephone")
	WebElement telephone_field;
	
	@FindBy(css = "#input-password")
	WebElement passwod_field;
	
	@FindBy(css = "#input-confirm")
	WebElement confirm_password_field;
	
	@FindBy(xpath = "//*[@id=\"content\"]//*[@type='checkbox']")
	WebElement privacy_chk;
	
	@FindBy(css = "input[type='submit']")
	WebElement register_submit;
	
	@FindBy(css = "#content > h1")
	WebElement reg_success_page_title;
	
	public void fill_and_submit_reg_form() {
		action.enter_text_field(first_name_field, Constants.REG_FIRST_NAME);
		action.enter_text_field(last_name_field, Constants.REG_LAST_NAME);
		action.enter_text_field(email_field, prop.get_property("email"));
		action.enter_text_field(telephone_field, Constants.REG_TELEPHONE);
		action.enter_text_field(passwod_field, prop.get_property("password"));
		action.enter_text_field(confirm_password_field, prop.get_property("password"));
		action.click_on_element(privacy_chk);
		action.click_on_element(register_submit);
		logger.info("Fill and submit the registration form page with test data.");
		
	}
	
	public void validate_registration_success() {
		String page_title = action.get_text_of_element(reg_success_page_title);
		logger.info("Validate the login is successful or failed.");
		Assert.assertEquals(page_title, Constants.REG_SUCCESS_PAGE_TITLE);
		
	}

}
