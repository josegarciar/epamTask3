package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends BaseClassPage {
    @FindBy(xpath = "(//div[@class='gs-title']/a[contains(@href, 'cloud.google.com/products/calculator') and contains(., 'Google Cloud Pricing Calculator')])[1]")
    private WebElement calculatorLink;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void selectCalculatorLink(){
        waitForElementLocated(driver, convertToBy(calculatorLink));
        calculatorLink.click();

    }
}
