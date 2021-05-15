package ru.training.at.hw6.tests;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import ru.training.at.hw6.PageObjects.JdiSite;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static java.lang.String.format;

public class JdiSiteTest {


    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);

    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        //WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test
    public void jdiHomepageBenefitsTest() {
        /*
         *Login on JDI site as User
            Open Metals & Colors page by Header menu
            Fill form Metals & Colors by data below:
            Submit form Metals & Colors
            Result sections should contains data  below:

         */

    }
}