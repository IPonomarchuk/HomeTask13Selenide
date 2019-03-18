package com.aqacourses.project.pages;

import com.aqacourses.project.base.BaseTest;

public class TShirtsPage extends AbstractPage {

    /**
     * Constructor
     *
     * @param testClass
     */
    public TShirtsPage(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(divPage);
    }
}
