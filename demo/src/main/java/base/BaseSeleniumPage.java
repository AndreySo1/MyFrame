package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static common.ConfigFramework.TimeoutVariable.EXPLICIT_WAIT;

abstract public class BaseSeleniumPage {
   protected static WebDriver driver;

   // if we can create constructor here, we need remove method in BaseTest

   public static void setDriver(WebDriver webDriver) {
      driver = webDriver;
   }

   public void open(String url) {
      driver.get(url);
   }

   public WebElement waitElementIsVisible(WebElement element) {
      new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)).until(ExpectedConditions.visibilityOf(element));

      return element;
   }
}
