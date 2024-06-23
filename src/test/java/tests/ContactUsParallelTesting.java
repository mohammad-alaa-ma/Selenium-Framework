package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsParallelTesting extends TestBaseSeleniumGrid
{
	HomePage home;
	ContactUsPage contactPage;
	
	Faker fakeData = new Faker();
	String email = fakeData.internet().emailAddress();
	String fullName = "Test User";
	String enquiry = "Hello, This is for test";
	
	@Test
	public void UserCanUseContactUs()
	{
		home = new HomePage(getDriver());
		home.openContactUsPage();
		contactPage = new ContactUsPage(getDriver());
		contactPage.ContactUs(fullName, email, enquiry);
		Assert.assertTrue(contactPage.successMessage.getText().contains("Your enquiry has been successfully sent to the store owner."));
	}
	
	
}
