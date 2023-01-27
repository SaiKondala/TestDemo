package central.TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

import central.PageObject.SCRole;

public class TC_SCRoleTrail extends TC01_SCExtLogin
{
	
	//public String element;
	
	@Test(priority = 2)
	public void role() throws Exception
	{
		
//		ExtentTest test = extent.createTest("Role Creation");
		SCRole crole = new SCRole(driver);
//		try
//		{
		Faker faker = new Faker();
		crole.acctdashboard.click();
		SCRole.createrole.click();
		String rtext = faker.name().name();
		SCRole.rname.sendKeys(rtext.toLowerCase());
		SCRole.isassignext.click();
		SCRole.assignprivileges.click();
		Thread.sleep(3000);
		SCRole.accd.click();
		SCRole.maptorole.click();
		SCRole.rsave.click();
		SCRole.rolesuccess.isDisplayed();
		SCRole.rsearch.click();
		SCRole.rsearch.sendKeys(rtext.toLowerCase());
		
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(15));
		Boolean element = wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"RolesGrid\"]/tbody/tr[1]/td[1]"), rtext.toLowerCase()));
//		if (SCRole.firstrow.equals(rtext.toLowerCase()))
//			{
//				System.out.println("Successfull");
//				String path = capturescreen(driver, "SCRole Create");
//				test.pass("Role created successfully").addScreenCaptureFromPath(path);
//			}
//			else if((!SCRole.firstrow.equals(rtext.toLowerCase()))) 											//|| (SCRole.noroleexist.isDisplayed())) 
//			{
//				System.out.println("Failed");
//				String path = capturescreen(driver, "SCRole Incorrect record");
//				test.fail("Incorrect record").addScreenCaptureFromPath(path);
//				
//			}
//			else
//			{
//				System.out.println("Failed");
//				String path = capturescreen(driver, "SCRole NoRoleExist");
//				test.fail("No role exist").addScreenCaptureFromPath(path);
//			}	
		
		SCRole.editrole.click();
		Thread.sleep(5000);

		SCRole.rmodifybtn.click();
		Thread.sleep(3000);
		SCRole.uncheckpriv.click();
		Thread.sleep(5000);
		SCRole.wmgmtpriv.click();
		Thread.sleep(3000);
		SCRole.rupdate.click();
		SCRole.rupdatebtn.click();
		SCRole.rupdatesuccess.isDisplayed();
		SCRole.cancelrole.click();
		SCRole.rsearch.click();
		SCRole.rsearch.sendKeys(rtext.toLowerCase());
		//WebDriverWait cwait = new WebDriverWait(driver,  Duration.ofSeconds(15));
		Boolean celement = wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"RolesGrid\"]/tbody/tr[1]/td[1]"), rtext.toLowerCase()));
//		if(SCRole.firstrow.equals(rtext.toLowerCase()))
//		{
//			System.out.println("Successfull");
//			String path = capturescreen(driver, "SCRole Create");
//			test.pass("Clone role created successfully").addScreenCaptureFromPath(path);
//			
//			
//		}
//		else
//		{
//			System.out.println("Failed");
//			String path = capturescreen(driver, "SCRole Creation failed");
//			test.fail("Clone role creation failed").addScreenCaptureFromPath(path);
//		}
		SCRole.clonerole.click();
		SCRole.rclonesave.click();
		Thread.sleep(3000);
		//SCRole.rolesuccess.isDisplayed();
//		}
//		catch (Exception e)
//		{
//			System.out.println(e);
////			String path = capturescreen(driver, "SCRole Creation failed");
////			test.fail(e).addScreenCaptureFromPath(path);
//		}
	}

}
