package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase
{
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	String oldPassword = "12345678";
	String newPassword = "123456";
	String firstName = "Mohammad";
	String lastName = "Alaa";
	String email = "test33@gmail.com";
	
	
	
	@Test(priority = 1, alwaysRun = true)
	public void UserCanRegisterSuccessfully()
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstName, lastName, email, oldPassword);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test (dependsOnMethods = "UserCanRegisterSuccessfully")
	public void RegisteredUserCanChangePassword()
	{
		myAccountObject = new MyAccountPage(driver);
		registerObject.openMyAccountPage();
		myAccountObject.openChangePasswordPage();
		myAccountObject.ChangePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.resultlb1.getText().contains("Password was changed"));
		myAccountObject.closeBtn.click();
	}
	
	@Test (dependsOnMethods = "RegisteredUserCanChangePassword")
	public void RegisteredUserCanLogout()
	{
		registerObject.userLogout();
	}
	
	@Test(dependsOnMethods = "RegisteredUserCanLogout")
	public void RegisteredUserCanLogin()
	{
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.userlogin(email, newPassword);
	    Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
	
	
}
