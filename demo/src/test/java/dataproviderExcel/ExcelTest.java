package dataproviderExcel;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.ExcelDataProviders;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ExcelTest {
   @DataProvider
   public Object[][] data(){
      return new Object[][]{
         {"test1"},
         {"test2"},
         {"test3"},
      };
   }

   @Test (dataProvider = "data")
   public void test(String param){
      System.out.println("hello test: " + param); 
   }

   @Test(dataProvider = "usersFromSheet1", dataProviderClass = ExcelDataProviders.class)
   public void testWithExcel(String ...params){
      System.out.println("User " + params[1] + " have id="+ params[0]); 
   }

   @Test(dataProvider = "usersFromSheet2", dataProviderClass = ExcelDataProviders.class)
   public void testWithExcel2(String ...params){
      System.out.println("Login: " + params[0] + "  pass: "+ params[1]); 
   }

   @Test(dataProvider = "usersForApi", dataProviderClass = ExcelDataProviders.class)
   public void checkUsers(String ...params){
      int id = (int) Double.parseDouble(params[0]);
      Response response = given()
         .contentType(ContentType.JSON)
         .get("https://reqres.in/api/users/" + id)
         .then().log().all()
         .extract().response();

      JsonPath jsonPath = response.jsonPath();
      // String email = jsonPath.getString("data.email");
      Assert.assertEquals(jsonPath.getInt("data.id"), id);
      Assert.assertEquals(jsonPath.getString("data.email"), params[1]);
      Assert.assertEquals(jsonPath.getString("data.first_name"), params[2]);
      Assert.assertEquals(jsonPath.getString("data.last_name"), params[3]);
      Assert.assertEquals(jsonPath.getString("data.avatar"), params[4]);


   }
}
