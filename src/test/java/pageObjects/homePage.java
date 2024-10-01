package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import PageBase.BasePageObj;

public class homePage extends BasePageObj{

	public homePage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement linkmyacc;
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement linkreg;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement linklogin;
	
	public void ClickMyAccount()
	{
		linkmyacc.click();
	}
	
	public void ClickRegistration()
	{
		linkreg.click();
	}
	
	public void ClickLoggin()
	{
		linklogin.click();
	}

}
