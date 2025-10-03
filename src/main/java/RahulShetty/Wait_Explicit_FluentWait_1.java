package RahulShetty;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class Wait_Explicit_FluentWait_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		String profilepath = "C:/Temp/ChromeProfile" + System.currentTimeMillis();
		option.addArguments("user-data-dir=" + profilepath);
		option.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		driver.findElement(By.cssSelector("div#start button")).click();
		
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

            WebElement element = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(By.cssSelector("div#finish h4"));
                }
            });
            
			/*
			 * reason isdisplayed shows false because "div#finish h4" present in dom but not
			 * clickable or showing in front end
			 */
            System.out.println(driver.findElement(By.cssSelector("div#finish h4")).isDisplayed());

	}

}
