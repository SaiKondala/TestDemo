package central.PageObject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.github.javafaker.Faker;
import central.TestCases.CommonClass;


public class SCTaskTemplate extends CommonClass
{
	WebDriver driver;
//	ExtentTest test;
	
	public SCTaskTemplate( WebDriver driver) //, ExtentTest test)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
//		this.test = test;
	}
	@FindBy(xpath = "//a[@href='/Task/GetMasterTaskList']")
	public WebElement tasksdashboard;
	
	@FindBy(xpath = "//span[text()='Create a new task']")
	public WebElement createtask;
	
	@FindBy(id = "TaskName")
	public WebElement taskname;
	
	@FindBy(xpath = "//span[@class='slider round']")
	public WebElement status;
	
	// @FindBy(className = "k-radio radio-inline IsMandatoryTaskYes") public
	// WebElement mandatorytaskYes;
	// @FindBy(className="k-radio radio-inline IsMandatoryTaskNo") public WebElement
	// mandatorytaskNo;
	@FindBy(xpath = "/html/body/div[1]/div[2]/section/form/div[2]/div[2]/div[4]/div[2]/div[1]/input")
	public WebElement milestonetaskYes;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/section/form/div[2]/div[2]/div[4]/div[2]/div[2]/input")
	public WebElement milestonetaskNo;
	
	@FindBy(xpath = "//*[@id=\"ms-list-2\"]/button/span")
	public WebElement milestonemanagement;
	
	@FindBy(xpath = "//*[@id=\"ms-list-2\"]/div/div/input")
	public WebElement milestonemanagementsearch;
	
	@FindBy(xpath = "//*[@title='Acquiring Editor']")
	public WebElement selectAE;
	
	@FindBy(xpath = "//*[@id=\"RequiredDays\"]")
	public WebElement duration;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/section/form/div[2]/div[2]/div[7]/div[2]/span[1]/span/span[2]")
	public WebElement tasktype;
	
	@FindBy(css = "#TaskType_listbox > li:nth-child(1)")
	public WebElement tastypeanimation;
	
	@FindBy(xpath = "//*[@id=\"ms-list-1\"]/button/span")
	public WebElement taskresponsibility;
	
	@FindBy(xpath = "//*[@id=\"ms-list-1\"]/div/ul/li[1]/label/span")
	public WebElement tranimation;
	
	@FindBy(xpath = "//*[@id=\"createTaskForm\"]/div[2]/div[2]/div[17]/button[1]")
	public WebElement savetask;
	
	@FindBy(xpath = "//*[@id=\"TaskSuccessMsg\"]")
	public WebElement successmsg;
	// newly added locator for edit and clone task

	@FindBy(xpath = "//input[@id=\"ms-opt-2\"]")
	public WebElement trAnalyst;
	
	@FindBy(xpath = "//input[@id=\"ms-opt-3\"]")
	public WebElement trAnimator;
	
	@FindBy(xpath = "//*[@title='Analyst']")
	public WebElement select1AE;
	
	@FindBy(css = "#TaskType_listbox > li:nth-child(3)")
	public WebElement tastypeAssetBatch;
	
	@FindBy(css = "#TaskType_listbox > li:nth-child(2)")
	public WebElement tastypeAsset;
	
	@FindBy(xpath = "//th[@aria-label=\"ID : activate to sort column ascending\"]")
	public WebElement IDSort;
	
	@FindBy(xpath = "//button[normalize-space()=\"Save task\"]")
	public WebElement Updatesavetask;
	
	@FindBy(xpath = "//tbody/tr[1]/td[8]/a[2]")
	public WebElement editcreatedtask;
	
	@FindBy(xpath = "//div[@id=\"msgTaskEditSuccess\"]")
	public WebElement EditSuccessMsg;
	
	@FindBy(xpath = "//div[@id=\"msgTaskSuccess\"]")
	public WebElement ClonetaskSucmsg;
	
	@FindBy(xpath = "(//a[@title='Clone'])[1]")
	public WebElement Clonetask;
	
	@FindBy(xpath = "//div[@id=\"ms-list-3\"]//button[@type=\"button\"]")
	public WebElement MSUpdateRecipients;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/section[1]/form[1]/div[2]/div[2]/div[5]/div[2]/div[2]/div[1]/div[1]/ul[1]/li[1]/label[1]/input[1]")
	public WebElement MSupdaterespo;
	
	@FindBy(xpath = "//div[@id=\"ms-list-4\"]//button[@type=\"button\"]")
	public WebElement MSbreachrecipients;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/section[1]/form[1]/div[2]/div[2]/div[5]/div[3]/div[2]/div[1]/div[1]/ul[1]/li[2]/label[1]/input[1]")
	public WebElement MSBreachRespo;
	
	@FindBy(xpath = "//button[@id=\"cloneTask\"]")
	public WebElement Clonesavetask;

	public static Faker faker = new Faker();
	public static String TASKNAME = faker.name().lastName();
	public static String TK = TASKNAME + "-AuTask";
	public static String Smsg = "Task " + TK + " created successfully.";
	public static String EditSmsg = "Task " + TK + " updated successfully";
	public static String Clonetasksucvalmsg = "Task " + "CLONE-" + TK + " created successfully.";

	public void CreateEditCloneTask() throws InterruptedException, IOException 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		tasksdashboard.click();
		wait.until(ExpectedConditions.titleContains("Sage :: Tasks dashboard"));
		createtask.click();
		wait.until(ExpectedConditions.titleContains("Sage :: Create task"));
		taskname.sendKeys(TK);
		status.click();
		milestonetaskYes.click();
		milestonemanagement.click();
		Thread.sleep(2000);
		selectAE.click();
		milestonemanagement.click();
		duration.sendKeys("5");
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		Thread.sleep(2000);
		tasktype.click();
		Thread.sleep(2000);
		tastypeanimation.click();
		Thread.sleep(2000);
		taskresponsibility.click();
		Thread.sleep(2000);
		tranimation.click();
		taskresponsibility.click();
		wait.until(ExpectedConditions.elementToBeClickable(savetask)).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.textToBePresentInElement(successmsg, Smsg));

		// edit task
		Actions act = new Actions(driver);
		act.doubleClick(IDSort).perform();
		editcreatedtask.click();
		taskname.clear();
		taskname.sendKeys(TK);
		status.click();
		status.click();
//		mandatorytaskNo.click();
//		mandatorytaskYes.click();
		milestonetaskNo.click();
		milestonetaskYes.click();
		Thread.sleep(3000);
		milestonemanagement.click();
		wait.until(ExpectedConditions.elementToBeClickable(select1AE)).click();
		milestonemanagement.click();
		duration.clear();
		duration.sendKeys("6");
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		Thread.sleep(2000);
		tasktype.click();
		Thread.sleep(3000);
		tastypeAssetBatch.click();
		Thread.sleep(2000);
		taskresponsibility.click();
		wait.until(ExpectedConditions.elementToBeClickable(trAnalyst)).click();
		taskresponsibility.click();
		wait.until(ExpectedConditions.elementToBeClickable(Updatesavetask)).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.textToBePresentInElement(EditSuccessMsg, EditSmsg));

//clone task

		tasksdashboard.click();
		act.doubleClick(IDSort).perform();
		Clonetask.click();
		milestonetaskNo.click();
		milestonetaskYes.click();
		Thread.sleep(3000);
		MSUpdateRecipients.click();
		MSupdaterespo.click();
		MSUpdateRecipients.click();
		Thread.sleep(3000);
		MSbreachrecipients.click();
		MSBreachRespo.click();
		MSbreachrecipients.click();
		duration.clear();
		duration.sendKeys("5");
		((JavascriptExecutor) driver).executeScript("scroll(0,600)");
		Thread.sleep(2000);
		tasktype.click();
		Thread.sleep(3000);
		tastypeAsset.click();
		Thread.sleep(2000);
		taskresponsibility.click();
		wait.until(ExpectedConditions.elementToBeClickable(trAnimator)).click();
		taskresponsibility.click();
		Clonesavetask.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.textToBePresentInElement(ClonetaskSucmsg, Clonetasksucvalmsg));

	}
}
