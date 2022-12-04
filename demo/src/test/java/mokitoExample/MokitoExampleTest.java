package mokitoExample;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MokitoExampleTest {

   @Mock
   ExampleCar mockCar;

   @BeforeTest
   void setupMock(){
       MockitoAnnotations.openMocks(this);
   }
   
   @Test
   public void createCar(){
      ExampleCar car = new ExampleCar("BMW", "123", 2014, "Andrey"); // create usual object
      ExampleCar mockCar = Mockito.mock(ExampleCar.class); // create object with Machito with empty parametrs

       Assert.assertEquals(car.getManufacturer(), "BMW");
       Assert.assertEquals(mockCar.getManufacturer(), null);
   }

   @Test
   void remoteServiseReturnValue(){
      ExampleCar mockCar = Mockito.mock(ExampleCar.class);

       when(mockCar.testInt(4)).thenReturn(777);//!!!!!!!!! // set parametr what I need (defaul return 8 but i set 10) 
       Assert.assertEquals(mockCar.testInt(4), 777); //ok
      //  Assert.assertEquals(mockCar.testInt(4), 8); // errror
       System.out.println(mockCar.testInt(4));
   }

   @Test
   void getOwner(){
      ExampleCar mockCar = Mockito.mock(ExampleCar.class);
       when(mockCar.getOwner()).thenReturn("Andrey"); // if we use method getOwner(), program return "Andrey"

       Assert.assertEquals(mockCar.getOwner(), "Andrey");
       System.out.println(mockCar.getOwner());
   }

   @Test
   void verificationTest(){
      ExampleCar mockCar = Mockito.mock(ExampleCar.class);
       System.out.println(mockCar.getOwner());
       verify(mockCar).getOwner(); // if we use in this test methood mockCar.getOwner() , return ok(null), else return error
   }

   @Test
   void verificationMetodParametrTest(){
       ExampleCar mockCar = Mockito.mock(ExampleCar.class);
       mockCar.setOwner("Andrey1");
       verify(mockCar).setOwner("Andrey1");//if we use in this test methood mockCar.setOwner() with parametr"Andrey", return OK, if use with anther parametr return error
   }

   @Test
   void mockAnotation(){
       when(mockCar.testInt(3)).thenReturn(333);
       Assert.assertEquals(mockCar.testInt(3), 333); //init mockCar in Befor anotation
   }

   @Test
   void verificationTimesTest(){
       mockCar.getOwner();
       mockCar.getOwner();

       verify(mockCar, times(2)).getOwner(); // count how much times call methods
//        verify(mockCar, never()).getOwner();  // method never called
//        verify(mockCar, atLeast(2)).getOwner();  // method called min 2 times or more
//      verify(mockCar, atMost(2)).getOwner();  // method called max 2 times or more
//      verify(mockCar, only()).getOwner();  // if use only this class 1 times - true
   }

   @Test
   void mockAlternativeSintacses(){
//        when(mockCar.testInt(3)).thenReturn(444);
       given(mockCar.testInt(3)).willReturn(444); // given == then
       Assert.assertEquals(mockCar.testInt(3), 444); //init mockCar in Befor anotatio
   }

   @Test
   void mockAnyInt(){
       when(mockCar.testInt(anyInt())).thenReturn(11111);
       Assert.assertEquals(mockCar.testInt(356), 11111); //anyInt get result 11111
   }

   @Test(expectedExceptions = Exception.class)
   void mockAnyIntEception() throws Exception{
       when(mockCar.testInt(anyInt())).thenThrow(Exception.class);
       Assert.assertEquals(mockCar.testInt(333), 333); //anyInt get exception
   }

}
