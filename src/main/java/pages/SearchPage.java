package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(id = "small-searchterms")
	WebElement searchTextBox;
	
	@FindBy(css = "button.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(id = "ui-id-1")
	List<WebElement> ProductList;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement productTitle;
	
	public void ProductSearch(String productName)
	{
		setTextelementText(searchTextBox, productName);
		clickButton(searchBtn);
	}
	
	public void OpenProductDetailsPage()
	{
		clickButton(productTitle);
	}
	
	public void ProductSearchUsingAutoSuggest(String searchTxt)
	{
		setTextelementText(searchTextBox, searchTxt);
	    try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		ProductList.get(0).click();
	
	}
	
	
	
	
}
