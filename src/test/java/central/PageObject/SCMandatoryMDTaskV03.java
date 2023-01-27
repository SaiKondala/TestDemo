package central.PageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SCMandatoryMDTaskV03 extends SCWFTemplate
{
	//WebDriver driver;
	public SCMandatoryMDTaskV03(WebDriver driver)
	{
		super(driver);

	}
	public static String MandatoryMDTaskWFT = "MD mandatory 1 " + Auto_WFTName;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	public void CreateWFTV3_FirstPage() throws Exception 
	{
		SCWFTemplate.wftdashboard.click();
		SCWFTemplate.CreateWFTLink.click();
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		SCWFTemplate.WFTName.sendKeys(MandatoryMDTaskWFT);
		SCWFTemplate.WFTStatusToggle.click();
		Thread.sleep(3000);
		SCWFTemplate.Related_WST_DP.click();
		//Thread.sleep(3000);
		SCWFTemplate.Related_WST_SearchBox.sendKeys(SCWSTemplate.wsname2); // Library //SCWSTemplate.wsname2
		//Thread.sleep(3000);
		SCWFTemplate.Related_WST_Selection.click();
		Thread.sleep(3000);
		SCWFTemplate.Related_WIT_DP.click();
		SCWFTemplate.Related_WIT_SearchBox.sendKeys(SCWITemplate.WIT); // Campus - Batch // SCWITemplate.WIT
		SCWFTemplate.Related_WIT_Selection.click();
		Thread.sleep(5000);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,350)", "");
		SCWFTemplate.NWFT_NextButton.click();
		wait.until(ExpectedConditions.visibilityOf(AddTaskLink));
	}
	
	public void MandatoryMDTask() throws Exception		//need to configure the mandatory dropdown for this method
	{
		System.out.println("Task Validation-3 : Mandatory at completion");
		SCWFTemplate.AddTaskLink.click();
		SCWFTemplate.TaskTypeDP.click();
		SCWFTemplate.TaskTypeDP.sendKeys("Animation");
		SCWFTemplate.TaskTypeDP.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		SCWFTemplate.TaskDP.click();
		SCWFTemplate.TaskDP.sendKeys(TaskName1);
		SCWFTemplate.TaskDP.sendKeys(Keys.ENTER);
		SCWFTemplate.TaskDuration.click();
		Thread.sleep(3000);
		SCWFTemplate.TaskResponsibilityDp.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SCWFTemplate.TaskDuration);
		
		SCWFTemplate.TaskRespoSelectall.click();  //at first click all respo's will get select.
		SCWFTemplate.TaskRespoSelectall.click(); // at second click all respo's get unselect.
	
		  for(WebElement opt : SCWFTemplate.TaskRespoList) 
		  {
		 // System.out.println("Task respo Name : "+opt.getText());
		  
		  if(opt.getText().equals("Copyeditor")) 
			  {
			  //System.out.println("Task Name : "+opt.getText());
			  opt.click(); 
			  }
		  }
		SCWFTemplate.TaskResponsibilityDp.click();
		SCWFTemplate.ReviewRequiredNo.click();
		SCWFTemplate.MandatoryTaskNo.click();
		SCWFTemplate.AllowStartDateLockNo.click();
		SCWFTemplate.AllowEndDateLockNo.click();
		SCWFTemplate.MilestoneTaskNo.click();
		SCWFTemplate.BillableTaskNo.click();	
		SCWFTemplate.InvokeSystemNo.click();
		SCWFTemplate.ManageMetadaDatalink.click();
		
		for(WebElement MDL : SCWFTemplate.MDFieldTaskDisplayList) 
		{
			if(MDL.getText().equalsIgnoreCase("%C&A of First Review (Import: PE)") || MDL.getText().equalsIgnoreCase("3play id")||MDL.getText().equalsIgnoreCase("Access id"))
			{
				MDL.click(); 
			}
			else if(MDL.getText().equalsIgnoreCase("trim size") || MDL.getText().equalsIgnoreCase("colors to use")) 
			{
				MDL.click(); 
			}
		}
		SCWFTemplate.MDFieldTaskDisplaySelect.click();
		SCWFTemplate.MDFieldTaskDisplaySave.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SCWFTemplate.ManageMetadaDatalink);
		MandatoryMDdrp.sendKeys("Mandatory");
		SCWFTemplate.SaveTaskBtn.click();
	}
	public void savewftv3()
	{
		SCWFTemplate.SaveWFTBtn.click();		 
		 //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		 wait.until(ExpectedConditions.visibilityOf(WFTSuccessMsg));
		 System.out.println("Success msg :"+SCWFTemplate.WFTSuccessMsg.getText());
		Assert.assertEquals(SCWFTemplate.WFTSuccessMsg.getText(), "Workflow template "+MandatoryMDTaskWFT+" created successfully.");
	}
}
