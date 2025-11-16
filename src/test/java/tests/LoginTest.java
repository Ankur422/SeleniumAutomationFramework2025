package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.Log;

public class LoginTest extends BaseTest {
	
	@Test 
	public void testvalidLogin() {
		
		Log.info("Starting login test...");
		LoginPage loginPage =new LoginPage(driver);
		
		loginPage.enterusername("admin@yourstore.com");
		loginPage.enterpassword("admin");
		loginPage.submit();
		
	String title=	driver.getTitle();
	System.out.println(title);
	Log.info("Verfying ...");
	Assert.assertEquals(driver.getTitle(), "Just a moment...");
		
		
	}
	
	

}
