package com.aqacourses.project.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;

import com.aqacourses.project.base.BaseTest;
import com.aqacourses.project.utils.YamlParser;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    // Title of the LoginPage
    private final String TITLE = "Login - My Store";

    // Web elements
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailTextField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordTextField;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement signInButton;

    /**
     * Constructor
     *
     * @param testClass
     */
    public LoginPage(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(divPage);
    }

    /** Verify LoginPage */
    public void verifyLoginPage() {
        Assert.assertEquals("Title is not as expected", TITLE, title());
    }

    /**
     * Fill in email and password to login form and click on the "Sign in" button
     *
     * @return new instance of MyAccountPage
     */
    public MyAccountPage login() {
        testClass.waitTillElementIsVisible(emailTextField);
        $(emailTextField).sendKeys(YamlParser.getYamlData().getEmail());
        $(passwordTextField).sendKeys(YamlParser.getYamlData().getPassword());
        $(signInButton).click();
        return new MyAccountPage(testClass);
    }
}
