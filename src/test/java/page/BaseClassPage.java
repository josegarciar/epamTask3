package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseClassPage {
    protected WebDriver driver;

    public BaseClassPage(WebDriver driver) {
        this.driver = driver;
    }

    //open page method
    public void openPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    // Generic Send data method
    public static void sendData(WebDriver driver, WebElement element, String data) {
        waitForElementLocated(driver, convertToBy(element));
        element.click();
        element.clear();
        element.sendKeys(data);
    }


    //Generic Select dropdown option method
    public void selectData(WebDriver driver, WebElement element1, WebElement element2, int option) {
        waitForElementLocated(driver, convertToBy(element1));
        element1.click();
        List<WebElement> listOfElements = driver.findElements(convertToBy(element2));
        listOfElements.get(option).click();
        //pasteExpirationDropdown2.get(index).click();
    }

    //Generic Click element method
    public void clickElement(WebDriver driver, WebElement element) {
        waitForElementLocated(driver, convertToBy(element));
        element.click();

    }

    // Wait for element method
    protected static WebElement waitForElementLocated(WebDriver driver, By locator) {
        return new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    //Conver to By Webelements created using @FindBy annotation
    protected static By convertToBy(WebElement element) {
        return By.xpath(element.toString().split("xpath: ")[1].replaceFirst(".$", ""));
    }

    public static WebElement waitForElementInvisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}