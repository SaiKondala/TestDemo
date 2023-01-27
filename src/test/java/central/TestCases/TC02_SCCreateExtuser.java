package central.TestCases;

import org.testng.annotations.Test;

import central.PageObject.SCCreateExtuser;


public class TC02_SCCreateExtuser extends TC01_SCExtLogin
{
	@Test //(priority = 1)
	public void CreateExtuser() throws Exception
	{
		
		SCCreateExtuser sccreate = new SCCreateExtuser(driver);
		sccreate.createuser();
//		ExtentTest test = extent.createTest("Create ExtUser");
//		try
//		{
//			SCCreateExtuser sccreate = new SCCreateExtuser(driver);
//			sccreate.createuser();
//		}
//		catch (Exception e)
//		{
//			System.out.println(e);
//		}
//		try
//		{
//		
//			SCCreateExtuser.usercreated.isDisplayed();
//			System.out.println("Successfull");
//			String path = capturescreen(driver, "SCCreateExtuser Successful");
//			test.pass("User Created Successfully").addScreenCaptureFromPath(path);
//		
//		
//		}
//		catch (Exception e)
//		{
//			
//			
//				System.out.println("Failed");
//				String path = capturescreen(driver, "SCCreateExtuser failed");
//				test.fail("User creation failed").addScreenCaptureFromPath(path);
//				System.out.println(e);
//		}
		//extent.flush();	
	}
		
	
	
}