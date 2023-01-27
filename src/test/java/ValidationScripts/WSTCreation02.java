package ValidationScripts;

import org.testng.annotations.Test;

import central.PageObject.SCWSTemplate;
import central.TestCases.TC01_SCExtLogin;

public class WSTCreation02 extends Parent_ChildWITCreation  //TC01_SCExtLogin //Parent_ChildWITCreation
{
	@Test(priority=5)
	public void WSTCreationWithMultiplwWIT() throws Exception 
	{
		SCWSTemplate wst = new SCWSTemplate(driver);
		wst.WSTemplateforValidations();
	
	}
	

}
