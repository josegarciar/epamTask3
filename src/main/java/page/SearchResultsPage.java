package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



import static page.MainPage.waitForElementLocated;

public class SearchResultsPage {
    private static final String SEARCH_FIELD = "//input[@aria-label='Search']";
    private static final String CALCULATOR_LINK = "(//div[@class='gs-title']/a[contains(@href, 'cloud.google.com/products/calculator') and contains(., 'Google Cloud Pricing Calculator')])[1]";

    public SearchResultsPage searchText(WebDriver driver, String text){
        waitForElementLocated(driver, By.xpath(SEARCH_FIELD));
        driver.findElement(By.xpath(SEARCH_FIELD)).sendKeys(text);
        driver.findElement(By.xpath(SEARCH_FIELD)).submit();
        return this;
    }
    public SearchResultsPage selectCalculatorLink(WebDriver driver){
        waitForElementLocated(driver,By.xpath(CALCULATOR_LINK));
        driver.findElement(By.xpath(CALCULATOR_LINK)).click();
        return this;
    }
}
