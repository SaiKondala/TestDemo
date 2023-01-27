package central.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import central.TestCases.CommonClass;

public class ExtentListener extends CommonClass implements ITestListener {
	
//	public WebDriver driver;
	 private static final String BROWSER = "browser";
	
	ExtentReports extentReport = CommonClass.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();

	

	public void onTestStart(ITestResult result) {
		
		String testMethodName= result.getName();
		extentTest = extentReport.createTest(testMethodName);
		extentTestThread.set(extentTest);
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String testMethodName= result.getName();
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			extentTestThread.get().log(Status.PASS,testMethodName+" Test Passed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String screenshotFilePath1=takeScreenshot(testMethodName,driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath1, testMethodName);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public void onTestFailure(ITestResult result) {
		
		//extentTest.fail(result.getThrowable());
		extentTestThread.get().fail(result.getThrowable());
		
		String testMethodName=result.getName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String screenshotFilePath1=takeScreenshot(testMethodName,driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath1, testMethodName);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
		extentReport.flush();
		
	}
	
	

}
