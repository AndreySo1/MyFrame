package softAssertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class softAssertionsTest {

    @Test
    public void softAssert(){
        String name1="Andrey";
        String name2="Julia";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false,"not true!!!!!");  // assert
        softAssert.assertTrue(true, "not true!!!!!");
        softAssert.assertEquals(name1, name2,"not same!!!"); //assert
        softAssert.assertEquals(name1, "abracadabra", "not same!!!"); // assert
        softAssert.assertEquals(name1, "Andrey" , "not same!!!");
        softAssert.assertAll();
    }

    @Test
    public void usualAssert(){
        String name1="Andrey";
        String name2="Julia";

        Assert.assertTrue(false,"not true789!!!!!");  // assert
        Assert.assertTrue(true, "not true!!!!!");
        Assert.assertEquals(name1, name2,"not same111!!!"); //assert
        Assert.assertEquals(name1, "abracadabra", "not same!!!"); // assert
        Assert.assertEquals(name1, "Andrey" , "not same!!!");
    }
}
