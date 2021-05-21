package ru.training.at.hw5.hook;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import ru.training.at.hw5.driverutils.DriverManager;

public class WebDriverHook {

    @Before
    public void setUp() {
        DriverManager.setupDriver();
    }

    @After
    public void tearDown() {
        DriverManager.driver.quit();
        DriverManager.driver = null;
    }
}
