package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static page.MainPage.waitForElementLocated;

public class EstimationPage {
    //element locators
    public static final String INSTANCE_NUMBER = "//span[text()='Number of Instances']/following-sibling::*[1]";
    public static final String OPERATING_SYSTEM = "//span[text()='Operating System / Software']/following-sibling::*[1]";
    public static final String PROVISIONING_MODEL = "//span[text()='Provisioning Model']/following-sibling::*[1]";
    public static final String MACHINE_TYPE = "//span[text()='Machine type']/following-sibling::*[1]";
    public static final String ADD_GPUS = "//span[text()='Add GPUs']/following-sibling::*[1]";
    public static final String GPU_MODEL = "//span[text()='GPU Model']/following-sibling::*[1]";
    public static final String NUMBER_OF_GPUS = "//span[text()='Number of GPUs']/following-sibling::*[1]";
    public static final String LOCAL_SSD = "//span[text()='Local SSD']/following-sibling::*[1]";
    public static final String REGION = "//span[text()='Region']/following-sibling::*[1]";
    public static final String COMMITED_USE_DISCOUNT = "//span[text()='Committed use discount options']/following-sibling::*[1]";

    //method to get the text for the estimation page to use them on the test asserts
    public String getText(WebDriver driver,String element) {
        //initialize the text variable
        String text = null;
        // witch to the secont window opened for the estimation page
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        //create the text for each element to be compared with the test asserts

                //get the text for Instance number
                waitForElementLocated(driver, By.xpath(element));
                text = driver.findElement(By.xpath(element)).getText();



        return text;
    }
}