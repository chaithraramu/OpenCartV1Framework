package PageBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageObj {
	
	
	WebDriver driver;
	
	public BasePageObj(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}

}
