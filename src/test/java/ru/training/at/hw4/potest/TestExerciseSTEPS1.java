package ru.training.at.hw4.potest;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw4.pages.MainPage;
import ru.training.at.hw4.steps.Steps;
import ru.training.at.hw4.testdata.TestData;

@Feature("Implementing Exercise1")
@Story("testing MainPage elements")
public class TestExerciseSTEPS1 extends BaseTest {

    MainPage mainPage;

    @Test
    public void exerciseOne() {
        Steps steps = new Steps(webDriver);

        //1. Open test site by URL
        steps.openPage();
        //2. Assert Brower title
        steps.assertTitle(TestData.HOME_PAGE_TITLE );
        //3. Perform login
        steps.loggingIN();
        // 4. Assert User name in the right-top side of screen that user is logged in
        steps.assertUserName(TestData.EXPECTED_USER_NAME);
        //5. Assert that there are 4 items on the header section
        // are displayed and they have proper texts
        steps.assertHeaderMenu(TestData.EXPECTED_HEADER_SIZE);
        //6. Assert that there are 4 images on the Index Page and they are displayed
        steps.assertBenefitImages(TestData.EXPECTED_IMAGE_COUNT);
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        steps.assertBenefitText(TestData.EXPECTED_TEXT_COUNT);
        //8. Assert that there is the iframe with “Frame Button” exist
        steps.assertIFrame();
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        steps.switchToFrame();
        steps.asssertButton();
        //10. Switch to original window back
        steps.switchToMain();
        //11. Assert that there are 5 items in the Left Section
        // are displayed and they have proper text
        steps.assertLeftNavMenu(TestData.EXPECTED_MENU_SIZE);
    }
}
