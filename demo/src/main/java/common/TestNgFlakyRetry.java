package common;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestNgFlakyRetry implements IRetryAnalyzer {
    /**
     * add to class where we have Flaky Tests:
     * @BeforeClass
     *     public void setUpFlakyRetry(ITestContext context){
     *         Arrays.stream(context.getAllTestMethods()).forEach(x->x.setRetryAnalyzerClass(TestNgFlakyRetry.class));
     *     }
     * */
    private int count = 0;
    private int maxCount = 3;  // count to retry

    @Override
    public boolean retry(ITestResult result) {
        if(!result.isSuccess()){
            if(count < maxCount-1){
                count++;
                return true;
            }
        }

        return false;
    }
}
