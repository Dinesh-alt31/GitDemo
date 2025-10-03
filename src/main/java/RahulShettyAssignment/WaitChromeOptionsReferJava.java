package RahulShettyAssignment;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitChromeOptionsReferJava {

	private static final HashMap String = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//suppress this pop-up by launching Chrome with specific options using ChromeOptions.
		
		//Option									|	Purpose
		//--disable-save-password-bubble			|	Prevents Chrome from showing the "Save password?" bubble
		//credentials_enable_service: false			|	Disables Chrome’s credential service
		//profile.password_manager_enabled: false	|	Turns off the password manager UI
		
        //Create ChromeOptions to disable password manager
		String[] itemName = {"iphone X","Nokia Edge"};
		
		ChromeOptions options = new ChromeOptions();
		String profilePath = "C:/Temp/ChromeProfile_" + System.currentTimeMillis();
		options.addArguments("user-data-dir=" + profilePath);
		options.addArguments("--incognito");
//		options.addArguments("--disable-save-password-bubble");
//		options.addArguments("--disable-extensions");
//		options.addArguments("--disable-popup-blocking");
//		options.addArguments("--disable-notifications");
//		options.addArguments("--no-sandbox");
//		options.addArguments("--disable-dev-shm-usage");

//		Map<String, Object> prefs = new HashMap<>();
//		prefs.put("credentials_enable_service", false);
//		prefs.put("profile.password_manager_enabled", false);
//		options.setExperimentalOption("prefs", prefs);
		
        
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-save-password-bubble");
//        options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {{
//            put("credentials_enable_service", false);
//            put("profile.password_manager_enabled", false);
//        }});
		
		WebDriver driver = new ChromeDriver(options);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://FrameworkBuildTestNgMain.com/loginpagePractise/");
		
			
		driver.findElement(By.id("username")).sendKeys("FrameworkBuildTestNgMain");
		driver.findElement(By.id("password")).sendKeys("learning");
		
		driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();
		
		//driver.findElement(By.cssSelector("input[value='user']")).click();	
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Okay')]"))));
		driver.findElement(By.xpath("//button[contains(text(),'Okay')]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select.form-control")));
		WebElement opt = driver.findElement(By.cssSelector("select.form-control"));
		Select op = new Select(opt);
		op.selectByValue("consult");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("terms")));
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("terms"))));
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.cssSelector(".btn.btn-info.btn-md")).click();
		//wait.until(ExpectedConditions.alertIsPresent());
		//driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.urlToBe("https://FrameworkBuildTestNgMain.com/angularpractice/shop"));
		System.out.println(driver.findElement(By.xpath("//a[text()='ProtoCommerce Home']")).getText());

		
		WaitChromeOptionsReferJava wc = new WaitChromeOptionsReferJava();
		wc.addItem(driver, itemName);
		
		driver.findElement(By.partialLinkText("Checkout")).click();
		//driver.findElement(By.xpath("//a[contains(text(), 'Checkout ')]/parent::li")).click();
		System.out.println(driver.findElement(By.xpath("//button[@class='btn btn-default']")).getText());

	}
	
	public void addItem(WebDriver driver, String[] itemName)
	{
		int j = 0;
		List<WebElement> items = driver.findElements(By.cssSelector("h4.card-title"));
		for(int i = 0;i<items.size(); i++)
		{
			List<String> list = Arrays.asList(itemName);
			if(list.contains(items.get(i).getText()))
			{
				j++;
				driver.findElements(By.cssSelector("button.btn.btn-info")).get(i).click();
				
				if(j == itemName.length)
				{
					break;
				}
			}
		}
	}

}
