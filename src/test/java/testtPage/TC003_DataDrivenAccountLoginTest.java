package testtPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageBase.BaseClassTest;

import pageObjects.LoginAccountPageObj;
import pageObjects.MyAccountPageObj;
import pageObjects.homePage;
import utilities.DataProviders;



/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/
public class TC003_DataDrivenAccountLoginTest extends BaseClassTest{
	
	
	@Test(dataProvider="LoginData" , dataProviderClass=DataProviders.class, groups="DataDriven")
	public void Verify_LoginDDT(String email, String password, String exp)
	{
		logger.info("******************** Starting TC003_DataDrivenAccountLoginTest***************");
		
		try
		{
			//Home Page
			homePage hp=new homePage(driver);
			hp.ClickMyAccount();
			hp.ClickLoggin();
			
			
			//Login page
			LoginAccountPageObj lp=new LoginAccountPageObj(driver);
			lp.getEmail(email);
			lp.getPassword(password);
			lp.btnClickLogin(); //Login button
				
			//My Account Page
			MyAccountPageObj macc=new MyAccountPageObj(driver);
			boolean targetPage=macc.isMyAccountPageExists();
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					macc.ClickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
					
				}
			}
			if(exp.equalsIgnoreCase("Invalid"))
			{
					if(targetPage==true)
					{
						macc.ClickLogout();
						Assert.assertTrue(false);
						
					}
					else
					{
						Assert.assertTrue(true);
					}
			}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("******************** Finished TC003_DataDrivenAccountLoginTest***************");
	}	
}
