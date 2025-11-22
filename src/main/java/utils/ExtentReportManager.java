package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
	private static ExtentReports extent;
	private static  ExtentTest test;
	
	public static ExtentReports getReportInstance() {
		
		if(extent==null) {
			String timestamp =new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
			String reportPath="reports/ExtentReport_"+timestamp+".html";
			ExtentSparkReporter reporter =new ExtentSparkReporter(reportPath);
			reporter.config().setDocumentTitle("Automation test report");
			reporter.config().setReportName("test execution report");
			
			extent =new ExtentReports();
			extent.attachReporter(reporter);
			
			
		}
		
		
		return extent;
	}
	public static ExtentTest createTest(String testName) {
		
		test=getReportInstance().createTest(testName);
		return test;
	}
	
public static String captureScreenshot(WebDriver driver, String screenshotName) {
	
	try {
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/screenshots/"+screenshotName+".png";
		FileUtils.copyFile(src,new File(path));
		return path;
		
	}
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		return null;
	}
	
}
}
