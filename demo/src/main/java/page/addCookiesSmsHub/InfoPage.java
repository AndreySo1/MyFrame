package page.addCookiesSmsHub;

import base.BaseSeleniumPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InfoPage extends BaseSeleniumPage {
    @FindBy(xpath = "//a[@id='balansUser']")
    private WebElement balanceInfo;

    public InfoPage(){
        driver.get("https://smshub.org/ru/info");
//        driver.manage().addCookie(new Cookie("userid", "152232"));
//        driver.manage().addCookie(new Cookie("session", "45e4c82cbdf1ecec4c38407495d6a55e")); //may change
//        driver.manage().addCookie(new Cookie("lang", "ru"));
//        driver.navigate().refresh();
        PageFactory.initElements(driver, this);
    }

//    public InfoPage addCookies(){
//        driver.manage().addCookie(new Cookie("userid", "152232"));
//        driver.manage().addCookie(new Cookie("session", "45e4c82cbdf1ecec4c38407495d6a55e")); //may change
//        driver.manage().addCookie(new Cookie("lang", "ru"));
//
//        driver.navigate().refresh();
//        return this;
//    }

//    public InfoPage refreshPage(){
//        driver.navigate().refresh();
//
//        return this;
//    }

    public void addCookiesAndRefresh(){
        driver.manage().addCookie(new Cookie("userid", "152232"));
        driver.manage().addCookie(new Cookie("session", "afa056f438f532b6b1854360427b3a5c")); //may change
        driver.manage().addCookie(new Cookie("lang", "ru"));
        driver.navigate().refresh();
    }

    public Float getBalance(){
        addCookiesAndRefresh();

        String[] strArr = balanceInfo.getText().split(" ");
        Float uiBalance = Float.valueOf(strArr[0]);

        return uiBalance;
    }
}
