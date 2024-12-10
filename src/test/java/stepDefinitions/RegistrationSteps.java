package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccRegisterPage;
import pageObjects.HomePage;

public class RegistrationSteps {
	WebDriver driver;
	HomePage hp;
	AccRegisterPage accrp;
	
	@Given("the user navigates to Register Account page")
	public void the_user_navigates_to_register_account_page() {
		hp = new HomePage(BaseClass.getDriver());
		hp.clickMyAccount();
		hp.clickRegister();
		
		//accrp = new AccRegisterPage(BaseClass.getDriver());
		
		
	}

	@When("the user enters the details into below fields")
	public void the_user_enters_the_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		
		accrp = new AccRegisterPage(BaseClass.getDriver());
		
		//accrp.checkAccRegPage();
		accrp.setFirstName(dataMap.get("firstName"));
		accrp.setLastName(dataMap.get("lastName"));
		accrp.setEMail(BaseClass.rndAlphaNumeric()+"@test10.com");
		accrp.setTelePhoneNo(dataMap.get("telephone"));
		accrp.setPassword(dataMap.get("password"));
		accrp.setConfirmPassword(dataMap.get("password"));
	}

	@When("the user selects Privacy Policy")
	public void the_user_selects_privacy_policy() {
		
		accrp.setPrivacyPolicy();

	}

	@When("the user clicks on Continue button")
	public void the_user_clicks_on_continue_button() {
		accrp.clickContinue();
	}

	@Then("the user account should get created successfully")
	public void the_user_account_should_get_created_successfully() {
		String confMsg = accrp.getConfirmationMsg();
		Assert.assertEquals(confMsg, "Your Account Has Been Created!");
	}
	
}
