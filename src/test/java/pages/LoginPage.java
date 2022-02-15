package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase{
	@FindBy(id="login2")
	WebElement login;
	
	@FindBy(id="loginusername")
	WebElement userName;
	
	@FindBy(id="loginpassword")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Log in')]")
	WebElement loginButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLogin() {
		login.click();
	}
	
	public void enterUserName() {
		userName.sendKeys("Padamati.Bhanu.9@gmail.com");
	}
	
	public void enterPassword() {
		password.sendKeys("Sribhatul@9");
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
}
