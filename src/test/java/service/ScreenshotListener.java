package service;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotListener implements ITestListener {

    private WebDriver driver;

    public ScreenshotListener(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (driver != null) {
            takeScreenshot(result.getMethod().getMethodName());
        }
    }

    private void takeScreenshot(String methodName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            FileUtils.copyFile(scrFile, new File("screenshots/" + methodName + "_" + timestamp + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Implementación vacía para otros métodos del listener
    @Override
    public void onTestStart(ITestResult result) {}
    @Override
    public void onTestSuccess(ITestResult result) {}
    @Override
    public void onTestSkipped(ITestResult result) {}
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override
    public void onStart(ITestContext context) {}
    @Override
    public void onFinish(ITestContext context) {}
}
