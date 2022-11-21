package page.govPL;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseSeleniumPage;

public class JobsListPage extends BaseSeleniumPage{

   @FindBy(xpath = "//div//details//a[contains(@href,'mailto:')]")
   // @FindBy(xpath = "//p/a[contains(@href,'mailto:')]")
   private List<WebElement> listEmails;

   @FindBy(xpath = "//div/details/summary")
   // @FindBy(xpath = "//p/a[contains(@href,'mailto:')]")
   private List<WebElement> listSummary;

   public JobsListPage() {
      driver.get("https://www.gov.pl/web/poland-businessharbour-en/itspecialist");
      PageFactory.initElements(driver, this);
   }

   // public List<String> getAllEmail(){
   //    List<String> list = new ArrayList<>();
   //    for(WebElement elem: listEmails){
   //       list.add(elem.getText());
   //    }

   //    return list;
   // }

   public List<String> getAllEmail(){
      List<String> list = new ArrayList<>();
      for(WebElement elem: listEmails){
         list.add(elem.getAttribute("href").replace("mailto:", ""));
      }

      return list;
   }

   public List<String> get5Email(){
      List<String> list = new ArrayList<>();
      for(int i =0; i<5; i++){
         String mail = listEmails.get(i).getAttribute("href");
         String res = mail.replace("mailto:", "");
         list.add(res);//OK
      }     
      return list;
   }
   
}
