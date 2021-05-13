package ru.training.at.hw4.potest;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw4.pages.DifferentElementsPage;
import ru.training.at.hw4.pages.MainPage;
import ru.training.at.hw4.steps.Steps;
import ru.training.at.hw4.testdata.TestData;

@Feature("Implementing Exercise2")
@Story("testing DifferentElementsPage elements")
public class TestExerciseSteps2 extends BaseTest {

    @Test
    public void exerciseTwo() {
        Steps steps = new Steps(webDriver);

        //1. Open test site by URL
        steps.openPage();
        //2. Assert Brower title
        steps.assertTitle(TestData.HOME_PAGE_TITLE );
        //3. Perform login
        steps.loggingIn();
        // 4. Assert User name in the right-top side of screen that user is logged in
        steps.assertUserName(TestData.EXPECTED_USER_NAME);
        //5. Open through the header menu Service -> Different Elements Page
        steps.goToDifElem();
        //6. Select checkboxes
        steps.selectCheckbox(0);
        steps.selectCheckbox(2);
        //7. Select radio
        steps.selectRadioButton(3);
        //8. Select in dropdown
        steps.selectDropdown(TestData.YELLOW);
        //9. Assert that
        // for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.
        steps.checkLog(TestData.WIND_CHBOX_TO_TRUE);
        steps.checkLog(TestData.WATER_CHBOX_TO_TRUE);
        steps.checkLog(TestData.COLORS_MENU_TO_YELLOW);
        // Assert that for radiobutton there is a log row
        // and value is corresponded to the status of radiobutton.
        steps.checkLog(TestData.METAL_RADIO_TO_SELEN);
        // Assert that for dropdown there is a log row
        // and value is corresponded to the selected value.
        steps.checkLog(TestData.METAL_RADIO_TO_SELEN);
    }
}
