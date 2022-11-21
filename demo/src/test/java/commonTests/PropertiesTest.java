package commonTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import common.ConfigProvider;

public class PropertiesTest {
   @Test
   public void shouldAnswerWithTrue()
   {
       Assert.assertTrue(true);
   }

   @Test
   public void readProp() throws IOException{
     System.getProperties().load(ClassLoader.getSystemResourceAsStream("app.properties"));

     String urlProp = System.getProperty("url");
     Assert.assertEquals(urlProp, "https://www.testproperties.com");
     System.out.println(urlProp);
   }

   @Test
   public void readConf(){
     String urlFromConfig = ConfigProvider.URL;
     Assert.assertEquals(urlFromConfig, "https://django-helpdesk-demo.herokuapp.com/");
     System.out.println(urlFromConfig);

     if(ConfigProvider.readConfig().getBoolean("users.admin.isAdmin")){
        System.out.println("Admin success");
     } else{
        System.out.println("Error");
     }
   }
}
