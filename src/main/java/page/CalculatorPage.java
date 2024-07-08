package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static page.MainPage.waitForElementInvisible;
import static page.MainPage.waitForElementLocated;

public class CalculatorPage {
    //element locators
    public static final String ADD_TO_ESTIMATE_BTN = "//button[@data-idom-class='VVEJ3d']";
    public static final String COMPUTE_ENGINE_BTN = "//*[@role='button' and .//h2[text()='Compute Engine']]";
    public static final String NUMBER_OF_INSTANCES = "//input[@id='c13']";
    public static final String OS_SOFTWARE1 = "//div[@placeholder-id='ucc-25']";
    public static final String OS_SOFTWARE2 = "//ul[@role='listbox' and (@aria-label='Operating System / Software')]/*";
    public static final String PROVISIONING_MODEL_REGULAR = "//*[@id='regular']";
    public static final String PROVISIONING_MODEL_SPOT = "//*[@id='spot']";
    public static final String MACHINE_FAMILY1 = "//div[@aria-controls='c26']";
    public static final String MACHINE_FAMILY2 = "//ul[@aria-label='Machine Family']/*";
    public static final String SERIES1 = "//div[@aria-controls='c30']";
    public static final String SERIES2 = "//ul[@aria-label='Series']/*";
    public static final String MACHINE_TYPE1 = "//div[@aria-controls='c34']";
    public static final String MACHINE_TYPE2 = "//ul[@aria-label='Machine type']/*";
    public static final String ADD_GPU_BTN = "//button[@aria-label='Add GPUs']";
    public static final String GPU_MODEL1 = "(//span[text()='NVIDIA T4']/../..)[1]";
    public static final String GPU_MODEL2 = "//ul[@aria-label='GPU Model']/*";
    public static final String NUMBER_OF_GPUS1 = "//*[text()='Number of GPUs']/../../..";
    public static final String NUMBER_OF_GPUS2 = "//ul[@aria-label='Number of GPUs']/*";
    public static final String LOCAL_SSD1 = "//div[@aria-controls='c42']";
    public static final String LOCAL_SSD2 = "//ul[@aria-label='Local SSD']/*";
    public static final String REGION1 = "//div[@aria-controls='c46']";
    public static final String REGION2 = "//ul[@aria-label='Region']/*";
    public static final String COMMITED_USE_1_YEAR_BTN = "//label[@for='1-year']";
    public static final String SAVING_MESSAGE = "//div[text()='Service cost updated']";
    public static final String SHARE_BTN = "//button[@aria-label='Open Share Estimate dialog']";
    public static final String OPEN_ESTIMATE_SUMMARY = "//a[text()='Open estimate summary']";


    // openEstimation method will open the estimation calculator page
    public CalculatorPage openEstimation(WebDriver driver) {
        //click on the Add to Estimate button
        waitForElementLocated(driver, By.xpath(ADD_TO_ESTIMATE_BTN));
        driver.findElement(By.xpath(ADD_TO_ESTIMATE_BTN)).click();
        // use the implicit wait to click on the Compute Engine button, explicit wait
        //was displaying an error
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        // click on the Compute Engine button
        waitForElementLocated(driver, By.xpath(COMPUTE_ENGINE_BTN));
        driver.findElement(By.xpath(COMPUTE_ENGINE_BTN)).click();
        return this;
    }
    public CalculatorPage sendData(WebDriver driver, String element, String data) {

            waitForElementLocated(driver, By.xpath(element));
            driver.findElement(By.xpath(element )).click();
            driver.findElement(By.xpath(element )).clear();
            driver.findElement(By.xpath(element )).sendKeys(data);

        return this;
    }


    // method to select an option from the dropdown fields
    public CalculatorPage selectData(WebDriver driver, String element1, String element2, int option) {
        //base on the number of given element will throw the element and element2 to

        //click on the given element
        waitForElementLocated(driver, By.xpath(element1));
        driver.findElement(By.xpath(element1)).click();
        //click on the given element2 (where the option is saved as a List)
        waitForElementLocated(driver, By.xpath(element2));
        List<WebElement> listOfElements = driver.findElements(By.xpath(element2));
        listOfElements.get(option).click();

        return this;
    }

    //ClickOption method is clicking on different options from the calculation form
    public CalculatorPage clickOption(WebDriver driver, int option) {

        switch (option) {
            case 1:
                //validate if provisioning Model Regular button is checked if not will be checked
                boolean isChecked;
                isChecked = driver.findElement(By.xpath(PROVISIONING_MODEL_REGULAR)).getAttribute("checked").isEmpty();
                if (isChecked) {
                    waitForElementLocated(driver, By.xpath(PROVISIONING_MODEL_REGULAR));
                    driver.findElement(By.xpath(PROVISIONING_MODEL_REGULAR)).click();
                }
                break;
            case 2:
                //click on the Spot button
                waitForElementLocated(driver, By.xpath(PROVISIONING_MODEL_SPOT));
                driver.findElement(By.xpath(PROVISIONING_MODEL_SPOT)).click();
                break;
            case 3:
                //click on the AddGpu button
                waitForElementLocated(driver, By.xpath(ADD_GPU_BTN));
                driver.findElement(By.xpath(ADD_GPU_BTN)).click();
                break;
            case 4:
                //click on the Commited Use for 1 year button
                waitForElementLocated(driver, By.xpath(COMMITED_USE_1_YEAR_BTN));
                driver.findElement(By.xpath(COMMITED_USE_1_YEAR_BTN)).click();
                break;
            case 5:
                //click on the Share button but after to validate that the saving
                //message is displayed and then disappeared (means saved)
                waitForElementLocated(driver, By.xpath(SAVING_MESSAGE));
                waitForElementInvisible(driver, By.xpath(SAVING_MESSAGE));
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                waitForElementLocated(driver, By.xpath(SHARE_BTN));
                driver.findElement(By.xpath(SHARE_BTN)).click();
                break;
            case 6:
                //click on the Open Estimate summary button
                waitForElementLocated(driver, By.xpath(OPEN_ESTIMATE_SUMMARY));
                driver.findElement(By.xpath(OPEN_ESTIMATE_SUMMARY)).click();
                break;
        }
        return this;
    }
}
