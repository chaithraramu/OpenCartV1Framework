package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import PageBase.BasePageObj;

public class LoginAccountPageObj extends BasePageObj{

	public LoginAccountPageObj(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']") 
	WebElement txtinemail;
	
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement txtinpwd;
	
	@FindBy(xpath="//input[@value='Login']") 
	WebElement btnLogin;
	
	
	
	public void getEmail(String email) 
	{
		txtinemail.sendKeys(email);
	}
	
	public void getPassword(String password) 
	{
		txtinpwd.sendKeys(password);
	}
	
	public void btnClickLogin() 
	{
		btnLogin.click();
	}
}
