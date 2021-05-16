package ru.training.at.hw4.potest;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.training.at.hw4.steps.MainPageSteps;
import ru.training.at.hw4.testdata.TestData;

@Feature("Implementing Exercise1")
@Story("testing MainPage elements")
public class TestFail extends BaseTest {
    
    @Test
    @Parameters("wrongTitle")
    public void exerciseOne(String wrongTitle) {

        MainPageSteps steps = new MainPageSteps(webDriver);

        steps.openPage();
        steps.assertTitle(wrongTitle);
    }
}
