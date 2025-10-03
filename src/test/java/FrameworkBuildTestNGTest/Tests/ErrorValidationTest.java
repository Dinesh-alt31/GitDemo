package FrameworkBuildTestNGTest.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import FrameworkBuildTestNGTest.TestComponents.BaseTest;
import FrameworkBuildTestNGTest.TestComponents.RetryFlakyTest;
import FrameworkBuildTestNgMain.pageObjects.CartPage;
import FrameworkBuildTestNgMain.pageObjects.ProductCatalogue;


public class ErrorValidationTest extends BaseTest {

		// TODO Auto-generated method stub
		//WebDriverManager
	@Test(groups = {"ErrorHandling"}, retryAnalyzer = RetryFlakyTest.class )
	public void loginErrorValidationTest() throws IOException
	{
		String productName = "ZARA COAT 3";
		String countryName = "India";
		String confirmationMessage = "thankyou for the order.";

		ProductCatalogue productCatalogue = landingPage.loginApplication("InfosysInterview@gmail.com", "5410A09a1995@@");
		
		Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password." );
		//Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or ." );
	}

	@Test
	public void productErrorValidationTest() throws IOException
	{
		String productName = "ZARA COAT 3";
		String countryName = "India";
		String confirmationMessage = "thankyou for the order.";

		ProductCatalogue productCatalogue = landingPage.loginApplication("TestProduct@gmail.com", "10A09a1995@@");
		
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage =  productCatalogue.goToCartPage();

		Assert.assertFalse(cartPage.findProductIsAdded("ZARA COAT 33"));
	}		
		

		
		
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[routerlink = '/dashboard/cart']")));
		
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection")));
		
		//System.out.println(carts.size());
		//System.out.println(carts);
		//boolean match = carts.stream().anyMatch(c -> c.findElement(By.cssSelector(".cartSection h3")).getText().equalsIgnoreCase(productName));

		//Assert.assertTrue(match);
		
		//section.list-group span
		//List<WebElement> d = 

		

		 
		
		
		//driver.close();


}
