package pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.CommonMethods;
import utility.Waits;

public class RegistrationObjects {

	private WebDriver driver;
	
	public RegistrationObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='hero-module--topRightNav--2eKnV']")
	private WebElement navBar;
	
	@FindBy(xpath="//div[@class='row']/h1")
	private WebElement pageContent;
	
	@FindBy(xpath="//input[@value='Self']")
	private WebElement selfPerson;
	
	@FindBy(xpath="//input[@value='Family']")
	private WebElement familyPerson;
	
	@FindBy(xpath="//button[contains(text(),'Begin')]")
	private WebElement letsBeginButton;
	
	@FindBy(xpath="//form[@class='form-module--wrapper--1fEjU']")
	private WebElement registrationAndBasicDeatilsForm;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement nextButton;
	
	@FindBy(xpath="//div[@class='form-module--formButton--1Y41d']/p/a")
	private WebElement loginLink;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailIdField;
	
	@FindBy(xpath="//input[@name='password1']")
	private WebElement passwordField;
	
	@FindBy(xpath="//div[@class='Dropdown-control postedby_selector']")
	private WebElement profile;
	
	@FindBy(xpath="//div[@class='Dropdown-menu postedby_options']/div")
	private List<WebElement> listOfProfile;
	
	@FindBy(xpath="//input[@type='radio' and @name='gender']")
	private List<WebElement> genderRadioButton;
	
	@FindBy(xpath="//h2[contains(text(),'Great! Now some basic details')]")
	private WebElement basicDetailsTitle; 
	
	@FindBy(xpath="//label[contains(text(),'Mother tongue')]/..//div[@class='Dropdown-placeholder is-selected']")
	private List<WebElement> motherTongue;
	
	
	public void enterUrl(String url)
	{
		driver.get(url);
	}
	public void verifyLoginPage(String expectedPageName)
	{
		String pagetitle= driver.getTitle();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.and(
				ExpectedConditions.visibilityOf(navBar),
				ExpectedConditions.visibilityOf(pageContent),
				ExpectedConditions.titleIs(pagetitle)));
		
		String pagetitlearray[] = pagetitle.split(" -");
		String actualPageName = pagetitlearray[0]; 
		if(actualPageName.equalsIgnoreCase(expectedPageName))
		{
			System.out.println("I am on"+" "+ expectedPageName+" "+"page");
		}
		else
		{
			System.out.println("Not a valid page");
		}
	}
	
	public void clickOnRadioButtonOfconcernedPerson(String person) throws InterruptedException
	{
		CommonMethods.threadSleep(1000);
		if(person.equalsIgnoreCase("Self"))
		{
			Waits.waitforSeconds(driver, 10, selfPerson);
			selfPerson.click();
		}
		else if(person.equalsIgnoreCase("Family"))
		{
			Waits.waitforSeconds(driver, 10, familyPerson);
			familyPerson.click();
		}
		else
		{
			System.out.println("Not a valid concerned person");
		}	
	}
	
	public void clickOnLetsBeginButton() throws InterruptedException
	{
		Waits.waitforSeconds(driver, 10, letsBeginButton);
		letsBeginButton.click();
	}
	
	public void verifyRegistrationPopup() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.and(
				ExpectedConditions.visibilityOf(registrationAndBasicDeatilsForm),
				ExpectedConditions.visibilityOf(nextButton),
				ExpectedConditions.visibilityOf(loginLink)));
	}
	
	public void enterEmailId(String email) throws InterruptedException
	{
		Waits.waitforSeconds(driver, 10, emailIdField);
		emailIdField.clear();
		emailIdField.sendKeys(email);
	}
	
	public void enterPassword(String pass) throws InterruptedException
	{
		Waits.waitforSeconds(driver, 10, passwordField);
		passwordField.clear();
		passwordField.sendKeys(pass);
	}
	
	public void selectProfile(String expectedprofileName) throws InterruptedException
	{
		CommonMethods.threadSleep(1000);
		Waits.waitforSeconds(driver, 10, profile);
		profile.click();
		Waits.waitforSecondsForMultipleElements(driver, 10, listOfProfile);
		
		for(WebElement profileName:listOfProfile)
		{
			if(profileName.getAttribute("innerHTML").equalsIgnoreCase(expectedprofileName))
			{
				profileName.click();
				break;
			}
		}
	}
	
	public void selectGenderRadioButton(String gender) throws InterruptedException
	{
		CommonMethods.threadSleep(1000);
		Waits.waitforSecondsForMultipleElements(driver, 10, genderRadioButton);
		for(WebElement genderRadio:genderRadioButton)
		{
			if(genderRadio.getAttribute("value").equalsIgnoreCase("Male"))
			{
				genderRadio.click();
			}
			else
			{
				genderRadio.click();
			}
		}
	}
	
	public void clickOnNextButton() throws InterruptedException
	{
		Thread.sleep(1000);
		Waits.waitforSeconds(driver, 10, nextButton);
		nextButton.click();
	}
	
	public void verifyBasicDetailsPopup() throws InterruptedException
	{
		CommonMethods.threadSleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(registrationAndBasicDeatilsForm),
					ExpectedConditions.visibilityOf(basicDetailsTitle)));
		
	}
	
	public void verifyMotherTongue(String expectedMotherTongue) throws InterruptedException
	{
		Waits.waitforSecondsForMultipleElements(driver, 10, motherTongue);
		
		for(WebElement motherTong: motherTongue)
		{
			String motherLan= motherTong.getAttribute("innerHTML");
			if(motherLan.equalsIgnoreCase(expectedMotherTongue) || motherLan.equalsIgnoreCase(expectedMotherTongue))
			{
				System.out.println("Mother tongue: "+motherLan);
			}
		}	
	}
	
	public void closeBrowser()
	{
		CommonMethods.tearDown(driver);
	}
}
