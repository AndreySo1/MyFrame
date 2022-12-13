package addCookiesSmsHub;

import base.BaseSeleniumTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.addCookiesSmsHub.InfoPage;

public class AddCookieTest extends BaseSeleniumTest {

    @Test
    public void getBalanceAddCookiesSeleniumUi(){
        Float uiBalance = new InfoPage() //maybe change session cookies
//                .addCookies()
//                .refreshPage()
                .getBalance();

        Assert.assertTrue(uiBalance == 0.00);
    }
}
