package realtBy;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseSeleniumTest;
import page.realtBy.RealtHomePage;
import page.realtBy.RealtListingPage;

public class SearchApartmenTest extends BaseSeleniumTest{
   
   @Test
   public void checkRedirectToListing() {
      
      int check2Rooms = new RealtHomePage()
         .enterCountRooms()
         .clickToFind()
         .checkCountCard();

      Assert.assertEquals(check2Rooms, 20);
   }
}
