package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import PageBase.BasePageObj;

public class AccountregisterPageObj extends BasePageObj{

	public AccountregisterPageObj(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtfName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtlName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemailid;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txttlphone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtconfpwd;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkpolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_continue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confmessage;
	
	public void inputFirstName(String fname)
	{
		txtfName.sendKeys(fname);
	}
	
	public void inputLastName(String lname)
	{
		txtlName.sendKeys(lname);
	}
	
	public void inputEmailID(String email)
	{
		txtemailid.sendKeys(email);
	}
	
	public void inputTelephone(String tele)
	{
		txttlphone.sendKeys(tele);
	}
	
	public void inputPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void inputConfirmPwd(String pwd)
	{
		txtconfpwd.sendKeys(pwd);
	}
	
	public void CheckPolicy()
	{
		chkpolicy.click();
	}
	public void ContinueButton()
	{
		btn_continue.click();
	}
	
	public String  getconfirmMessage()
	{
		try 
		{
			return (confmessage.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
		
		
	}
	
}
