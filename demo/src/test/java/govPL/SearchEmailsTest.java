package govPL;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseSeleniumTest;
import page.govPL.JobsListPage;

public class SearchEmailsTest extends BaseSeleniumTest{
   
   // @Test
   public void checkListEmail() {
      List<String> listEmails = new JobsListPage()
      // .getAllEmail();
      .get5Email();

      System.out.println("emails size = "+listEmails.size());
      for(String str : listEmails){
         System.out.println(str);
      }
      Assert.assertTrue(listEmails.size()>100);
   }
   
   
   
}
