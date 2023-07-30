package Com.Ecommerce.BaseClass;

import java.lang.ProcessHandle.Info;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Com.Ecommerce.Utilities.ReadConfiguration;
public class Ecommerce_BaseClass {
	
	public static WebDriver driver;
	public static Logger logger;
	
	ReadConfiguration readconfig = new ReadConfiguration(); 
	public String BaseURL = readconfig.getApplicationURL();
	public String Username = readconfig.Username();
	public String password = readconfig.Password();
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	
	@Parameters("Browser")
	public void initialization(String Browsername) {

		logger = logger.getLogger("11March_Framework");
		
		PropertyConfigurator.configure("log4j.Properties");
		
		if(Browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace2\\11March_Framework\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\eclipse-workspace2\\11March_Framework\\Driver\\chromedriver.exe");
			driver = new FirefoxDriver();
		}

		
		logger.info("Open Browser");
		
		driver.manage().window().maximize();
		
		logger.info("Maximize the browser");
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(BaseURL);
		
		logger.info("Open application");
		
		
	}
	
	@AfterMethod
	public void Teardown() throws InterruptedException{ 
	Thread.sleep(3000);
	driver.quit();

	}

}
