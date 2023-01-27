package central.TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import central.Utilities.Readconfig;
import io.github.bonigarcia.wdm.WebDriverManager;



public class CommonClass 
{
	Readconfig RC = new Readconfig();
	public String baseurl = RC.getapplicationURL();
	public String username = RC.getusername();
	public String password = RC.getpassword();
	public WebDriver driver;
	
//	public ExtentReports extent = new ExtentReports();
//    ExtentSparkReporter spark = new ExtentSparkReporter("Reports//SCReport.html");
	
	@Parameters("browser")
	@BeforeClass
	public void launchbrowser(String br) throws Exception
	{
//		ExtentTest test = extent.createTest("Hitting the URL");
		if(br.equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
//			Thread.sleep(10000);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
		driver.get(baseurl);
		Thread.sleep(10000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		test.pass("entered url successfully");
		
	}
//	@BeforeSuite
//    public void reports() {
//
//        spark.config().setTheme(Theme.DARK);
//        spark.config().setDocumentTitle("Facebook Report");
//        spark.config().setDocumentTitle("Screen shot module");
//        extent.attachReporter(spark);
//	}
	
//	public String capturescreen(WebDriver driver, String TCname) throws IOException 
//	{
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + TCname + ".PNG");
//		FileUtils.copyFile(source, target);
//		System.out.println("Screenshot taken");
//		return target.getAbsolutePath();
//	}
	
	 public String takeScreenshot(String testName, WebDriver driver) throws IOException 
	 {
	        File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        String destinationFilePath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
	        FileUtils.copyFile(SourceFile,new File(destinationFilePath));
	        System.out.println("Screenshot taken");
	        return destinationFilePath;
	  }
	@AfterClass
	public void closebrowser()
	{
//		driver.quit();
//		extent.flush();
	}
	
	static ExtentReports extentReport;
	public static ExtentReports getExtentReport() {
	        
			String timestamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
			String repName = "SCRegressionReport" +timestamp+".html";
	        String extentReportPath = System.getProperty("user.dir")+"\\reports\\"+repName;
	        ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);                // Create Object of ExtentSparkReporter and provide the path where you want to generate the report 

	        reporter.config().setReportName("Regression Pack");
	        reporter.config().setDocumentTitle("Sc Automation Report");
	        
	        extentReport = new ExtentReports(); 		            // Create object of ExtentReports class- This is main class which will create report
	        extentReport.attachReporter(reporter);					// attach the reporter which we created in above step
	        extentReport.setSystemInfo("Tested By","YBVN");
	        
	        return extentReport;
	        
	    }
	
	public String date()
	{
		Random rand = new Random();
		int randValue = rand.nextInt(10);
		System.out.println(randValue);
	    
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, randValue);						//instead of value 10 we can pass variable "randValue" to use random value generated
		c.add(Calendar.MONTH, 2);
		c.add(Calendar.YEAR, 1);
		Date d = c.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-YYYY");
		String dateString = sdf.format(d);
		return dateString;
	}
	
	public void accountsdashboard()
	{
		driver.findElement(By.xpath("//a[@href='/User/Index']")).click();
	}
}