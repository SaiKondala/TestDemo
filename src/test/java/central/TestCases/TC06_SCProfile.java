package central.TestCases;

import org.testng.annotations.Test;

import central.PageObject.SCContractor;
import central.PageObject.SCProfile;

public class TC06_SCProfile extends TC05_SCTeams
{
	@Test(priority = 6)
	public void Profile() throws Exception
	{
		
			SCProfile profile = new SCProfile(driver);
			profile.Profile();
		
		
	}
}
