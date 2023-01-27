package central.PageObject;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import central.TestCases.CommonClass;

public class SCContractor extends CommonClass
{
	WebDriver ldriver;
	public SCContractor(WebDriver driver)
	{
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//span[text()=' Create a contractor']")
	public static WebElement createcontractor;
	
	@FindBy (id="AddLinkUsers")
	public static WebElement linkcontractor ;
	
	@FindBy (xpath="//input[@aria-label='Select row']")
	public static WebElement selectcontractor;
	
	@FindBy (id="btnLinkUserSave")
	public static WebElement linkusersave ;
	
	@FindBy (id="btnContractorBasicInfoNext")
	public static WebElement contractornext ;
	
	@FindBy (xpath="//span[text()='-- Please select --']")
	public static WebElement responsibilitydropdown;
	
	@FindBy (id="btnCreateContractorSave")
	public static WebElement contractorsave;
	
	@FindBy (xpath="//a[@class='editContractor']")
	public static WebElement editcontractor;
	
	@FindBy (id="btnContractorBasicInfoNext")
	public static WebElement cbasicNext ;
	
	@FindBy (id="btnContractorAvailabilityNext")
	public static WebElement cbillingNext ;
	
	@FindBy (id="btnContractorUsersNext")
	public static WebElement cusernext ;
	
	@FindBy (xpath="(//button[@id=\"btnContractorUpdate\"])[2]") 
	public static WebElement cupdate ;
	
	@FindBy(xpath = "//a[@href='/User/Index']")
    public static WebElement acctdashboard;
	
	@FindBy(xpath = "//input[starts-with(@id,'ms-opt')]")
    public static WebElement reschkbox;
	
	@FindBy(xpath = "//p[text() = 'Contractor ' and text() = ' created successfully']")
    public static WebElement ccsuccess;
	
	@FindBy(id = "txtContractorNameSearchField")
	public static WebElement searchcontractor;
	
	@FindBy(xpath = "//p[@id = 'ContractorUpdateFinalMsg']")
	public static WebElement cusuccess;
	
	@FindBy(xpath = "//button[@class = 'alert__close']")
	public static WebElement closesuccessalert;
	
	@FindBy (xpath="//*[@id=\"ms-list-1\"]/button")
	public static WebElement editresdropdown;
	
	@FindBy (id="btnContractorWorkHistoryCancel")
    public static WebElement cancelcontr;

@Test
public void contractor() throws Exception 
{
//	SCContractor.acctdashboard.click();
	
	SCContractor.createcontractor.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	SCContractor.linkcontractor.click();
	SCContractor.selectcontractor.click();
	SCContractor.linkusersave.click();
	SCContractor.contractornext.click();
	SCContractor.responsibilitydropdown.click();
	List<WebElement> crres=driver.findElements(By.xpath("//*[@id=\"ms-list-1\"]/div/ul//li"));
//	System.out.println(crres.size());
	Random rand = new Random();
	int rannum = rand.nextInt(5);
	System.out.println("Randome no for responsibility is: " + rannum);
	for (int i = rannum; i < crres.size()-70; i++)
	{
		crres.get(i).click();
	}
	SCContractor.contractorsave.click();
	SCContractor.ccsuccess.isDisplayed();
	String cname = driver.findElement(By.xpath("//p[text() = 'Contractor ' and text() = ' created successfully']/b")).getText();
	SCContractor.closesuccessalert.click();
	SCContractor.searchcontractor.click();
	SCContractor.searchcontractor.sendKeys(cname);
	WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(25));
	Boolean element = wait.until(ExpectedConditions.textToBe(By.xpath("//td[@class = 'col-md-3 minwidth sorting_1']"), cname));
	SCContractor.editcontractor.click();
	driver.navigate().refresh();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	SCContractor.cbasicNext.click();
	SCContractor.editresdropdown.click();
	List<WebElement> crres1=driver.findElements(By.xpath("//*[@id=\"ms-list-1\"]/div/ul//li"));
	int rannum1 = rand.nextInt(10);
	for (int i = rannum1; i < crres1.size()-70; i++)
	{
		crres1.get(i).click();
	}
	SCContractor.cbillingNext.click();
	
	SCContractor.cusernext.click();
//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	SCContractor.cupdate.click();
	SCContractor.cusuccess.isDisplayed();
	SCContractor.cancelcontr.click();
}
}

	
	
	
	

