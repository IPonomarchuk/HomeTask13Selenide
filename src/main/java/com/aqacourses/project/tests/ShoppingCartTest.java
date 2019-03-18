package com.aqacourses.project.tests;

import com.aqacourses.project.base.BaseTest;
import com.aqacourses.project.pages.*;
import com.aqacourses.project.utils.Categories;
import org.junit.Test;

public class ShoppingCartTest extends BaseTest {

    /**
     * Open site and click on the "Sign in" link, fill in email and password to login form and click
     * on the "Sign in" button. Proceed to T-Shirts page and open product, verify breadcrumb and add
     * product to shopping cart and proceed to checkout. Increase quantity of product by one and
     * check that total price is increased by the price of product. Delete the product and verify
     * message
     */
    @Test
    public void testShoppingCartTest() {

        // Open site
        HomePage homePage = openSite();
        log("Opened site");

        // Click on the "Sign in" link
        LoginPage loginPage = homePage.clickSignInLink();
        log("Clicked on the \"Sign in\" link");

        // Fill in email and password to login form and click on the "Sign in" button
        MyAccountPage myAccountPage = loginPage.login();
        log("Filled in email and password to login form and clicked on the \"Sign in\" button");

        // Open TShirtsPage
        TShirtsPage tShirtsPage = myAccountPage.openTShirtsPage();
        log("Opened TShirtsPage");

        // Open the product
        ProductPage productPage = tShirtsPage.openProductByTitle("Faded Short Sleeve T-shirts");
        log("Opened product");

        // Verify breadcrumb
        productPage.verifyBreadcrumb(
                Categories.WOMEN.toString() + ">" + Categories.TOPS + ">" + Categories.TSHIRTS);
        log("Verified breadcrumb");

        // Add product to shopping cart and proceed to checkout
        ShoppingCartPage shoppingCartPage =
                productPage.addProductToShoppingCartAndProceedToCheckout();
        log("Added product to shopping cart and proceeded to checkout");

        // Increase quantity of product by one
        shoppingCartPage.increaseQuantityOfProductByOne();
        log("Increased quantity of product by one");

        // Validate total price
        shoppingCartPage.validateTotalPrice();
        log("Validated total price");

        // Delete product and verify that message is displayed
        shoppingCartPage.deleteProduct();
        log("Deleted product and verified that message is displayed");

        // Close site
        closeSite();
        log("Closed site");
    }
}
