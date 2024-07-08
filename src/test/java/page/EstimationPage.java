package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class EstimationPage extends BaseClassPage {
    //element locators
    @FindBy(xpath = "//span[text()='Number of Instances']/following-sibling::*[1]")
    private WebElement instanceNumber;

    @FindBy(xpath = "//span[text()='Operating System / Software']/following-sibling::*[1]")
    private WebElement operatingSystem;

    @FindBy(xpath = "//span[text()='Provisioning Model']/following-sibling::*[1]")
    private WebElement provisioningModel;

    @FindBy(xpath = "//span[text()='Machine type']/following-sibling::*[1]")
    private WebElement machineType;

    @FindBy(xpath = "//span[text()='Add GPUs']/following-sibling::*[1]")
    private WebElement addGpus;

    @FindBy(xpath = "//span[text()='GPU Model']/following-sibling::*[1]")
    private WebElement gpuModel;

    @FindBy(xpath = "//span[text()='Number of GPUs']/following-sibling::*[1]")
    private WebElement numberOfGpus;

    @FindBy(xpath = "//span[text()='Local SSD']/following-sibling::*[1]")
    private WebElement localSsd;

    @FindBy(xpath = "//span[text()='Region']/following-sibling::*[1]")
    private WebElement region;

    @FindBy(xpath = "//span[text()='Committed use discount options']/following-sibling::*[1]")
    private WebElement commitedUseDiscount;

    public EstimationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getInstanceNumberText() {
        // witch to the second window opened for the estimation page
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        waitForElementLocated(driver, convertToBy(instanceNumber));
        return instanceNumber.getText().trim();
    }
    public String getOperatingSystemText() {
        waitForElementLocated(driver, convertToBy(operatingSystem));
        return operatingSystem.getText().trim();
    }
    public String getProvisioningModelText() {
        waitForElementLocated(driver, convertToBy(provisioningModel));
        return provisioningModel.getText().trim();
    }
    public String getMachineTypeText() {
        waitForElementLocated(driver, convertToBy(machineType));
        return machineType.getText().trim();
    }
    public String getAddGpusText() {
        waitForElementLocated(driver, convertToBy(addGpus));
        return addGpus.getText().trim();
    }
    public String getGpuModelText() {
        waitForElementLocated(driver, convertToBy(gpuModel));
        return gpuModel.getText().trim();
    }
    public String getNumberOfGpusText() {
        waitForElementLocated(driver, convertToBy(numberOfGpus));
        return numberOfGpus.getText().trim();
    }
    public String getLocalSsdText() {
        waitForElementLocated(driver, convertToBy(localSsd));
        return localSsd.getText().trim();
    }
    public String getRegionText() {
        waitForElementLocated(driver, convertToBy(region));
        return region.getText().trim();
    }
    public String getCommitedUseDiscountText() {
        waitForElementLocated(driver, convertToBy(commitedUseDiscount));
        return commitedUseDiscount.getText().trim();
    }
}
