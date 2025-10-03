package RahulShetty;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SwitchToTabOrWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--incognito");
		//if you want to open in incognito means use below code
		//WebDriver driver = new ChromeDriver(op);
		WebDriver driver = new ChromeDriver();
		driver.get("https://FrameworkBuildTestNgMain.com/loginpagePractise/");
		driver.manage().window().maximize();
		/*
		 * nth-child(0) is invalid — indexing starts at 1 
		 * nth-of-type() is different from nth-child() — use it when targeting elements of a specific type among sibling 
		 * You can't use .class:nth-child(n) unless that class is the nth child of its parent
		 */	
		
		/*
		 * for below html 
		 * <div> 
		 * <p>Paragraph 1</p> 
		 * <span>Span 1</span> 
		 * <p>Paragraph 2</p> 
		 * <span>Span 2</span> 
		 * <p>Paragraph 3</p> 
		 * <span>Span 3</span> 
		 * </div> 
		 * give code to find span 2 element using nth-type and nth-child in cssselector
		 * By.cssSelector("div > span:nth-of-type(2)") // output: span 2
		 * By.cssSelector("div > span:nth-child(4)") // output: span 2
		 */
		//driver.findElement(By.cssSelector("div > a:nth-of-type(1)")).click(); //this will check 1st a element
		//driver.findElement(By.cssSelector("div > a:nth-chid(1)")).click(); //this will check 1st a element
		
		driver.findElement(By.xpath("//a[contains(text(),'InterviewQues')]")).click();
		Set<String> windows = driver.getWindowHandles(); //returns [parentId, childId] i.e., arrays of ids
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		driver.findElement(By.cssSelector("p.im-para.red")).getText();
		String emailId = driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim().split(" ")[1];
		System.out.println(emailId);
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(emailId);
		//String s = driver.findElement(By.cssSelector("p.im-para.red")).getText();
		//System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());
		
		
		
		
	}

}
