package page.realtBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseSeleniumPage;

import static constants.ForRealtBy.REALT_HOME_PAGE;

public class RealtHomePage extends BaseSeleniumPage{

   @FindBy(id = "rooms")
   private WebElement countRooms;

   @FindBy(xpath = "//select[@id='rooms']/option[@value='2']")
   private WebElement optionRooms2;

   @FindBy(xpath = "//div[@id='residentialInputs']//a[text()='Найти']")
   private WebElement findBtn;


   public RealtHomePage() {
      driver.get(REALT_HOME_PAGE);
      PageFactory.initElements(driver, this);
   }

   public RealtHomePage enterCountRooms() {
      countRooms.click();
      optionRooms2.click();

      return this;
   }

   public RealtListingPage clickToFind() {
      waitElementIsVisible(findBtn).click();
       
      return new RealtListingPage();
   }


   

}
