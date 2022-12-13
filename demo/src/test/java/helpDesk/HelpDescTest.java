package helpDesk;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseSeleniumTest;
import common.ConfigProvider;
import helpers.TestValues;
import page.helpDesk.MainPage;
import page.helpDesk.ResultSearchTicketPage;
import page.helpDesk.TicketsPage;

import static helpers.StringModifier.getUniqueString;

public class HelpDescTest extends BaseSeleniumTest{
   @Test(enabled = false)
   public void checkTicket() {
      String title = getUniqueString(TestValues.TEST_TITLE);

      ResultSearchTicketPage searchResult = new MainPage()
         .createTicket(title, TestValues.TEST_BODY, TestValues.TEST_EMAIL)
         .openLoginPage()
         .auth(ConfigProvider.DEMO_LOGIN, ConfigProvider.DEMO_PASS)
         .findTicket(title);

      Assert.assertTrue(searchResult.getTitle().contains(title));
      Assert.assertEquals(searchResult.getBody(), TestValues.TEST_BODY);
      Assert.assertEquals(searchResult.getEmail(), TestValues.TEST_EMAIL);
   }
}
