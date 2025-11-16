package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test 
	public void testvalidLogin() {
		
		LoginPage loginPage =new LoginPage(driver);
		
		loginPage.enterusername("admin@yourstore.com");
		loginPage.enterpassword("admin");
		loginPage.submit();
		
	String title=	driver.getTitle();
	System.out.println(title);
	Assert.assertEquals(driver.getTitle(), "Just a moment...");
		
		
	}
	
	

}
