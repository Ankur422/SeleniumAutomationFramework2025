package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy(id="Email")
	WebElement usernameTextBox;
	
	@FindBy(id="Password")
	WebElement passwordTextBox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	
	//private By usernameTextBox =By.id("Email");
	
	//private By passwordTextBox =By.id("Password");
	
	//private By submit =By.xpath("//button[@type='submit']");
	
	public LoginPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		        
	}
	
	public void enterusername(String username) {
		
		usernameTextBox.clear();
		usernameTextBox.sendKeys(username);
		//driver.findElement(usernameTextBox).clear();
		//driver.findElement(usernameTextBox).sendKeys(username);
		
	}
	
	public void enterpassword(String password) {
		
		passwordTextBox.sendKeys(password);
		//driver.findElement(passwordTextBox).sendKeys(password);
		
	}
	
	public void submit() {
		submit.click();
		//driver.findElement(submit).click();
		
	}
	
	

}
