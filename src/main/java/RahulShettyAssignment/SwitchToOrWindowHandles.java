package RahulShettyAssignment;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchToOrWindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		//System.out.println(driver.findElement(By.cssSelector("ul > li:nth-child(33)")).getText());
		//driver.findElement(By.cssSelector("ul > li:nth-child(33)")).getText();
		//Actions a = new Actions(driver);
		//a.moveToElement(driver.findElement(By.cssSelector("div[id='content'] > ul > li:nth-child(33)"))).build().perform();
		System.out.println(driver.findElement(By.cssSelector("div[id='content'] > ul > li:nth-child(33)")).getText());
		//driver.findElement(By.cssSelector("div[id='content'] > ul > li:nth-child(33)")).click();
		driver.findElement(By.cssSelector("div ul li:nth-child(33) a")).click();
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='content'] div h3")));
		//w.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div[id='content'] div h3"))));
		driver.findElement(By.partialLinkText("Click")).click();
		
		Set<String> windowsOrTabs = driver.getWindowHandles();
		Iterator<String> it = windowsOrTabs.iterator();
		String tab1 = it.next();
		String tab2 = it.next();
		driver.switchTo().window(tab2);
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3")));
		System.out.println(driver.findElement(By.cssSelector("h3")).getText());
		driver.switchTo().window(tab1);
		System.out.println(driver.findElement(By.cssSelector("div[id='content'] div h3")).getText());
		
		
	}

}
