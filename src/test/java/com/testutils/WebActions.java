package com.testutils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebActions {
	private WebDriver driver;
	
	public WebActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public void open_application(String base_url) {
		driver.get(base_url);
	}
	
	public void maximize_browser_window() {
		driver.manage().window().maximize();
	}
	
	public void set_implicit_wait(int imp_wait) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(imp_wait));
	}
	
	public void click_on_element(WebElement elem) {
		elem.click();
	}
	
	public void enter_text_field(WebElement elem, String text) {
		elem.clear();
		elem.sendKeys(text);
	}
		
	public boolean elemenet_visiblity_by_css_locator(String css_selector) {
		try {
		return driver.findElement(By.cssSelector(css_selector)).isDisplayed();
		}
		catch (NoSuchElementException e) {
			// Do nothing
			return false;
		}
	}

}
