package ru.training.at.hw3.potest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.pages.MainPage;

public class TestExercise1 extends BaseTest {

    SoftAssert assertS = new SoftAssert();

    @Test
    public void exerciseOne() {
        MainPage mainPage = new MainPage(webDriver);
        //System.out.println(webDriver);

        //1. Open test site by URL
        mainPage.openPage();

        //2. Assert Brower title
        assertS.assertEquals(mainPage.getTitle(), "Home Page");

        //3. Perform login
        mainPage.login("Roman", "Jdi1234");

        // 4. Assert User name in the right-top side of screen that user is logged in
        assertS.assertEquals(mainPage.loggedUser(), "ROMAN IOVLEV");

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertS.assertEquals(mainPage.headerMenuSize(), 4);
        assertS.assertEquals(mainPage.headerMenuItemText(0),"HOME");

        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertS.assertEquals(mainPage.imageCount(), 4);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertS.assertEquals(mainPage.textCount(), 4);;
        assertS.assertEquals(mainPage.textGet(1), "To be flexible and\n"
                + "customizable");

        //8. Assert that there is the iframe with “Frame Button” exist
        assertS.assertTrue(mainPage.frameItem().isDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");
        assertS.assertTrue(mainPage.frameButtonItem().isDisplayed());

        //10. Switch to original window back
        webDriver.switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        String [] expectedMenuItems = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
        int expectedMenuSize = 5;

        assertS.assertEquals(mainPage.leftNavMenuSize(), expectedMenuSize);
        for (int i = 0; i < mainPage.leftNavMenuSize(); i++) {
            assertS.assertEquals(mainPage.leftNavMenuItems(i), expectedMenuItems[i]);
        }

        //12. Close Browser *DEPRECATED*
        assertS.assertAll();
    }
}
