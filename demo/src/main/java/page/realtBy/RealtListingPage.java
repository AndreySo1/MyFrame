package page.realtBy;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseSeleniumPage;
import common.WebDriverFactory;

public class RealtListingPage extends BaseSeleniumPage{

   @FindBy(xpath = "//div[contains(@class, 'highlighted')]")
   private List<WebElement> listResultsCard;

   public RealtListingPage() {
      PageFactory.initElements(driver, this);
   }

   public int checkCountCard(){
      int countCard = listResultsCard.size();
      return countCard;
   }
   
   
}
