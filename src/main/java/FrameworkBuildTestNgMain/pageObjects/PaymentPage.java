package FrameworkBuildTestNgMain.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkBuildTestNgMain.AbstractComponents.AbstractComponent;

public class PaymentPage extends AbstractComponent {

	WebDriver driver;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Country')]")
	WebElement countryField;
	
	@FindBy(xpath = "//a[contains(@class,'submit')]")
	WebElement placeOrderButton;
	
	By dropdownBy = By.cssSelector("section.list-group span");
	
	public PaymentPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	public List<WebElement> sendCountryInField(String country)
	{
		//System.out.println("before sendCountryInField");
		countryField.sendKeys(country);
		//System.out.println("after sendCountryInField");
		return getCountryList();
	}
	public List<WebElement> getCountryList()
	{
		//System.out.println("before getCountryList");
		waitForElementToClickable(dropdownBy);
		List<WebElement> countryList = driver.findElements(dropdownBy);
		return countryList;
	}
	public void selectCountryInDropDown(String country)
	{
		//System.out.println("1");
		List<WebElement> countryList= sendCountryInField(country);
		
		waitForElementToClickable(dropdownBy);
		int size = countryList.size();
		
		for(int i=0;i<size;i++)
		{
			WebElement option = driver.findElements(dropdownBy).get(i);
			if(option.getText().equalsIgnoreCase(country))
			{
				System.out.println("Inside if option.getText() = " +option.getText());
				elementClickInterCeptedClickFixWithByLocator(dropdownBy);
				System.out.println("Inside if option.getText() =  after click");
				//
				
				//System.out.println("After click option.getText() = " +option.getText());
				break;
			}
		}
		
	}
		
/*		for(WebElement countryToSelect :countryList)
		{
			
			if(countryToSelect.getText().equalsIgnoreCase(country))
			{
				System.out.println("Inside if countryToSelect.getText() = " +countryToSelect.getText());

				elementClickInterCeptedClickFixWithByLocator(dropdownBy);
				
				System.out.println("After click countryToSelect.getText() = " +countryToSelect.getText());
				break;
			}
		}
	}
*/
	
	public ConfirmationPage placeOrderInPaymentPage()
	{
		elementClickInterCeptedClickFix(placeOrderButton);
		//placeOrderButton.click();
		
		return new ConfirmationPage(driver);
	}
}
