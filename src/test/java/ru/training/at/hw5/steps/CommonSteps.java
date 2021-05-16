package ru.training.at.hw5.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import ru.training.at.hw5.driverutils.DriverManager;
import ru.training.at.hw5.entity.User;
import ru.training.at.hw5.pages.MainPageJdi;

public class CommonSteps {
    User user = new User();

    @Given("I open JDI GitHub site")
    public void openPage() {
        DriverManager.driver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @And("I login as user Roman Iovlev")
    public void loggingIn() {
        new MainPageJdi(DriverManager.driver).login(user.getLogin(), user.getPassword());
    }

    @And("I click on Service button in Header")
    public void openServiceSubmenu() {
        new MainPageJdi(DriverManager.driver).headerMenuItem(2).click();
    }

    @And("Open Different Elements Page")
    public void openDifferentElementsPage() {
        new MainPageJdi(DriverManager.driver).getDifferentElementsMenuItem().click();
    }

    @And("I click on User Table button in Service dropdown")
    public void openUserTablePage() {
        new MainPageJdi(DriverManager.driver).getUserTableMenuItem().click();
    }
}
