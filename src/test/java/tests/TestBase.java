package tests;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helpers;


public class TestBase extends AbstractTestNGCucumberTests
{
	public static WebDriver driver;
	public static String downloadPath= System.getProperty("user.dir")+"\\Downloads\\";
	
	public static ChromeOptions chromeOption()
	{
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--remote-allow-origins=*");
		
		
		HashMap<String, Object> chromePrefs= new HashMap<String , Object>();
		chromePrefs.put("profile.default.content_setting.popus", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		return options;
		//	return new ChromeDriver(chromeOptions);
	}
	
	public static FirefoxOptions firefoxOption()
	{
		FirefoxOptions option= new FirefoxOptions();
		option.addPreference("browser.download.folderList",2);
		option.addPreference("browser.download.dir",downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
		option.addPreference("browser.download.manger.showWhenStarting", false);
		return option;
	}

	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("Chrome") String browserName)
	{
		if (browserName.equalsIgnoreCase("Chrome")) 
		{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+" /drivers/chromedriver.exe");
			driver = new ChromeDriver(chromeOption());
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+" /drivers/geckodriver.exe");
			driver = new FirefoxDriver(firefoxOption());
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{

			//System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+" /drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browserName.equalsIgnoreCase("microsoft edge"))
		{
			driver = new EdgeDriver();
		}

		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.navigate().to("https://demo.nopcommerce.com/");
	}

	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}
	
	//Take screenshot when test case fail and add it in the screenshot folder
	@AfterMethod
	public void screenshotOnfailure(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("Failed");
			System.out.println("Taking ScreenShot....");
			Helpers.captureScreenshot(driver, result.getName());
		}
	}
}
