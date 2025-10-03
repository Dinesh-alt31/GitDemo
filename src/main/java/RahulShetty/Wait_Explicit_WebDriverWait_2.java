package RahulShetty;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_Explicit_WebDriverWait_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver  = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(By.cssSelector("div#start button")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish h4")));
		
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#finish h4")));
		System.out.println(driver.findElement(By.cssSelector("div#finish h4")).isDisplayed());
		
	}

}
