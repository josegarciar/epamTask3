package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class CalculatorPage extends BaseClassPage {
    //element locators
    @FindBy(xpath = "//button[@data-idom-class='VVEJ3d']")
    private WebElement addToEstimateBtn;

    @FindBy(xpath = "//*[@role='button' and .//h2[text()='Compute Engine']]")
    private WebElement computeEngineBtn;

    @FindBy(xpath = "//input[@id='c13']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//div[@placeholder-id='ucc-25']")
    private WebElement osSoftware1;

    @FindBy(xpath = "//ul[@role='listbox' and (@aria-label='Operating System / Software')]/*")
    private WebElement osSoftware2;

    @FindBy(xpath = "//input[@value='regular']")
    private WebElement provisioningModelRegularBtn;

    @FindBy(xpath = "//div[@aria-controls='c26']")
    private WebElement machineFamily1;

    @FindBy(xpath = "//ul[@aria-label='Machine Family']/*")
    private WebElement machineFamily2;

    @FindBy(xpath = "//div[@aria-controls='c30']")
    private WebElement series1;

    @FindBy(xpath = "//ul[@aria-label='Series']/*")
    private WebElement series2;

    @FindBy(xpath = "//div[@aria-controls='c34']")
    private WebElement machineType1;

    @FindBy(xpath = "//ul[@aria-label='Machine type']/*")
    private WebElement machineType2;

    @FindBy(xpath = "//button[@aria-label='Add GPUs']")
    private WebElement addGpuBtn;

    @FindBy(xpath = "(//span[text()='NVIDIA T4']/../..)[1]")
    private WebElement gpuModel1;

    @FindBy(xpath = "//ul[@aria-label='GPU Model']/*")
    private WebElement gpuModel2;

    @FindBy(xpath = "//*[text()='Number of GPUs']/../../..")
    private WebElement numberOfGpus1;

    @FindBy(xpath = "//ul[@aria-label='Number of GPUs']/*")
    private WebElement numberOfGpus2;

    @FindBy(xpath = "//div[@aria-controls='c42']")
    private WebElement localSsd1;

    @FindBy(xpath = "//ul[@aria-label='Local SSD']/*")
    private WebElement localSsd2;

    @FindBy(xpath = "//div[@aria-controls='c46']")
    private WebElement region1;

    @FindBy(xpath = "//ul[@aria-label='Region']/*")
    private WebElement region2;

    @FindBy(xpath = "//label[text()='1 year']")
    private WebElement commitedUse1YearBtn;

    @FindBy(xpath = "//div[text()='Service cost updated']")
    private WebElement savingMessage;

    @FindBy(xpath = "//button[@aria-label='Open Share Estimate dialog']")
    private WebElement shareBtn;

    @FindBy(xpath = "//a[text()='Open estimate summary']")
    private WebElement openEstimateSummaryBtn;

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickAddToEstimateBtn() {
        clickElement(driver, addToEstimateBtn);
    }
    public void clickComputeEngineBtn() {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        clickElement(driver, computeEngineBtn);
    }

    public void enterNumberOfInstances(String data){
        sendData(driver, numberOfInstances, data);
    }
    public void selectOsSoftware(int option){
        selectData(driver,osSoftware1,osSoftware2,option);
    }
    public void clickProvisioningRegularBtn(){
        boolean isChecked;
        isChecked = provisioningModelRegularBtn.getAttribute("checked").isEmpty();
        if (isChecked) {
            waitForElementLocated(driver, convertToBy(provisioningModelRegularBtn));
            provisioningModelRegularBtn.click();
        }
    }
    public void selectMachineFamily(int option){
        selectData(driver,machineFamily1,machineFamily2,option);
    }

    public void selectSeries(int option){
        selectData(driver,series1,series2,option);
    }
    public void selectMachineType(int option){
        selectData(driver,machineType1,machineType2,option);
    }
    public void clickAddGpuBtn() {
        clickElement(driver, addGpuBtn);
    }
    public void selectGpuModel(int option){
        selectData(driver,gpuModel1,gpuModel2,option);
    }
    public void selectNumberOfGpus(int option){
        selectData(driver,numberOfGpus1,numberOfGpus2,option);
    }
    public void selectLocalSsd(int option){
        selectData(driver,localSsd1,localSsd2,option);
    }
    public void selectRegion(int option){
        selectData(driver,region1,region2,option);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    public void clickCommitedUse1Year() {
        clickElement(driver, commitedUse1YearBtn);
    }
    public void clickShareBtn() {
        waitForElementLocated(driver, convertToBy(savingMessage));
        waitForElementInvisible(driver, convertToBy(savingMessage));


        clickElement(driver, shareBtn);
    }
    public void clickOpenEstimateSummary() {
        clickElement(driver, openEstimateSummaryBtn);
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
