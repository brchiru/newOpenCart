package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccRegisterPage extends BasePage {

	public AccRegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Locators 
	@FindBy(xpath="//h1[text()='Register Account']")
	WebElement txtCheckAccRegPage;
	
	@FindBy(name = "firstname")
	WebElement inputTextFirstName;
	
	@FindBy(name = "lastname")
	WebElement inputTextlastName;
	
	@FindBy(name = "email")
	WebElement inputTexteMail;
	
	@FindBy(name = "telephone")
	WebElement inputTexttelephone;
	
	@FindBy(name = "password")
	WebElement inputTextpassword;
	
	@FindBy(name = "confirm")
	WebElement inputTextpasswordConfirm;
	
	@FindBy(name = "agree")
	WebElement checkBoxagree;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath="//h1[contains(text(),'Created!')]")
	WebElement msgConfirmation;
	
	public boolean checkAccRegPage() {
		
		if(txtCheckAccRegPage.getText()=="Register Account") 
		{
			Assert.assertTrue(true);
			return true;
		}
		else
		{
			Assert.fail();
			return false;
		}
	}
	
	public void setFirstName(String fname) {
		inputTextFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		inputTextlastName.sendKeys(lname);
	}
	
	public void setEMail(String email) {
		inputTexteMail.sendKeys(email);
	}
	
	public void setTelePhoneNo(String telno) {
		inputTexttelephone.sendKeys(telno);
	}
	
	public void setPassword(String cPwd) {
		inputTextpassword.sendKeys(cPwd);
	}
	
	public void setConfirmPassword(String cPwd) {
		inputTextpasswordConfirm.sendKeys(cPwd);
	}
	
	public void setPrivacyPolicy() {
		checkBoxagree.click();
	}
	
	public void clickContinue() {
		btncontinue.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return(e.getMessage());
		}
		
	}
	
	
}
