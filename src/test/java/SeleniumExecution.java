import core.Base;
import org.junit.*;
import org.junit.rules.TestName;
import resources.Reporting;
import resources.WebTestDriver;
import testing.actions.HomePageActions;



public class SeleniumExecution extends Base
{
                @Rule
                public TestName name = new TestName();

                @Before
                public void PreTest()
                {
                    TestName = name.getMethodName();
                    Reporting.createTest();
                    SeleniumExecutionInstance = new WebTestDriver(WebTestDriver.BrowserType.CHROME);
                }


                @Test
                public void BetikaLogin()
                {
                    String Login = HomePageActions.Betika("0743551248","1234");
                    Assert.assertTrue("Unable to Complete Login Test"+ Login,Login == null);
                }

                @Test
                public void BetikaFilter()
                 {
                  String filterGames = HomePageActions.BetikaFilter("0743551248","1234");
                  Assert.assertTrue("Unable to Complete Login Test"+ filterGames,filterGames == null);
                 }
                @Test
                public void BetikaPlaceBets()
                {
                    String filterGames = HomePageActions.BetikaPlaceBets("0743551248","1234");
                    Assert.assertTrue("Unable to Complete Login Test"+ filterGames,filterGames == null);
                }

                @Test
                public void BetikaDownload()
                {
                   String y = HomePageActions.BetikaDoownloadBets("0743551248","1234");
                    Assert.assertTrue("Unable to Complete Login Test"+ y,y == null);
                }
                @After
                public void PostTest()
                {
                    SeleniumExecutionInstance.shutDown();
                }

}
