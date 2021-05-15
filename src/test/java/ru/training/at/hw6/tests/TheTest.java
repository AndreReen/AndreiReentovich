package ru.training.at.hw6.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.training.at.hw6.States.States;

import static org.testng.Assert.assertEquals;
import static ru.training.at.hw6.PageObjects.JdiSite.*;


public class TheTest implements TestsInit {

    @BeforeMethod
    public void openPerformancePage() {
        homePage.shouldBeOpened();
        States.shouldBeLoggedIn();

    }
    @Test
    public void menuTest() {
        headerMenu.select("METALS & COLORS");
    }

}
