package ru.training.at.hw4.potest;

import org.testng.annotations.Test;
import ru.training.at.hw4.pages.DifferentElementsPage;
import ru.training.at.hw4.pages.MainPage;
import ru.training.at.hw4.testdata.TestData;

public class TestExerciseSTEPS2 extends BaseTest {

    @Test
    public void exerciseTwo() {
        MainPage mainPage = new MainPage(webDriver);
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(webDriver);

        //1. Open test site by URL
        mainPage.openPage();

        //2. Assert Brower title
        assertS.assertEquals(mainPage.getTitle(), TestData.HOME_PAGE_TITLE);

        //3. Perform login
        mainPage.login(TestData.LOGIN, TestData.PASSWORD);

        // 4. Assert User name in the right-top side of screen that user is logged in
        assertS.assertEquals(mainPage.loggedUser(), TestData.EXPECTED_USER_NAME);

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
        differentElementsPage.colorDropDown(TestData.YELLOW);

        //9. Assert that
        // for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.
        assertS.assertTrue(differentElementsPage
                .searchLog(TestData.WIND_CHBOX_TO_TRUE).isDisplayed());
        assertS.assertTrue(differentElementsPage
                .searchLog(TestData.WATER_CHBOX_TO_TRUE).isDisplayed());

        // Assert that for radiobutton there is a log row
        // and value is corresponded to the status of radiobutton.
        assertS.assertTrue(differentElementsPage
                .searchLog(TestData.METAL_RADIO_TO_SELEN).isDisplayed());

        // Assert that for dropdown there is a log row
        // and value is corresponded to the selected value.
        assertS.assertTrue(differentElementsPage
                .searchLog(TestData.COLORS_MENU_TO_YELLOW).isDisplayed());

        //10. Close Browser *DEPRECATED* managed by BaseTest class
        assertS.assertAll();
    }
}
