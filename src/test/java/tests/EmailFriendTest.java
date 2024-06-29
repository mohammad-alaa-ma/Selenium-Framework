package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase 
{
		
		HomePage homeObject;
		UserRegistrationPage registerObject;
		LoginPage loginObject;
		String productName ="Apple MacBook Pro 13-inch";
		SearchPage searchObject;
		ProductDetailsPage detailsObject;
		EmailPage emailObject;
		
		Faker fakeData = new Faker();
		String firstName = fakeData.name().firstName();
		String lastName = fakeData.name().lastName();
		String yourEmail = fakeData.internet().emailAddress();
		String password = fakeData.number().digits(8).toString();
		
		// 1. User registration
		
		@Test(priority = 1, alwaysRun = true)
		public void UserCanRegisterSuccessfully()
		{
			homeObject = new HomePage(driver);
			homeObject.openRegisterationPage();
			registerObject = new UserRegistrationPage(driver);
			registerObject.userRegisteration(firstName, lastName, yourEmail, password);
			Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		}
		
		
		// 2. Search for product
		
		@Test(priority = 2)
		public void UserCanSearchWithAutoSuggest()
		{
			try {
				searchObject = new SearchPage(driver);
				searchObject.ProductSearchUsingAutoSuggest("MacB");
				detailsObject = new ProductDetailsPage(driver);
				Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), productName);
				
			} catch (Exception e) {
				System.out.println("Error occurred    " + e.getMessage());
			}
			
		}
		
		// 3. Email to friend
		
		@Test(priority = 3)
		public void RegisteredUserCanSendProductToFriend()
		{
			detailsObject.openSendEmail();
			emailObject = new EmailPage(driver);
			emailObject.SendEmailToFriend("aaa@gmail.com" ,"Hello my friend" ); 
			Assert.assertTrue(emailObject.messageNotification.getText().contains("Your message has been sent."));
		}
		
		// 4. User Logout
		@Test (priority = 4)
		public void RegisteredUserCanLogout()
		{
			registerObject.userLogout();
		}

	}
