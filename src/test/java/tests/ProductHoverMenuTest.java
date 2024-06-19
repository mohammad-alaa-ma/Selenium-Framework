///////// This class doesn't work due to something in selenium package (Actions)


package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase
{
	HomePage homeObject;
	
	
	@Test
	public void UserCanSelectSubcategoryFromMainMenu()
	{
		homeObject = new HomePage(driver);
		homeObject.selectNotebooksMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}
	
	

}
