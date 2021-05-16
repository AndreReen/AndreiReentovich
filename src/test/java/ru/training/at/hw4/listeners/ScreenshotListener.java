package ru.training.at.hw4.listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.training.at.hw4.driverutils.DriverManager;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed. Taking a screenshot.");
        WebDriver driver = DriverManager.driver;

        try {
            attachScreenShot(driver);
        } catch (NullPointerException e) {
            System.out.println("Driver not found");
        }
    }

    @Attachment(type = "image/png", fileExtension = "png")
    private byte[] attachScreenShot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
