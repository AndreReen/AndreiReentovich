package ru.training.at.hw3.potest;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import ru.training.at.hw3.driverutils.DriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;


public class BaseTest {

    public WebDriver webDriver;
    public SoftAssert assertS;
    public String login = "";
    public String password = "";

    @BeforeClass
    public void prepareToTest() {
        //Using our singleton for driver setup
        webDriver = DriverManager.setupDriver();
        System.out.println(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();

        assertS = new SoftAssert();

        // loading credetials from properties file
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String testDataPath = rootPath + "testData.properties";

        Properties testProps = new Properties();
        try {
            testProps.load(new FileInputStream(testDataPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        login = testProps.getProperty("login");
        password = testProps.getProperty("password");
    }

    @AfterClass
    public void resetBetweenTests() {
        webDriver.manage().deleteAllCookies();
        webDriver.navigate().refresh();
    }

    @AfterSuite
    public void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
