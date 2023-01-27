package central.TestCases;

import org.testng.annotations.Test;

import central.PageObject.SCProfile;
import central.PageObject.SCWSTemplate;

public class TC07_SCWSTemplate extends TC08_SCWITemplate														//TC06_SCProfile
{
	@Test (priority = 5)
	public void WSTemplate() throws Exception
	{
		
			SCWSTemplate wst = new SCWSTemplate(driver);
			wst.WSTemplate();
		
		
	}
	
	
}
