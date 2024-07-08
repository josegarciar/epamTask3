package service;

import model.EstimationModel;
import org.openqa.selenium.WebDriver;
import page.CalculatorPage;
import page.EstimationPage;
import page.MainPage;
import page.SearchResultsPage;

public class EstimationService {
    private WebDriver driver;

    public EstimationService(WebDriver driver) {
        this.driver = driver;
    }

    public void searchCalculator(EstimationModel estimationModel) {
        // Step 1: Open the main page and search
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.searchPage(estimationModel.getSearchData());
    }

    public void openCalculator() {
        // Step 2: Select the calculator link from search results
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.selectCalculatorLink();
    }

    public void fillCalculator(EstimationModel estimationModel) {
        // Step 3: Fill in the calculator form
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.clickAddToEstimateBtn();
        calculatorPage.clickComputeEngineBtn();
        calculatorPage.enterNumberOfInstances(estimationModel.getInstanceNumber());
        calculatorPage.selectOsSoftware(1); // Assuming dropdown index
        calculatorPage.clickProvisioningRegularBtn();
        calculatorPage.selectMachineFamily(1); // Assuming dropdown index
        calculatorPage.selectSeries(1); // Assuming dropdown index
        calculatorPage.selectMachineType(7); // Assuming dropdown index
        if (estimationModel.isAddGpus()) {
            calculatorPage.clickAddGpuBtn();
            calculatorPage.selectGpuModel(2); // Assuming dropdown index
            calculatorPage.selectNumberOfGpus(1); // Assuming dropdown index
        }
        calculatorPage.selectLocalSsd(3); // Assuming dropdown index
        calculatorPage.selectRegion(5); // Assuming dropdown index
        calculatorPage.clickCommitedUse1Year();
        calculatorPage.clickShareBtn();
        calculatorPage.clickOpenEstimateSummary();
    }

    public void validateEstimation(EstimationModel estimationModel) {
        // Validate the estimation values
        EstimationPage estimationPage = new EstimationPage(driver);
        assert estimationModel.getInstanceNumber().equals(estimationPage.getInstanceNumberText());
        assert estimationModel.getOperatingSystem().equals(estimationPage.getOperatingSystemText());
        assert estimationModel.getProvisioningModel().equals(estimationPage.getProvisioningModelText());
        assert estimationModel.getMachineType().equals(estimationPage.getMachineTypeText());
        assert String.valueOf(estimationModel.isAddGpus()).equals(estimationPage.getAddGpusText());
        assert estimationModel.getGpuModel().equals(estimationPage.getGpuModelText());
        assert estimationModel.getNumberOfGpus().equals(estimationPage.getNumberOfGpusText());
        assert estimationModel.getLocalSsd().equals(estimationPage.getLocalSsdText());
        assert estimationModel.getRegion().equals(estimationPage.getRegionText());
        assert estimationModel.getCommitedUseDiscount().equals(estimationPage.getCommitedUseDiscountText());
    }
}
