package FrameworkBuildTestNgMain.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import FrameworkBuildTestNgMain.pageObjects.CartPage;
import FrameworkBuildTestNgMain.pageObjects.OrderHistoryPage;

public class AbstractComponent {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	public AbstractComponent(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = "button[routerlink = '/dashboard/cart']")
	WebElement cartHeader;
	
	@FindBy(css = "button[routerlink *='myorders']")
	WebElement orderHeader;
	
	public void elementClickInterCeptedClickFix(WebElement ele)
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		try{
			ele.click();
		}
		catch(ElementClickInterceptedException e){
			js.executeScript("arguments[0].click();", ele);
		}
	}
	
	public void elementClickInterCeptedClickFixWithByLocator(By findBy)
	{
		js = (JavascriptExecutor) driver;		
		try {
			System.out.println("inside try before click");
			driver.findElement(findBy).click();
			System.out.println("inside try ater click");
		}  
		catch(ElementClickInterceptedException  e){
			System.out.println("inside catch before js ElementClickInterceptedException");
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(findBy));
			js.executeScript("arguments[0].click();", driver.findElement(findBy));
			System.out.println("inside catch after js ElementClickInterceptedException");
		}
		catch(StaleElementReferenceException  e){
			System.out.println("inside catch before js StaleElementReferenceException");
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(findBy));
			js.executeScript("arguments[0].click();", driver.findElement(findBy));
			System.out.println("inside catch after js StaleElementReferenceException");
		}
	}
	public void waitForElementToAppear(By findBy)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForElementToDisappear(By findBy)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	public void waitForElementToClickable(By findBy)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
		
	}
	public CartPage goToCartPage()
	{
		waitForElementToClickableByWebElement(cartHeader);
		elementClickInterCeptedClickFix(cartHeader);
		return new CartPage(driver);
	}
	
	public void waitForElementToAppearByWebElement(WebElement we)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	public void waitForElementToClickableByWebElement(WebElement we)
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(we) );
	}
	
	public OrderHistoryPage goToOrderHistoryPage()
	{
		elementClickInterCeptedClickFix(orderHeader);
		//orderHeader.click();
		return new OrderHistoryPage(driver);
	}
	
}
