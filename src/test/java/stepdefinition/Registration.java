package stepdefinition;

import org.openqa.selenium.WebDriver;

import pageobject.RegistrationObjects;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.CommonMethods;
import utility.Waits;

public class Registration {
	public WebDriver driver;
	RegistrationObjects regob;

	public Registration() {
		this.driver = CommonMethods.initializeDriver();
	}

	@Given("^I enter url as '(.+)' in the url bar of the browser$")
	public void i_enter_url_as_https_www_marathishaadi_com_in_the_url_bar_of_the_browser(
			String url) throws Throwable {
		regob = new RegistrationObjects(driver);
		regob.enterUrl(url);
	}

	@Given("^I navigate to '(.+)' login page$")
	public void i_navigate_to_marathishaddi_login_page(String expectedPageName)
			throws Throwable {
		regob.verifyLoginPage(expectedPageName);
	}
	
	@Given("^I select option as '(.+)' who is looking for partner$")
	public void i_select_option_as_Myself_who_is_looking_for_partner(String concernedPerson) throws Throwable {
	    regob.clickOnRadioButtonOfconcernedPerson(concernedPerson);
	}
	
	@Given("^I click on Let's Begin button$")
	public void i_click_on_Let_s_Begin_button() throws Throwable {
		regob.clickOnLetsBeginButton();
	}
	
	@Given("^I can see registeration pop up$")
	public void i_can_see_registeration_pop_up() throws Throwable {
	 regob.verifyRegistrationPopup();
	}
	
	@Given("^I enter '(.+)' in Enter your email id text field$")
	public void i_enter_avi_gmail_com_in_Enter_your_email_id_text_field(String emailId) throws Throwable {
	    regob.enterEmailId(emailId);
	}
	
	@Given("^I enter '(.+)' in Create a password field$")
	public void i_enter_in_Create_a_password_field(String password) throws Throwable {
	    regob.enterPassword(password);
	}
	
	@Given("^I select (.+) from Create Profile for drop down$")
	public void i_select_from_Create_Profile_for_drop_down(String profileName) throws Throwable {
	    regob.selectProfile(profileName);
	}
	
	@Given("^I select (.+) radio button$")
	public void i_select_radio_button(String gender) throws Throwable {
		regob.selectGenderRadioButton(gender);
	}
	
	@Given("^I click on Next button$")
	public void i_click_on_Next_button() throws Throwable{
	    regob.clickOnNextButton();
	}
	@When("^I navigate to basic details pop up$")
	public void i_navigate_to_basic_details_pop_up() throws Throwable {
	    regob.verifyBasicDetailsPopup();
	}

	@Then("^I should see '(.+)' as Mother tongue$")
	public void i_should_see_Marathi_as_Mother_tongue(String motherTongue) throws Throwable {
	   regob.verifyMotherTongue(motherTongue);
	}
	
	@Then("^I should see the web browser closed$")
	public void i_should_see_the_web_browser_closed() throws Throwable {
	    regob.closeBrowser();
	}

}
