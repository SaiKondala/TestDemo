package central.PageObject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import central.TestCases.CommonClass;

public class SCWSInstance extends CommonClass {
//	WebDriver driver;
//	ExtentTest test;

	public SCWSInstance(WebDriver driver) // , ExtentTest test)
	{
		
		this.driver = driver;
//		this.test = test;
		PageFactory.initElements(driver, this);
	}

	public static Faker faker = new Faker();
	public static String WSIname = faker.numerify("Auto-####-WSI");
	//public static String WSInstancename = "Auto-WSI-" + WSIname;
	public String WSISucmsg = "Workspace" + WSIname + "created successfully.";

	@FindBy(xpath = "(//a[@href='/WorkflowEnduser'])[1]")
	public static WebElement WorkflowEndUserDashboard;
	@FindBy(xpath = "//span[@class=\"links-04 \"]")
	public static WebElement CreateNewWsi;
	@FindBy(xpath = "//input[@id=\"WSinstanceName\"]")
	public static WebElement WsiName;
	@FindBy(xpath = "//span[@class=\"text-danger errmsgWSinstanceName\"]")
	public static WebElement WSIValmsg;
	@FindBy(xpath = "//input[@id=\"WSinstanceDesc\"]")
	public static WebElement WsiDesc;
	@FindBy(xpath = "//span[@class=\"mainslider round\"]")
	public static WebElement Wsiactivate;
	@FindBy(xpath = "//select[@id=\"DrpWorkspaceTemplate\"]")
	public static WebElement WSTSelect;
	@FindBy(xpath = "//button[@id=\"btnSaveWSInstance\"]")
	public static WebElement WSISave;
	@FindBy(xpath = "//*[@id=\"workspaceworkitemdashboardmsgs\"]")
	public static WebElement WSIsucmsgdisplay;

	public void CreateWSIForValidations() throws InterruptedException, IOException

	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WorkflowEndUserDashboard.click();
		CreateNewWsi.click();
		WsiName.sendKeys(WSIname);
		WsiDesc.sendKeys("Created WSI by using automation");
		Wsiactivate.click();
		WSTSelect.click();
		WSTSelect.sendKeys(SCWSTemplate.wsname2 + Keys.ENTER);
		WSISave.click();
		Thread.sleep(5000);;
		WSIsucmsgdisplay.isDisplayed();
		

	}

}
