package FrameworkBuildTestNGTest.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import FrameworkBuildTestNGTest.data.ExtentReportNG;
import FrameworkBuildTestNgMain.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;
	public String headlessFlag;
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\FrameworkBuildTestNgMain\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName= System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
		headlessFlag = System.getProperty("headless") != null ? System.getProperty("headless") : prop.getProperty("headless");
		//ExtenReport = ExtentReportNG.getReportObject(headlessFlag);
		System.out.println("***********************");
		System.out.println("browserName = "+browserName);
		System.out.println("headlessFlag = "+headlessFlag);
		System.out.println("***********************");
		//String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(headlessFlag.equalsIgnoreCase("true"))
			{
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1440,900");
			}
			driver = new ChromeDriver(options);
			//driver.manage().window().setSize(new Dimension(1440, 900));
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			EdgeOptions options = new EdgeOptions();
			if(headlessFlag.equalsIgnoreCase("true"))
			{
				options.addArguments("--headless");
				options.addArguments("--window-size=1440,900");
			}
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(options);
			/*
			 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver();
			 */			
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		return driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage launchApplication() throws IOException
	{
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		driver.close();
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
	{
		String jsonContent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
		});
		
		return data;
	}
	
	public String getScreenshotFilepath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts  = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "\\reportForFrameWork\\"+testCaseName+".png");
		FileUtils.copyFile(source, dest);
		
		return System.getProperty("user.dir") + "\\reportForFrameWork\\"+testCaseName+".png";
	}
}
