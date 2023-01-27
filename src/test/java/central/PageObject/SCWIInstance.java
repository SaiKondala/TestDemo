package central.PageObject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class SCWIInstance {
	WebDriver driver;
//	ExtentTest test;
	
	public SCWIInstance(WebDriver driver) //, ExtentTest test)
	{
		this.driver=driver;
//		this.test = test;
		PageFactory.initElements(driver, this);
	}
	public static Faker faker = new Faker();
	public static String WIIname = faker.numerify("Auto-####-WII");
	//public static String WIInstancename = "Auto-WSI-" + WSIname;
	public String WIISucmsg = "Workitem" + WIIname + "created successfully.";

	@FindBy(xpath = "(//a[@href='/WorkflowEnduser'])[1]")
	public static WebElement WorkflowEndUserDashboard;
	
	
	@FindBy(xpath="//span[normalize-space()=\"Create a new work item\"]")
	public static WebElement CreateWII;
	
	@FindBy(xpath="//input[@id=\"txtWIInstanceName\"]")
	public static WebElement WIINametextField;
	
	@FindBy(xpath="//select[@id=\"ddlrelatedwspaceInstance\"]")
	public static WebElement RelatedWSIDD;
	
	@FindBy(xpath="//select[@id=\"ddlwITemplate\"]")
	public static WebElement WITDD;
	
	@FindBy(xpath="//select[@id=\"ddlwIfindivsion\"]")
	public static WebElement FinancialdivisionDD;
	
	@FindBy(xpath="//select[@id=\"ddlwISAGEOwner\"]")
	public static WebElement CompanyDD;
	
	@FindBy(xpath="//a[@id=\"WIbillingRates\"]")
	public static WebElement step7;
	
	@FindBy(xpath="//select[@id=\"ddlOverrideType\"]")
	public static WebElement OverridetypeDD;
	
	@FindBy(xpath="//button[@id=\"btnwiInsatnceSave\"]")
	public static WebElement WIISaveAssign;
	
	
	public void CreateWIIforValidations()
	{
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		WorkflowEndUserDashboard.click();
		CreateWII.click();
		//wait.until(ExpectedConditions.visibilityOf(WIINametextField));
		WIINametextField.sendKeys(WIIname);     
		RelatedWSIDD.click();
		RelatedWSIDD.sendKeys(SCWSInstance.WSIname + Keys.ENTER);   // SCWSInstance.WSIname
		WITDD.click();
		WITDD.sendKeys(SCWITemplate.WIT + Keys.ENTER);   //SCWITemplate.WIT
		FinancialdivisionDD.click();
		FinancialdivisionDD.sendKeys("India" + Keys.ENTER);
		CompanyDD.click();
		CompanyDD.sendKeys("SAGE India" + Keys.ENTER);
		step7.click();
		OverridetypeDD.click();
		OverridetypeDD.sendKeys("Work" + Keys.ENTER);
		WIISaveAssign.click();
		wait.until(ExpectedConditions.titleContains("Sage :: Create workflow"));
		
		//wait.until(ExpectedConditions.visibilityOf(SC_WFI_NoResourceV01.WFTListDD));
	}

	
}
