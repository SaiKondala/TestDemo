package central.PageObject;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import central.TestCases.CommonClass;

public class SC_WFI_Validations extends CommonClass {
	WebDriver driver;
	
	public SC_WFI_Validations(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//a[@href='/WorkflowEnduser'])[1]")
	public static WebElement WorkflowEndUserDashboard1;
	
	@FindBy(xpath = "//span[text()='Create a new workflow']")
	public static WebElement CreateWFILink;
	
	@FindBy(id= "ddlwfTemplateList")
	public static WebElement WFTListDD;
	
	@FindBy(id= "btnWorkflowInstSave")   
	public static WebElement CreateWFIsavebtn;
	
	@FindBy(id="btnWorkflowInsteditSave")
	public static WebElement EditWFIsavebtn;
	
	@FindBy(id= "txtWorkflowSearchField")
	public static WebElement WFTSearchBox;
	
	@FindBy(xpath = "//a[@title='Edit']")
	public static WebElement WFTEditbtn;
	
	@FindBy(xpath= "//a[text()='Work item']")
	public static WebElement WITab;
	
	@FindBy(xpath="//table[@id=\"WorkitemViewgrid\"]/tfoot/tr/th[2]/input")
	public static WebElement WIISearchbox;
	
	@FindBy(xpath="//table[@id='WorkitemViewgrid']/tbody/tr/td[2]")
	public static WebElement WIInameConformationSearch;
	
	@FindBy(xpath="//a[@title='Workflows']")
	public static WebElement ViewWFslink;
	
	@FindBy(xpath="(//table[@id='WorkflowViewgrid']/tbody/tr/td[2]/span)[1]")
	public static WebElement WFInameConformationSearch;
	
	@FindBy(xpath="(//span[@class='mainslider round'])[1]")
	public static WebElement EditWFIDeactivatebtn;
	
	@FindBy(id="de-activated")
	public static WebElement Deactivationconformation;
	
	@FindBy(xpath="//table[@id='WorkflowViewgrid']/tbody/tr[*]/td[2]/span")
	public static List<WebElement> ViewWFs;
	
	//Gantt Chart
	
	@FindBy(xpath = "//*[@id='WorkflowGantt']//tr[1]/td[13]")
	public static  WebElement GanttCStatusDD;
	
	@FindBy(xpath = "//div[@class='col-md-12 text-center GanttErrorMsg text-danger hide']")
	public static WebElement GCNoResourceValidationmsg;
	
	//GC Edit Task
	
	@FindBy(xpath = "//*[@id='WorkflowGantt']//tr[1]/td[5]/span/a")
	public static WebElement EditTaskbtn;
	
	@FindBy(id="ddlWFITaskStatus")
	public static WebElement EdittaskStatusDD; 
	
	@FindBy(xpath = "//div[@class='col-md-12 text-center LightboxErrorMsg text-danger']")
	public static WebElement EditNoResourceValidationmsg;
	
	@FindBy(xpath = "//div[@class='col-md-12 text-center AssetMessage text-danger']")  
	public static WebElement EditAssetValidationmsg;  
	
	@FindBy(xpath = "//div[@class='col-md-12 text-center LightboxMetadataErrorMsg text-danger']")  
	public static WebElement EditMDValidationmsg;
	
	@FindBy(xpath = "//div[@class='col-md-12 text-center tastAttachmentMsgDiv text-danger']")  
	public static WebElement EditAttachmentValidationmsg;
	
	@FindBy(id ="btnTaskInfoCancel")
	public static WebElement EdittaskCancelbtn;
	
	@FindBy(id="btnWorkflowInstCancel")
	public static WebElement GCCancelbtn;
	
	@FindBy(id="btnMetadataCancel")
	public static WebElement MDTabCancelBtn;
	
	@FindBy(id="btnFileAttachmentsCancel")
	public static WebElement AttachmentTabCancelBtn;
	
	//Content Dashboard
	
	@FindBy(xpath ="//a[@href='/Dashboard']") 
	public static WebElement contentdashboard;
	
	@FindBy(xpath = "//div[@id='divmytasksinprogress']//a[@title='Work item title filter column settings']")
	public static WebElement CDWIIsearch;
	
	@FindBy(xpath = "//input[@title='Value']")
	public static WebElement CDWIIsearchbox;
	
	@FindBy(xpath ="//div[@id='divmytasksinprogress']//a[@class='MTViewWI']")
	public static WebElement SearchConformationwii;
	
	@FindBy(xpath ="//td[text()='In progress']")
	public static WebElement CDstatusDD;
	
	@FindBy(xpath ="//ul[starts-with(@id, 'drptaskstatus')]/li")
	public static List<WebElement> CDStatusDDlist;
	
	@FindBy(id="divtaskstatus")
	public static WebElement CDValidationmsg;
	
	//CD Edit Task
	
	@FindBy(xpath="//div[@id='divmytasksinprogress']//a[@class='k-button k-button-icontext k-grid-edit']")
	public static WebElement CDEdittask;
	
	@FindBy(id="btnMetadataCancel")
	public static WebElement CDCancelbtnMD;
	
	
	public void NoResourceV1() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		// In Create WFI screen
		
		WFTListDD.click();
		WFTListDD.sendKeys(SCNoResourceTaskV01.NoResourceTaskWFT + Keys.ENTER); 		
		wait.until(ExpectedConditions.visibilityOf(CreateWFIsavebtn));	
		wait.until(ExpectedConditions.elementToBeClickable(CreateWFIsavebtn)).click();
		
		//In View WFs Screen
		
		for(WebElement WFName: ViewWFs)
		{
			if(WFName.getText().contains("No Resource Assigned "))
			{
				WFName.click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Gantt chart Edit Task
		
		EditTaskbtn.click();
		wait.until(ExpectedConditions.visibilityOf(EdittaskStatusDD));
		EdittaskStatusDD.click();
		EdittaskStatusDD.sendKeys("Inprogress" + Keys.ENTER);
		wait.until(ExpectedConditions.textToBePresentInElement(EditNoResourceValidationmsg,
				"Task can not be set to In progress, with out resource"));
		EdittaskCancelbtn.click();
		GCCancelbtn.click();
	}
	
	public void AssetTaskV02() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));	
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		
		//In View WF screen
		
		CreateWFILink.click();
		
		//In Create WFI screen
		
		WFTListDD.click();
		WFTListDD.sendKeys(SCCreateAssetTaskV02.AssetTaskWFT + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(CreateWFIsavebtn));	
		wait.until(ExpectedConditions.elementToBeClickable(CreateWFIsavebtn)).click();
		
		//In View WF screen 
		
		for(WebElement WFName: ViewWFs)
		{
			if(WFName.getText().contains("Asset Task"))
			{
				WFName.click();
				break;
			}
		}
		Thread.sleep(2000);
		
		//Gantt chart Edit Task
		
		EditTaskbtn.click();
		wait.until(ExpectedConditions.visibilityOf(EdittaskStatusDD));
		EdittaskStatusDD.click();
		EdittaskStatusDD.sendKeys("Completed" + Keys.ENTER);
		wait.until(ExpectedConditions.textToBePresentInElement(EditAssetValidationmsg,
				"Asset is not yet present. Please create."));
		MDTabCancelBtn.click();

		//ContentDashboard
		
		contentdashboard.click();
		CDWIIsearch.click();
		CDWIIsearchbox.sendKeys(SCWIInstance.WIIname + Keys.ENTER);
		wait.until(ExpectedConditions.textToBePresentInElement(SearchConformationwii, SCWIInstance.WIIname));
		
		
		//ContentDashboard Check
		Actions act = new Actions(driver);        
        act.moveToElement(CDstatusDD).doubleClick().build().perform();
        Thread.sleep(2000);
        for(WebElement taskstatus: CDStatusDDlist)
        {
            System.out.println(taskstatus.getText());
            if(taskstatus.getText().equals("Completed"))
                taskstatus.click();
        }
		wait.until(ExpectedConditions.textToBePresentInElement(CDValidationmsg,
				"Asset is not yet present. Please create."));
		wait.until(ExpectedConditions.invisibilityOf(CDValidationmsg));
		
		//ContentDashboard Edit Task
		
		CDEdittask.click();
		wait.until(ExpectedConditions.visibilityOf(EdittaskStatusDD));
		EdittaskStatusDD.click();
		EdittaskStatusDD.sendKeys("Completed" + Keys.ENTER);
		wait.until(ExpectedConditions.textToBePresentInElement(EditAssetValidationmsg,
				"Asset is not yet present. Please create."));
		CDCancelbtnMD.click();
	}
	
	public void MandatoryMDValidation03() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		
		//Navigating to WII and view WFs screen
		
		SCWIInstance.WorkflowEndUserDashboard.click();
		WITab.click();
		WIISearchbox.sendKeys(SCWIInstance.WIIname);
		wait.until(ExpectedConditions.textToBePresentInElement(WIInameConformationSearch, SCWIInstance.WIIname));
		ViewWFslink.click();
		
		//Deactivating Previous WFI ( Asset WFI ) because of not getting confusing in the CD.
		
		for(WebElement WFName: ViewWFs)
		{
			if(WFName.getText().contains("Asset Task"))
			{
				WFName.click();
				break;
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(EditWFIDeactivatebtn)).click();
		wait.until(ExpectedConditions.textToBePresentInElement(Deactivationconformation,"De-activated"));
		EditWFIsavebtn.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(GCCancelbtn)).click();  
		
		//Creating WFI
		
		wait.until(ExpectedConditions.elementToBeClickable(CreateWFILink)).click();
		WFTListDD.click();
		WFTListDD.sendKeys(SCMandatoryMDTaskV03.MandatoryMDTaskWFT + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(CreateWFIsavebtn));	
		wait.until(ExpectedConditions.elementToBeClickable(CreateWFIsavebtn)).click();
		
		// In View WF screen
		Thread.sleep(5000);
		for(WebElement WFName2: ViewWFs)
		{	
			if(WFName2.getText().contains("MD mandatory"))
				{
				System.out.println(WFName2.getText());
				WFName2.click();
				break;
				}
		}
		Thread.sleep(5000);
		
		//Gantt chart Edit Task
		wait.until(ExpectedConditions.visibilityOf(EditTaskbtn));
		EditTaskbtn.click();
		wait.until(ExpectedConditions.visibilityOf(EdittaskStatusDD));
		EdittaskStatusDD.click();
		EdittaskStatusDD.sendKeys("Completed" + Keys.ENTER);
		Thread.sleep(2000);
		
		Assert.assertEquals(EditMDValidationmsg.getText(), "Please enter all required metadata fields.");
		MDTabCancelBtn.click();
		
		//ContentDashboard
		
		contentdashboard.click();
		CDWIIsearch.click();
		CDWIIsearchbox.sendKeys(SCWIInstance.WIIname + Keys.ENTER);
		wait.until(ExpectedConditions.textToBePresentInElement(SearchConformationwii, SCWIInstance.WIIname));
		
		//ContentDashboard Check
		Actions act = new Actions(driver);
		act.moveToElement(CDstatusDD).doubleClick().build().perform();
		Thread.sleep(2000);
		for (WebElement taskstatus : CDStatusDDlist) {
			System.out.println(taskstatus.getText());
			if (taskstatus.getText().equals("Completed"))
				taskstatus.click();
		}
		wait.until(ExpectedConditions.textToBePresentInElement(CDValidationmsg,
				"Please enter all required metadata fields."));
		wait.until(ExpectedConditions.invisibilityOf(CDValidationmsg));
		
		//ContentDashboard Edit Task
		
		CDEdittask.click();
		wait.until(ExpectedConditions.visibilityOf(EdittaskStatusDD));
		EdittaskStatusDD.click();
		EdittaskStatusDD.sendKeys("Completed" + Keys.ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.textToBePresentInElement(EditMDValidationmsg,
				"Please enter all required metadata fields."));
		CDCancelbtnMD.click();
	}
	
	public void MandatoryAttachmentValidation04() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		
		//Navigating to WII and view WFs screen
		
		SCWIInstance.WorkflowEndUserDashboard.click();
		WITab.click();
		WIISearchbox.sendKeys(SCWIInstance.WIIname);
		wait.until(ExpectedConditions.textToBePresentInElement(WIInameConformationSearch, SCWIInstance.WIIname));
		ViewWFslink.click();
		
		//Deactivating Previous WFI ( MD mandatory )
		
		for(WebElement WFName3: ViewWFs)
		{
			if(WFName3.getText().contains("MD mandatory"))
			{
				WFName3.click();
				break;
			}
		}
		wait.until(ExpectedConditions.elementToBeClickable(EditWFIDeactivatebtn)).click();
		wait.until(ExpectedConditions.textToBePresentInElement(Deactivationconformation,"De-activated"));
		EditWFIsavebtn.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(GCCancelbtn)).click();
		
		//Creating WFI
		
		wait.until(ExpectedConditions.elementToBeClickable(CreateWFILink)).click();
		WFTListDD.click();
		WFTListDD.sendKeys(SCMandatoryAttachmentV04.MandatoryAttachmentTaskWFT + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(CreateWFIsavebtn));	
		wait.until(ExpectedConditions.elementToBeClickable(CreateWFIsavebtn)).click();
		Thread.sleep(5000);
		
		//In View WF screen
		
		for(WebElement WFName3: ViewWFs)
		{
			if(WFName3.getText().contains("Attachment mandatory"))
			{
				WFName3.click();
				break;
			}
		}
		//Gantt chart Edit Task
		
		EditTaskbtn.click();
		wait.until(ExpectedConditions.visibilityOf(EdittaskStatusDD));
		EdittaskStatusDD.click();
		EdittaskStatusDD.sendKeys("Completed" + Keys.ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.textToBePresentInElement(EditAttachmentValidationmsg,
				"Please upload A/V Release to complete the task."));
		AttachmentTabCancelBtn.click();	
		
		//ContentDashboard
		
		contentdashboard.click();
		CDWIIsearch.click();
		CDWIIsearchbox.sendKeys(SCWIInstance.WIIname + Keys.ENTER);
		wait.until(ExpectedConditions.textToBePresentInElement(SearchConformationwii, SCWIInstance.WIIname));
		
		//ContentDashboard Check
		Actions act = new Actions(driver);
		act.moveToElement(CDstatusDD).doubleClick().build().perform();
		Thread.sleep(2000);
		for (WebElement taskstatus : CDStatusDDlist) {
			System.out.println(taskstatus.getText());
			if (taskstatus.getText().equals("Completed"))
				taskstatus.click();
		}
		wait.until(ExpectedConditions.textToBePresentInElement(CDValidationmsg,
				"Please upload A/V Release to complete the task."));
		wait.until(ExpectedConditions.invisibilityOf(CDValidationmsg));
		
		//ContentDashboard Edit Task
		
		CDEdittask.click();
		wait.until(ExpectedConditions.visibilityOf(EdittaskStatusDD));
		EdittaskStatusDD.click();
		EdittaskStatusDD.sendKeys("Completed" + Keys.ENTER);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.textToBePresentInElement(EditAttachmentValidationmsg, "Please upload A/V Release to complete the task."));
		AttachmentTabCancelBtn.click();
	}
}
