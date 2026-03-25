package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "inventory_item")
    private List<WebElement> productItems;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(css = ".inventory_item .btn_inventory")
    private List<WebElement> addToCartButtons;

    public String getPageTitleText() {
        return pageTitle.getText();
    }

    public boolean areProductsDisplayed() {
        return !productItems.isEmpty();
    }

    public int getProductCount() {
        return productItems.size();
    }

    public ProductsPage addFirstProductToCart() {
        if (!addToCartButtons.isEmpty()) {
            addToCartButtons.get(0).click();
        }
        return this;
    }

    public CartPage clickCartIcon() {
        cartIcon.click();
        return new CartPage();
    }
}

