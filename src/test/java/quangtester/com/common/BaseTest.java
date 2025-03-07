package quangtester.com.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import quangtester.com.drivers.DriverManager;

public class BaseTest {


      @BeforeMethod
      @Parameters({"browser"})
      public static void createDriver(@Optional("chrome") String browser) {
            WebDriver driver  = setupDriver(browser);
            DriverManager.setDriver(driver);
      }


      public static WebDriver setupDriver(String browserName) {
            WebDriver driver;
            switch (browserName.trim().toLowerCase()) {
                  case "chrome":
                        driver = initChromeDriver();
                        break;
                  case "firefox":
                        driver = initFirefoxDriver();
                        break;
                  case "edge":
                        driver = initEdgeDriver();
                        break;
                  default:
                        System.out.println("Browser: " + browserName + " is invalid, Launching Chrome as browser of choice...");
                        driver = initChromeDriver();
            }
            return driver;
      }

      private static WebDriver initChromeDriver() {
            System.out.println("Launching Chrome browser...");
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            return driver;
      }

      private static WebDriver initEdgeDriver() {
            System.out.println("Launching Edge browser...");
            WebDriverManager.edgedriver().setup();
            WebDriver driver = new EdgeDriver();
            driver.manage().window().maximize();
            return driver;
      }

      private static WebDriver initFirefoxDriver() {
            System.out.println("Launching Firefox browser...");
            WebDriverManager.firefoxdriver().setup();
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();
            return driver;
      }

      @AfterMethod
      public void closeDriver() {

            if (DriverManager.getDriver() != null) {
                  DriverManager.quit();
            }
      }

}
