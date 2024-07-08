package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class MainPage {
    private static final String HOME_PAGE_URL= "https://cloud.google.com/";
    private static final String SEARCH_FIELD =  "//input[@aria-label='Search']";


    public MainPage openPage(WebDriver driver){
        driver.get( HOME_PAGE_URL);
        driver.manage().window().maximize();
        waitForElementLocated(driver, By.xpath(SEARCH_FIELD));
        return this;
    }
    public static WebElement waitForElementLocated (WebDriver driver, By by){
        return new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public static Boolean waitForElementInvisible (WebDriver driver, By by){
        return new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
}








