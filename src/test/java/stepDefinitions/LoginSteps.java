package stepDefinitions;

import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

public class LoginSteps {
	WebDriver driver;
	HomePage hp;
	LoginPage lp;
	MyAccountPage maccp;
	
	List<HashMap<String, String>> datamap; //data driven

	
	@Given("user on login page")
	public void user_on_login_page() {
	    BaseClass.getLogger().info("GoTo my account > Click on Login button");
	    
	    hp=new HomePage(BaseClass.getDriver());
	    
	    hp.clickMyAccount();
	    hp.clickLogin();
	}

	@When("user enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String pwd) {
	    BaseClass.getLogger().info("Enter Email and Password");
	    lp = new LoginPage(BaseClass.getDriver());
	    
	    lp.inputTextEmail(email);
	    lp.inputTextPassword(pwd);
	    
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		lp.clickLogin();
		BaseClass.getLogger().info("Click on Login button");
	}

	@Then("user should be redirected to MyAccount Page")
	public void user_should_be_redirected_to_my_account_page() {
		
		maccp = new MyAccountPage(BaseClass.getDriver());
		
		boolean targetpage = maccp.isMyAccountPageExists();
		if(targetpage=true)
		{
			Assert.assertEquals(targetpage,true);
			BaseClass.getLogger().info("Sucessfully reached My Accout Page");
		}	
		else 
		{
			Assert.fail();
			BaseClass.getLogger().info("Failed to reach");
		}
	}

	@Then("user should be redirected to Login Page with Warning Message")
	public void user_should_be_redirected_to_login_page_with_message() {
	    lp.getWarningTextDisplay();
	    BaseClass.getLogger().info("Login Failed");
	}
	
	//************** Data Driven Test ********************
	@When("the user shuld be redirected to MyAccount Page by passing email and password via excel row {string}")
	public void the_user_shuld_be_redirected_to_my_account_page_by_passing_email_and_password_via_excel_row(String rows) {
		//datamap=DataReader.data(System.getProperty("user.dir")+"/newOpenCart/testData/OpenCartLoginData.xlsx", "sheet1");
		datamap=DataReader.data("/Users/br_chiru/Documents/EclipseIDE/newOpenCart/testData/OpenCartLoginData.xlsx", "Sheet1");
		System.out.println("index value :::: **** ::: "+rows);
		int index=Integer.parseInt(rows)-1;
		System.out.println("index value :::: **** ::: "+index);
		
		String email = datamap.get(index).get("username");
		String pwd = datamap.get(index).get("password");
		String exp_res = datamap.get(index).get("res");
		
		lp = new LoginPage(BaseClass.getDriver());
		
		lp.inputTextEmail(email);
		lp.inputTextPassword(pwd);
		
		lp.clickLogin();
		
		
		maccp = new MyAccountPage(BaseClass.getDriver());
		
		try 
		{
			boolean targetpage = maccp.isMyAccountPageExists();
			System.out.println("target Page: "+targetpage);
			if(exp_res.equals("Valid")) 
			{
				if(targetpage==true)
				{
					MyAccountPage myaccpage=new MyAccountPage(BaseClass.getDriver()); 
					myaccpage.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			if(exp_res.equals("Invalid")) 
			{
				if(targetpage==true)
				{
					maccp.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		} 
		catch (Exception e) 
		{
			Assert.assertTrue(false);
		}
		
		
		
	}
	
	
}
