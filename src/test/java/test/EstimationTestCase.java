package test;

import driver.DriverSingleton;
import model.EstimationModel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import service.EstimationService;
import service.TestDataReader;
import service.TestNGScreenshotListener;

@Listeners(TestNGScreenshotListener.class)
public class EstimationTestCase {

    private WebDriver driver;
    private EstimationService estimationService;
    private EstimationModel estimationModel;

    @BeforeMethod
    public void setUp() {
        driver = DriverSingleton.getDriver();
        estimationService = new EstimationService(driver);

        // Load test data for the TestDataReader
        estimationModel = new EstimationModel();
        estimationModel.setSearchData(TestDataReader.getTestData("searchData"));
        estimationModel.setInstanceNumber(TestDataReader.getTestData("instanceNumber"));
        estimationModel.setOperatingSystem(TestDataReader.getTestData("operatingSystem"));
        estimationModel.setProvisioningModel(TestDataReader.getTestData("provisioningModel"));
        estimationModel.setMachineType(TestDataReader.getTestData("machineType"));
        estimationModel.setAddGpus(Boolean.parseBoolean(TestDataReader.getTestData("addGpus")));
        estimationModel.setGpuModel(TestDataReader.getTestData("gpuModel"));
        estimationModel.setNumberOfGpus(TestDataReader.getTestData("numberOfGpus"));
        estimationModel.setLocalSsd(TestDataReader.getTestData("localSsd"));
        estimationModel.setRegion(TestDataReader.getTestData("region"));
        estimationModel.setCommitedUseDiscount(TestDataReader.getTestData("commitedUseDiscount"));
    }

    @Test
    public void testEstimationCreationAndValidation() {
        estimationService.searchCalculator(estimationModel);
        estimationService.openCalculator();
        estimationService.fillCalculator(estimationModel);
        estimationService.validateEstimation(estimationModel);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            DriverSingleton.closeDriver();
        }
    }
}
