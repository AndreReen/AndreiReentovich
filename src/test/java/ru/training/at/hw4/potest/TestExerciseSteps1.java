package ru.training.at.hw4.potest;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.training.at.hw4.steps.MainPageSteps;

@Feature("Implementing Exercise1")
@Story("testing MainPage elements")
public class TestExerciseSteps1 extends BaseTest {

    @Test
    @Parameters({"title", "userName",
        "headerItem1", "headerItem2", "headerItem3", "headerItem4",
        "benefit1", "benefit2", "benefit3", "benefit4",
        "headerSize", "imageCount", "textCount", "menuSize",
        "leftMenuItem1", "leftMenuItem2", "leftMenuItem3", "leftMenuItem4", "leftMenuItem5"})
    public void exerciseOne(String title, String userName, String headerItem1,
        String headerItem2, String headerItem3, String headerItem4,
        String benefit1, String benefit2, String benefit3, String benefit4,
        int headerSize, int imageCount, int textCount, int menuSize,
        String leftMenuItem1, String leftMenuItem2, String leftMenuItem3,
        String leftMenuItem4, String leftMenuItem5) {

        MainPageSteps steps = new MainPageSteps(webDriver);

        //1. Open test site by URL
        steps.openPage();
        //2. Assert Brower title
        steps.assertTitle(title);
        //3. Perform login
        steps.loggingIn(user.getLogin(), user.getPassword());
        // 4. Assert User name in the right-top side of screen that user is logged in
        steps.assertUserName(userName);
        //5. Assert that there are 4 items on the header section
        // are displayed and they have proper texts
        steps.assertHeaderMenuSize(headerSize);
        steps.assertHeaderMenuTexts(headerItem1, headerItem2, headerItem3, headerItem4);
        //6. Assert that there are 4 images on the Index Page and they are displayed
        steps.assertBenefitImages(imageCount);
        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        steps.assertBenefitText(textCount, benefit1, benefit2, benefit3, benefit4);
        //8. Assert that there is the iframe with “Frame Button” exist
        steps.assertIframe();
        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        steps.switchToFrame();
        steps.asssertButton();
        //10. Switch to original window back
        steps.switchToMain();
        //11. Assert that there are 5 items in the Left Section
        // are displayed and they have proper text
        steps.assertLeftNavMenu(menuSize, leftMenuItem1, leftMenuItem2,
                leftMenuItem3, leftMenuItem4, leftMenuItem5);
    }
}
