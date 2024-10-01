package testtPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageBase.BaseClassTest;
import pageObjects.AccountregisterPageObj;
import pageObjects.homePage;


public class TC001_AccountRegistrartionTest extends BaseClassTest{

	
	@Test(groups={"Regresstion", "Master"})
	public void verify_Account_Registration()
	{
		try
		{
			logger.info("****Starting TC001_AccountRegistrartionTest****");
			homePage hp=new homePage(driver);
			hp.ClickMyAccount();
			logger.info("clicked on MyAccount");
			hp.ClickRegistration();
			logger.info("clicked on Registration");
			
			AccountregisterPageObj rp=new AccountregisterPageObj(driver);
			
			logger.info("Providing customer details");
			rp.inputFirstName(randomString().toUpperCase());
			rp.inputLastName(randomString().toUpperCase());
			rp.inputEmailID(randomString()+"@gmail.com");
			rp.inputTelephone("9786547896");
			
			String password=randomAlphNum();
			rp.inputPassword(password);
			rp.inputConfirmPwd(password);
			rp.CheckPolicy();
			rp.ContinueButton();
			
			logger.info("Validating error message");
			String confirm_Message=rp.getconfirmMessage();
			if(confirm_Message.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Test Failed");
				logger.debug("Debug Logs");
				Assert.assertTrue(false);
			}
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		logger.info("****Finished TC001_AccountRegistrartionTest****");
	}
}
