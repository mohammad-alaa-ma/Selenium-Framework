package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitleTxt;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewText;
	
	@FindBy(id = "addproductrating_4")
	WebElement rating4RdioBtn;
	
	@FindBy(id ="add-review")
	WebElement submitReviewBtn;
	
	@FindBy(css ="p.content")
	public WebElement reviewNotification;
	
	@FindBy(css ="span.close")
	public WebElement closeNotificationButton;
	
	public void AddProductReview (String reviewTitle , String reviewMessage)
	{
		setTextelementText(reviewTitleTxt, reviewTitle);
		setTextelementText(reviewText, reviewMessage);
		clickButton(rating4RdioBtn);
		clickButton(submitReviewBtn);
	}
}
