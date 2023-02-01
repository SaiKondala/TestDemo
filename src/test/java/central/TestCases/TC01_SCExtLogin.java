package central.TestCases;

import org.testng.annotations.Test;

import central.PageObject.SCExtLogin;

public class TC01_SCExtLogin extends CommonClass{

	@Test //(priority = 0)
	public void Login() throws Exception
	{
		
//		ExtentTest test = extent.createTest("Ext Login");
		SCExtLogin sclogin = new SCExtLogin(driver);
		sclogin.login();
		System.out.println("I am logged in");
		
		
//		if(driver.getTitle().equals("Sage :: Dashboard"))
//		{
//			//Assert.assertTrue(true);
//			String path = capturescreen(driver, "SCLogin Successful");
////			test.pass("Successfully Logged in").addScreenCaptureFromPath(path);
//		}
//		else
//		{
//			
//			//Assert.assertTrue(false);
//			String path = capturescreen(driver, "SCLogin Failed");
//			test.fail("Invalid Credentials").addScreenCaptureFromPath(path);
//			
//		}
		//extent.flush();
	}
	
}
