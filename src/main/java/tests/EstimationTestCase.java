package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.CalculatorPage;
import page.EstimationPage;
import page.MainPage;
import page.SearchResultsPage;

import static org.junit.Assert.assertEquals;

 public class EstimationTestCase {

    private WebDriver driver;

    String searchData= "Google Cloud Platform Pricing Calculator";
    String instanceNumber= "4";
    String operatingSystem= "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)";
    String provisioningModel= "Regular";
    String machineType="n1-standard-8, vCPUs: 8, RAM: 30 GB";
    String addGpus= "true";
    String gpuModel= "NVIDIA V100";
    String numberOfGpus= "1";
    String localSsd = "2x375 GB";
    String region = "Netherlands (europe-west4)";
    String commitedUseDiscount= "1 year";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void createNewPaste() {
        //Step 1 Open https://pastebin.com/ or a similar service in any browser.
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.searchPage(searchData);

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.selectCalculatorLink();


        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.clickAddToEstimateBtn();
        calculatorPage.clickComputeEngineBtn();
        calculatorPage.enterNumberOfInstances(instanceNumber);
        calculatorPage.selectOsSoftware(1);
        calculatorPage.clickProvisioningRegularBtn();
        calculatorPage.selectMachineFamily(1);
        calculatorPage.selectSeries(1);
        calculatorPage.selectMachineType(7);
        calculatorPage.clickAddGpuBtn();
        calculatorPage.selectGpuModel(2);
        calculatorPage.selectNumberOfGpus(1);
        calculatorPage.selectLocalSsd(3);
        calculatorPage.selectRegion(5);
        calculatorPage.clickCommitedUse1Year();
        calculatorPage.clickShareBtn();
        calculatorPage.clickOpenEstimateSummary();

        // validate created estimation in new page
        EstimationPage estimationPage = new EstimationPage(driver);
        // verify the estimation values
        assertEquals(instanceNumber, estimationPage.getInstanceNumberText());
        assertEquals(operatingSystem, estimationPage.getOperatingSystemText());
        assertEquals(provisioningModel, estimationPage.getProvisioningModelText());
        assertEquals(machineType, estimationPage.getMachineTypeText());
        assertEquals(addGpus, estimationPage.getAddGpusText());
        assertEquals(gpuModel, estimationPage.getGpuModelText());
        assertEquals(numberOfGpus, estimationPage.getNumberOfGpusText());
        assertEquals(localSsd, estimationPage.getLocalSsdText());
        assertEquals(region, estimationPage.getRegionText());
        assertEquals(commitedUseDiscount, estimationPage.getCommitedUseDiscountText());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}















