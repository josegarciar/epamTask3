package service;

import driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestNGScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String fail= "Failed-";
        saveScreenshot(fail);
    }

    private void saveScreenshot(String status) {
        WebDriver driver = DriverSingleton.getDriver();
        File screenCapture = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"+ status + getCurrentTimeAsString() + ".png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }

    @Override
    public void onTestStart(ITestResult result) {}

    @Override
    public void onTestSuccess(ITestResult result) {
        String pass= "Passed-";
        saveScreenshot(pass);}

    @Override
    public void onTestSkipped(ITestResult result) {}

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onStart(ITestContext context) {}

    @Override
    public void onFinish(ITestContext context) {}
}
