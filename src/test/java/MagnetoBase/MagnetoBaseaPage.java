package MagnetoBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MagnetoBaseaPage {
     public WebDriver driver;
     @BeforeSuite
     //launching browser
     public void launch(){
          driver=new ChromeDriver();
          WebDriverManager.chromedriver().setup();

          //driver.get("https://magento.softwaretestingboard.com/customer/account/");

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
     }
     @BeforeClass
     //Lamda Test
     public void lamdatest() throws MalformedURLException {
          DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
          ChromeOptions chromeOptions = new ChromeOptions();
          desiredCapabilities.setCapability("browser", "chrome");
          desiredCapabilities.merge(chromeOptions);
          driver = new RemoteWebDriver(new URL("https://manogna.gangisetti:mxG5dTiDApq5HCyjLFP5yWRq2zrmPhyonNUNv4hfdiqzWYktdF@hub.lambdatest.com/wd/hub"), chromeOptions);
          driver.get("https://magento.softwaretestingboard.com/customer/account/");
          driver.manage().window().maximize();
     }
     @AfterSuite
     //Kill the browser
     public void kill(){
          driver.quit();
     }
}
