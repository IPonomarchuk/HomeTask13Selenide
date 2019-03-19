package com.aqacourses.project.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.aqacourses.project.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DressesPage extends AbstractPage {

    // Web elements
    @FindBy(xpath = "//div[@class='block_content']//li/a[contains(text(),'Summer Dresses')]")
    private WebElement summerDressesButton;

    @FindBy(xpath = "//input[@id='layered_id_attribute_group_8'][@style='background: #ffffff;']")
    private WebElement whiteCheckBox;

    @FindBy(xpath = "//span[@class='cat-name'][contains(text(),'Summer Dresses > Color White')]")
    private WebElement whiteColorFilter;

    /**
     * Constructor
     *
     * @param testClass
     */
    public DressesPage(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(divPage);
    }

    /**
     * Click on the "Summer Dresses" button
     *
     * @return new instance of SummerDressesPage
     */
    public SummerDressesPage chooseSummerDressesCategory() {
        testClass.waitTillElementIsVisible(summerDressesButton);
        $(summerDressesButton).click();
        return new SummerDressesPage(testClass);
    }

    /** Click on the "White" checkbox */
    public void chooseWhiteDresses() {
        testClass.waitTillElementIsVisible(whiteCheckBox);
        $(whiteCheckBox).click();
        testClass.waitTillElementIsVisible(whiteColorFilter);
    }

    /** Verify that quantity of products on the page is the same as in the message */
    public void verifyQuantityOfProducts() {
        testClass.waitTillElementIsVisible(counterOfProducts);
        Assert.assertEquals(
                "Quantity of products on the page is not the same as in the message",
                $$(listOfProducts).size(),
                Integer.parseInt($(counterOfProducts).getText().replaceAll("[\\D]", "")));
    }
}
