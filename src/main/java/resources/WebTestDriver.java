package resources;
import core.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
public class WebTestDriver  extends Base {
    private WebDriver driver;
    public enum BrowserType {CHROME, FIREFOX}
    private BrowserType RunningBrowser;
    public static int PicCounter = 0;
    public WebTestDriver(BrowserType browser)
    {
        this.RunningBrowser = browser;
        LaunchBrowser();
    }
    public boolean LaunchBrowser()
    {

        switch (this.RunningBrowser)
        {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                this.driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                this.driver = new FirefoxDriver();
            default:
                break;
        }

        this.driver.manage().window().maximize();

        return true;
    }
    public boolean shutDown ()
    {
        try
        {
            this.driver.close();
            this.driver.quit();
            return false;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public WebDriver getDriver()
    {
        return driver;
    }
    public boolean Navigate(String URL)
    {
        try
        {
            this.driver.navigate().to(URL);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public boolean WaitForElement(By selector)
    {
        boolean found = false;
        int counter = 0;
        try
        {
            while (!found && counter < 30)
            {
                try {
                    WebDriverWait wait = new WebDriverWait(this.driver, 1);
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
                    found = true;
                }
                catch (Exception e)
                {
                    counter ++;
                    pause(1000);
                }
            }
            return found;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public boolean ClickElement(By selector)
    {
        try {
                WaitForElement(selector);

                WebDriverWait wait = new WebDriverWait(this.driver, 1);
                wait.until(ExpectedConditions.elementToBeClickable(selector));
                WebElement ClickElement = this.driver.findElement(selector);
                ClickElement.click();

                 return true;
            }
        catch (Exception e)
            {
                return false;

            }

    }
    public boolean ScrollToElement(By selector)
    {
        try {

            WebElement WElement = driver.findElement(selector);
            Actions action = new Actions(this.driver);
            action.moveToElement(WElement).perform();


            return true;
        }
        catch (Exception e)
        {
            return false;

        }

    }
    public boolean EnterText(By selector, String TextToBeEntered)
    {
        try {
            WaitForElement(selector);

            WebDriverWait wait = new WebDriverWait(this.driver, 1);
            wait.until(ExpectedConditions.elementToBeClickable(selector));
            WebElement TextElement = this.driver.findElement(selector);
            TextElement.sendKeys(TextToBeEntered);

            return true;
        }
        catch (Exception e)
        {
            return false;

        }

    }
    public void pause (int millis) {
    try
    {
        Thread.sleep(millis);
    }
    catch (InterruptedException e)
    {
        e.printStackTrace();
    }
}
    public boolean ValidationElement(By selector, String TextToValidate)
    {
        try {
            WaitForElement(selector);
            WebDriverWait wait = new WebDriverWait(this.driver, 1);
            wait.until(ExpectedConditions.elementToBeClickable(selector));
            WebElement ValidationElement = this.driver.findElement(selector);

            return ValidationElement.getText().equals(TextToValidate);
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public String takeScreenShot(boolean isError)
    {
        StringBuilder imageFilePathBuilder = new StringBuilder();
        StringBuilder relativePathBuilder = new StringBuilder();
        try
        {
            PicCounter++;
            imageFilePathBuilder.append(get_ReportDirectory());
            relativePathBuilder.append("ScreenShot\\");
            new File(imageFilePathBuilder.toString() + (relativePathBuilder).toString()).mkdir();
                relativePathBuilder.append(PicCounter+"_");
            if (isError)
            {
                relativePathBuilder.append("PASSED");
            }
            else
            {
                relativePathBuilder.append("FAILED");
            }

            relativePathBuilder.append(".png");
            File screenShot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot,new File(imageFilePathBuilder.append(relativePathBuilder).toString()));

            return "./"+relativePathBuilder.toString();
        }
        catch (Exception e)
        {
            return null;
        }
    }
    public void AlertHendler(){
        driver.switchTo().alert().accept();
    }
    public void SwitchTab(int ScrNo){
        driver.getWindowHandles();
        Set<String> handlesSet = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<String>(handlesSet);
        driver.switchTo().window(handlesList.get(ScrNo));
    }
    public void CloseAndSwitchTab(){


            driver.close();
            SwitchTab(0);
                 }
}
