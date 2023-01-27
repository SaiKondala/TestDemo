package central.PageObject;

import java.time.Duration;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import central.TestCases.CommonClass;


public class SCCreateExtuser extends CommonClass
{
	WebDriver driver;
	public SCCreateExtuser(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//a[@href='/User/Index']")
	public WebElement acctdashboard;
	
	@FindBy(xpath="//span[text() = ' Create a new user']")
	public static WebElement createnewuser;
	
	@FindBy(id=("username"))
	public static WebElement eaddress;
	
	@FindBy(xpath=("//button[@title = 'Find User']"))
	public static WebElement finduser;
	
	@FindBy(id=("fstname"))
	public static WebElement fstname;
	
	@FindBy(id=("lstname"))
	public static WebElement lstname;
	
	@FindBy(id=("countrycode"))
	public static WebElement countrycode;
	
	@FindBy(id=("phnNumber"))
	public static WebElement phnnumber;
	
	@FindBy(xpath = "//span[@aria-owns = 'ddcTimeZone_listbox']") 
	public static WebElement timezone;
	
	@FindBy(xpath = "//ul[@id = 'ddcTimeZone_listbox']//li")
	public static WebElement timezonev;
	
	@FindBy(xpath=("//button[@class = 'btn btn-primary createUserNext Button']"))
	public static WebElement nextstep;
	
	@FindBy(xpath=("//span[@aria-controls='selectUserRoles_listbox']"))
	public static WebElement role;
	
//	@FindBy(xpath=("//li[1][. = 'SAGE System Administrator']"))
//	public static WebElement roleselect;
	
	@FindBy(id=("finalsubmit"))
	public static WebElement submit;
	
	@FindBy(id=("AccountMngDashboardSuccess"))
	public static WebElement usercreated;
	
//	@FindBy(xpath = "//*[@id=\"2\"]")
//	public static WebElement wiclick;
//	
	@FindBy(id = "extnumber")
	public static WebElement extnumber;
	
	
	@FindBy(id = "chkIsbillable")
	public static WebElement billablecheckbox;
	
	@FindBy(id = "btnAddContractor")
	public static WebElement addcontractorbtn;
	
	@FindBy(xpath = "//td[@class = ' col-md-1 text-center']")
	public static WebElement selectcontractor;
	
	@FindBy(id = "btncontractusersave")
	public static WebElement savecontractor;
			
	@FindBy(xpath = "//a[@class = 'editUser']")
	public static WebElement edituser;
	
	@FindBy(id = "AcctExpirydate")
	public static WebElement acctExpirydate;
	
	@FindBy(id = "txtUserEmailSearchField")
	public static WebElement searchuser;
	
	@FindBy(id = "btnsavecontactinfo")
	public static WebElement updateuser;
	
	@FindBy(id = "CancelCommEditUser")
    public static WebElement canceluser;
	
	@Test
	
	public  void createuser() throws Exception 
	{
//		try {
			
		
		acctdashboard.click();
		SCCreateExtuser.createnewuser.click();
		SCCreateExtuser.eaddress.click();
		String email = randomemail() + "@sel.com";
		SCCreateExtuser.eaddress.sendKeys(email.toLowerCase());
		SCCreateExtuser.finduser.click();
		SCCreateExtuser.billablecheckbox.click();
		SCCreateExtuser.addcontractorbtn.click();
		SCCreateExtuser.selectcontractor.click();
		SCCreateExtuser.savecontractor.click();
		SCCreateExtuser.fstname.sendKeys(email);
		SCCreateExtuser.lstname.sendKeys(email);
		SCCreateExtuser.countrycode.sendKeys("91");
		SCCreateExtuser.phnnumber.sendKeys("987654321");
		SCCreateExtuser.extnumber.sendKeys("321");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 250)" , "");
		SCCreateExtuser.timezone.click();
		
		List<WebElement> t = driver.findElements(By.xpath("//ul[@id = 'ddcTimeZone_listbox']//li"));
		int count = t.size();
		System.out.println("TimeZone count is: " + count);
		t.get(count-95).click();
		
		//SCCreateExtuser.timezonev.click();
		SCCreateExtuser.nextstep.click();
		SCCreateExtuser.role.click();
		List<WebElement> R = driver.findElements(By.xpath("//ul[@id = 'selectUserRoles_listbox']//li"));
		int Rcount = R.size();
		System.out.println("Role count is: " + Rcount);
		
		R.get(Rcount-25).click();
		
		
		//SCCreateExtuser.roleselect.click();
		SCCreateExtuser.submit.click();
		SCCreateExtuser.usercreated.isDisplayed();
		SCCreateExtuser.searchuser.click();
		SCCreateExtuser.searchuser.sendKeys(email);
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(25));
		wait.until(ExpectedConditions.textToBe(By.xpath("//td[@class = ' col-md-3']"), email.toLowerCase()));
		SCCreateExtuser.edituser.click();
		SCCreateExtuser.acctExpirydate.click();
		SCCreateExtuser.acctExpirydate.sendKeys(date());
		SCCreateExtuser.updateuser.click();
//		SCCreateExtuser.canceluser.click();
//	}
//	
//	catch (Exception e)
//	{
//		System.out.println(e);
//	}
	}
	public String randomemail() 
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return generatedstring;
		
		
	}
	
//	public String date()
//	{
//		Random rand = new Random();
//		int randValue = rand.nextInt(10);
//		System.out.println(randValue);
//	    
//		Calendar c = Calendar.getInstance();
//		c.add(Calendar.DATE, randValue);						//instead of value 10 we can pass variable "randValue" to use random value generated
//		c.add(Calendar.MONTH, 2);
//		c.add(Calendar.YEAR, 1);
//		Date d = c.getTime();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY");
//		String dateString = sdf.format(d);
//		return dateString;
//	}
	

}
