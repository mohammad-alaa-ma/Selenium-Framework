package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;


public class UserRegistrationTestWithDDTAndExcel extends TestBase
{
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	
	
	@DataProvider(name = "ExcelData")
	public Object[][] userRegisterData() throws IOException
	{
		// Get data from Excel Reader class
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
		
	}
	
	@Test(priority = 1, alwaysRun = true, dataProvider = "ExcelData")
	public void UserCanRegisterSuccessfully(String firstname, String lastname, String email, String password)
	{
		homeObject = new HomePage(driver);
		homeObject.openRegisterationPage();
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegisteration(firstname,lastname,email,password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogout();
		homeObject.openLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.userlogin(email, password);
	    Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	    registerObject.userLogout();
	}
	
}
