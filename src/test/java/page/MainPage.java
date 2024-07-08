package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage extends BaseClassPage {
    private static final String homePageUrl= "https://cloud.google.com/";

    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchField;


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        openPage(homePageUrl);
    }
    public void searchPage(String data){
        waitForElementLocated(driver, convertToBy(searchField));
        searchField.click();
        searchField.sendKeys(data);
        searchField.submit();
    }
}








