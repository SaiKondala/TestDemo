package central.TestCases;

import org.testng.annotations.Test;

import central.PageObject.SCContractor;

public class TC04_SCContractor extends TC03_SCRole

{
	@Test (priority = 4)
	public void Vendor() throws Exception
	{
		
			SCContractor sccont = new SCContractor(driver);
			sccont.contractor();
		
		
		
	}
	
	
}
