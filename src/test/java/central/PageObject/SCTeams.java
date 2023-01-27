package central.PageObject;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import central.TestCases.CommonClass;

public class SCTeams extends CommonClass
{
	WebDriver ldriver;
	public SCTeams(WebDriver driver) 
	{
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//span[text()=' Create a team']")
	public static WebElement createteam;
	
	@FindBy (id="txtTeamName")
	public static WebElement teamname;
	
	@FindBy (xpath="//span[text()='-- Please select --']")
	public static WebElement teamres;
	
	@FindBy (id="txtTeamDescription")
	public static WebElement description;
	
	@FindBy (id="AddLinkMembers")
	public static WebElement linkmember;
	
	@FindBy (xpath="(//input[@aria-label='Select row'])[1]")
	public static WebElement usercheckbox;
	
	@FindBy (id="btnLinkMemberSave")
	public static WebElement popupsave;
	
	@FindBy (xpath="//button[@class='btn btn-primary Button' and @id='btnSaveTeam'] ")
	public static WebElement saveteam;
	
	@FindBy (xpath="(//span[@class='k-icon k-i-filter'])[2]")
	public static WebElement searchhandle;
	
	@FindBy (xpath="//input[@class='k-textbox']")
	public static WebElement searchteam;
	
	@FindBy (xpath="//button[@title='Filter']")
	public static WebElement filterbtn;
	
	@FindBy (xpath="//a[@class='k-button k-button-icontext k-grid-edit']")
	public static WebElement editteam;
	
	@FindBy (xpath="//*[@id=\"teams_Dashboard\"]/div[2]/table/tbody/tr/td[8]/a")
	public static WebElement editteam1;
	
	@FindBy (id="chkisowner")
	public static WebElement isowner;
	
	@FindBy (id="btnUpdateTeam")
	public static WebElement teamupdate;
	
	@FindBy (id="AccountMngDashboardSuccess")
	public static WebElement teamsuccess;
	
	@FindBy (xpath="//*[@id=\"msgAccountMngDashboardSuccess\"]/button")
	public static WebElement teamsuccessclose;
	
	@FindBy (xpath="(//td[@class='k-command-cell']")
	public static WebElement teamdeactivate;
	

public void teams() throws Exception
{
	Faker f=new Faker();
	String tname=f.name().name();
	
	SCTeams.createteam.click();
	SCTeams.teamname.click();
	SCTeams.teamname.sendKeys(tname);
	SCTeams.description.sendKeys("Team Created By Selenium Script");
	SCTeams.teamres.click();
	Random rnum=new Random();
	int resnum=rnum.nextInt(10);
	List<WebElement> countres=driver.findElements(By.xpath("//label[starts-with(@for,'ms-opt')]"));
	for(int i=resnum;i<=countres.size()-70;i++) 
	{
		countres.get(i).click();
		
	}
	SCTeams.linkmember.click();
	SCTeams.usercheckbox.click();
	SCTeams.popupsave.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	SCTeams.saveteam.click();
	SCTeams.teamsuccess.isDisplayed();
	SCTeams.searchhandle.click();
	Thread.sleep(3000);
//	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	SCTeams.searchteam.click();
	SCTeams.searchteam.sendKeys(tname);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	SCTeams.filterbtn.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//	WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(15));
//	Boolean element = wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"teams_Dashboard\"]/div[2]/table/tbody/tr[1]/td[2]/a"), tname));
	SCTeams.editteam1.click();
	SCTeams.isowner.click();
	SCTeams.teamupdate.click();
	
}
}
	

