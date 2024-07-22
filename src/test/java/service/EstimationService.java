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
        calculatorPage.selectOsSoftware(1); // option 1 free debian
        calculatorPage.clickProvisioningRegularBtn();
        calculatorPage.selectMachineFamily(1); // option 1 General Purpose
        calculatorPage.selectSeries(1); // option 1 N1
        calculatorPage.selectMachineType(7); // option 7 n1 - starndard-8
        if (estimationModel.isAddGpus()) {
            calculatorPage.clickAddGpuBtn();
            calculatorPage.selectGpuModel(2); // option 2 Nvidia 100
            calculatorPage.selectNumberOfGpus(1); // option 1 1
        }
        calculatorPage.selectLocalSsd(3); // option 3 2x375 GB
        calculatorPage.selectRegion(5); // option 5 Netherlands (europe-west4)
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
