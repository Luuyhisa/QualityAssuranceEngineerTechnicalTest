package testing.Pages;
import org.openqa.selenium.By;
public class TestPaths {
    public static String url() {return "https://www.betika.com/en-ke/login";}
//---------------- Login
    public static By usernameTextbox() {return By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/div[1]/input");}
    public static By passwordTextbox() {return By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/div[2]/div/input");}
    public static By loginButton() {return By.xpath("//button[@class=\"button account__payments__submit session__form__button login button button__secondary\"]");}
    public static By soccerSpan() {return By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/div[1]/div/div[1]/div/div/div/span/div[1]/div/span");}
    //------------------- Filter
    public static By filterOption() {return By.xpath("//span[text()='Filters']");}
    public static By tomorrowFilterOption(String filter) {return By.xpath("//button[contains(text(),'"+filter+"')]");}
    public static By ApplyFilter() {return By.xpath("//button[contains(text(),'Apply')]");}
//--------------- Place Bet on Rugby
    public static By sportOption(String sport) {return By.xpath("//span[text()='"+sport+"']");}
    public static By southSydneeyVsPenerith() {return By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/div/div[7]/div[2]/div[2]/div/button[1]/span");}
    public static By parramattaDraw() {return By.xpath("/html/body/div[2]/main/div/div[3]/div/div/div[2]/div/div[2]/div[8]/div[2]/div[2]/div/button[2]/span");}
    public static By dolphinsDraw() {return By.xpath("/html/body/div[2]/main/div/div[3]/div/div/div[2]/div/div[2]/div[9]/div[2]/div[2]/div/button[2]/span");}
    public static By cronullaWin() {return By.xpath("/html/body/div[2]/main/div/div[3]/div/div/div[2]/div/div[2]/div[10]/div[2]/div[2]/div/button[3]/span");}
    public static By newcastleWin() {return By.xpath("/html/body/div[2]/main/div/div[3]/div/div/div[2]/div/div[2]/div[11]/div[2]/div[2]/div/button[3]/span");}
    public static By amountToBet() {return By.xpath("//input[@class = 'input']");}
    public static By placeBetButton() {return By.xpath("//*[@id=\"slips\"]/div[2]/div/div[2]/button");}
//---------------------------------- Download
    public static By printMatchesBTN() {return By.xpath("//span[text()='Print Matches']");}
    public static By costomLeagueDropDown() {return By.xpath("//*[@id=\"fixtures\"]/div/div[2]/div[1]/div[1]/div");}
    public static By costomLeague(String LeagueX) {return By.xpath("//div[contains(text(),'"+LeagueX+"')]");}
    public static By printDownloadBTN() {return By.xpath("//button/span[text()='Download']");}






// /html/body/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/div/div[7]/div[2]/div[2]/div/button[1]/span




}
