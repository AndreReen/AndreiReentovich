package ru.training.at.hw3.potest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestExercise1 extends BaseTest {

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

        //1. Open test site by URL
        webDriver.get("https://jdi-testing.github.io/jdi-light/index.html");

        //2. Assert Brower title
        assertS.assertEquals(mainPage.getTitle(), title);

        //3. Perform login
        mainPage.login(user.getLogin(), user.getPassword());

        // 4. Assert User name in the right-top side of screen that user is logged in
        assertS.assertEquals(mainPage.loggedUser(), userName);

        //5. Assert that there are 4 items on the header section
        // are displayed and they have proper texts
        assertS.assertEquals(mainPage.headerMenuSize(), headerSize);
        assertS.assertEquals(mainPage.headerMenuItemText(0), headerItem1);
        assertS.assertEquals(mainPage.headerMenuItemText(1), headerItem2);
        assertS.assertEquals(mainPage.headerMenuItemText(2), headerItem3);
        assertS.assertEquals(mainPage.headerMenuItemText(3), headerItem4);


        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertS.assertEquals(mainPage.imageCount(), imageCount);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertS.assertEquals(mainPage.textCount(), textCount);
        assertS.assertEquals(mainPage.textGet(0), benefit1);
        assertS.assertEquals(mainPage.textGet(1), benefit2);
        assertS.assertEquals(mainPage.textGet(2), benefit3);
        assertS.assertEquals(mainPage.textGet(3), benefit4);

        //8. Assert that there is the iframe with “Frame Button” exist
        assertS.assertTrue(mainPage.frameItem().isDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");
        assertS.assertTrue(mainPage.frameButtonItem().isDisplayed());

        //10. Switch to original window back
        webDriver.switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section
        // are displayed and they have proper text
        assertS.assertEquals(mainPage.leftNavMenuSize(), menuSize);

        assertS.assertEquals(mainPage.leftNavMenuItems(0), leftMenuItem1);
        assertS.assertEquals(mainPage.leftNavMenuItems(1), leftMenuItem2);
        assertS.assertEquals(mainPage.leftNavMenuItems(2), leftMenuItem3);
        assertS.assertEquals(mainPage.leftNavMenuItems(3), leftMenuItem4);
        assertS.assertEquals(mainPage.leftNavMenuItems(4), leftMenuItem5);

        //12. Close Browser *DEPRECATED* managed by BaseTest class
        assertS.assertAll();
    }
}
