package FrameworkBuildTestNGTest.Tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import FrameworkBuildTestNGTest.TestComponents.BaseTest;
import FrameworkBuildTestNgMain.pageObjects.CartPage;
import FrameworkBuildTestNgMain.pageObjects.ConfirmationPage;
import FrameworkBuildTestNgMain.pageObjects.OrderHistoryPage;
import FrameworkBuildTestNgMain.pageObjects.PaymentPage;
import FrameworkBuildTestNgMain.pageObjects.ProductCatalogue;


public class SubmitOrderTest extends BaseTest {

		// TODO Auto-generated method stub
	String productName = "ZARA COAT 3";
	
	@Test(dataProvider = "getData", groups = {"Purchase"})
	public void submitOrder(HashMap<String, String> input) throws IOException
	{
		String countryName = "India";
		String confirmationMessage = "thankyou for the order.";

		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email") ,input.get("password") );
		
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("productName"));
		CartPage cartPage =  productCatalogue.goToCartPage();

		Assert.assertTrue(cartPage.findProductIsAdded(input.get("productName")));
		PaymentPage paymentPage =  cartPage.checkOutProductAdded(input.get("productName"));
		
		paymentPage.selectCountryInDropDown(countryName);
		ConfirmationPage confirmationPage = paymentPage.placeOrderInPaymentPage();

		System.out.println(confirmationPage.getConfirmationMessage());
		Assert.assertEquals(confirmationPage.getConfirmationMessage(), confirmationMessage); 
	}
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void productCheckInOrderPageTest() throws IOException
	{
		String countryName = "India";
		String confirmationMessage = "thankyou for the order.";

		ProductCatalogue productCatalogue = landingPage.loginApplication("InfosysInterview@gmail.com", "10A09a1995@@");
		OrderHistoryPage orderHistoryPage= productCatalogue.goToOrderHistoryPage();
		Assert.assertTrue(orderHistoryPage.verifyProductInOrderHistory(productName));
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{

		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+
				"\\src\\test\\java\\FrameworkBuildTestNGTest\\data\\PurchaseOrderData.json");
		
		return new Object[][]	{{data.get(0)} };//, {data.get(1)}};
	}
	
	/*
	 * HashMap<String, String> map1 = new HashMap<String, String>();
	 * map1.put("email", "InfosysInterview@gmail.com"); map1.put("password",
	 * "10A09a1995@@"); map1.put("productName", "ZARA COAT 3");
	 * 
	 * HashMap<String, String> map2 = new HashMap<String, String>();
	 * map2.put("email", "TestProduct@gmail.com"); map2.put("password",
	 * "10A09a1995@@"); map2.put("productName", "ADIDAS ORIGINAL");
	 */
	
	/*
	 * return new Object[][] {{"InfosysInterview@gmail.com", "10A09a1995@@",
	 * "ZARA COAT 3"} ,{"TestProduct@gmail.com","10A09a1995@@", "ADIDAS ORIGINAL"}};
	 */
	
/*	public String getScreenshotFilepath(String testCaseName) throws IOException
	{
		TakesScreenshot ts  = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "\\reports\\"+testCaseName+".png");
		FileUtils.copyFile(source, dest);
		
		return System.getProperty("user.dir") + "\\reports\\"+testCaseName+".png";
	}
*/
}
