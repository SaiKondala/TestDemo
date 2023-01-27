package central.PageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import central.PageObject.SCWFTemplate;

public class CWFCWIDependencyWFT extends SCWFTemplate {

	public CWFCWIDependencyWFT(WebDriver driver) {
		super(driver);

	}

	public String PredecessorCWFTName = "PredecessorWFAuto-1" + fake.name().firstName();
	public String SuccessorCWFTName = "SuccessorWFAuto-1" + fake.name().lastName();

	public String PredecessorCWIWFTTName = "PredecessorWIWFAuto-1" + fake.name().firstName();
	public String SuccessorCWIWFTName = "SuccessorWIWFAuto-1" + fake.name().lastName();

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));

	public void PredecessorCWFTemplateCreation1() throws InterruptedException, IOException {
		// First page

		SCWFTemplate.wftdashboard.click();
		SCWFTemplate.CreateWFTLink.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		SCWFTemplate.WFTName.sendKeys(PredecessorCWFTName);
		SCWFTemplate.WFTStatusToggle.click();
		Thread.sleep(3000);
		SCWFTemplate.Related_WST_DP.click();
		// Thread.sleep(3000);
		SCWFTemplate.Related_WST_SearchBox.sendKeys(Related_WST_Name2);
		// Thread.sleep(3000);
		SCWFTemplate.Related_WST_Selection.click();
		Thread.sleep(3000);
		SCWFTemplate.Related_WIT_DP.click();
		SCWFTemplate.Related_WIT_SearchBox.sendKeys(Reated_WIT_Name);
		SCWFTemplate.Related_WIT_Selection.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		SCWFTemplate.NWFT_NextButton.click();

		// Second Page

		// First Task Adding
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

		SCWFTemplate.TaskRespoSelectall.click(); // at first click all respo's will get select.
		SCWFTemplate.TaskRespoSelectall.click(); // at second click all respo's get unselect.

		for (WebElement opt : SCWFTemplate.TaskRespoList) {

			if (opt.getText().equals("Copyeditor")) {

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
		SCWFTemplate.SaveTaskBtn.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		// Second Task Adding

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

		SCWFTemplate.TaskRespoSelectall.click(); // at first click all respo's will get select.
		SCWFTemplate.TaskRespoSelectall.click(); // at second click all respo's get unselect.

		for (WebElement opt : SCWFTemplate.TaskRespoList) {

			if (opt.getText().equals("Digital Content Editor")) {

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
		AddRelatedTaskLink.click();
		Thread.sleep(2000);
		TaskrelationDP.click();
		TaskrelationDP.sendKeys("finish" + Keys.ENTER);

		TaskNamerelationDP.click();
		TaskNamerelationDP.sendKeys(TaskName1 + Keys.ENTER);
		Thread.sleep(2000);
		TaskDepSave.click();
		SCWFTemplate.SaveTaskBtn.click();
		SCWFTemplate.SaveWFTBtn.click();
		wait.until(ExpectedConditions.textToBePresentInElement(WFTSuccessMsg,
				"Workflow template " + PredecessorCWFTName + " created successfully."));

	}

	public void SuccessorCWFTemplateCreation2() throws Exception {
		// First page

		SCWFTemplate.wftdashboard.click();
		SCWFTemplate.CreateWFTLink.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		SCWFTemplate.WFTName.sendKeys(SuccessorCWFTName);
		SCWFTemplate.WFTStatusToggle.click();
		Thread.sleep(3000);
		SCWFTemplate.Related_WST_DP.click();
		// Thread.sleep(3000);
		SCWFTemplate.Related_WST_SearchBox.sendKeys(Related_WST_Name2);
		// Thread.sleep(3000);
		SCWFTemplate.Related_WST_Selection.click();
		Thread.sleep(3000);
		SCWFTemplate.Related_WIT_DP.click();
		SCWFTemplate.Related_WIT_SearchBox.sendKeys(Reated_WIT_Name);
		SCWFTemplate.Related_WIT_Selection.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		SCWFTemplate.NWFT_NextButton.click();

		// Second Page

		// First Task Adding
		SCWFTemplate.AddTaskLink.click();
		SCWFTemplate.TaskTypeDP.click();
		SCWFTemplate.TaskTypeDP.sendKeys("Animation");
		SCWFTemplate.TaskTypeDP.sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		SCWFTemplate.TaskDP.click();
		SCWFTemplate.TaskDP.sendKeys(TaskName3);
		SCWFTemplate.TaskDP.sendKeys(Keys.ENTER);

		SCWFTemplate.TaskDuration.click();
		Thread.sleep(3000);
		SCWFTemplate.TaskResponsibilityDp.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SCWFTemplate.TaskDuration);

		SCWFTemplate.TaskRespoSelectall.click(); // at first click all respo's will get select.
		SCWFTemplate.TaskRespoSelectall.click(); // at second click all respo's get unselect.

		for (WebElement opt : SCWFTemplate.TaskRespoList) {

			if (opt.getText().equals("Analyst")) {

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
		AddRelatedTaskLink.click();
		Thread.sleep(2000);
		TaskrelationDP.click();
		TaskrelationDP.sendKeys("finish" + Keys.ENTER);
		Thread.sleep(2000);

		WFTNamerelationDP.click();
		WFTNamerelationDP.sendKeys(PredecessorCWFTName + Keys.ENTER);
		Thread.sleep(2000);

		TaskNamerelationDP.click();
		TaskNamerelationDP.sendKeys(TaskName1 + Keys.ENTER);
		Thread.sleep(2000);
		TaskDepSave.click();
		SCWFTemplate.SaveTaskBtn.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		// Second task

		SCWFTemplate.AddTaskLink.click();
		SCWFTemplate.TaskTypeDP.click();
		SCWFTemplate.TaskTypeDP.sendKeys("Animation");
		SCWFTemplate.TaskTypeDP.sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		SCWFTemplate.TaskDP.click();
		SCWFTemplate.TaskDP.sendKeys(TaskName4);
		SCWFTemplate.TaskDP.sendKeys(Keys.ENTER);

		SCWFTemplate.TaskDuration.click();
		Thread.sleep(3000);
		SCWFTemplate.TaskResponsibilityDp.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SCWFTemplate.TaskDuration);

		SCWFTemplate.TaskRespoSelectall.click(); // at first click all respo's will get select.
		SCWFTemplate.TaskRespoSelectall.click(); // at second click all respo's get unselect.

		for (WebElement opt : SCWFTemplate.TaskRespoList) {

			if (opt.getText().equals("Digital Content Editor")) {

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
		AddRelatedTaskLink.click();
		Thread.sleep(2000);
		TaskrelationDP.click();
		TaskrelationDP.sendKeys("finish" + Keys.ENTER);

		TaskNamerelationDP.click();
		TaskNamerelationDP.sendKeys(TaskName3 + Keys.ENTER);
		Thread.sleep(2000);
		TaskDepSave.click();
		SCWFTemplate.SaveTaskBtn.click();
		SCWFTemplate.SaveWFTBtn.click();
		wait.until(ExpectedConditions.textToBePresentInElement(WFTSuccessMsg,
				"Workflow template " + SuccessorCWFTName + " created successfully."));

	}

	public void PredecessorCWIWFTemplateCreation1() throws InterruptedException, IOException {
		// First page

		SCWFTemplate.wftdashboard.click();
		SCWFTemplate.CreateWFTLink.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		SCWFTemplate.WFTName.sendKeys(PredecessorCWIWFTTName);
		SCWFTemplate.WFTStatusToggle.click();
		Thread.sleep(3000);
		SCWFTemplate.Related_WST_DP.click();
		// Thread.sleep(3000);
		SCWFTemplate.Related_WST_SearchBox.sendKeys(Related_WST_Name2);
		// Thread.sleep(3000);
		SCWFTemplate.Related_WST_Selection.click();
		Thread.sleep(3000);
		SCWFTemplate.Related_WIT_DP.click();
		SCWFTemplate.Related_WIT_SearchBox.sendKeys(Reated_WIT_Name);
		SCWFTemplate.Related_WIT_Selection.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		SCWFTemplate.NWFT_NextButton.click();

		// Second Page

		// First Task Adding
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

		SCWFTemplate.TaskRespoSelectall.click(); // at first click all respo's will get select.
		SCWFTemplate.TaskRespoSelectall.click(); // at second click all respo's get unselect.

		for (WebElement opt : SCWFTemplate.TaskRespoList) {

			if (opt.getText().equals("Copyeditor")) {

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
		SCWFTemplate.SaveTaskBtn.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		// Second Task Adding

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

		SCWFTemplate.TaskRespoSelectall.click(); // at first click all respo's will get select.
		SCWFTemplate.TaskRespoSelectall.click(); // at second click all respo's get unselect.

		for (WebElement opt : SCWFTemplate.TaskRespoList) {

			if (opt.getText().equals("Digital Content Editor")) {

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
		AddRelatedTaskLink.click();
		Thread.sleep(2000);
		TaskrelationDP.click();
		TaskrelationDP.sendKeys("finish" + Keys.ENTER);

		TaskNamerelationDP.click();
		TaskNamerelationDP.sendKeys(TaskName1 + Keys.ENTER);
		Thread.sleep(2000);
		TaskDepSave.click();
		SCWFTemplate.SaveTaskBtn.click();
		SCWFTemplate.SaveWFTBtn.click();
		wait.until(ExpectedConditions.textToBePresentInElement(WFTSuccessMsg,
				"Workflow template " + PredecessorCWIWFTTName + " created successfully."));

	}

	public void SuccessorCWIWFTemplateCreation2() throws Exception {
		// First page

		SCWFTemplate.wftdashboard.click();
		SCWFTemplate.CreateWFTLink.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		SCWFTemplate.WFTName.sendKeys(SuccessorCWIWFTName);
		SCWFTemplate.WFTStatusToggle.click();
		Thread.sleep(3000);
		SCWFTemplate.Related_WST_DP.click();
		// Thread.sleep(3000);
		SCWFTemplate.Related_WST_SearchBox.sendKeys(Related_WST_Name2);
		// Thread.sleep(3000);
		SCWFTemplate.Related_WST_Selection.click();
		Thread.sleep(3000);
		SCWFTemplate.Related_WIT_DP.click();
		SCWFTemplate.Related_WIT_SearchBox.sendKeys(Related_WIT_Name2);
		SCWFTemplate.Related_WIT_Selection.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		SCWFTemplate.NWFT_NextButton.click();

		// Second Page

		// First Task Adding
		SCWFTemplate.AddTaskLink.click();
		SCWFTemplate.TaskTypeDP.click();
		SCWFTemplate.TaskTypeDP.sendKeys("Animation");
		SCWFTemplate.TaskTypeDP.sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		SCWFTemplate.TaskDP.click();
		SCWFTemplate.TaskDP.sendKeys(TaskName3);
		SCWFTemplate.TaskDP.sendKeys(Keys.ENTER);

		SCWFTemplate.TaskDuration.click();
		Thread.sleep(3000);
		SCWFTemplate.TaskResponsibilityDp.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SCWFTemplate.TaskDuration);

		SCWFTemplate.TaskRespoSelectall.click(); // at first click all respo's will get select.
		SCWFTemplate.TaskRespoSelectall.click(); // at second click all respo's get unselect.

		for (WebElement opt : SCWFTemplate.TaskRespoList) {

			if (opt.getText().equals("Analyst")) {

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
		AddRelatedTaskLink.click();
		Thread.sleep(2000);
		TaskrelationDP.click();
		TaskrelationDP.sendKeys("finish" + Keys.ENTER);
		Thread.sleep(2000);

		WITNamerelationDP.click();
		WITNamerelationDP.sendKeys(Reated_WIT_Name + Keys.ENTER);
		Thread.sleep(2000);

		WFTNamerelationDP.click();
		WFTNamerelationDP.sendKeys(PredecessorCWIWFTTName + Keys.ENTER);
		Thread.sleep(2000);

		TaskNamerelationDP.click();
		TaskNamerelationDP.sendKeys(TaskName1 + Keys.ENTER);
		Thread.sleep(2000);
		TaskDepSave.click();
		SCWFTemplate.SaveTaskBtn.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

		// Second task

		SCWFTemplate.AddTaskLink.click();
		SCWFTemplate.TaskTypeDP.click();
		SCWFTemplate.TaskTypeDP.sendKeys("Animation");
		SCWFTemplate.TaskTypeDP.sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		SCWFTemplate.TaskDP.click();
		SCWFTemplate.TaskDP.sendKeys(TaskName4);
		SCWFTemplate.TaskDP.sendKeys(Keys.ENTER);

		SCWFTemplate.TaskDuration.click();
		Thread.sleep(3000);
		SCWFTemplate.TaskResponsibilityDp.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SCWFTemplate.TaskDuration);

		SCWFTemplate.TaskRespoSelectall.click(); // at first click all respo's will get select.
		SCWFTemplate.TaskRespoSelectall.click(); // at second click all respo's get unselect.

		for (WebElement opt : SCWFTemplate.TaskRespoList) {

			if (opt.getText().equals("Digital Content Editor")) {

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
		AddRelatedTaskLink.click();
		Thread.sleep(2000);
		TaskrelationDP.click();
		TaskrelationDP.sendKeys("finish" + Keys.ENTER);

		TaskNamerelationDP.click();
		TaskNamerelationDP.sendKeys(TaskName3 + Keys.ENTER);
		Thread.sleep(2000);
		TaskDepSave.click();
		Thread.sleep(2000);
		SCWFTemplate.SaveTaskBtn.click();
		SCWFTemplate.SaveWFTBtn.click();
		wait.until(ExpectedConditions.textToBePresentInElement(WFTSuccessMsg,
				"Workflow template " + SuccessorCWIWFTName + " created successfully."));

	}
}
