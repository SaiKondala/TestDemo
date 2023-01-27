package central.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import central.TestCases.CommonClass;


public class SCExtLogin extends CommonClass
{
	WebDriver ldriver;
//	public SCExtLogin(WebDriver driver)					//We have to create webdriver constructor in every class so to maintain same 
//														    //instance of browser instead of different instances
//	{
//		ldriver = driver;
//		PageFactory.initElements(driver, this);
//	}
	
	public SCExtLogin(WebDriver driver)
    {
        ldriver = driver;
        PageFactory.initElements(driver, this);
    }
		@FindBy(id = "signInName")
		public WebElement txtuname;
		
		@FindBy(id = "password")
		public WebElement txtpassword;
		
		@FindBy(id = "next")
		public WebElement btnsignin;
		
		@FindBy(xpath = "//span[text()='Close']")
		public WebElement cookieclose;
	
	
	public  void login() throws Exception 
	{
		
		txtuname.sendKeys(username);
		txtpassword.sendKeys(password);
		btnsignin.click();
		
//		Thread.sleep(10000);
		cookieclose.click();
//		if(driver.getTitle().equals("Sage :: Dashboard"))
//		{
//			Assert.assertTrue(true);
//		}
//		else
//		{
//			//capturescreen(driver, "TC01_ExtLogin");
//			Assert.assertTrue(false);
//			
//		}
		
	}

}
