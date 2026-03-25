package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    public String getPageTitleText() {
        return pageTitle.getText();
    }

    public int getCartItemCount() {
        return cartItems.size();
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

    public ProductsPage clickContinueShopping() {
        continueShoppingButton.click();
        return new ProductsPage();
    }
}

