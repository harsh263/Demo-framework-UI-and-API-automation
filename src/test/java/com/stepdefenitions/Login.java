package com.stepdefenitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {

	@Given("I opened the web browser")
	public void i_opened_the_web_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Create object of webdriver and open web browser");
	}

	@Given("Navigate to home page of application under test")
	public void navigate_to_home_page_of_application_under_test() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Navigate to the Home/login page of application under test.");
	}

	@When("Provide valid credentials")
	public void provide_valid_credentials() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Provide valid credentials and click on login button.");
	}

	@Then("Validate successful login")
	public void validate_successful_login() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Validate the successful login message.");
	}

	
	
}
