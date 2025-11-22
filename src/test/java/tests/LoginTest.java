package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {
	
	@Test 
	public void testvalidLogin() {
		
		Log.info("Starting login test...");
		test =ExtentReportManager.createTest("Login Test");
		LoginPage loginPage =new LoginPage(driver);
		
		test.info("Navigating to URL");
		loginPage.enterusername("admin@yourstore.com");
		loginPage.enterpassword("admin");
		loginPage.submit();
		
	String title=	driver.getTitle();
	System.out.println(title);
	
	
	Log.info("Verfying ...");
	Assert.assertEquals(driver.getTitle(), "Just a moment...");
		
		
	}
	
@Test	
public void testLoginwithIvalidCredentials() {
		
		Log.info("Starting login test...");
		test =ExtentReportManager.createTest("Login Test with Invalid credentials");
		LoginPage loginPage =new LoginPage(driver);
		
		test.info("Navigating to URL");
		loginPage.enterusername("admin23@yourstore.com");
		loginPage.enterpassword("admin778");
		loginPage.submit();
		
	String title=	driver.getTitle();
	System.out.println(title);
	
	
	Log.info("Verfying ...");
	Assert.assertEquals(driver.getTitle(), "Just a moment...789");
		
		
	}
	
	

}
