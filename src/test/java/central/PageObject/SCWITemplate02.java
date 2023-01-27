package central.PageObject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class SCWITemplate02 extends SCWITemplate
{
	public SCWITemplate02(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static Faker faker = new Faker();
	public static String WIT2 = faker.numerify("Auto-####-WIT2");
	public String SMWIT2= "Work item template " +WIT2+ " created successfully.";
	
	public void CreateWIT02() throws InterruptedException, IOException
	{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
			
			workspacedashboard.click();
			wait.until(ExpectedConditions.titleContains("Sage :: Workspace dashboard"));
		CreateWIT.click();
			wait.until(ExpectedConditions.titleContains("Sage :: Create work item template"));
		wit.sendKeys(WIT2);
		activate.click();
			((JavascriptExecutor)driver).executeScript("scroll(0,600)");
		attachmentbtn.click();
			Thread.sleep(3000);
		attachment1.click();
		attachment2.click();
		addbutton.click();
			Thread.sleep(3000);
		removebtn.click();
			Thread.sleep(3000);
		selectrespbtn1.click();
			Thread.sleep(3000);
		a1resp1.click();
		a1resp2.click();
			Thread.sleep(3000);
		finalsel.click();
			((JavascriptExecutor)driver).executeScript("scroll(0,500)");
		MDsearch.sendKeys("College - title");
			wait.until(ExpectedConditions.elementToBeClickable(selectMDG)).click();
		rightmove.click();
			((JavascriptExecutor)driver).executeScript("scroll(0,650)");
		savewit.click();	
			wait.until(ExpectedConditions.textToBePresentInElement(successmsg,SMWIT2));
	}

}
