package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ComparePage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase
{

	String firstProductName = "Apple MacBook Pro 13-inch";
	String secondProductName = "Asus N551JK-XO076H Laptop";
	
	ProductDetailsPage detailsObject;
	HomePage homeObject;
	ComparePage compareObject;
	SearchPage searchObject;
	
	
	@Test (priority = 1)
	public void UserCanCompareProducts() throws InterruptedException
	{
		searchObject = new SearchPage(driver);
		detailsObject = new ProductDetailsPage(driver);
		compareObject = new ComparePage(driver);
		
          // Searching may takes some time due to Internet connection
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), firstProductName);
		detailsObject.addProductToCompare();
		
		searchObject.ProductSearchUsingAutoSuggest("Asus");
		Assert.assertEquals(detailsObject.productNamebreadCrumb.getText(), secondProductName);
		detailsObject.addProductToCompare();
		Thread.sleep(2000);
		
		
		driver.navigate().to("http://demo.nopcommerce.com" + "/compareproducts");
		Assert.assertTrue(compareObject.firstProductName.getText().equals("Asus N551JK-XO076H Laptop"));
		Assert.assertTrue(compareObject.secondProductName.getText().equals("Apple MacBook Pro 13-inch"));
		compareObject.compareProducts();
	
	}
	
	@Test(priority = 2)
	public void UserCanClearCompareList()
	{
		compareObject.clearCompareList();
		Assert.assertTrue(compareObject.noDataLb1.getText().contains("You have no items to compare"));
	}
	
	
	
	
	
	
	
}
