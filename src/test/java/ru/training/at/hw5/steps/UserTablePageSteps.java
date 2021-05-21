package ru.training.at.hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ru.training.at.hw5.driverutils.DriverManager;
import ru.training.at.hw5.pages.UserTablePage;
import java.util.List;
import java.util.Map;

public class UserTablePageSteps {

    @When("I select 'vip' checkbox for Sergey Ivan")
    public void selectVipCheckboxSergeyIvan() {
        new UserTablePage(DriverManager.driver).getVipCheckboxIvan().click();
    }

    @Then("I log row has {string} text in log section")
    public void checkLogVipTrue(String log) {
        Assert.assertTrue(new UserTablePage(DriverManager.driver)
                .searchLog(log).isDisplayed());
    }

    @Then("{string} page should be opened")
    public void assertUserTableOpen(String title) {
        Assert.assertEquals(DriverManager.driver.getTitle(), title);
    }

    @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void assertDropdownNumber(Integer expectedNumber) {
        Assert.assertTrue(new UserTablePage(DriverManager.driver)
                .getDropdownMenuNumber() == expectedNumber);
    }

    @And("{int} Usernames should be displayed on Users Table on User Table Page")
    public void assertUsernameNumber(Integer expectedNumber) {
        Assert.assertTrue(new UserTablePage(DriverManager.driver)
                .getUsersNumber() == expectedNumber);
    }

    @And("{int} Description texts should be displayed on Users Table on User Table Page")
    public void assertDescriptionTextNumber(Integer expectedNumber) {
        Assert.assertTrue(new UserTablePage(DriverManager.driver)
                .getDescriptionsNumber() == expectedNumber);
    }

    @And("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void assertCheckboxNumber(Integer expectedNumber) {
        Assert.assertTrue(new UserTablePage(DriverManager.driver)
                .getCheckboxNumber() == expectedNumber);
    }

    @And("User table should contain following values")
    public void assertUserTableValues(DataTable dataTable) {
        UserTablePage userTablePage = new UserTablePage(DriverManager.driver);
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);

        for (int i = 0; i < table.size(); i++) {
            Assert.assertEquals(userTablePage.getNumbersText(i), table.get(i).get("number"));
            Assert.assertEquals(userTablePage.getNamesText(i), table.get(i).get("name"));
            Assert.assertEquals(userTablePage
                    .getDescriptionsText(i), table.get(i).get("description"));
        }
    }

    @And("droplist should contain values in column Type for user Roman")
    public void assertDroplistRomanValues(List<String> list) {

        for (int i = 0; i < list.size(); i++) {
            Assert.assertEquals(new UserTablePage(DriverManager.driver)
                    .getDropdownOptionsText(i), list.get(i));
        }
    }
}
