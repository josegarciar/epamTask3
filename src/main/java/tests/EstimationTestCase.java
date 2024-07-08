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
import static page.CalculatorPage.*;
import static page.EstimationPage.*;

public class EstimationTestCase {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }
    @Test
    public void googleCloudSearchTest() throws InterruptedException {
        //open search app
        MainPage validateOpenSearch = new MainPage()
                .openPage(driver);
        //search for the Google Cloud Platform Pricing Calculator, and click on the link
         SearchResultsPage validateOpenCalculation = new SearchResultsPage()
                 .searchText(driver, "Google Cloud Platform Pricing Calculator")
                 .selectCalculatorLink(driver);
         //select the items for the calculation form
         CalculatorPage validateSelection = (CalculatorPage) new CalculatorPage()
                 //open estimation page
                 .openEstimation(driver)
                 //enter data to the element 1 = number of instances
                 .sendData(driver,NUMBER_OF_INSTANCES,"4")
                 //select option 1 from the element 3 = Operating system
                 .selectData(driver,OS_SOFTWARE1, OS_SOFTWARE2,1)
                 //click on the provisioning Model Regular button
                 .clickOption(driver, 1)
                 //select option 1 from the element 4 = Machine Family
                 .selectData(driver,MACHINE_FAMILY1, MACHINE_FAMILY2,1)
                 //select option 1 from the element 5 = series
                 .selectData(driver,SERIES1, SERIES2,1)
                 //select option 7 from the element 6 = Machine Type
                 .selectData(driver,MACHINE_TYPE1, MACHINE_TYPE2,7)
                 //click on the provisioning Add GPU button
                 .clickOption(driver,3)
                 //select option 2 from the element 7 = GPU Model
                 .selectData(driver,GPU_MODEL1, GPU_MODEL2,2)
                 //select option 1 from the element 8 = Number of GPUs
                 .selectData(driver,NUMBER_OF_GPUS1, NUMBER_OF_GPUS2,1)
                 //select option 3 from the element 9 = Local SSD
                 .selectData(driver,LOCAL_SSD1, LOCAL_SSD2,3)
                 //select option 5 from the element 10 = Region
                 .selectData(driver, REGION1, REGION2,5)
                 //click on the provisioning Commited use 1 Year button
                 .clickOption(driver, 4)
                 //click on the provisioning Share button
                 .clickOption(driver, 5)
                 //click on the provisioning Open Estimate Summary button
                 .clickOption(driver,6);

         //asserts for all the elements entered agains the estimation page
        EstimationPage validate2 = new EstimationPage();
        assertEquals("4",validate2.getText(driver,INSTANCE_NUMBER));
        assertEquals("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)",validate2.getText(driver,OPERATING_SYSTEM));
        assertEquals("Regular",validate2.getText(driver,PROVISIONING_MODEL));
        assertEquals("n1-standard-8, vCPUs: 8, RAM: 30 GB",validate2.getText(driver,MACHINE_TYPE));
        assertEquals("true",validate2.getText(driver,ADD_GPUS));
        assertEquals("NVIDIA V100",validate2.getText(driver,GPU_MODEL));
        assertEquals("1",validate2.getText(driver,NUMBER_OF_GPUS));
        assertEquals("2x375 GB",validate2.getText(driver,LOCAL_SSD));
        assertEquals("Netherlands (europe-west4)",validate2.getText(driver,REGION));
        assertEquals("1 year",validate2.getText(driver,COMMITED_USE_DISCOUNT));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
