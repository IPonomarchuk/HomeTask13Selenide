package com.aqacourses.project.pages;

import static com.codeborne.selenide.Selenide.$;

import com.aqacourses.project.base.BaseTest;
import java.math.BigDecimal;

import com.codeborne.selenide.Condition;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends AbstractPage {

    // Web elements
    @FindBy(xpath = "//a[@title='Add']//span")
    private WebElement plusButton;

    @FindBy(xpath = "//td[@class='cart_unit']/span")
    private WebElement unitPrice;

    @FindBy(xpath = "//td[@class='cart_total']/span")
    private WebElement totalPrice;

    @FindBy(xpath = "//td[@class='cart_quantity text-center']/input[@type='hidden']")
    private WebElement quantityOfProducts;

    private String QUANTITY_OF_PRODUCTS_XPATH =
            "//td[@class='cart_quantity text-center']/input[@type='hidden']";

    @FindBy(xpath = "//i[@class='icon-trash']")
    private WebElement deleteButton;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement emptyShoppingCart;

    private final String MESSAGE_EMPTY_SHOPPING_CART = "Your shopping cart is empty.";

    /**
     * Constructor
     *
     * @param testClass
     */
    public ShoppingCartPage(BaseTest testClass) {
        super(testClass);
    }

    /** Increase quantity of product by one */
    public void increaseQuantityOfProductByOne() {
        int intQuantity = Integer.parseInt($(quantityOfProducts).getAttribute("value"));
        $(plusButton).click();
        System.out.println("Till wait - " + intQuantity);
        testClass.waitTillValueOfElementIsIncreasedByOne(quantityOfProducts, intQuantity + 1);
    }

    /** Validate total price */
    public void validateTotalPrice() {

        BigDecimal bigDecimalUnitPrice =
                new BigDecimal($(unitPrice).getText().replaceAll("[^0-9,.]", ""));
        BigDecimal bigDecimalTotalPrice =
                new BigDecimal($(totalPrice).getText().replaceAll("[^0-9,.]", ""));
        int intQuantity = Integer.parseInt($(quantityOfProducts).getAttribute("value"));
        System.out.println("After wait - " + intQuantity);
        Assert.assertEquals(
                "Total price isn't correct",
                bigDecimalTotalPrice,
                (bigDecimalUnitPrice.multiply(new BigDecimal(intQuantity))));
    }

    /** Delete product and verify that message is displayed */
    public void deleteProduct() {
        $(deleteButton).click();
        testClass.waitTillElementIsVisible(emptyShoppingCart);
        Assert.assertEquals(
                "Message is not the same as expected",
                MESSAGE_EMPTY_SHOPPING_CART,
                $(emptyShoppingCart).text());
    }
}
