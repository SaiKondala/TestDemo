package ValidationScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import central.PageObject.SCWITemplate;
import central.PageObject.SCWITemplate02;
import central.TestCases.TC09_SCMDGroup;

public class Parent_ChildWITCreation extends TC09_SCMDGroup
{
	@Test(priority=4)
	public void WITSCreations() throws Exception
	{ 
		SCWITemplate02 Workitem2 = new SCWITemplate02(driver);
		Workitem2.CreateWIT();
		Workitem2.CreateWIT02();
	}
}
