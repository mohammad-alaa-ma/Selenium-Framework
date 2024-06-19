package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class WishlistPage extends PageBase{

	public WishlistPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (css ="td.product" )
	public WebElement productCell;
	
	@FindBy (css = "h1")
	public WebElement wishListHeader;
	
	@FindBy (id  ="updatecart")
	WebElement updateWishListBtn;
	
	@FindBy (css = "button.remove-btn")
	WebElement removeFromCartCheck;
	
	@FindBy (css = "div.no-data")
	public WebElement EmptyCartLb1;
	
	public void removeProductFromWishlist()
	{
		clickButton(removeFromCartCheck);
		clickButton(updateWishListBtn);
		Assert.assertTrue(EmptyCartLb1.getText().contains("empty"));
	}
	
	
	
	

}
