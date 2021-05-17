package ru.training.at.hw3.potest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestExercise2 extends BaseTest {

    @Test
    @Parameters({"title", "userName", "yellow", "windLogTrue", "waterLogTrue",
        "selenLogTrue", "yellowLogTrue"})
    public void exerciseTwo(String title, String userName, String yellow, String windLogTrue,
                            String waterLogTrue, String selenLogTrue, String yellowLogTrue) {

        //1. Open test site by URL
        webDriver.get("https://jdi-testing.github.io/jdi-light/index.html");

        //2. Assert Brower title
        assertS.assertEquals(mainPage.getTitle(), title);

        //3. Perform login
        mainPage.login(user.getLogin(), user.getPassword());

        // 4. Assert User name in the right-top side of screen that user is logged in
        assertS.assertEquals(mainPage.loggedUser(), userName);

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
        differentElementsPage.colorDropDown(yellow);

        //9. Assert that
        // for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.
        assertS.assertTrue(differentElementsPage
                .searchLog(windLogTrue).isDisplayed());
        assertS.assertTrue(differentElementsPage
                .searchLog(waterLogTrue).isDisplayed());

        // Assert that for radiobutton there is a log row
        // and value is corresponded to the status of radiobutton.
        assertS.assertTrue(differentElementsPage
                .searchLog(selenLogTrue).isDisplayed());

        // Assert that for dropdown there is a log row
        // and value is corresponded to the selected value.
        assertS.assertTrue(differentElementsPage
                .searchLog(yellowLogTrue).isDisplayed());

        //10. Close Browser *DEPRECATED* managed by BaseTest class
        assertS.assertAll();
    }
}
