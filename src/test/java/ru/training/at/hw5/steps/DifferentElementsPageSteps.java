package ru.training.at.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ru.training.at.hw5.driverutils.DriverManager;
import ru.training.at.hw5.pages.DifferentElementsPageJdi;

public class DifferentElementsPageSteps {
    
    @When("I select checkbox Water")
    public void selectWaterCheckBox() {
        new DifferentElementsPageJdi(DriverManager.driver).getCheckBox(0).click();
    }

    @And("select checkbox Wind")
    public void selectWindCheckBox() {
        new DifferentElementsPageJdi(DriverManager.driver).getCheckBox(2).click();
    }

    @And("select radio button Selen")
    public void selectSelenRadioButton() {
        new DifferentElementsPageJdi(DriverManager.driver)
                .getRadioButton(3).click();
    }

    @And("select color {string} from dropdown menu")
    public void selectYellowColor(String color) {
        new DifferentElementsPageJdi(DriverManager.driver).colorDropDown(color);
    }

    @Then("Log entry correspondent to checkbox Water is displayed {string}")
    public void checkLogWater(String log) {
        Assert.assertTrue(new DifferentElementsPageJdi(DriverManager.driver)
                .searchLog(log).isDisplayed());
    }

    @Then("Log entry correspondent to checkbox Wind is displayed {string}")
    public void checkLogWind(String log) {
        Assert.assertTrue(new DifferentElementsPageJdi(DriverManager.driver)
                .searchLog(log).isDisplayed());
    }

    @Then("Log entry correspondent to radio button Selen is displayed {string}")
    public void checkLogSelen(String log) {
        Assert.assertTrue(new DifferentElementsPageJdi(DriverManager.driver)
                .searchLog(log).isDisplayed());
    }

    @Then("Log entry correspondent color Yellow is displayed {string}")
    public void checkLogYellow(String log) {
        Assert.assertTrue(new DifferentElementsPageJdi(DriverManager.driver)
                .searchLog(log).isDisplayed());
    }
}
