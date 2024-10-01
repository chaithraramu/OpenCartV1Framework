package PageBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BaseClassTest {

	
	protected static WebDriver driver;
	public Logger logger;
	public Properties p;
	@SuppressWarnings("deprecation")
	@BeforeClass(groups={"Sanity","regression" ,"Master"})
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws IOException
	{
		
		
		//to generate Logs
		logger=LogManager.getLogger(this.getClass());
		
		//Loading config.properties file
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		//execution_env=remote
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabalities = new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capabalities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabalities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No Matching OS");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capabalities.setBrowserName("chrome"); break;
			case "edge": capabalities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No Matching Browser");return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabalities);
			
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//browser
			switch(br.toLowerCase())
			{
				case "chrome":driver = new ChromeDriver();break;
				case "edge": driver = new EdgeDriver();break;
				case "firefox":driver = new FirefoxDriver();break;
				default:System.out.println("Invalid Browser");return;
			}
		}
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL")); //reading browser from property file
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
	}
	@AfterClass(groups={"Sanity","regression" ,"Master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNum()
	{
		String generatedNum=RandomStringUtils.randomNumeric(10);
		return generatedNum;
	}
	
	public String randomAlphNum()
	{
		String generatedAlphNum=RandomStringUtils.randomAlphanumeric(8);
		return generatedAlphNum;
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}
