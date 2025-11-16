package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	private By usernameTextBox =By.id("Email");
	
	private By passwordTextBox =By.id("Password");
	
	private By submit =By.xpath("//button[@type='submit']");
	
	public LoginPage(WebDriver driver) {
		
		this.driver= driver;
	}
	
	public void enterusername(String username) {
		driver.findElement(usernameTextBox).clear();
		driver.findElement(usernameTextBox).sendKeys(username);
		
	}
	
	public void enterpassword(String password) {
		driver.findElement(passwordTextBox).sendKeys(password);
		
	}
	
	public void submit() {
		driver.findElement(submit).click();
		
	}
	
	

}
