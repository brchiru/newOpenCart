package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Locators
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgMyAccPageHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][text()='Logout']")
	WebElement btnLogout;
	
	//Methods
	
	public boolean isMyAccountPageExists()
	{
		try 
		{
			return (msgMyAccPageHeading.isDisplayed());
		}
		catch(Exception e) 
		{
			return false;
		}
		
	}
	
	public void clickLogout() {
		btnLogout.click();
	}
}
