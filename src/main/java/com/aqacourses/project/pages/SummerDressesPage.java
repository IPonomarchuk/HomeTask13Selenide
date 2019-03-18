package com.aqacourses.project.pages;

import com.aqacourses.project.base.BaseTest;

public class SummerDressesPage extends DressesPage {

    /**
     * Constructor
     *
     * @param testClass
     */
    public SummerDressesPage(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(divPage);
    }
}
