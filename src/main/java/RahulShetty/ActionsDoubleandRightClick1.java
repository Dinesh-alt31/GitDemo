package RahulShetty;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

class CustomClass
{
	public int customClassStatus = 0;
	protected int status;
}

public class ActionsDoubleandRightClick1 {
	
	int thisclasstatus = 0;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ActionsDoubleandRightClick1 thisclassObject = new ActionsDoubleandRightClick1();
		CustomClass customClassObject = new CustomClass();
		
		ChromeOptions op = new ChromeOptions();
		//op.addArguments("--incognito");
		//WebDriver driver = new ChromeDriver(op);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.amazon.com/");
		driver.findElement(By.xpath("//button[contains(text(), 'shopping')]")).click();
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-bb-search")));
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Search Amazon']/parent::div[@class='nav-search-field ']")));
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
		Actions a = new Actions(driver);
		//a.moveToElement(driver.findElement(By.xpath("//label[text()='Search Amazon']/parent::div[@class='nav-search-field ']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		//a.moveToElement(driver.findElement(By.cssSelector("#nav-bb-search"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		//a.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		//#twotabsearchtextbox
		final int[] useArray = {0};
		
		AtomicInteger atomicIntObj = new AtomicInteger(0);
		
        FluentWait<WebDriver> wf = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

            WebElement element = wf.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {

                	
                    List<WebElement> el1 = driver.findElements(By.cssSelector("#nav-bb-search"));
                    List<WebElement> el2 = driver.findElements(By.id("twotabsearchtextbox"));
                    if (!el1.isEmpty() && el1.get(0).isDisplayed()) 
                    {
                    	//following are ways to use global variable to use inside lamba function
                    	atomicIntObj.set(1);
                    	customClassObject.status = 1;
                    	thisclassObject.thisclasstatus = 1;
                    	useArray[0] = 1;
                    	
                        return el1.get(0);
                    }
                    else if (!el2.isEmpty() && el2.get(0).isDisplayed()) 
                    {
                    	atomicIntObj.set(2);
                    	customClassObject.status = 2;
                    	thisclassObject.thisclasstatus = 2;
                    	useArray[0] = 2;
                    	
                        return el2.get(0);
                    }               	
                	else
                	{
                		return null;
                	}
                    
                }
            });
            


            String elementGetText = element.getText(); //get text method returns null because in dom there is no text present for that element
            
            System.out.println("Element Get Text = [     "+elementGetText+ "   ]");
            if(atomicIntObj.get() == 1 && customClassObject.status == 1 && thisclassObject.thisclasstatus == 1 && useArray[0] == 1)
            {
            	a.moveToElement(driver.findElement(By.cssSelector("#nav-bb-search"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
            }
            else if(atomicIntObj.get() == 2 && customClassObject.status == 2 && thisclassObject.thisclasstatus == 2 && useArray[0] == 2)
            {
            	WebElement move = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
            	a.moveToElement(driver.findElement(By.xpath("//div[text()='EN']"))).build().perform();            	
            	driver.findElement(By.xpath("//input[@data-action-type = 'DISMISS']")).click();            	
            	a.moveToElement(move).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
            	a.moveToElement(move).click().keyDown(Keys.SHIFT).sendKeys("World").doubleClick().build().perform();
            	a.moveToElement(driver.findElement(By.xpath("//div[@class='nav-line-1-container']"))).contextClick().build().perform();
            }

	}

}
