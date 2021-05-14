package ru.training.at.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ru.training.at.hw5.driverutils.DriverManager;
import ru.training.at.hw5.pages.DifferentElementsPageJdi;
import ru.training.at.hw5.testdata.TestData;

public class DifferentElementsPageSteps {


    @When("I select checkbox Water")
    public void selectWaterCheckBox() {
        new DifferentElementsPageJdi(DriverManager.driver).getCheckBox(TestData.WATER_BOX).click();
    }

    @And("select checkbox Wind")
    public void selectWindCheckBox() {
        new DifferentElementsPageJdi(DriverManager.driver).getCheckBox(TestData.WIND_BOX).click();
    }

    @And("select radio button Selen")
    public void selectSelenRadioButton() {
        new DifferentElementsPageJdi(DriverManager.driver)
                .getRadioButton(TestData.SELEN_RADIO).click();
    }

    @And("select color Yellow from dropdown menu")
    public void selectYellowColor() {
        new DifferentElementsPageJdi(DriverManager.driver).colorDropDown(TestData.YELLOW);
    }

    @Then("Log entry correspondent to checkbox Water is displayed")
    public void checkLogWater() {
        Assert.assertTrue(new DifferentElementsPageJdi(DriverManager.driver)
                .searchLog(TestData.WATER_CHBOX_TO_TRUE).isDisplayed());
    }

    @Then("Log entry correspondent to checkbox Wind is displayed")
    public void checkLogWind() {
        Assert.assertTrue(new DifferentElementsPageJdi(DriverManager.driver)
                .searchLog(TestData.WIND_CHBOX_TO_TRUE).isDisplayed());
    }

    @Then("Log entry correspondent to radio button Selen is displayed")
    public void checkLogSelen() {
        Assert.assertTrue(new DifferentElementsPageJdi(DriverManager.driver)
                .searchLog(TestData.METAL_RADIO_TO_SELEN).isDisplayed());
    }

    @Then("Log entry correspondent color Yellow is displayed")
    public void checkLogYellow() {
        Assert.assertTrue(new DifferentElementsPageJdi(DriverManager.driver)
                .searchLog(TestData.COLORS_MENU_TO_YELLOW).isDisplayed());
    }
}
