package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

import static common.ConfigFramework.PLATFORM_AND_BROWSER;

public class WebDriverFactory {
   public static WebDriver createDriver() {
      WebDriver driver = null;

      switch(PLATFORM_AND_BROWSER){
         case "win_chrome":
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            break;
         case "win_firefox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            break;
         default:
            Assert.fail("Incorrect platform name: " + PLATFORM_AND_BROWSER);
      }
      return driver;
   }
}
