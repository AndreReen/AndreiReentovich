package ru.training.at.hw4.potest;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.training.at.hw4.steps.DifferentElementsSteps;


@Feature("Implementing Exercise2")
@Story("testing DifferentElementsPage elements")
public class TestExerciseSteps2 extends BaseTest {

    @Test
    @Parameters({"title", "userName", "yellow", "windLogTrue", "waterLogTrue",
            "selenLogTrue", "yellowLogTrue"})
    public void exerciseTwo(String title, String userName, String yellow, String windLogTrue,
                            String waterLogTrue, String selenLogTrue, String yellowLogTrue) {

        DifferentElementsSteps steps = new DifferentElementsSteps(webDriver);

        //1. Open test site by URL
        steps.openPage();
        //2. Assert Brower title
        steps.assertTitle(title);
        //3. Perform login
        steps.loggingIn(user.getLogin(), user.getPassword());
        // 4. Assert User name in the right-top side of screen that user is logged in
        steps.assertUserName(userName);
        //5. Open through the header menu Service -> Different Elements Page
        steps.goToDifElem();
        //6. Select checkboxes
        steps.selectCheckbox(0);
        steps.selectCheckbox(2);
        //7. Select radio
        steps.selectRadioButton(3);
        //8. Select in dropdown
        steps.selectDropdown(yellow);
        //9. Assert that
        // for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox.
        steps.checkLog(windLogTrue);
        steps.checkLog(waterLogTrue);
        // Assert that for radiobutton there is a log row
        // and value is corresponded to the status of radiobutton.
        steps.checkLog(selenLogTrue);
        // Assert that for dropdown there is a log row
        // and value is corresponded to the selected value.
        steps.checkLog(yellowLogTrue);
    }
}
