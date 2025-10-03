package FrameworkBuildTestNgMain.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkBuildTestNgMain.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By productBy = By.cssSelector(".mb-3");
	By addProductToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productBy);
		return products;
	}
	
	public WebElement getProductByName(String productName)
	{
		for(WebElement prod : getProductList())
		{
			if(prod.findElement(By.tagName("b")).getText().equals(productName))
			{
				System.out.println(prod.findElement(By.tagName("b")).getText());
				return prod;
				//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			}
		}
		return null;
	}

	public void addProductToCart(String productName)
	{
		if(getProductByName(productName) != null)
		{
			getProductByName(productName).findElement(addProductToCart).click();
		}
		waitForElementToDisappear(toastMessage);
	}
	
	
	
	
	
	
	
}
