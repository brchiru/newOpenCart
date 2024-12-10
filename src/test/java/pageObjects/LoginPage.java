package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	
	@FindBy(id="input-email")
	WebElement txtboxEmail;
	
	@FindBy(id="input-password")
	WebElement txtboxPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	//Enhancement for failure of login credentials
	
	@FindBy(xpath="//div[text()='Warning: No match for E-Mail Address and/or Password.']")
	WebElement warningTxtMsgDisplayed;
	
	
	//Methods
	public void inputTextEmail(String email) {
		txtboxEmail.clear();
		txtboxEmail.sendKeys(email);
	}
	
	public void inputTextPassword(String pwd) {
		txtboxPassword.clear();
		txtboxPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public boolean getWarningTextDisplay() {
		try {
			
			String warningTxt = warningTxtMsgDisplayed.getText();
			System.out.println("Warning msg"+warningTxt);
			if(warningTxt!="Warning: No match for E-Mail Address and/or Password.")
			{	Assert.fail();
				return false;
			}	
			else
				return true;
			//return (warningTxtMsgDisplayed.isDisplayed());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	

}
