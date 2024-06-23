package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "strong.current-item")
	public WebElement productNamebreadCrumb;
	
	@FindBy(css = "button.button-2.email-a-friend-button")
	public WebElement emailFriendBtn;
	
	@FindBy(id = "price-value-4")
	public WebElement productPriceLabel;
	
	@FindBy(id ="add-to-wishlist-button-4")
	WebElement addToWishListBtn; 
	
	@FindBy (linkText = "Add your review")
	WebElement addReviewLink;
	
	@FindBy (css = "button.button-2.add-to-compare-list-button")
	WebElement addToCompareBtn;
	
	public void openSendEmail()
	{
		clickButton(emailFriendBtn);
	}
	
	public void openAddReviewPage()
	{
		clickButton(addReviewLink);
	}
	
	public void addProductToWishlist()
	{
		clickButton(addToWishListBtn);
	}
	
	public void addProductToCompare()
	{
		clickButton(addToCompareBtn);
	}

}
