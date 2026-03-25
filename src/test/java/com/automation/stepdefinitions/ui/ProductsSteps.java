package com.automation.stepdefinitions.ui;

import com.automation.pages.CartPage;
import com.automation.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;

import static com.automation.utils.LoggerUtil.getLogger;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductsSteps {

    private static final Logger logger = getLogger(ProductsSteps.class);
    private ProductsPage productsPage;
    private CartPage cartPage;

    @When("I am on the products page")
    public void iAmOnTheProductsPage() {
        logger.info("Verifying products page");
        productsPage = new ProductsPage();
    }

    @Then("I should see multiple products displayed")
    public void iShouldSeeMultipleProductsDisplayed() {
        logger.info("Verifying multiple products are displayed");
        assertThat(productsPage.getProductCount()).isGreaterThan(0);
    }

    @And("products page title should be {string}")
    public void productsPageTitleShouldBe(String expectedTitle) {
        logger.info("Verifying products page title: {}", expectedTitle);
        assertThat(productsPage.getPageTitleText()).isEqualTo(expectedTitle);
    }

    @And("I add first product to cart")
    public void iAddFirstProductToCart() {
        logger.info("Adding first product to cart");
        productsPage.addFirstProductToCart();
    }

    @And("I click on cart icon")
    public void iClickOnCartIcon() {
        logger.info("Clicking cart icon");
        cartPage = productsPage.clickCartIcon();
    }

    @Then("I should see {int} item in the cart")
    public void iShouldSeeItemInTheCart(int expectedCount) {
        logger.info("Verifying cart item count: {}", expectedCount);
        assertThat(cartPage.getCartItemCount()).isEqualTo(expectedCount);
    }
}

