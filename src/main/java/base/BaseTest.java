package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import utils.ExtentReportManager;
import utils.Log;

public class BaseTest {
	
	protected WebDriver driver;
	protected static ExtentReports extent;
	protected ExtentTest test;
	
	@BeforeSuite
	public void setupreport() {
		
		extent =ExtentReportManager.getReportInstance();
	}
	@AfterSuite
	public void teardonReport() {
		extent.flush();
	}
	
	@BeforeMethod
	public void setup() {
		Log.info("Staring Webdriver");
	driver = new ChromeDriver();
	driver .manage().window().maximize();
	
	Log.info("Navigating to URL .......");
	driver.get("https://admin-demo.nopcommerce.com/login");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			String screenshotPath=ExtentReportManager.captureScreenshot(driver,"LoginFailure");
			System.out.println("Screenshot Captures, PATH:"+screenshotPath);
			test.fail("Test Failed. Screenshot attached" ,MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
		}
		
		
		
		if(driver!=null) {
			
			Log.info("Closing the browser....");
			driver.quit();
		}
	}

}
