package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	
	@FindBy (id="Email")
	WebElement emailTxtBox;
	
	@FindBy (id="Password")
	WebElement passwordTxtBox;
	
	@FindBy (css="button.button-1.login-button")
	WebElement loginBtn;
	
	public void userlogin(String email , String password)
	{
		setTextelementText(emailTxtBox, email);
		setTextelementText(passwordTxtBox, password);
		clickButton(loginBtn);
	}
	
}
