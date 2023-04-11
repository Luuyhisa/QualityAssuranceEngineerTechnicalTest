import core.Base;
import org.junit.*;
import org.junit.rules.TestName;
import resources.Reporting;
import java.net.HttpURLConnection;
import java.net.URL;
import testing.actions.RestAPIActions;

public class APIExecution extends Base {

    @Rule
    public TestName name = new TestName();

    @Before
    public void PreTest()
    {
        TestName = name.getMethodName();
        Reporting.createTest();
    }

    @After
    public void PostTest()
    {
    }

    @Test
    public void API_AllDogs_List_And_Validation()
    {
        String BaseUrl = "https://fakerestapi.azurewebsites.net/api/v1/Users";
        String EndPoint = "";

        String APIResult = RestAPIActions.APICall_AndValidation(BaseUrl,EndPoint,"success","retriever");
        Assert.assertTrue("Result Not Good for API Test"+ APIResult,APIResult == null);
    }

    @Test
    public void fakerestapi()
    {
        String BaseUrl = "https://fakerestapi.azurewebsites.net/api/v1/Users";
        String EndPoint = "";

        String APIResult = RestAPIActions.APIRandomImage(BaseUrl,EndPoint,"success");
        Assert.assertTrue("Result Not Good for API Test"+ APIResult,APIResult == null);
    }



}
