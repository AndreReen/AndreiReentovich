package ru.training.at.hw3.potest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.pages.DifferentElementsPage;
import ru.training.at.hw3.pages.MainPage;

public class TestExercise2 extends BaseTest {

    SoftAssert assertS = new SoftAssert();

    @Test
    public void exerciseTwo() {
        MainPage mainPage = new MainPage(webDriver);
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(webDriver);

        //System.out.println(webDriver);

        //1. Open test site by URL
        mainPage.openPage();

        //2. Assert Brower title
        assertS.assertEquals(mainPage.getTitle(), "Home Page");

        //3. Perform login
        mainPage.login("Roman", "Jdi1234");

        // 4. Assert User name in the right-top side of screen that user is logged in
        assertS.assertEquals(mainPage.loggedUser(), "ROMAN IOVLEV");

        //5. Open through the header menu Service -> Different Elements Page
        mainPage.headerMenuItem(2).click();
        mainPage.getDifferentElementsMenuItem().click();

        //6. Select checkboxes
        differentElementsPage.getCheckBox(0).click();
        assertS.assertTrue(differentElementsPage.getCheckBox(0).isSelected());
        differentElementsPage.getCheckBox(2).click();
        assertS.assertTrue(differentElementsPage.getCheckBox(2).isSelected());

        //7. Select radio
        differentElementsPage.getRadioButton(3).click();
        assertS.assertTrue(differentElementsPage.getRadioButton(3).isSelected());

        //8. Select in dropdown
        differentElementsPage.colorDropDown("Yellow");

       //9. Assert that
       // for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        assertS.assertTrue(differentElementsPage.searchLog("Wind: condition changed to true").isDisplayed());
        assertS.assertTrue(differentElementsPage.searchLog("Water: condition changed to true").isDisplayed());

        // Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton.
        assertS.assertTrue(differentElementsPage.searchLog("metal: value changed to  Selen").isDisplayed());

        // Assert that for dropdown there is a log row and value is corresponded to the selected value.
        assertS.assertTrue(differentElementsPage.searchLog("Colors: value changed to Yellow").isDisplayed());

        //10. Close Browser *DEPRECATED*
        assertS.assertAll();
    }
}
