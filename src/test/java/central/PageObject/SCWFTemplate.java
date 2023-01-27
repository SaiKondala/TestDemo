package central.PageObject;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.github.javafaker.Faker;
import central.TestCases.CommonClass;

public class SCWFTemplate  extends CommonClass
{
	WebDriver driver;
	static Faker fake = new Faker();
	public static String Auto_WFTName=fake.numerify("Auto-####-WFT");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
    
	public String Reated_WST_Name = SCWSTemplate.wsname; 
	public String Related_WST_Name2 = SCWSTemplate.wsname2; //SCWSTemplate.wsname; //"Library"
	public String Reated_WIT_Name = SCWITemplate.WIT;     //SCWITemplate.WIT;  //"SK-SRM Annual Title List"
	public String Related_WIT_Name2= SCWITemplate02.WIT2;									//"Video - Flat Graphic Animation";
	
	public static String Attachment_Md;       //used at Webelement in 230 line;
	public String TaskName1 ="A";
	public String TaskName2 ="c";
	public String TaskName3 ="d";
	public String TaskName4 ="e";
	

	public SCWFTemplate(WebDriver driver) 
	{

		this.driver = driver;
		PageFactory.initElements(driver, this);	    

	}
	
	@FindBy(xpath="//a[@href = '/Workflow/GetWorkFlowTemplatelist']")
	public static WebElement wftdashboard;
	
	@FindBy(xpath="//div[@class='box-body']//span[@class='links-04 pad']")
	public static WebElement CreateWFTLink;
	 
	@FindBy(name="WorkflowTemplateName")
    public static WebElement WFTName;
	
//	@FindBy(className="col-md-12 text-danger errmsgtxtWorkflowtemplatename validation-error")
//	public WebElement WFTinvalidNameValidation;
	
	@FindBy(xpath="//span[@class='Mainslider round']")
	public static WebElement WFTStatusToggle;
	
	@FindBy(xpath="//span[@id='select2-ddlRelatedWorkspaceList-container']")
	public static WebElement Related_WST_DP;
	
	@FindBy(xpath="//input[@aria-controls='select2-ddlRelatedWorkspaceList-results']")
	public static WebElement Related_WST_SearchBox;
	
	@FindBy(xpath="//ul[@id='select2-ddlRelatedWorkspaceList-results']//li[@class='select2-results__option select2-results__option--highlighted']")
	public static WebElement Related_WST_Selection;
	
	@FindBy(xpath="//span[@id='select2-ddlRelatedWorkitemList-container']")
	public static WebElement Related_WIT_DP;
	
	@FindBy(xpath="//input[@aria-controls='select2-ddlRelatedWorkitemList-results']")
	public static WebElement Related_WIT_SearchBox;
	
	@FindBy(xpath="//ul[@id='select2-ddlRelatedWorkitemList-results']//li[@class='select2-results__option select2-results__option--highlighted']")
	public static WebElement Related_WIT_Selection;
	
	@FindBy(id="btnworkflownext")
	public static WebElement NWFT_NextButton;
	
	@FindBy(id="chkIsdefault1")
	public static WebElement UDSCheck;
		
	@FindBy(linkText="Add task")
	public static WebElement AddTaskLink;
	
	@FindBy(xpath="//span[@aria-controls='ddlTaskType_listbox']")
	public static WebElement TaskTypeDP;
	
	@FindBy(xpath="//span[@aria-controls='ddlTask_listbox']")       //div[@id='taskdropdown']//span[@class='k-dropdown-wrap k-state-default']
	public static WebElement TaskDP;
	
	@FindBy(xpath="//input[@data-validatelabel='Task duration']")      
	public static WebElement TaskDuration;
	
	@FindBy(xpath="//div[@id='selectTaskResponsibilities']//button[@type='button']")
	public static WebElement TaskResponsibilityDp;

	@FindBy(xpath="//div[@id='selectTaskResponsibilities']//div[@class='ms-options']//a")
	public static WebElement TaskRespoSelectall;
	
	@FindBy(xpath="//div[@id='selectTaskResponsibilities']//div[@class='ms-options']//li//span")
	public static List<WebElement> TaskRespoList;
	
	@FindBy(xpath="//span[@aria-controls='ddlDefaultResponsibility_listbox']")
	public static WebElement PrimaryRepoDP;
	
	@FindBy(xpath="//div[@class='k-animation-container']//ul[@id='ddlDefaultResponsibility_listbox']//li")
	public static List<WebElement> PrimaryRespoList;
	
	@FindBy(xpath="(//input[@id='IsReviewRequired'])[2]")
	public static WebElement ReviewRequiredNo;
	
	@FindBy(xpath="(//input[@id='IsMandatoryTask'])[1]")
	public static WebElement MandatoryTaskYes;
	
	@FindBy(xpath="(//input[@id='IsMandatoryTask'])[2]")
	public static WebElement MandatoryTaskNo;
	
	@FindBy(xpath="((//input[@id='IsSkippedByDefault'])[1]")
	public static WebElement DefaultActive;
	
	@FindBy(xpath="(//input[@id='IsSkippedByDefault'])[2]")
	public static WebElement DefaultSkip;
	
	@FindBy(xpath="(//input[@id='IsWFTStartDateLock'])[1]")
	public static WebElement AllowStartDateLockYes;
	
	@FindBy(xpath="(//input[@id='IsWFTStartDateLock'])[2]")
	public static WebElement AllowStartDateLockNo;
	
	@FindBy(xpath="(//input[@id='IsWFTEndDateLock'])[1]")
	public static WebElement AllowEndDateLockYes;
	
	@FindBy(xpath="(//input[@id='IsWFTEndDateLock'])[2]")
	public static WebElement AllowEndDateLockNo;
		
	@FindBy(id="selectLockdateManagementResp")
	public static WebElement LockDateManagementDp;
	
	@FindBy(xpath="//span[text()= 'Lock date management is required.']")
	public static WebElement LockDateManagementValidation;
	
	@FindBy(xpath="//div[@id='selectLockdateManagementResp']//li")
	public static List<WebElement> LockDateManagementRespoList;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/section/form/div/div/section/div/div[2]/div/div[2]/div[2]/div/div[3]/form/div[1]/div/div[5]/div[2]/div[2]/div")
	public static WebElement LockDateBreachRecepientDp;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/section[1]/form[1]/div[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[3]/form[1]/div[1]/div[1]/div[5]/div[2]/div[2]/div[1]/div[1]/ul[1]/li[*]")
	public static List<WebElement> LockDateBreachRespoList;  
	
	@FindBy(xpath="(//input[@id='IsWFTMilestoneTask'])[1]")
	public static WebElement MilestoneTaskYes;
	
	@FindBy(xpath="(//input[@id='IsWFTMilestoneTask'])[2]")
	public static WebElement MilestoneTaskNo;
	
	@FindBy(id="selectMilestoneManagementResp")
	public static WebElement MilestoneManagementDp;
	
	@FindBy(xpath="//div[@id='selectMilestoneManagementResp']//li")
	public static List<WebElement> MilestoneManagementRespoList;
	
	@FindBy(xpath="//div[@id='selectMilestoneManagementResp']//a[@class='ms-selectall global links-04']")
	public static WebElement MilestoneManagementRespoSellectAll;
	
	@FindBy(xpath="//span[text()= 'Milestone management is required.']")
	public static WebElement MilestoneManagementValidation;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/section/form/div/div/section/div/div[2]/div/div[2]/div[2]/div/div[3]/form/div[1]/div/div[7]/div[2]/div[2]/div/button")
	public static WebElement MilestoneUpdateRecipientsDP;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/section/form/div/div/section/div/div[2]/div/div[2]/div[2]/div/div[3]/form/div[1]/div/div[7]/div[2]/div[2]/div/div/ul/li[*]")
	public static List<WebElement> MilestoneUpdateRespoList;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/section/form/div/div/section/div/div[2]/div/div[2]/div[2]/div/div[3]/form/div[1]/div/div[7]/div[3]/div[2]/div/button")
	public static WebElement MilestoneBreachDp;
	
	@FindBy(xpath="/html/body/div[1]/div[2]/section/form/div/div/section/div/div[2]/div/div[2]/div[2]/div/div[3]/form/div[1]/div/div[7]/div[3]/div[2]/div/div/ul/li[*]")
	public static List<WebElement> MilestoneBreachRespoList;
	
	@FindBy(xpath="(//input[@id='IsBillableTask'])[2]")
	public static WebElement BillableTaskNo;
	
	@FindBy(xpath="(//input[@id='wf_IsInvokeFunction'])[1]")
	public static WebElement InvokeSystemYes;
	
	@FindBy(xpath="(//input[@id='wf_IsInvokeFunction'])[2]")
	public static WebElement InvokeSystemNo;
	
	@FindBy(xpath="//div[@id='wf_SelectedInvokeFunction_div']//button[@type='button']")
	public static WebElement InvokeSystemDp;
	
	@FindBy(xpath="//div[@id='wf_SelectedInvokeFunction_div']//a")
	public static WebElement InvokeSystemDpSellectAll;
	
	@FindBy(xpath="//div[@id='wf_SelectedInvokeFunction_div']//li") ////div[@id='wf_SelectedInvokeFunction_div']//li//input
	public static List<WebElement> InvokeSystemList;
	
	@FindBy(xpath="//span[@class='col-md-12 text-danger errmsgwf_MS_InvokeFunction validation-error']")
	public static WebElement InvokeValidationMsg;
	
	@FindBy(xpath="//div[@id='ConfigureAttachmentTypeDiv']//div[@class='ms-options-wrap']")
	public static WebElement AttachmentTypeDp;
	
	@FindBy(xpath="//div[@id='ConfigureAttachmentTypeDiv']//li")
	public static List<WebElement> AttachmentTypeList;
	
	@FindBy(id="btnAddAttachment")
	public static WebElement AttachmentsAddButton;
	
	@FindBy(xpath="//div[@id='AttachmentsGrid']//div[@class='k-grid-content k-auto-scrollable']//td[@class]")
	public static List<WebElement> AttachmentTypeGrid;  ////div[@id='AttachmentsGrid']//td[normalize-space()='AttachmentTypeSelected']
	
	@FindBy(xpath="//div[@id='AttachmentsGrid']//span[@class='k-dropdown-wrap k-state-default']")
	public static List<WebElement> AttachmentTypeConfigDp;
	
	@FindBy(xpath="//span[text()='Manage metadata fields and groups']")
	public static WebElement ManageMetadaDatalink;
	
	@FindBy(xpath="//table[@id='WFTaskMetadatFieldList']//td")
	public static List<WebElement> MDFieldTaskDisplayList;
	
	@FindBy(id="WFTaskRightMove")
	public static WebElement MDFieldTaskDisplaySelect;
	
	@FindBy(id="btnSaveTaskMetadata")
	public static WebElement MDFieldTaskDisplaySave;
	
	@FindBy(xpath="//div[@id='MetaDataConfigureGrid']//td[text()]")
	public static List<WebElement> MD_namesExtract;
	
	@FindBy(xpath="//td[@role='gridcell'][normalize-space()=\\\"\"+Attachment_Md+\"\\\"]/..//span[@role='option']")
	public static WebElement MD_ConfigurationDp;
	
	@FindBy(id="txtSuffixFileName")
	public static WebElement ExportFileName;
	
	@FindBy(xpath="//table[@id='FromWFTaskExportMetadatFieldList']//tr//td[@class=' col-md-10']")
	public static List<WebElement> ExportMDList;
	
	@FindBy(id="btnWFExportTaskRightMove")
	public static WebElement ExportMDRightMove;
	
	@FindBy(id="btnSaveTask")
	public static WebElement SaveTaskBtn;
	
	@FindBy(id="btnfinalSaveWorkflow")
	public static WebElement SaveWFTBtn;
	
	@FindBy(id="WorkflowSuccessMsg")
	public static WebElement WFTSuccessMsg;
	
	@FindBy(xpath="//a[normalize-space()='Add related task']")
	public static WebElement AddRelatedTaskLink;
	
	@FindBy(xpath="//td[@class='dependent']//span[@role='listbox']")
	public static WebElement TaskrelationDP;
	
	@FindBy(xpath="//td[@class='workitem']//span[@role='listbox']")
	public static WebElement WITNamerelationDP;
	
	@FindBy(xpath="//td[@class='workflow']//span[@role='listbox']")
	public static WebElement WFTNamerelationDP;
	
	@FindBy(xpath="//td[@class='taskname']//span[@role='listbox']")
	public static WebElement TaskNamerelationDP;
		
	@FindBy(id="btnupdateDep")
	public static WebElement TaskDepSave;
	
	@FindBy(xpath="//span[@class=\"k-widget k-dropdown drpmetaDataConfig\"]")
    public static WebElement MandatoryMDdrp;
	
	@FindBy(xpath="//span[@class=\"k-widget k-dropdown drpattachmentConfig\"]")
    public static WebElement Mandatoryattachmentdrp;

	
public void CreateWFT_FirstPage() throws InterruptedException 
	{
	
	
		SCWFTemplate.wftdashboard.click();
		SCWFTemplate.CreateWFTLink.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		SCWFTemplate.WFTName.sendKeys("Auto-" + Auto_WFTName);
		SCWFTemplate.WFTStatusToggle.click();
		Thread.sleep(3000);
		SCWFTemplate.Related_WST_DP.click();
		//Thread.sleep(3000);
		SCWFTemplate.Related_WST_SearchBox.sendKeys(Reated_WST_Name);
		//Thread.sleep(3000);
		SCWFTemplate.Related_WST_Selection.click();
		Thread.sleep(3000);
		SCWFTemplate.Related_WIT_DP.click();
		SCWFTemplate.Related_WIT_SearchBox.sendKeys( Reated_WIT_Name);
		SCWFTemplate.Related_WIT_Selection.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		SCWFTemplate.NWFT_NextButton.click();
				
		
	}
	
public void CreateWFTask() throws InterruptedException 
	{
		
		
		SCWFTemplate.AddTaskLink.click();
		SCWFTemplate.TaskTypeDP.click();
		SCWFTemplate.TaskTypeDP.sendKeys("Animation");
		SCWFTemplate.TaskTypeDP.sendKeys(Keys.ENTER);						
		Thread.sleep(3000);
		SCWFTemplate.TaskDP.click();
		SCWFTemplate.TaskDP.sendKeys(TaskName1);
		SCWFTemplate.TaskDP.sendKeys(Keys.ENTER);
		SCWFTemplate.TaskDuration.click();
		SCWFTemplate.TaskResponsibilityDp.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SCWFTemplate.TaskDuration);
		
		SCWFTemplate.TaskRespoSelectall.click();  //at first click all respo's will get select.
		SCWFTemplate.TaskRespoSelectall.click(); // at second click all respo's get unselect.
	
		  for(WebElement opt : SCWFTemplate.TaskRespoList) 
		  {
		 // System.out.println("Task respo Name : "+opt.getText());
		  
		  if(opt.getText().equals("Associate Editor")) 
			  {
			  //System.out.println("Task Name : "+opt.getText());
			  opt.click(); 
			  }
		  else if(opt.getText().equals("Animator")) 
			  {
				  System.out.println("Task Name : "+opt.getText());
				  opt.click();
			  }
		  else if(opt.getText().equals("Acquiring Editor")) 
			  {
				  //System.out.println("Task Name : "+opt.getText());
				  opt.click();
			  
			  }
		  	}
	
		  SCWFTemplate.PrimaryRepoDP.click();
		  for(WebElement opt1 : SCWFTemplate.PrimaryRespoList) 
		  {
			  //System.out.println("Task respo Name : "+opt1.getText());
			  
			  if(opt1.getText().equals("Animator"))
			  {
			  //System.out.println("Task Name : "+opt1.getText());
			  opt1.click(); 
			  }
		  }
		  
		  SCWFTemplate.ReviewRequiredNo.click();
		  SCWFTemplate.MilestoneTaskNo.click();
		  SCWFTemplate.MandatoryTaskNo.click();
		  SCWFTemplate.DefaultSkip.click();
		
		  
		  SCWFTemplate.AllowStartDateLockYes.click();
		  SCWFTemplate.AllowEndDateLockYes.click();
		  
		  SCWFTemplate.LockDateManagementDp.click();  // Drop down opens
		  SCWFTemplate.LockDateManagementDp.click();  // Drop Down closes
		  SCWFTemplate.AllowEndDateLockYes.click();  // Click's on yes button to get the validation.
		  
		  
		  assertEquals(SCWFTemplate.LockDateManagementValidation.getText(), "Lock date management is required.");
		  
		  SCWFTemplate.LockDateManagementDp.click(); // Again Click the Drop down to select the respo's
		  
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SCWFTemplate.AllowStartDateLockNo);
		  
		  
		  
		  
		  for(WebElement LDM : SCWFTemplate.LockDateManagementRespoList) 
		  {
			  if(LDM.getText().equalsIgnoreCase("Animator") || LDM.getText().equalsIgnoreCase("Designer")||LDM.getText().equalsIgnoreCase("qc Team"))
			  {
			  
			  LDM.click(); 
			  }
		  }
		  
		  SCWFTemplate.LockDateManagementDp.click(); // Closes the Drop down after selecting respo's
		  
		  SCWFTemplate.LockDateBreachRecepientDp.click();
		  for(WebElement LDBR : SCWFTemplate.LockDateBreachRespoList) 
		  {
			  if(LDBR.getText().equalsIgnoreCase("Animator") || LDBR.getText().equalsIgnoreCase("Designer")||LDBR.getText().equalsIgnoreCase("qc Team"))
			  {
			  
				  LDBR.click(); 
			  }
		  }
		  SCWFTemplate.LockDateBreachRecepientDp.click();
		  SCWFTemplate.MilestoneTaskNo.click();
		  SCWFTemplate.MilestoneTaskYes.click();
		  SCWFTemplate.MilestoneManagementDp.click();
		  SCWFTemplate.MilestoneManagementRespoSellectAll.click();  //Just to make sure if task is alrdy configured with milestone, then repo's will be present so to uncheck those we peromoing it
		  SCWFTemplate.MilestoneManagementRespoSellectAll.click(); // It wil un select all the repo's
		  SCWFTemplate.MilestoneTaskYes.click(); //To get the validation
		  
		 // System.out.println("Validation msg  :"+SCWFTemplate.MilestoneManagementValidation.getText());
		  
		  assertEquals(SCWFTemplate.MilestoneManagementValidation.getText(), "Milestone management is required.");
		 
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SCWFTemplate.AllowEndDateLockNo);
		  SCWFTemplate.MilestoneManagementDp.click(); //To open the pop up
		  
		  
		  for(WebElement MSM : SCWFTemplate.MilestoneManagementRespoList) 
		  {
			  if(MSM.getText().equalsIgnoreCase("Animator") || MSM.getText().equalsIgnoreCase("Designer")||MSM.getText().equalsIgnoreCase("qc Team"))
			  {
			  
				  MSM.click(); 
			  }
		  }
		  
		  SCWFTemplate.MilestoneManagementDp.click(); // To close the Pop up
		  
		  SCWFTemplate.MilestoneUpdateRecipientsDP.click();
		  
		  for(WebElement MSUR : SCWFTemplate.MilestoneUpdateRespoList)
		  {
			  if(MSUR.getText().equalsIgnoreCase("Animator") || MSUR.getText().equalsIgnoreCase("Designer")||MSUR.getText().equalsIgnoreCase("qc Team"))
			  {
			  
				  MSUR.click(); 
			  }
		  }
		  SCWFTemplate.MilestoneUpdateRecipientsDP.click();
		  
		  SCWFTemplate.MilestoneBreachDp.click();
		  for(WebElement MSBR : SCWFTemplate.MilestoneBreachRespoList)
		  {
			  if(MSBR.getText().equalsIgnoreCase("Animator") || MSBR.getText().equalsIgnoreCase("Designer")||MSBR.getText().equalsIgnoreCase("qc Team"))
			  {
			  
				  MSBR.click(); 
			  }
		  }
		  SCWFTemplate.MilestoneBreachDp.click();
		  
		  
		  
		  
		  SCWFTemplate.BillableTaskNo.click();
		  
		  SCWFTemplate.InvokeSystemNo.click();
		  SCWFTemplate.InvokeSystemYes.click();
		  SCWFTemplate.InvokeSystemDp.click();
		  SCWFTemplate.InvokeSystemDpSellectAll.click(); // it will select all the data
		  SCWFTemplate.InvokeSystemDpSellectAll.click(); // it will de-select all the data
		  
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SCWFTemplate.SaveTaskBtn);
		  
		  SCWFTemplate.SaveTaskBtn.click();
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SCWFTemplate.MilestoneTaskNo);
		  assertEquals(SCWFTemplate.InvokeValidationMsg.getText(), "System function is required."); // Check's the Invoke validation msg
		  
		 // SCWFTemplate.InvokeSystemDp.click();
		  for(WebElement Isl : SCWFTemplate.InvokeSystemList) 
		  {
			  
			  //Isl.click(); 
			  System.out.println("Invoke names : "+Isl.getText());
			  if(Isl.getText().equalsIgnoreCase("create asset"))
			  {
			  
				  Isl.click(); 
			  }
		  }
		  
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SCWFTemplate.BillableTaskNo);
		  
		  SCWFTemplate.AttachmentTypeDp.click();
		  
		 
		  
		  for(WebElement ATL : SCWFTemplate.AttachmentTypeList) 
		  {
			  
			  if(ATL.getText().equalsIgnoreCase("A/v release") || ATL.getText().equalsIgnoreCase("art log")||ATL.getText().equalsIgnoreCase("call sheet"))
			  {
			  
				  ATL.click(); 
			  }
			  else if(ATL.getText().equalsIgnoreCase("figure") || ATL.getText().equalsIgnoreCase("one pager"))
			  {
				  ATL.click(); 
					 
			  }
		  }
		  
		  SCWFTemplate.AttachmentsAddButton.click();
		  
//		  for(WebElement ATSelected : SCWFTemplate.AttachmentTypeGrid)
//		  {
//			  System.out.println("Attachments" + ATSelected.getText());
//			  for(WebElement asd : SCWFTemplate.AttachmentTypeConfigDp)
//			  {
//				  if(ATSelected.getText().equalsIgnoreCase("Art log")||ATSelected.getText().equalsIgnoreCase("call sheet"))
//				  {
//					  ATSelected.click();
//					  Thread.sleep(5000);
//					  ATSelected.click();
//				  }
//			  }
//		  }
		  
		  
		  
		/*  SCWFTemplate.ManageMetadaDatalink.click();
		  
		  for(WebElement MDL : SCWFTemplate.MDFieldTaskDisplayList) 
		  {
			  
			  if(MDL.getText().equalsIgnoreCase("title") || MDL.getText().equalsIgnoreCase("author(s)")||MDL.getText().equalsIgnoreCase("colors to use"))
			  {
			  
				  MDL.click(); 
			  }
			  else if(MDL.getText().equalsIgnoreCase("trim size") || MDL.getText().equalsIgnoreCase("3play id"))
			  {
				  MDL.click(); 
					 
			  }
		  }
		  SCWFTemplate.MDFieldTaskDisplaySelect.click();
		  SCWFTemplate.MDFieldTaskDisplaySave.click();*/
		  
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SCWFTemplate.ManageMetadaDatalink);
		  
		  
//		  for(WebElement AMDN : SCWFTemplate.MD_namesExtract) 
//		  {
//			  
//			  if(AMDN.getText().equalsIgnoreCase("title") || AMDN.getText().equalsIgnoreCase("trim size")||AMDN.getText().equalsIgnoreCase("3play id"))
//			  {
//				  Attachment_Md=AMDN.getText();
//				  System.out.println("MD names"+ Attachment_Md);
//				  SCWFTemplate.MD_ConfigurationDp.click();
//				  SCWFTemplate.MD_ConfigurationDp.sendKeys("mandatory");
//				  SCWFTemplate.MD_ConfigurationDp.click();
//				  
//			  
//				 
//			  }
//		  }
		  
		  SCWFTemplate.ExportFileName.sendKeys("Auto-File Name");
		  
	
		  for(WebElement ExportMD : SCWFTemplate.ExportMDList) 
		  {
			  
			  if(ExportMD.getText().equalsIgnoreCase("title") || ExportMD.getText().equalsIgnoreCase("author(s)")||ExportMD.getText().equalsIgnoreCase("colors to use"))
			  {
			  
				  ExportMD.click(); 
			  }
		  }

		  SCWFTemplate.ExportMDRightMove.click();
		  SCWFTemplate.SaveTaskBtn.click();
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   
		   
		  //@nd task adding
//		  SCWFTemplate.AddTaskLink.click();
//		  SCWFTemplate.TaskTypeDP.click();
//		  SCWFTemplate.TaskTypeDP.sendKeys("Animation");
//			SCWFTemplate.TaskTypeDP.sendKeys(Keys.ENTER);
//			
//			Thread.sleep(3000);
//			SCWFTemplate.TaskDP.click();
//			SCWFTemplate.TaskDP.sendKeys("TaskName2");
//			SCWFTemplate.TaskDP.sendKeys(Keys.ENTER);
//			
//			SCWFTemplate.TaskDuration.click();
//			Thread.sleep(3000);
//		  SCWFTemplate.ReviewRequiredNo.click();
//		  SCWFTemplate.MandatoryTaskNo.click();
//		  SCWFTemplate.AllowStartDateLockNo.click();
//		  SCWFTemplate.AllowEndDateLockNo.click();
//		  SCWFTemplate.MilestoneTaskNo.click();
//		  SCWFTemplate.BillableTaskNo.click();
//		  SCWFTemplate.InvokeSystemNo.click();
//		 // js.executeScript("window.scrollBy(0,350)", "");
//		 // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SCWFTemplate.ExportFileName);
//		  SCWFTemplate.SaveTaskBtn.click();
//		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		  SCWFTemplate.UDSCheck.click();
	  
		  
		  
	}
	
	 public void MilestoneWFT() throws InterruptedException {
		  
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
		 SCWFTemplate.ReviewRequiredNo.click();
		 SCWFTemplate.MandatoryTaskNo.click();
		 SCWFTemplate.AllowStartDateLockNo.click();
		 SCWFTemplate.AllowEndDateLockNo.click();
		 SCWFTemplate.MilestoneTaskNo.click();
		 SCWFTemplate.MilestoneTaskYes.click();
		 SCWFTemplate.MilestoneManagementDp.click();
		 SCWFTemplate.MilestoneManagementRespoSellectAll.click();  //Just to make sure if task is alrdy configured with milestone, then repo's will be present so to uncheck those we peromoing it
		 SCWFTemplate.MilestoneManagementRespoSellectAll.click(); // It wil un select all the repo's
		 SCWFTemplate.MilestoneTaskYes.click(); //To get the validation
		  
		 // System.out.println("Validation msg  :"+SCWFTemplate.MilestoneManagementValidation.getText());
		  
		  assertEquals(SCWFTemplate.MilestoneManagementValidation.getText(), "Milestone management is required.");
		 
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SCWFTemplate.AllowEndDateLockNo);
		  SCWFTemplate.MilestoneManagementDp.click(); //To open the pop up
		  
		  
		  for(WebElement MSM : SCWFTemplate.MilestoneManagementRespoList) 
		  {
			  if(MSM.getText().equalsIgnoreCase("Animator") || MSM.getText().equalsIgnoreCase("Designer")||MSM.getText().equalsIgnoreCase("qc Team"))
			  {
			  
				  MSM.click(); 
			  }
		  }
		  
		  SCWFTemplate.MilestoneManagementDp.click(); // To close the Pop up
		  
		  SCWFTemplate.MilestoneUpdateRecipientsDP.click();
		  
		  for(WebElement MSUR : SCWFTemplate.MilestoneUpdateRespoList)
		  {
			  if(MSUR.getText().equalsIgnoreCase("Animator") || MSUR.getText().equalsIgnoreCase("Designer")||MSUR.getText().equalsIgnoreCase("qc Team"))
			  {
			  
				  MSUR.click(); 
			  }
		  }
		  SCWFTemplate.MilestoneUpdateRecipientsDP.click();
		  
		  SCWFTemplate.MilestoneBreachDp.click();
		  for(WebElement MSBR : SCWFTemplate.MilestoneBreachRespoList)
		  {
			  if(MSBR.getText().equalsIgnoreCase("Animator") || MSBR.getText().equalsIgnoreCase("Designer")||MSBR.getText().equalsIgnoreCase("qc Team"))
			  {
			  
				  MSBR.click(); 
			  }
		  }
		  SCWFTemplate.MilestoneBreachDp.click();
		  
		  SCWFTemplate.BillableTaskNo.click();
		  SCWFTemplate.InvokeSystemNo.click();
			 // js.executeScript("window.scrollBy(0,350)", "");
			 // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SCWFTemplate.ExportFileName);
			  SCWFTemplate.SaveTaskBtn.click();
		 
	  }
	  
	
	 public void Task2Adding() throws InterruptedException {
		  SCWFTemplate.AddTaskLink.click();
		  SCWFTemplate.TaskTypeDP.click();
		  SCWFTemplate.TaskTypeDP.sendKeys("Animation");
			SCWFTemplate.TaskTypeDP.sendKeys(Keys.ENTER);
			
			Thread.sleep(3000);
			SCWFTemplate.TaskDP.click();
			SCWFTemplate.TaskDP.sendKeys(TaskName2);
			SCWFTemplate.TaskDP.sendKeys(Keys.ENTER);
			
			SCWFTemplate.TaskDuration.click();
			Thread.sleep(3000);
			
			SCWFTemplate.TaskResponsibilityDp.click();
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SCWFTemplate.TaskDuration);
			
			SCWFTemplate.TaskRespoSelectall.click();//at first click all respo's will get select.
			SCWFTemplate.TaskRespoSelectall.click(); // at second click all respo's get unselect.
		
			  for(WebElement opt : SCWFTemplate.TaskRespoList) 
			  {
			 // System.out.println("Task respo Name : "+opt.getText());
			  
			  if(opt.getText().equals("Circulation")) 
				  {
				  System.out.println("Task Name : "+opt.getText());
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
		 // SCWFTemplate.ExportFileName.click();
		  //SCWFTemplate.ExportMDRightMove.click();
		 // js.executeScript("window.scrollBy(0,350)", "");
		 // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SCWFTemplate.ExportFileName);
		  SCWFTemplate.SaveTaskBtn.click();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  SCWFTemplate.UDSCheck.click();
	 }
	
	
	public void FinalsaveWFT() {
		 SCWFTemplate.SaveWFTBtn.click();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		 wait.until(ExpectedConditions.visibilityOf(WFTSuccessMsg));
		 System.out.println("Success msg :"+SCWFTemplate.WFTSuccessMsg.getText());
		Assert.assertEquals(SCWFTemplate.WFTSuccessMsg.getText(), "Workflow template Auto-"+Auto_WFTName+" created successfully.");
		
	}
	
	
	
	
	

}
	
