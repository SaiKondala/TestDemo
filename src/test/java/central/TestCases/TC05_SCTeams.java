package central.TestCases;

import org.testng.annotations.Test;

import central.PageObject.SCTeams;

public class TC05_SCTeams extends TC04_SCContractor
{
	@Test(priority=5)
	public void teams() throws Exception
	{
		
			SCTeams teams = new SCTeams(driver);
			teams.accountsdashboard();
			teams.teams();
		
		
	}

}
