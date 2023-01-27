package central.PageObject;

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


public class SCMDGroup extends CommonClass
{
	WebDriver ldriver;
	public SCMDGroup(WebDriver driver)
	{
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//a[contains(text(),'Metadata dashboard')]" )public static WebElement MetadataDashboard;
	@FindBy(xpath="//span[@class='links-04']")public static WebElement CreateMDGGrouplink;
	@FindBy(xpath = "//input[@id='txtmetadatagroupname']") public static WebElement Mdgroupname;
	@FindBy(xpath= "//div[@id=\"MDMaxlength\"]")public static WebElement Mdgnameval;
	@FindBy(xpath = "//textarea[@id=\"txtDescriptionMDG\"]" ) public static WebElement MdgDescription;
	@FindBy(xpath = "//input[@id=\"MetadataFieldSearch\"]")public static WebElement Mdfieldsearch;
	@FindBy(xpath="//td[@class=\" col-md-10 clswhitespace\"]" ) public static WebElement MdfieldsearchandSelect;
	@FindBy(xpath ="//td[normalize-space()=\"%C&A of First Review (Import: PE)\"]")public static WebElement Mdfield2select;
	@FindBy(xpath="//td[normalize-space()=\"3Play ID\"]")public static WebElement Mdfield3select;
	@FindBy(xpath = "//td[normalize-space()=\"Academic Level\"]") public static WebElement Mdfield4select;
	@FindBy(xpath="//td[normalize-space()=\"Access ID\"]")public static WebElement Mdfield5select;	
	@FindBy(xpath="//td[normalize-space()=\"Abbreviated Video Project Title\"]")public static WebElement Mdfield6select;
	@FindBy(xpath="//td[normalize-space()=\"Actual Collection Go-Live Date\"]")public static WebElement Mdfield7select;
	@FindBy(xpath="//td[normalize-space()=\"Acknowledge Reviewers\"]")public static WebElement Mdfield8select;
	@FindBy(xpath="//button[@id=\"RightMove\"]")public static WebElement Selectpostmdselect;
	@FindBy(xpath="//td[@class=\" col-md-10\"]")public static WebElement MDfieldselectfromselectedMDfields;
	@FindBy(xpath="//button[@id=\"LeftMove\"]")public static WebElement MDfieldsMoveback;
	@FindBy(xpath="//button[@id=\"SaveMDG\"]")public static WebElement SaveMdg;
	@FindBy(xpath="//p[@id=\"metadatadashboardmsgs\"]")public static WebElement SuccesmessageMDG;
	@FindBy(xpath="//div[@id=\"msgMetaDataEditSuccess\"]")public static WebElement EditedSucessMDG;
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/section[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[1]")public static WebElement IDsortclick;
	@FindBy(xpath="//body[1]/div[1]/div[2]/section[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]")public static WebElement EditcreatedMDG;
	public static Faker faker = new Faker();
	public static String MDGname = faker.name().name();
	public static String MDN =  "Auto-MDG-" + MDGname;
	

	
	public void CreateMDG() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	//	driver.findElement(MetadataDashboard).click();
		MetadataDashboard.click();
		Thread.sleep(5000);
		CreateMDGGrouplink.click();
		Mdgroupname.sendKeys(MDN);
		Mdgroupname.clear();
		Mdgnameval.isDisplayed();
		Mdgroupname.sendKeys(MDN);
		MdgDescription.sendKeys("This is the new metadata group created by automation ");
		Mdfieldsearch.sendKeys("3Play Account");
		wait.until(ExpectedConditions.elementToBeClickable(MdfieldsearchandSelect)).click();
		Selectpostmdselect.click();
		Mdfieldsearch.clear();
		wait.until(ExpectedConditions.elementToBeClickable(Mdfieldsearch)).clear();
		Mdfieldsearch.sendKeys(Keys.BACK_SPACE);
		MdfieldsearchandSelect.click();
		Mdfield2select.click();
		Mdfield3select.click();
		Mdfield4select.click();
		Mdfield5select.click();
		Mdfield6select.click();
		wait.until(ExpectedConditions.elementToBeClickable(Selectpostmdselect)).click();
		MDfieldselectfromselectedMDfields.click();
		MDfieldsMoveback.click();
		SaveMdg.click();
		SuccesmessageMDG.isDisplayed();
		
	}
		public void EditMDG() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(IDsortclick)).click();
			IDsortclick.click();
			wait.until(ExpectedConditions.elementToBeClickable(EditcreatedMDG)).click();
			MdgDescription.clear();
			MdgDescription.sendKeys("\"This is the new metadata group created by automation and edited by automation as well \"");
			Mdfieldsearch.sendKeys("Accounting Reference Code");
			wait.until(ExpectedConditions.elementToBeClickable(MdfieldsearchandSelect)).click();
			Mdfieldsearch.clear();
			wait.until(ExpectedConditions.elementToBeClickable(Mdfieldsearch)).clear();
			Mdfieldsearch.sendKeys(Keys.BACK_SPACE);
			Mdfield7select.click();
			Mdfield8select.click();
			wait.until(ExpectedConditions.elementToBeClickable(Selectpostmdselect)).click();
			MDfieldselectfromselectedMDfields.click();
			MDfieldsMoveback.click();
			SaveMdg.click();
			System.out.println(EditedSucessMDG.isDisplayed());
			driver.getCurrentUrl().equals("https://butterflytest.sagepub.com/Metadata/Index/?ActiveTab=MetadataGroupsInfo");
 
        

	}
}
