package central.PageObject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

import central.TestCases.CommonClass;



public class SCRole extends CommonClass
{
	WebDriver ldriver;
	public SCRole(WebDriver driver)
	{
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//public WebElement acctdashboard1 = driver.findElement(By.xpath("/html/body/div[1]/aside/section/ul/li[3]/ul/li[1]/a"));
	
	@FindBy(xpath = "//a[@href='/User/Index']")
	public WebElement acctdashboard;

	@FindBy(xpath = "//span[text() = ' Create a new role']")
	public static WebElement createrole;

	@FindBy(id = "txtRoleName")
	public static WebElement rname;

	@FindBy(id = "chkIsassignExt")
	public static WebElement isassignext;

	@FindBy(id = "GetPermissions")
	public static WebElement assignprivileges;

	@FindBy(id = "prlgGroup1")
	public static WebElement accd;

	@FindBy(id = "Maptorole")
	public static WebElement maptorole;

	@FindBy(id = "RoleSubmitSave")
	public static WebElement rsave;

	@FindBy(id = "AccountMngDashboardSuccess")
	public static WebElement rolesuccess;

	@FindBy(id = "txtRoleNameSearchField")
	public static WebElement rsearch;

	@FindBy(xpath = "//a[@class ='editRole']")													//"//a[3]/span")
	public static WebElement editrole;

	@FindBy(id = "ModifyPermission")
	public static WebElement rmodifybtn;

	@FindBy(id = "prlgtype3")
	public static WebElement uncheckpriv;

	@FindBy(id = "prlgGroup10")
	public static WebElement wmgmtpriv;

	@FindBy(id = "MaptoroleUpdate")
	public static WebElement rupdate;

	@FindBy(id = "RoleSubmitUpdate")
	public static WebElement rupdatebtn;

	@FindBy(id = "roleUpdateMsg")
	public static WebElement rupdatesuccess;

	@FindBy(id = "CancelRole")
	public static WebElement cancelrole;

	@FindBy(xpath = "//a[@class ='CloneRole']")                               // "//*[@id=\"RolesGrid\"]/tbody/tr/td[4]/a[2]/span"
	public static WebElement clonerole;

	@FindBy(id = "RoleSubmitClone")
	public static WebElement rclonesave;

	@FindBy(id = "msgAccountMngDashboardSuccesss")
	public static WebElement clonesuccess;

	@FindBy(xpath = "//td[text() ='No roles exist']")
	public static WebElement noroleexist;
	
	@FindBy(xpath = "//*[@id=\"RolesGrid\"]/tbody/tr[1]/td[1]")
	public static WebElement firstrow;
	
	@FindBy(id = "txtRoleDescSearchField")
	public static WebElement roledesc;
	

	public String element;
	public void role() throws Exception
	{
//		ExtentTest test = extent.createTest("Role Creation");
		Faker faker = new Faker();
		acctdashboard.click();
		SCRole.createrole.click();
		String rtext = faker.name().name();
		SCRole.rname.sendKeys(rtext.toLowerCase());
		SCRole.isassignext.click();
		SCRole.assignprivileges.click();
		Thread.sleep(3000);
		SCRole.accd.click();
		SCRole.maptorole.click();
		SCRole.rsave.click();
		SCRole.rolesuccess.isDisplayed();
		SCRole.rsearch.click();
		SCRole.rsearch.sendKeys(rtext.toLowerCase()); //rtext.toLowerCase()
		//Thread.sleep(10000);
		SCRole.roledesc.click();
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(25));
		wait.until(ExpectedConditions.textToBe(By.xpath("//td[@class='col-md-3 sorting_1']"), rtext.toLowerCase())); //"//*[@id=\"RolesGrid\"]/tbody/tr[1]/td[1]"
		SCRole.editrole.click();
		Thread.sleep(5000);
		SCRole.rmodifybtn.click();
		Thread.sleep(3000);
		SCRole.uncheckpriv.click();
		Thread.sleep(5000);
		SCRole.wmgmtpriv.click();
		Thread.sleep(3000);
		SCRole.rupdate.click();
		SCRole.rupdatebtn.click();
		SCRole.rupdatesuccess.isDisplayed();
		SCRole.cancelrole.click();
		SCRole.rsearch.click();
		SCRole.rsearch.sendKeys(rtext.toLowerCase());
		wait.until(ExpectedConditions.textToBe(By.xpath("//td[@class='col-md-3 sorting_1']"), rtext.toLowerCase())); // "//*[@id=\"RolesGrid\"]/tbody/tr[1]/td[1]"
		SCRole.clonerole.click();
		SCRole.rclonesave.click();
//		Thread.sleep(3000);
		SCRole.rolesuccess.isDisplayed();
	}

}
