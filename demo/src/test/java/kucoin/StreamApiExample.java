package kucoin;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.kucoin.pojo.TickerData;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.mockito.Mockito.*;

public class StreamApiExample {

    @Mock
    TickerData myTicket;

    @Mock
    Response myResponse;

    @BeforeTest
    public void setupMock(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void checkCrypto(){
//        TickerData newTicket = Mockito.mock(TickerData.class);

        when(myTicket.getSymbol()).thenReturn("BLR");
        TickerData responseData = new TickerData("BY-BLR","BY2-BY2","0.080957","0.081181","0.0404","0.003154","0.081841","0.076903","124039.6902","9798.9455020323","0.081191","0.08017117","0.001","0.001","1","1");

//        List<TickerData> resp = given()
//                .contentType(ContentType.JSON)
//                .when()
//                .get("https://api.kucoin.com/api/v1/market/allTickers")
//                .then().extract().body().jsonPath().getList("data.ticker", TickerData.class);


        RequestSpecification requestSpecification = RestAssured.given();

        myResponse = requestSpecification
                .expect()
                .statusCode(200)
                .when()
                .get("https://api.kucoin.com/api/v1/market/allTickers");

        int code = myResponse.statusCode();
        System.out.println(code); //200


        System.out.println(myTicket.getSymbol());  //BLR
        System.out.println(responseData.getSymbolName()); //BY2-BY2
        System.out.println(responseData.getSymbol()); //BY-BLR


//        System.out.println(resp.get(0).getBuy());
//        System.out.println(myTicket.getBuy());


    }
}
