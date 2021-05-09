package ru.training.at.hw3.potest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.pages.MainPage;
import ru.training.at.hw3.testdata.TestData;

public class TestExercise1 extends BaseTest {

    SoftAssert assertS = new SoftAssert();


    @Test
    public void exerciseOne() {
        MainPage mainPage = new MainPage(webDriver);

        //1. Open test site by URL
        mainPage.openPage();

        //2. Assert Brower title
        assertS.assertEquals(mainPage.getTitle(), TestData.HOME_PAGE_TITLE);

        //3. Perform login
        mainPage.login(TestData.LOGIN, TestData.PASSWORD);

        // 4. Assert User name in the right-top side of screen that user is logged in
        assertS.assertEquals(mainPage.loggedUser(), TestData.EXPECTED_USER_NAME);

        //5. Assert that there are 4 items on the header section
        // are displayed and they have proper texts
        assertS.assertEquals(mainPage.headerMenuSize(), TestData.EXPECTED_HEADER_SIZE);
        assertS.assertEquals(mainPage.headerMenuItemText(0), TestData.HEADER_ITEM_1);
        assertS.assertEquals(mainPage.headerMenuItemText(1), TestData.HEADER_ITEM_2);
        assertS.assertEquals(mainPage.headerMenuItemText(2), TestData.HEADER_ITEM_3);
        assertS.assertEquals(mainPage.headerMenuItemText(3), TestData.HEADER_ITEM_4);


        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertS.assertEquals(mainPage.imageCount(), TestData.EXPECTED_IMAGE_COUNT);

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertS.assertEquals(mainPage.textCount(), TestData.EXPECTED_TEXT_COUNT);
        assertS.assertEquals(mainPage.textGet(0), TestData.BENEFIT_TEXT_1);
        assertS.assertEquals(mainPage.textGet(1), TestData.BENEFIT_TEXT_2);
        assertS.assertEquals(mainPage.textGet(2), TestData.BENEFIT_TEXT_3);
        assertS.assertEquals(mainPage.textGet(3), TestData.BENEFIT_TEXT_4);

        //8. Assert that there is the iframe with “Frame Button” exist
        assertS.assertTrue(mainPage.frameItem().isDisplayed());

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");
        assertS.assertTrue(mainPage.frameButtonItem().isDisplayed());

        //10. Switch to original window back
        webDriver.switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section
        // are displayed and they have proper text
        assertS.assertEquals(mainPage.leftNavMenuSize(), TestData.EXPECTED_MENU_SIZE);
        for (int i = 0; i < mainPage.leftNavMenuSize(); i++) {
            assertS.assertEquals(mainPage.leftNavMenuItems(i), TestData.EXPECTED_MENU_ITEMS[i]);
        }

        //12. Close Browser *DEPRECATED* managed by BaseTest class
        assertS.assertAll();
    }
}
