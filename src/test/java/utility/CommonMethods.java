package utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.cucumber.listener.Reporter;


public class CommonMethods {
	private static WebDriver driver;
	private static Properties properties;
	private static String projectPath;
	
	public static WebDriver initializeDriver()
	{
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("incognito");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		return driver;
	}
	
	public static void getReportConfigPath(){
		 projectPath = System.getProperty("user.dir");
		 Reporter.loadXMLConfig(new File(projectPath+"\\extent-config.xml"));
		 Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	     Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	     Reporter.setSystemInfo("OS", "Windows 10" + "64 Bit");

		}
	
	public static void threadSleep(int secs) throws InterruptedException
	{
		Thread.sleep(secs);
	}
	public static void tearDown(WebDriver driver)
	{
		driver.quit();
	}
}
