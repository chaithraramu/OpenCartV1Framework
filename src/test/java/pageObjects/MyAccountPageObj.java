package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import PageBase.BasePageObj;

public class MyAccountPageObj extends BasePageObj{

	public MyAccountPageObj(WebDriver driver) {
		super(driver);

	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement loginPageheader;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")  //step 6
	WebElement linkloout;
	
	public boolean isMyAccountPageExists()
	{
		try
		{
		return(loginPageheader.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void ClickLogout()
	{
		linkloout.click();
	}
	

}
