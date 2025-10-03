package FrameworkBuildTestNgMain.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import FrameworkBuildTestNgMain.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".cartSection h3")
	List<WebElement> carts;
	
	@FindBy(xpath = "//div[contains(@class, 'subtotal')]//button")
	WebElement checkOutButton;
	
	public boolean findProductIsAdded(String productName)
	{
		for(WebElement cart : carts)
		{
			System.out.println("cart -> "+cart);
			if(cart.getText().equalsIgnoreCase(productName)){
				//System.out.println("Yes");
				//Assert.assertTrue(true);
				return true;
			}
		}
		
		return false;
	}
	
	public PaymentPage checkOutProductAdded(String productName)
	{
		if(findProductIsAdded(productName))
		{
			elementClickInterCeptedClickFix(checkOutButton);
			//checkOutButton.click();
		}
		return new PaymentPage(driver);
	}
	
	

	


}
