package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(id = "gender-male" )
	WebElement genderRdioBtn;
	
	@FindBy(id = "FirstName" )
	WebElement fnTxtBox;
	
	@FindBy(id = "LastName" )
	WebElement lnTxtBox;
	
	@FindBy(id = "Email" )
	WebElement emailTxtBox;
	
	@FindBy(id = "Password" )
	WebElement passwordTxtBox;
	
	@FindBy(id = "ConfirmPassword" )
	WebElement confirmPasswordTxtBox;
	
	@FindBy(id = "register-button" )
	WebElement registerBtn;
	
	@FindBy(css = "div.result" )
	public WebElement successMessage;
	
	@FindBy(css = "a.ico-logout" )
	public WebElement logoutLink;
	
	@FindBy(linkText = "My account" )
	WebElement myaccountLink;
	
	public void userRegisteration(String firstName ,String lastName, String email, String password)
	{
		clickButton(genderRdioBtn);
		setTextelementText(fnTxtBox, firstName);
		setTextelementText(lnTxtBox, lastName);
		setTextelementText(emailTxtBox, email);
		setTextelementText(passwordTxtBox, password);
		setTextelementText(confirmPasswordTxtBox, password);
		clickButton(registerBtn);
	}
	
	public void userLogout()
	{
		clickButton(logoutLink);
	}
	
	public void openMyAccountPage()
	{
		clickButton(myaccountLink);
	}

}
