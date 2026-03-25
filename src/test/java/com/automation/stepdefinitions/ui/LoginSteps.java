package com.automation.stepdefinitions.ui;
import com.automation.config.ConfigFactory;
import com.automation.driver.DriverManager;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import static com.automation.utils.LoggerUtil.getLogger;
import static org.assertj.core.api.Assertions.assertThat;
public class LoginSteps {
    private static final Logger logger = getLogger(LoginSteps.class);
    private LoginPage loginPage;
    private ProductsPage productsPage;
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        logger.info("Navigating to login page");
        DriverManager.getDriver().get(ConfigFactory.getConfig().appUrl());
        loginPage = new LoginPage();
    }
    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        logger.info("Entering username: {}", username);
        loginPage.enterUsername(username);
    }
    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        logger.info("Entering password");
        loginPage.enterPassword(password);
    }
    @And("I click on login button")
    public void iClickOnLoginButton() {
        logger.info("Clicking login button");
        productsPage = loginPage.clickLogin();
    }
    @Then("I should be redirected to products page")
    public void iShouldBeRedirectedToProductsPage() {
        logger.info("Verifying products page URL");
        String currentUrl = productsPage.getCurrentUrl();
        assertThat(currentUrl).contains("inventory.html");
    }
    @And("I should see products displayed")
    public void iShouldSeeProductsDisplayed() {
        logger.info("Verifying products are displayed");
        assertThat(productsPage.areProductsDisplayed()).isTrue();
    }
    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        logger.info("Verifying error message is displayed");
        assertThat(loginPage.isErrorMessageDisplayed()).isTrue();
    }
    @Then("I should see {string}")
    public void iShouldSee(String result) {
        logger.info("Verifying result: {}", result);
        if (result.equals("products page")) {
            assertThat(DriverManager.getDriver().getCurrentUrl()).contains("inventory");
        } else if (result.equals("error message")) {
            assertThat(loginPage.isErrorMessageDisplayed()).isTrue();
        }
    }
    @Given("I am logged in as {string} with password {string}")
    public void iAmLoggedInAsWithPassword(String username, String password) {
        logger.info("Performing login with user: {}", username);
        DriverManager.getDriver().get(ConfigFactory.getConfig().appUrl());
        loginPage = new LoginPage();
        productsPage = loginPage.login(username, password);
    }
}
