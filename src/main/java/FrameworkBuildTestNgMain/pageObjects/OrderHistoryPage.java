package FrameworkBuildTestNgMain.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkBuildTestNgMain.AbstractComponents.AbstractComponent;

public class OrderHistoryPage extends AbstractComponent {
	
	WebDriver driver;
	
	public OrderHistoryPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//table[contains(@class,'table-hover')]//td[2])")
	List<WebElement> orderProductList;
	
	public boolean verifyProductInOrderHistory(String productName)
	{
		boolean match = orderProductList.stream().anyMatch(p -> p.getText().equalsIgnoreCase(productName));
		
		return match;
	}

}
