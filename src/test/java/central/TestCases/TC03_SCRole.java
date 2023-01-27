package central.TestCases;

import org.testng.annotations.Test;

import central.PageObject.SCRole;

public class TC03_SCRole extends  TC01_SCExtLogin
{
	@Test//(priority = 1)
	public void role() throws Exception 
	{
//		ExtentTest test = extent.createTest("Role Creation");
		
			SCRole crole = new SCRole(driver);
			crole.role();
		

	}

}
