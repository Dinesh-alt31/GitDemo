package RahulShetty;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollUsingJavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://FrameworkBuildTestNgMain.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//scroll from top to bottom
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(3000);
		//scroll towards up from bottom to top
		js.executeScript("window.scrollBy({top:-1250, left:0,behaviour:'auto'})");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=-5000");

	}

}
