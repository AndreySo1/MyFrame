package flackyTests;

import common.TestNgFlakyRetry;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

public class FlakyTest {

    @BeforeClass
    public void setUpFlakyRetry(ITestContext context){
//        Arrays.stream(context.getAllTestMethods()).forEach(x->x.setRetryAnalyzerClass(TestNgFlakyRetry.class));
// OR:
        for(ITestNGMethod method : context.getAllTestMethods()){
            method.setRetryAnalyzerClass(TestNgFlakyRetry.class);
        }
    }

    @Test
    private void flakyExampleFalse(){
        Assert.assertTrue(false); // try to execute 3 times
    }

    @Test
    private void flakyExample2False(){
        Assert.assertEquals("Andrey", "Julia"); // try to execute 3 times
    }

    @Test
    private void flakyExampleTrue(){
        Assert.assertTrue(true);
    }
}
