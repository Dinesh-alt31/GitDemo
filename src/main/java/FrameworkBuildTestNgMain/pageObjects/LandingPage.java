package FrameworkBuildTestNgMain.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FrameworkBuildTestNgMain.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;
	JavascriptExecutor js;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(xpath = "//div[contains(@class,'toast-message')]")
	WebElement errorMessage;
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}

	
	public ProductCatalogue loginApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		waitForElementToClickableByWebElement(submit);
		elementClickInterCeptedClickFix(submit);
		//submit.click();
		return new ProductCatalogue(driver);
	}
	
	public String  getErrorMessage()
	{
		waitForElementToAppearByWebElement(errorMessage);
		System.out.println("$"+errorMessage.getText()+"$");
		return errorMessage.getText();
	}

	

}
