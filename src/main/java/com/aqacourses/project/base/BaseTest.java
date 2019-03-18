package com.aqacourses.project.base;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

import com.aqacourses.project.pages.HomePage;
import com.aqacourses.project.utils.YamlParser;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.junit.ScreenShooter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    // Instances of WebDriver and WebDriverWait
    private WebDriver driver;

    // Logger
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    // Rule
    @Rule public RunTestRule runTestRule = new RunTestRule(this);

    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests().succeededTests();

    /** Constructor */
    public BaseTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        setWebDriver(driver);
    }

    /**
     * Return instance of Driver
     *
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return getWebDriver();
    }

    /**
     * Open site and return instance of HomePage
     *
     * @return HomePage
     */
    public HomePage openSite() {
        getDriver().get(YamlParser.getYamlData().getUrl());
        return new HomePage(this);
    }

    /** Close site with driver.quit() */
    public void closeSite() {
        getDriver().quit();
    }

    /**
     * Write down info message
     *
     * @param message
     */
    public void log(String message) {
        logger.info(message);
    }

    /**
     * Write down error message
     *
     * @param error
     */
    public void error(String error) {
        logger.error(error);
    }

    /**
     * Wait till element is visible
     *
     * @param element
     */
    public void waitTillElementIsVisible(WebElement element) {
        $(element).shouldBe(Condition.visible);
    }

    /**
     * Wait till value of element is increased by one
     *
     * @param element
     * @param expectedValue
     */
    public void waitTillValueOfElementIsIncreasedByOne(WebElement element, int expectedValue) {
        $(element).shouldBe(Condition.attribute("value", String.valueOf(expectedValue)));
    }
}
