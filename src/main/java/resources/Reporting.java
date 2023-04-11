package resources;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import core.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import  java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends Base {

    private static ExtentReports report;
    private static ExtentTest RunningTest;

    private static void setup()
    {
        set_ReportDirectory(System.getProperty("user.dir")+"\\Reports\\"+ TestName+"\\"+getCurrentTime()+"\\");
        new File (get_ReportDirectory()).mkdir();
        report = new ExtentReports();
        ExtentHtmlReporter html = new ExtentHtmlReporter(get_ReportDirectory()+"ExtentReports.html");
        report.attachReporter(html);
        report.setAnalysisStrategy(AnalysisStrategy.TEST);

                report.flush();

    }

    public static void createTest()
    {
        try
        {
            if(report == null)setup();
            if(RunningTest == null || !RunningTest.getModel().getName().equals(TestName))
            {
                RunningTest = report.createTest(TestName);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void StepPassed(String message)
    {
        if(RunningTest == null)createTest();
        RunningTest.pass(message);
        System.out.println(message);

        report.flush();
    }

    public static void StepPassedWithScreenShot(String message)
    {
        if(RunningTest == null)createTest();
        try {
                RunningTest.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(SeleniumExecutionInstance.takeScreenShot(true)).build());
            }
        catch (Exception e)
            {
                RunningTest.pass(message+" - Failed to take ScreenShot");
            }
            //System.out.println(message);
            report.flush();
    }

    public static void info(String message)
    {
        if(RunningTest == null)createTest();
        RunningTest.info(message);
        System.out.println("[INFO] - "+message);

        report.flush();
    }


    public static void warning(String message)
    {
        if(RunningTest == null)createTest();
        RunningTest.warning(message);
        System.out.println("[warning] - "+message);

        report.flush();
    }

    public static String TestFailed(String message)
    {
        if(RunningTest == null)createTest();
        try
        {
            RunningTest.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(SeleniumExecutionInstance.takeScreenShot(false)).build());
        }
        catch (Exception e)
        {
            RunningTest.pass(message+" - Failed to take ScreenShot");
        }
        System.out.println("[TestFailed] - "+message);

        return  message;
    }

    public static String finaliseTest()
    {
        if(RunningTest == null)createTest();
        try
        {
            RunningTest.pass("Test Complete!", MediaEntityBuilder.createScreenCaptureFromPath(SeleniumExecutionInstance.takeScreenShot(true)).build());
        }
        catch (Exception e)
        {
            RunningTest.pass("Test Complete!");
        }
        System.out.println("Test Complete!");

        report.flush();
        return  null;
    }

    public static String getCurrentTime()
    {
        Date date = new Date();
        SimpleDateFormat form = new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");

        return form.format(date);
    }



}
