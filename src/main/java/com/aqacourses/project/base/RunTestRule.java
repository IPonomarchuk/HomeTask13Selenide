package com.aqacourses.project.base;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class RunTestRule extends TestWatcher {

    // Instance of BaseTest
    private BaseTest testClass;

    /**
     * Constructor
     *
     * @param testClass
     */
    public RunTestRule(BaseTest testClass) {
        this.testClass = testClass;
    }

    /**
     * Make driver.quit()
     *
     * <p>Overriding this method you can add some action when test is starting
     *
     * @param description
     */
    @Override
    protected void finished(Description description) {
        testClass.getDriver().quit();
    }

    /**
     * Make screenshot and make driver.quit() Overriding this method you can add some actions on
     * test failing
     *
     * @param e
     * @param description
     */
    @Override
    protected void failed(Throwable e, Description description) {

        // Write down to log file error message
        testClass.error(e.getMessage());

        // Driver quits on fail
        testClass.getDriver().quit();
    }
}
