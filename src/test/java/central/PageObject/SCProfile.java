package central.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import central.TestCases.CommonClass;

public class SCProfile extends CommonClass
{
	WebDriver ldriver;
	public SCProfile(WebDriver driver)
	{
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//img[@class = 'user-image']")
	public static WebElement profileimage;
	
	@FindBy (xpath = "//a[text() = 'Profile']")
	public static WebElement profile;
	
	@FindBy (xpath = "//a[text() = 'Sign out']")
	public static WebElement signout;
	
	@FindBy (xpath = "//button[@class=\"Button btn btn-default pull-left profile-cancel\"]")
	public static WebElement profilecancel;
	
	@FindBy (id = "ctrphone")
	public static WebElement phoneno;
	
	@FindBy (id = "btnContractorBasicInfoNext")
	public static WebElement basicnext;
	
	@FindBy (id = "btnContractorAvailabilityNext")
	public static WebElement billingnext;
	
	@FindBy (id = "btnContractorUsersNext")
	public static WebElement usenext;
	
	@FindBy (id = "btnCtrbaiscinfoSave")
	public static WebElement profilesave;
	
	@FindBy (id = "ctrext")
	public static WebElement phoneext;
	
	
	public void Profile() throws Exception
	{
		
		SCProfile.profileimage.click();
		SCProfile.profile.click();
		SCProfile.phoneno.click();
		SCProfile.phoneno.clear();
		SCProfile.phoneno.sendKeys("987654321");
		SCProfile.phoneext.click();
//		Thread.sleep(5000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		SCProfile.profilesave.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		try
		{
			SCProfile.profilecancel.click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		if(driver.getTitle().equals("Sage :: Dashboard"))
			{
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			
			}
	}
}
