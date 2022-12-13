package kucoin;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.kucoin.pojo.TickerData;
import page.kucoin.pojo.TickerShort;
import page.kucoin.pojo.TicketComparatorLow;

import java.util.*;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.*;

public class StreamApiExampleTest {

    public List<TickerData> getTickers(){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.kucoin.com/api/v1/market/allTickers")
                .then()
                .extract().jsonPath().getList("data.ticker", TickerData.class);
    }

    @Mock
    TickerData myTicket;

//    @Mock
//    Response myResponse;

    @BeforeTest
    public void setupMock(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void checkCryptoMockito(){
        RequestSpecification requestSpecification = given();

//       Response myResponse = requestSpecification
//                .expect()
//                .statusCode(200)
//                .when()
//                .get("https://api.kucoin.com/api/v1/market/allTickers");

        Response myResponse = Mockito.mock(Response.class);
        when(myResponse.statusCode()).thenReturn(222); // mock statusCode
        int code = myResponse.statusCode();
        System.out.println("StatusCode: "+code); //222 - mock response / 200 real response

//        TickerData myTicket = Mockito.mock(TickerData.class); // or @Mock + init @BeforeTest
        when(myTicket.getSymbol()).thenReturn("BLR");
        TickerData responseData = new TickerData("US-USA","COIN-COIN","0.080957","0.081181","0.0404","0.003154","0.081841","0.076903","124039.6902","9798.9455020323","0.081191","0.08017117","0.001","0.001","1","1");

        System.out.println(myTicket.getSymbol());  //BLR - mock
        System.out.println(myTicket.getSymbolName()); //null - mock
        System.out.println(responseData.getSymbol()); //BY-BLR - NOT mock
        System.out.println(responseData.getSymbolName()); //BY2-BY2 - Not mock
    }

    @Test
    public void checkCryptoUSDT(){
        List<TickerData> usdTickers = getTickers().stream()
                .filter(x->x.getSymbol().endsWith("USDT")).collect(Collectors.toList()); // list USDT tickers

       Assert.assertTrue(usdTickers.stream().allMatch(x->x.getSymbol().endsWith("USDT")));
    }

    @Test
    public void sortHighttoLowChangeRate(){
        List<TickerData> hightToLow = getTickers().stream()
                .filter(x->x.getSymbol().endsWith("USDT"))
                .sorted(new Comparator<TickerData>() {
                    @Override
                    public int compare(TickerData o1, TickerData o2) {
                        return o2.getChangeRate().compareTo(o1.getChangeRate());
                    }
                })
                .collect(Collectors.toList());

        List<TickerData> top10 = hightToLow.stream().limit(10).collect(Collectors.toList());
        Double maxChangeRate = Double.valueOf(top10.get(0).getChangeRate());

        Assert.assertTrue(top10.stream().allMatch(x->maxChangeRate >=Double.valueOf(x.getChangeRate()))); // check that maxChangeRate is >= in List top10
        Assert.assertTrue(top10.get(0).getSymbol().endsWith("USDT")); // top ticket SymbolName ends with "USDT"
    }

    @Test
    public void sortLowToHightChangeRate(){
        List<TickerData> lowToHightTop10 = getTickers().stream()
                .filter(x->x.getSymbol().endsWith("USDT"))
                .sorted(new TicketComparatorLow())
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(lowToHightTop10); // print top10 with low to hight
    }

    @Test
    public void map(){
        Map<String, Float> usd = new HashMap<>();
        List<String> lowerCases = getTickers().stream()
                .map(x->x.getSymbol().toLowerCase())
                .limit(10)
                .collect(Collectors.toList());

        System.out.println("List name 10lowes change rate: " + lowerCases);

        getTickers().stream()
                .forEach(x->usd.put(x.getSymbol(), Float.parseFloat(x.getChangeRate())));
        System.out.println("Map <Name - ChangeRate>: " + usd);

        List<TickerShort> shortList = new ArrayList<>();
        getTickers().stream().forEach(x->shortList.add(new TickerShort(x.getSymbol(), Float.parseFloat(x.getChangeRate()))));
    }
}
