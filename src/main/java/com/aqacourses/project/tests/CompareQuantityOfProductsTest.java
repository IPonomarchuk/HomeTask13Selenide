package com.aqacourses.project.tests;

import com.aqacourses.project.base.BaseTest;
import com.aqacourses.project.pages.*;
import org.junit.Test;

public class CompareQuantityOfProductsTest extends BaseTest {

    /**
     * Open site and click on the "Sign in" link, fill in email and password to login form and click
     * on the "Sign in" button. Proceed to Dresses page and choose Summer Dresses category. Verify
     * that quantity of products on the page is the same as in the message Choose white dresses and
     * verify that quantity of products on the page is the same as in the message.
     */
    @Test
    public void testCompareQuantityOfProductsTest() {

        // Open site
        HomePage homePage = openSite();
        log("Opened site");

        // Click on the "Sign in" link
        LoginPage loginPage = homePage.clickSignInLink();
        log("Clicked on the \"Sign in\" link");

        // Fill in email and password to login form and click on the "Sign in" button
        MyAccountPage myAccountPage = loginPage.login();
        log("Filled in email and password to login form and clicked on the \"Sign in\" button");

        // Open DressesPage
        DressesPage dressesPage = myAccountPage.openDressesPage();
        log("Opened DressesPage");

        // Choose Summer Dresses Category
        SummerDressesPage summerDressesPage = dressesPage.chooseSummerDressesCategory();
        log("Chose Summer Dresses Category");

        // Verify that quantity of products on the page is the same as in the message
        summerDressesPage.verifyQuantityOfProducts();
        log("Verified that quantity of products on the page is the same as in the message");

        // Choose white dresses
        summerDressesPage.chooseWhiteDresses();
        log("Chose white dresses");

        // Verify that quantity of products on the page is the same as in the message
        summerDressesPage.verifyQuantityOfProducts();
        log("Verified that quantity of products on the page is the same as in the message");

        // Close site
        closeSite();
        log("Closed site");
    }
}
