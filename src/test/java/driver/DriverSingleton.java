package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton(){}

    public static synchronized WebDriver getDriver(){
        if (driver == null) {
            String browser = System.getProperty("browser", "chrome").toLowerCase();
            //select the webdriverManager to use, chrome or firefox
            switch (browser) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
            //miximize the window
            driver.manage().window().maximize();
        }
        //return the driver for the selected browser to use it on the test case
        return driver;
    }

    public static synchronized void closeDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
