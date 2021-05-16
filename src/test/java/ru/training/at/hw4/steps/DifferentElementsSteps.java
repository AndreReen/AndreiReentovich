package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.training.at.hw4.pages.DifferentElementsPage;


public class DifferentElementsSteps extends CommonSteps {

    DifferentElementsPage differentElementsPage;

    public DifferentElementsSteps(WebDriver webDriver) {
        super(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
    }

    @Step("Select checkbox")
    public void selectCheckbox(int checkboxNumber) {
        differentElementsPage.getCheckBox(checkboxNumber).click();
        Assert.assertTrue(differentElementsPage.getCheckBox(checkboxNumber).isSelected());
    }

    @Step("Select radiobutton")
    public void selectRadioButton(int radioButtonNumber) {
        differentElementsPage.getRadioButton(radioButtonNumber).click();
        Assert.assertTrue(differentElementsPage.getRadioButton(radioButtonNumber).isSelected());
    }

    @Step("Select from dropdown menu")
    public void selectDropdown(String color) {
        differentElementsPage.colorDropDown(color);
    }

    @Step("Check log ")
    public void checkLog(String logEntry) {
        Assert.assertTrue(differentElementsPage
                .searchLog(logEntry).isDisplayed());
    }
}
