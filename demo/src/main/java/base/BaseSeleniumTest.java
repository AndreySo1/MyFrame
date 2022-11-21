package base;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import common.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

import static common.ConfigFramework.TimeoutVariable.IMPLICIT_WAIT;
import static common.ConfigFramework.TimeoutVariable.PAGE_LOAD_TIMEOUT;
import static common.ConfigFramework.CLEAR_COOKIES;
import static common.ConfigFramework.CLEAR_LOCAL_STORAGE;
import static common.ConfigFramework.CLOSE_BROWSER;

abstract public class BaseSeleniumTest {
   // protected WebDriver driver;
   // protected BaseSeleniumPage basePage = new BaseSeleniumPage(driver);

   // protected WebDriver driver = WebDriverFactory.createDriver(); // dublicate driver window
   protected WebDriver driver = null;

   @BeforeTest
   public void setUp(){
      // WebDriverManager.chromedriver().setup();
      // driver = new ChromeDriver();

      driver = WebDriverFactory.createDriver();

      driver.manage().window().maximize();
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));

      BaseSeleniumPage.setDriver(driver);
   }

   @AfterTest
   public void clearCookiesAndLocalStorage(){
      if(CLEAR_COOKIES){      
         driver.manage().deleteAllCookies();    
      }

      if(CLEAR_LOCAL_STORAGE){
         JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
         jsExecutor.executeScript("window.sessionStorage.clear()");
      }    
   }

   @AfterTest
   public void tearDown() {
      driver.close(); //close tab
      driver.quit(); // close driver
   }

   @AfterSuite(alwaysRun = true)
   public void closeBrowser(){
      if(CLOSE_BROWSER){
         driver.quit();
      }
   }
}
