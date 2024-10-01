package testtPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageBase.BaseClassTest;
import pageObjects.LoginAccountPageObj;
import pageObjects.MyAccountPageObj;
import pageObjects.homePage;

public class TC002_AccountLoginTest extends BaseClassTest{
	

	@Test(groups={"Sanity","Master"})
	public void LogintoAccount()
	{
		try
		{
			logger.info("**********Home Page*******");
			//Home Page
			homePage hp=new homePage(driver);
			
			hp.ClickMyAccount();
			logger.info("Clicked on My Account");
			
			hp.ClickLoggin();
			logger.info("Clicked on Login");
			
			logger.info("**********Starting Login Page*******");
			//Login Page
			LoginAccountPageObj lp=new LoginAccountPageObj(driver);
			logger.info("Providing Login Details");
			lp.getEmail(p.getProperty("email"));
			lp.getPassword(p.getProperty("password"));
			lp.btnClickLogin();
			
			logger.info("Validating MyAccount Page");
			//MyAccount Page
			MyAccountPageObj map=new MyAccountPageObj(driver);
			boolean targetpage=map.isMyAccountPageExists();
			Assert.assertTrue(targetpage);
			logger.info("**********Finished ******");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
				
	}
}
