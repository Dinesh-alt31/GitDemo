package RahulShetty;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_Explicit_WebDriverWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//driver.manage().window().maximize();
		Wait_Explicit_WebDriverWait imp = new Wait_Explicit_WebDriverWait();
		String[] name = {"Brocolli","Cucumber", "Carrot"};
		imp.addItems(driver,name);
		
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("FrameworkBuildTestNgMain");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());

	}

	public void addItems(WebDriver driver,String[] name)
	{

		driver.get("https://FrameworkBuildTestNgMain.com/seleniumPractise/");
		List<WebElement> productNames = driver.findElements(By.xpath("//h4[@class = 'product-name']"));
//		List<String> itemList = Arrays.asList(name);
		int j = 0;
		for(int i =0;i<productNames.size();i++)
		{
			String product = productNames.get(i).getText();
			
			List<String> itemList = Arrays.asList(name);
			if(itemList.contains(product.split("-")[0].trim()))
			{
				j++;
				//dont rely on text when locating when text changes on action scenario
				//driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j == name.length)
				{
					break;
				}
				
			}
		}
		

	}
}
