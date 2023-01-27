package central.PageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SCCreateAssetTaskV02 extends SCWFTemplate
{
	//WebDriver driver;
	public SCCreateAssetTaskV02(WebDriver driver){
		super(driver);
	}
	public static String AssetTaskWFT = "Asset Task 1" + Auto_WFTName;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	public void CreateWFTV2_FirstPage() throws Exception 
	{
		SCWFTemplate.wftdashboard.click();
		SCWFTemplate.CreateWFTLink.click();
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		SCWFTemplate.WFTName.sendKeys(AssetTaskWFT);
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
	
	public void CreateAssetTask() throws Exception 
	{
		System.out.println("Task Validation-2 : Create asset");
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
		
		//act.doubleClick(SCWFTemplate.TaskRespoSelectall).perform();
		
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
		SCWFTemplate.InvokeSystemYes.click();	
		SCWFTemplate.InvokeSystemDp.click();
		//Thread.sleep(3000);
		for(WebElement Isl : SCWFTemplate.InvokeSystemList) 
		{			
			if(Isl.getText().equalsIgnoreCase("create asset"))
			{
				Isl.click(); 
				System.out.println("Invoke names : "+Isl.getText());
			}
		}
		SCWFTemplate.SaveTaskBtn.click();
	}
	public void savewftv2()
	{
		SCWFTemplate.SaveWFTBtn.click();		 
		 //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		 wait.until(ExpectedConditions.visibilityOf(WFTSuccessMsg));
		 System.out.println("Success msg :"+SCWFTemplate.WFTSuccessMsg.getText());
		Assert.assertEquals(SCWFTemplate.WFTSuccessMsg.getText(), "Workflow template "+AssetTaskWFT+" created successfully.");
	}
}
