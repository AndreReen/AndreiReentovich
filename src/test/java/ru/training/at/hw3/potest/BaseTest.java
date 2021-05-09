package ru.training.at.hw3.potest;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ru.training.at.hw3.driverutils.DriverManager;


public class BaseTest {

    public WebDriver webDriver;

    @BeforeMethod
    public void prepareToTest() {
        //Using our singleton for setup
        webDriver = DriverManager.setupDriver();
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDownDriver() {
        if (webDriver != null) {
            webDriver.close();
        }
    }
}
