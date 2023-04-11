package testing.actions;

import core.Base;
import resources.Reporting;
import testing.Pages.TestPaths;

public class HomePageActions extends Base {
//    public static void Home_Demo()
//    {
//        //navigate to the URL/Webpage
//        if (!SeleniumExecutionInstance.Navigate(TestPaths.url())) {
//             Reporting.TestFailed("Failed to Navigate to -  " + TestPaths.url());
//        }
//        //checking the page is correct
//        if (!SeleniumExecutionInstance.WaitForElement(TestPaths.DemoPageHeader())) {
//             Reporting.TestFailed("Failed to Navigate to Home Page for URL - "+ TestPaths.url());
//        }
//        //report Printing
//        Reporting.StepPassed("successfully navigated to the Home/Demo Page");
//        Reporting.StepPassedWithScreenShot("Home/Demo Page");
//
//
//        if (!SeleniumExecutionInstance.ScrollToElement(TestPaths.FAQ())) {
//             Reporting.TestFailed("Failed to Scroll to the FAQ element. ");
//        }
//
//        Reporting.StepPassedWithScreenShot("Scrolled to the FAQs heading and took a screenshot.");
//        if (!SeleniumExecutionInstance.ClickElement(TestPaths.NavigationHeader())) {
//             Reporting.TestFailed("Failed to Click on the Features option");
//        }
//        if (!SeleniumExecutionInstance.ClickElement(TestPaths.NewsletterModuleOption())) {
//             Reporting.TestFailed("Failed to Click on the Newsletter Module");
//        }
//    }
//    public static void newsletter_module_features(String email)
//    {
//        if (!SeleniumExecutionInstance.WaitForElement(TestPaths.NewsletterModuleFeaturesHeader()))
//        {
//             Reporting.TestFailed("Failed to Navigate to Home Page for URL - "+ TestPaths.url());
//        }
//        Reporting.StepPassedWithScreenShot("successfully navigated to the newsletter-module-features");
//
//        if (!SeleniumExecutionInstance.EnterText(TestPaths.EmailaddressInput(),email))
//        {
//             Reporting.TestFailed( "Failed to Enter the email. ");
//        }
//        Reporting.StepPassedWithScreenShot("successfully  entered email address demouser@travels.com");
//
//        if (!SeleniumExecutionInstance.ClickElement(TestPaths.SUBSCRIBEButton())) {
//             Reporting.TestFailed("Failed to Click on the SUBSCRIBE Button ");
//        }        Reporting.StepPassedWithScreenShot("successfully Click on the SUBSCRIBE Button ");
//
//       SeleniumExecutionInstance.AlertHendler();
//
//        SeleniumExecutionInstance.pause(2000);
//        if (!SeleniumExecutionInstance.ClickElement(TestPaths.DocNavigationHeader())) {
//             Reporting.TestFailed("Failed to Click on the Navigate to DOC page ");
//        }         Reporting.StepPassed("successfully navigated to the Doc Page");
//
//
//    }
//    public static void PHPTARVELSDocumentation()
//    {
////switch
//        SeleniumExecutionInstance.SwitchTab(1);
//        //checking the page is correct
//        if (!SeleniumExecutionInstance.WaitForElement(TestPaths.DocPageHeader())) {
//             Reporting.TestFailed("Failed to Navigate to Doc Page");
//        }//DocPageHeader
//        Reporting.StepPassedWithScreenShot("successfully navigated to the DOC Page");
//        //close the current tab
//        SeleniumExecutionInstance.CloseAndSwitchTab();
//    }
//    public static void Pricing()
//    {
//        if (!SeleniumExecutionInstance.ClickElement(TestPaths.PricingNavigationHeader())) {
//             Reporting.TestFailed("Failed to Click on the Navigate to Pricing page ");
//        }
//        Reporting.StepPassed("successfully navigated to the Pricing Page");
//
//        //checking the page is correct
//        if (!SeleniumExecutionInstance.WaitForElement(TestPaths.PlansAndPricesPageHeader())) {
//             Reporting.TestFailed("Failed to Navigate to Plans And Prices Page");
//        }//DocPageHeader
//        if (!SeleniumExecutionInstance.ValidationElement(TestPaths.PlansAndPricesPageHeader(),"Plans and prices")) {
//            Reporting.TestFailed("Failed to Navigate to Plans And Prices Page");
//        }
//        Reporting.StepPassedWithScreenShot("successfully Validated the Plans And Prices Page");
//        //
//        if (!SeleniumExecutionInstance.ClickElement(TestPaths.AndroidButtonBuyNow())) {
//             Reporting.TestFailed("Failed to Click on Android Button Buy-Now ");
//        }
//        Reporting.StepPassedWithScreenShot("successfully Clicked on Android Button Buy-Now");
//    }
//    public static String phptravels(String email)
//    {
//        Home_Demo();
//        newsletter_module_features(email);
//        PHPTARVELSDocumentation();
//        Pricing();
//        return Reporting.finaliseTest();
//    }

//   *----------------------------------------------


    public static String Betika(String Username,String Passsword)
    {
        LoginToBetika(Username, Passsword);
        return Reporting.finaliseTest();
    }



    public static String BetikaFilter(String Username,String Passsword)
    {
        LoginToBetika(Username, Passsword);
        filterBy("Saturday");
        return Reporting.finaliseTest();
    }
            /*FilterOptions
            Today
            Next 48hrs
            Tomorrow
            Thursday
            Friday
            Saturday
            Sunday
            Monday
            Tuesday
            Next Week */

    public static String BetikaPlaceBets(String Username,String Passsword)
    {
        LoginToBetika(Username, Passsword);
        filterBy("Next Week");
        placeBet("Rugby","100");
        return Reporting.finaliseTest();
    }

    public static String BetikaDoownloadBets(String Username,String Passsword)
    {
        LoginToBetika(Username, Passsword);
        CustomFixtures("UEFA Champions League");
        return Reporting.finaliseTest();
    }

    public static void placeBet(String sport,String amountToBet){

        if (!SeleniumExecutionInstance.ClickElement(TestPaths.sportOption(sport))) {
            Reporting.warning("Failed to Click on Android Button Buy-Now ");
        }Reporting.StepPassed("Clicked Bet Option");


        if (!SeleniumExecutionInstance.ClickElement(TestPaths.southSydneeyVsPenerith())) {
            Reporting.TestFailed("Failed to Click on Android Button Buy-Now ");
        }Reporting.StepPassed("Clicked wining option Option");


        if (!SeleniumExecutionInstance.ClickElement(TestPaths.parramattaDraw())) {
            Reporting.warning("Failed Find the Teams selected");
        }Reporting.StepPassed("Clicked Winning team");


        if (!SeleniumExecutionInstance.ClickElement(TestPaths.dolphinsDraw())) {
            Reporting.warning("Failed Find the Teams selected");
        }Reporting.StepPassed("Clicked winning team");


        if (!SeleniumExecutionInstance.ClickElement(TestPaths.cronullaWin())) {
            Reporting.warning("Failed Find the Teams selected");
        }Reporting.StepPassed("Clicked Winning team");


        if (!SeleniumExecutionInstance.ClickElement(TestPaths.newcastleWin())) {
            Reporting.warning("Failed Find the Teams selected");
        }Reporting.StepPassed("Clicked Winning Team");


        if (!SeleniumExecutionInstance.EnterText(TestPaths.amountToBet(),amountToBet))
        {
            Reporting.TestFailed( "Failed to Enter Amount to bet ");
        } Reporting.StepPassed("Captured Amount  : " + amountToBet);



        if (!SeleniumExecutionInstance.ClickElement(TestPaths.placeBetButton())) {
            Reporting.TestFailed("Failed to Click on Android Button Buy-Now ");
        }Reporting.StepPassed("Clicked ClickBet");


        Reporting.StepPassedWithScreenShot("Information successfully captured.");

    }
    public static void filterBy(String filter){
        if (!SeleniumExecutionInstance.ClickElement(TestPaths.filterOption())) {
             Reporting.TestFailed("Failed to Click on Android Button Buy-Now ");
        }Reporting.StepPassed("Clicked Filter Option");
        if (!SeleniumExecutionInstance.ClickElement(TestPaths.tomorrowFilterOption(filter))) {
            Reporting.TestFailed("Failed to Click on Android Button Buy-Now ");
        }Reporting.StepPassed("Clicked  the desired Option");
        Reporting.StepPassedWithScreenShot("successfully Filtered by " + filter);
        if (!SeleniumExecutionInstance.ClickElement(TestPaths.ApplyFilter())) {
            Reporting.TestFailed("Failed to Click on Android Button Buy-Now ");
        }
        if (!SeleniumExecutionInstance.WaitForElement(TestPaths.filterOption())) {
            Reporting.TestFailed("Failed to apply the filter");
        }
        Reporting.StepPassedWithScreenShot("successfully Applied the Filter");
    }
    public static void LoginToBetika(String Username,String Password) {
        //navigate to the URL/Webpage
        if (!SeleniumExecutionInstance.Navigate(TestPaths.url())) {
            Reporting.TestFailed("Failed to Navigate to -  " + TestPaths.url());
        }
        if (!SeleniumExecutionInstance.WaitForElement(TestPaths.loginButton())) {
            Reporting.TestFailed("Failed to Navigate to Home Page for URL - " + TestPaths.url());
        }
        Reporting.StepPassed("successfully navigated to the Betika Page");
        Reporting.StepPassedWithScreenShot("Betika Login Page");

        if (!SeleniumExecutionInstance.EnterText(TestPaths.usernameTextbox(),Username))
        {
             Reporting.TestFailed( "Failed to Enter Username. ");
        } Reporting.StepPassed("Captured Username");

        if (!SeleniumExecutionInstance.EnterText(TestPaths.passwordTextbox(),Password))
        {
            Reporting.TestFailed( "Failed to Enter Password. ");
        }Reporting.StepPassed("Captured Password");
        Reporting.StepPassedWithScreenShot("Information successfully captured.");

        if (!SeleniumExecutionInstance.ClickElement(TestPaths.loginButton())) {
            Reporting.TestFailed("Failed to Click Login Button");
        }Reporting.StepPassed("Login Button Clicked");

        if (!SeleniumExecutionInstance.WaitForElement(TestPaths.soccerSpan())) {
            Reporting.TestFailed("Failed wait for an element on the Landing page");
        }else {
            Reporting.StepPassedWithScreenShot("Successfully Logged in on "+ TestPaths.url());
        }

    }

    public static void CustomFixtures(String x ){

        if (!SeleniumExecutionInstance.ClickElement(TestPaths.printMatchesBTN())) {
            Reporting.TestFailed("Failed to Click Print Matches ");
        }Reporting.StepPassed("Clicked Print matches");

        if (!SeleniumExecutionInstance.ClickElement(TestPaths.costomLeagueDropDown())) {
            Reporting.TestFailed("Failed to open dropdown");
        }Reporting.StepPassed("Clicked Dropdown");

        if (!SeleniumExecutionInstance.ClickElement(TestPaths.costomLeague(x))) {
            Reporting.TestFailed("Failed to select the provded League " + x);
        }Reporting.StepPassed("Selected the " + x);

        if (!SeleniumExecutionInstance.ClickElement(TestPaths.printDownloadBTN())) {
            Reporting.TestFailed("Failed to Click on Download ");
        }Reporting.StepPassed("Downloaded the Matches for " + x);

        Reporting.StepPassedWithScreenShot("Downloaded Leage Games for " + x);
    }
}
