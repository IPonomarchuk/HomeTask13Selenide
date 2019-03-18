package com.aqacourses.project.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

import com.aqacourses.project.base.BaseTest;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractPage {

    // Web Elements
    @FindBy(xpath = "//div/a[@class='login']")
    private WebElement signInLink;

    @FindBy(xpath = "//div/a[@class='logout']")
    private WebElement singOutButton;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li/a[@title='Dresses']")
    private WebElement dressesButton;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li/a[@title='T-shirts']")
    private WebElement tShirtsButton;

    @FindBy(xpath = "//div[@class='product-container']")
    protected List<WebElement> listOfProducts;

    @FindBy(xpath = "//span[@class='heading-counter']")
    protected WebElement counterOfProducts;

    @FindBy(xpath = "//div[@id='page']")
    protected WebElement divPage;

    private String PRODUCT_DETAIL_LINK_XPATH = "//h5/a[@title='%s']";

    // Instances of BaseTest
    protected BaseTest testClass;

    /**
     * Constructor
     *
     * @param testClass
     */
    public AbstractPage(BaseTest testClass) {
        this.testClass = testClass;
        page(this);
        testClass.waitTillElementIsVisible(divPage);
    }

    /**
     * Click on the "Sign in" link
     *
     * @return new instance of LoginPage
     */
    public LoginPage clickSignInLink() {
        testClass.waitTillElementIsVisible(signInLink);
        $(signInLink).click();
        return new LoginPage(testClass);
    }

    /**
     * Click on the "Sign out" button
     *
     * @return new instance of LoginPage
     */
    public LoginPage logout() {
        testClass.waitTillElementIsVisible(singOutButton);
        $(singOutButton).click();
        return new LoginPage(testClass);
    }

    /**
     * Click on the "Dresses" button
     *
     * @return new instance of DressesPage
     */
    public DressesPage openDressesPage() {
        testClass.waitTillElementIsVisible(dressesButton);
        $(dressesButton).click();
        return new DressesPage(testClass);
    }

    /**
     * Click on the "T-Shirts" button
     *
     * @return new instance of TShirtsPage
     */
    public TShirtsPage openTShirtsPage() {
        testClass.waitTillElementIsVisible(tShirtsButton);
        $(tShirtsButton).click();
        return new TShirtsPage(testClass);
    }

    /**
     * Open the product
     *
     * @return new instance of ProductPage
     */
    public ProductPage openProductByTitle(String title) {
        $(By.xpath(String.format(PRODUCT_DETAIL_LINK_XPATH, title))).click();
        return new ProductPage(testClass);
    }
}
