package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.Log;

public class LoginTest extends BaseTest {
	
	@DataProvider(name="LoginData")
	public Object[][] getLoginData() throws IOException{
		
		String filePath =System.getProperty("user.dir")+"/testdata/TestData.xlsx";
		
		ExcelUtils.loadExcel(filePath, "Sheet1");
		int rowCount =ExcelUtils.getRowCount();
		
		Object[][] data= new Object[rowCount -1][2];
		for(int i=1;i<rowCount;i++) {
			
			data[i-1][0]=ExcelUtils.getCellData(i,0);
			data[i-1][1]=ExcelUtils.getCellData(i,1);
		}
		
		ExcelUtils.closeExcel();
		return data;
	}
	
	@DataProvider(name="LoginData2")
	public Object[][] getData(){
		
		return new Object[][] {
			{"user1","pass1"},
			{"user2","pass2"},
			{"admin","admin123"}
		};
	}
	
	//@Test(dataProvider ="LoginData2")
	@Test
	@Parameters({"username","password"})
	public void testvalidLogin(@Optional("defaultUser") String username, @Optional("defaultUser") String password) {
		
		Log.info("Starting login test...");
		test =ExtentReportManager.createTest("Login Test");
		LoginPage loginPage =new LoginPage(driver);
		
		test.info("Navigating to URL");
		//loginPage.enterusername("admin@yourstore.com");
		//loginPage.enterpassword("admin");
		loginPage.enterusername(username);
		loginPage.enterpassword(password);
		loginPage.submit();
		
	String title=	driver.getTitle();
	System.out.println(title);
	
	
	Log.info("Verfying ...");
	//Assert.assertEquals(driver.getTitle(), "Just a moment...");
		
		
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
	Assert.assertEquals(driver.getTitle(), "Just a moment...");
		
		
	}
	
	

}
