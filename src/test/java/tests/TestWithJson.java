package tests;

import TestComponents.BaseTest;
import TestComponents.Retry;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class TestWithJson extends BaseTest {

    @Test(dataProvider = "getData", retryAnalyzer = Retry.class)
    public void maintest(HashMap<String , String > input){
        landingPage.logData(input.get("status"));
    }
    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> jsonData = getJsonDataToMap(System.getProperty("user.dir") +"/src/test/resources/testData.json");
        Object[][] data = new Object[jsonData.size()][1];
        for (int i = 0; i < jsonData.size(); i++) {
            data[i][0] = jsonData.get(i);
        }
        return data;
    }

}
