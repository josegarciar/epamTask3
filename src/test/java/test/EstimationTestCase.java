package test;

import driver.DriverSingleton;
import model.EstimationModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import service.EstimationService;
import service.ScreenshotListener;
import service.TestDataReader;

public class EstimationTestCase {

    private WebDriver driver;
    private EstimationService estimationService;
    private EstimationModel estimationModel;

    @Before
    public void setUp() {
        driver = DriverSingleton.getDriver();

        ScreenshotListener screenshotListener = new ScreenshotListener(driver);

        estimationService = new EstimationService(driver);

        // Cargar datos de prueba desde TestDataReader
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

    @After
    public void tearDown() {
        if (driver != null) {
            DriverSingleton.closeDriver();
        }
    }
}
