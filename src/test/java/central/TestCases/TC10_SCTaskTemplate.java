package central.TestCases;

import java.io.IOException;
import org.testng.annotations.Test;

import central.PageObject.SCTaskTemplate;



public class TC10_SCTaskTemplate extends TC09_SCMDGroup 
{
	@Test(priority=10)
	public void CreateTask() throws InterruptedException, IOException
	{	
		SCTaskTemplate TaskC = new SCTaskTemplate(driver);
		TaskC.CreateEditCloneTask();
	}
}
