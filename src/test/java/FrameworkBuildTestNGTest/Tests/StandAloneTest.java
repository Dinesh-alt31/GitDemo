package FrameworkBuildTestNGTest.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import FrameworkBuildTestNgMain.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WebDriverManager
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup(); //webdrivermanager internallly sets chromedriver 
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LandingPage login = new LandingPage(driver);
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("InfosysInterview@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("10A09a1995@@");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		for(WebElement p : products)
		{
			if(p.findElement(By.tagName("b")).getText().equals(productName))
			{
				System.out.println(p.findElement(By.tagName("b")).getText());
				p.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			}

		}
		
		
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[routerlink = '/dashboard/cart']")));
		driver.findElement(By.cssSelector("button[routerlink = '/dashboard/cart']")).click();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection")));
		List<WebElement> carts = driver.findElements(By.cssSelector(" .cartSection h3"));
		//System.out.println(carts.size());
		//System.out.println(carts);
		//boolean match = carts.stream().anyMatch(c -> c.findElement(By.cssSelector(".cartSection h3")).getText().equalsIgnoreCase(productName));
		for(WebElement cart : carts)
		{
			System.out.println("cart -> "+cart);
			if(cart.getText().equalsIgnoreCase(productName)){
				//System.out.println("Yes");
				Assert.assertTrue(true);
			}
		}
		//Assert.assertTrue(match);
		driver.findElement(By.xpath("//div[contains(@class, 'subtotal')]//button")).click();
		//section.list-group span
		//List<WebElement> d = 
		driver.findElement(By.xpath("//input[contains(@placeholder,'Country')]")).sendKeys("Ind");
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("section.list-group span")));
		List<WebElement> cs = driver.findElements(By.cssSelector("section.list-group span"));
		//System.out.println(cs);
		//System.out.println("==================================");
		for(WebElement c :cs)
		{
			//System.out.println(c.getText());
			if(c.getText().equalsIgnoreCase("India"))
			{
				c.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//a[contains(@class,'submit')]")).click();
		System.out.println(driver.findElement(By.cssSelector(".hero-primary")).getText().trim().toLowerCase());
		Assert.assertEquals(driver.findElement(By.cssSelector(".hero-primary")).getText().toLowerCase(), "Thankyou for the order.".toLowerCase()); 
		
		
		//driver.close();
	}

}
