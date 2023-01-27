package central.PageObject;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import central.TestCases.CommonClass;



public class SCWITemplate  extends CommonClass
{
	WebDriver driver;
//	ExtentTest test;
	
	public SCWITemplate(WebDriver driver) //, ExtentTest test)
	{
		this.driver=driver;
//		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[@href='/Workitem/Index']") 
	public WebElement workspacedashboard;
	
	@FindBy(xpath= "//span[text()='Create a new work item template']") 
	public WebElement CreateWIT;
	
	@FindBy(xpath="//input[@id='txtWorkitemtemplatename']") 
	public WebElement wit;
	
	@FindBy(xpath="//span[@class='mainslider round']") 
	public WebElement activate ;
	
	@FindBy(xpath="//*[@id=\"ms-list-1\"]/button") 
	public WebElement attachmentbtn ;
	
	@FindBy(xpath="//li[@data-search-term='a/v release']") 
	public WebElement attachment1 ;
	
	@FindBy(xpath="//li[@data-search-term='art log']") 
	public WebElement attachment2 ;
	
	@FindBy(xpath="//button[@id='btnAddAttachment']") 
	public WebElement addbutton;
	
	@FindBy(xpath="//span[text()='Select Responsibilities']") 
	public WebElement selectrespbtn1;
	
	@FindBy(xpath="//li[@data-search-term='acquiring editor']") 
	public WebElement a1resp1 ;
	
	@FindBy(xpath="//li[@data-search-term='analyst']") 
	public WebElement a1resp2 ;
	
	@FindBy(xpath="//span[text()='Acquiring Editor, Analyst']") 
	public WebElement finalsel ;
	
	@FindBy(xpath="//*[@id=\"grdSensitiveAttachmentType\"]/div[2]/table/tbody/tr[2]/td[5]/a") 
	public WebElement removebtn ;
	
	@FindBy(xpath="//input[@id='MetadataGroupSearch']") 
	public WebElement MDsearch ; 
	
	@FindBy(xpath="//td[@class='col-md-6 sorting_1']") 
	public WebElement selectMDG;
	
	@FindBy(xpath="//button[@id='WIRightMove']") 
	public WebElement rightmove ;
	
	@FindBy(xpath="//button[text()='Save work item']") 
	public WebElement savewit ;
	
	@FindBy(xpath="//div[@id='wrkitemwrkspacedashboardmsgsSuccess']") 
	public WebElement successmsg ;
	
	@FindBy(xpath="//a[text()='Work item template']") 
	public WebElement wittab;
	
	@FindBy(id="wiTemplateNameSearchField") 
	public WebElement witnamesearch;
	
	@FindBy(xpath="//span[@class='ViewWorkItem linkcolour']") 
	public WebElement foundWIT;
	
	@FindBy(xpath="//a[@class='editworkitem']") 
	public WebElement editsymbol;
	
	@FindBy(xpath="//span[@class='fas setting-icon style setIcon']") 
	public WebElement MDSettings;
	
	@FindBy(id="txtMetadataGroupLabel") 
	public WebElement MDTitle;
	
	@FindBy(xpath="//*[@id=\"WIMetdataGroupFields\"]/tbody/tr[1]/td[5]/input") 
	public WebElement MandC1;
	
	@FindBy(xpath="//*[@id=\"WIMetdataGroupFields\"]/tbody/tr[3]/td[5]/input") 
	public WebElement MandC3;
	
	@FindBy(id="lblDatasecurityrules") 
	public WebElement DataSecurityRules;
	
	@FindBy(id="Is_Confidential1") 
	public WebElement SensitiveMDF1;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/section/form/div/div/section/div/div/div/div[3]/div[4]/div[5]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/table/tbody/tr[2]/td[6]/div/div/button") 
	public WebElement pleaseselect;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/section/form/div/div/section/div/div/div/div[3]/div[4]/div[5]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/table/tbody/tr[2]/td[6]/div/div/div/ul/li[1]/label/span") 
	public WebElement AE1;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/section/form/div/div/section/div/div/div/div[3]/div[4]/div[5]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/table/tbody/tr[2]/td[6]/div/div/button") 
	public WebElement pleaseselect1;
	
	@FindBy(id="btnMetadataGroupsFieldsOk") 
	public WebElement Okbtn;
	
	@FindBy(id="workitemUpdatemsg") 
	public WebElement editwitsmsg;
	
	public static Faker faker = new Faker();
	public static String Workitemtemaplate = faker.book().title();
	public static String WIT = Workitemtemaplate+"-Auto-WIT";
	public String SMWIT= "Work item template " +WIT+ " created successfully.";
	
	public void CreateWIT() throws InterruptedException, IOException
	{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			
		workspacedashboard.click();
			wait.until(ExpectedConditions.titleContains("Sage :: Workspace dashboard"));
		CreateWIT.click();
			wait.until(ExpectedConditions.titleContains("Sage :: Create work item template"));
		wit.sendKeys(WIT);
		activate.click();
			((JavascriptExecutor)driver).executeScript("scroll(0,600)");
		attachmentbtn.click();
			Thread.sleep(3000);
		attachment1.click();
		attachment2.click();
		addbutton.click();
			Thread.sleep(3000);
		removebtn.click();
			Thread.sleep(3000);
		selectrespbtn1.click();
			Thread.sleep(3000);
		a1resp1.click();
		a1resp2.click();
			Thread.sleep(3000);
		finalsel.click();
			((JavascriptExecutor)driver).executeScript("scroll(0,500)");
		MDsearch.sendKeys(SCMDGroup.MDN);
			wait.until(ExpectedConditions.elementToBeClickable(selectMDG)).click();
		rightmove.click();
			((JavascriptExecutor)driver).executeScript("scroll(0,650)");
		savewit.click();
//			Object failscrnshot = TestLogin.CaptureScreen(driver);
//			if(successmsg.getText().equals(SMWIT))
//			{
//				test.log(LogStatus.PASS, "user has created WIT");
//			}
//			else
//			{
//				test.log(LogStatus.FAIL,test.addScreenCapture((String) failscrnshot)+"user is unable to create the WIT");
//			}	
			wait.until(ExpectedConditions.textToBePresentInElement(successmsg,SMWIT));
	}
	
	public void EditWIT() throws InterruptedException
	{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wittab.click();
		witnamesearch.sendKeys(WIT);
		
			Thread.sleep(5000);
			wait.until(ExpectedConditions.textToBePresentInElement(foundWIT,WIT));
		editsymbol.click();
		Thread.sleep(5000);
//			if(wit.getText().equals(WIT))
//			{
//				test.log(LogStatus.PASS, "User has edited correct WIT");
//			}
//			else
//			{
//				test.log(LogStatus.FAIL, "User has edited incorrect WIT ");
//			}
			wait.until(ExpectedConditions.textToBePresentInElementValue(wit,WIT));
			((JavascriptExecutor)driver).executeScript("scroll(0,600)");
		attachmentbtn.click();
			Thread.sleep(3000);
		attachment2.click();
		addbutton.click();
			Thread.sleep(3000);
		removebtn.click();
			Thread.sleep(3000);
			((JavascriptExecutor)driver).executeScript("scroll(0,750)");
	
			Actions act = new Actions(driver);		
			act.doubleClick(MDSettings).perform();
			wait.until(ExpectedConditions.textToBePresentInElementValue(MDTitle, SCMDGroup.MDN));
		MandC1.click();
		MandC3.click();
		Thread.sleep(3000);
		DataSecurityRules.click();
		SensitiveMDF1.click();
		pleaseselect.click();
		AE1.click();
		pleaseselect1.click();
		Okbtn.click();
		((JavascriptExecutor)driver).executeScript("scroll(0,600)");
		savewit.click();
		
		wait.until(ExpectedConditions.textToBePresentInElement(editwitsmsg,WIT));
	}

}