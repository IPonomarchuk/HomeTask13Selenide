package com.aqacourses.project.pages;

import static com.codeborne.selenide.Selenide.$;

import com.aqacourses.project.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends AbstractPage {

    // User name
    private final String MY_NAME = "MyTestFirstName MyTestLastName";

    // Web elements
    @FindBy(xpath = "//div/a[@class='account']")
    private WebElement name;

    /**
     * Constructor
     *
     * @param testClass
     */
    public MyAccountPage(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(divPage);
    }

    /** Verify name */
    public void verifyName() {
        Assert.assertEquals("Name isn't correct", MY_NAME, $(name).getText());
    }
}
