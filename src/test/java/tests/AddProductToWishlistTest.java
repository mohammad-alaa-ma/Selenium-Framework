//////////////////////////////////////////
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishlistPage;

public class AddProductToWishlistTest extends TestBase
{

	SearchPage searchPage;
	ProductDetailsPage productDetails;
	WishlistPage wishListObject;
	String productName ="Apple MacBook Pro 13-inch";
	
	
	
	@Test (priority = 1)
	public void UserCanSearchWithAutoSuggest()
	{
			searchPage = new SearchPage(driver);
			searchPage.ProductSearchUsingAutoSuggest("MacBook pro");
			productDetails = new ProductDetailsPage(driver);
			Assert.assertEquals(productDetails.productNamebreadCrumb.getText(), productName);	
	}
	
	
	@Test(priority = 2)
	public void UserCanAddProductToWishlist()
	{
		productDetails = new ProductDetailsPage(driver);
		productDetails.addProductToWishlist();
		driver.navigate().to("https://demo.nopcommerce.com/wishlist");
		wishListObject = new WishlistPage(driver);
		Assert.assertTrue(wishListObject.wishListHeader.isDisplayed());	
		Assert.assertTrue(wishListObject.productCell.getText().contains(productName));
		
	}
	
	@Test(priority = 3)
	public void UserCanRemoveProductFromCart()
	{
		wishListObject = new WishlistPage(driver);
		wishListObject.removeProductFromWishlist();
		//Assert.assertTrue(wishListObject.EmptyCartLb1.getText().contains("The wishlist is empty!"));
	    //Assert.assertTrue(driver.getCurrentUrl().contains("wishlist"));
		
	}
	
	
}
