package central.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;


import central.PageObject.SCMDGroup;

public class TC09_SCMDGroup extends TC01_SCExtLogin
{
	@Test(priority=2)
	public void MDGcreation() throws InterruptedException, IOException {
		SCMDGroup mdgc = new SCMDGroup(driver);
		
		mdgc.CreateMDG();
		
		Thread.sleep(5000);
//		if(driver.getCurrentUrl().equals("https://butterflytest.sagepub.com/Metadata/Index/?ActiveTab=MetadataGroupsInfo"))
//		{
//		test.log(LogStatus.PASS, test.addScreenCapture(CaptureScreen(driver))+"Navigated to the Md Dashboard URL and mdg group created successfully");
//		}
//		else
//		{
//		test.log(LogStatus.FAIL,test.addScreenCapture(CaptureScreen(driver))+ "Test Failed");
//		}
		
	}
	@Test(priority=3)
	public void MDGEdit() throws InterruptedException, IOException {
		SCMDGroup mdgc = new SCMDGroup(driver);
		mdgc.EditMDG();
		Thread.sleep(5000);
		
//		if(driver.getCurrentUrl().equals("https://butterflytest.sagepub.com/Metadata/Index/?ActiveTab=MetadataGroupsInfo"))
//		{
//		test.log(LogStatus.PASS, test.addScreenCapture(CaptureScreen(driver))+"Navigated to the Md Dashboard URL and mdg group edited successfully");
//		}
//		else
//		{
//		test.log(LogStatus.FAIL,test.addScreenCapture(CaptureScreen(driver))+ "Test Failed");
//		}
	}
}
