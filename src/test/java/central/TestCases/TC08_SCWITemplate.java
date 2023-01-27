package central.TestCases;

import java.io.IOException;
import org.testng.annotations.Test;

import central.PageObject.SCWITemplate;


public class TC08_SCWITemplate extends TC09_SCMDGroup
{
	@Test(priority=4)
	public void CreateWorkItemTemplate() throws InterruptedException, IOException
	{
		SCWITemplate Workitem = new SCWITemplate(driver);
		Workitem.CreateWIT(); 
		
		Workitem.EditWIT(); 
		
	}
}
