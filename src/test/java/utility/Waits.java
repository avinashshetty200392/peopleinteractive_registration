package utility;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Waits {
	
	private static WebDriverWait wait;
	
	
	public static void waitforSeconds(WebDriver driver,int secs, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,secs);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitforSecondsForMultipleElements(WebDriver driver,int secs, List<WebElement> elements)
	{	
		WebDriverWait wait = new WebDriverWait(driver,secs);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
}
