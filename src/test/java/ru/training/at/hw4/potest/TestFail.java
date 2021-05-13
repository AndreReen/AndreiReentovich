package ru.training.at.hw4.potest;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw4.pages.MainPage;
import ru.training.at.hw4.steps.Steps;
import ru.training.at.hw4.testdata.TestData;

@Feature("Implementing Exercise1")
@Story("testing MainPage elements")
public class TestFail extends BaseTest {
    
    @Test
    public void exerciseOne() {
        Steps steps = new Steps(webDriver);


        steps.openPage();
        steps.assertTitle(TestData.HOME_PAGE_TITLE );
        steps.loggingIn();
        steps.assertUserName(TestData.EXPECTED_USER_NAME);
        steps.assertHeaderMenu(10);
        steps.assertBenefitImages(TestData.EXPECTED_IMAGE_COUNT);
        steps.assertBenefitText(TestData.EXPECTED_TEXT_COUNT);
        steps.assertIframe();
        steps.switchToFrame();
        steps.asssertButton();
        steps.switchToMain();
        steps.assertLeftNavMenu(TestData.EXPECTED_MENU_SIZE);
    }
}
