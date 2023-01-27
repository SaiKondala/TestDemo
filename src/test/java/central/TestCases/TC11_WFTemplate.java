package central.TestCases;

import java.io.IOException;
import org.testng.annotations.Test;


import central.PageObject.SCWFTemplate;

public class TC11_WFTemplate extends TC01_SCExtLogin												//TC10_SCTaskTemplate 
{
	
	
	
	@Test (priority = 2)
	public void WFTCreation() throws IOException, InterruptedException 
	{
//		AllDashbaords Accounts=new AllDashbaords(driver);
//	    Accounts.AdminWorkflowDashbaord();
		
		SCWFTemplate WFTCreation=new SCWFTemplate(driver);
		
		// Seq WFT creation
		WFTCreation.CreateWFT_FirstPage();
		WFTCreation.CreateWFTask();
		WFTCreation.Task2Adding();
		WFTCreation.MilestoneWFT();
		WFTCreation.FinalsaveWFT();
		
		
		
	}

}
