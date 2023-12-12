package com.pageactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.testutils.WebActions;

public class HomePageActions {
	
	private WebDriver driver;
	private WebActions action;
	
	
	public HomePageActions(WebDriver driver) {
		action = new WebActions(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(css = "li.dropdown a[href*='route=account/account']")
	WebElement MyAccLink;
	
	@FindBy(css = "a[href$='route=account/login']")
	WebElement LoginLink;
	
	public LoginPageActions navigate_to_login_page() {
		action.click_on_element(MyAccLink);
		action.click_on_element(LoginLink);
		return new LoginPageActions(driver);
	}

}
