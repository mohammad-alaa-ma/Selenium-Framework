package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

//import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase //extends AbstractTestNGCucumberTests  (The commented section is used with cucumber)
{
	public static WebDriver driver;
	
	
	@SuppressWarnings("deprecation")
	@BeforeSuite
	@org.testng.annotations.Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName)
	{
		 System.out.println("Browser Name: " + browserName); // Add this line for debugging
		if (browserName.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdrvier.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdrvier.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			//System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/drivers/edgedriver.exe");
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		
		// Headless browser testing
		else if(browserName.equalsIgnoreCase("headless")) {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("javascriptEnabled", true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					System.getProperty("user.dir")+"/drivers/phantomjs.exe");
			String[] phantomJsArgs = {"--web-security=no","--ignore-ssl-errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgs);
			driver = new PhantomJSDriver(caps);
		}
		
		// Headless chrome
		else if(browserName.equalsIgnoreCase("chrome-headless")) {
			//System.setProperty("webdrvier.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(options);
			
		}
		
    	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
	}
	

	
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}
	
	// Take screenshot when test cases fail and add it to the Screenshots folder
	
	@AfterMethod
	public void screenshotOnFailure(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed");
			System.out.println("Taking screenshot.....");
			Helper.captureScreenshot(driver, result.getName());
		}
		
	}
	

}
