package ru.training.at.hw3.potest;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.potest.BaseTest;
import ru.training.at.hw3.pages.MainPage;

public class MainPageTest extends BaseTest {

    SoftAssert assertS = new SoftAssert();

    @Inject
    private MainPage mainPage;

    @Test
    public void exerciseOne() {

        //1. Open test site by URL
        mainPage.openTestPage();

        //2. Assert Brower title
        mainPage.verifyTitle("Home Page");

        //3. Perform login
        mainPage.login("Roman", "Jdi1234");

        // 4. Assert User name in the right-top side of screen that user is logged in
        mainPage.loggedUser("ROMAN IOVLEV");

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertS.assertEquals(mainPage.headerMenuSize(), 4);
        assertS.assertEquals(mainPage.headerMenuItem(0),"HOME");

        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertS.assertEquals(mainPage.imageCount(), 4);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertS.assertEquals(mainPage.textCount(), 4);;
        assertS.assertEquals(mainPage.textGet(1), "To be flexible and\n"
                + "customizable");

        //8. Assert that there is the iframe with “Frame Button” exist

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe

        //10. Switch to original window back

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text

        //12. Close Browser *DEPRECATED*
        assertS.assertAll();
    }
}
