package vtiger.Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger_GenericUtilities.ExcelSheetUtility;
import vtiger_GenericUtilities.JavaUtility;
import vtiger_GenericUtilities.PropertyFileUtility;
import vtiger_GenericUtilities.WebDriverUtility;

public class WebTable 
{
	@Test
	public void webTable() throws IOException 
	{
		ExcelSheetUtility eUtil = new ExcelSheetUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		JavaUtility jUtil = new JavaUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		// Step 2: Read all the necessary Data
		
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");

		String LASTNAME = eUtil.readDataFromExcelSheetFile("contacts", 5, 2);
		String ORGNAME = eUtil.readDataFromExcelSheetFile("contacts", 5, 3)+jUtil.getRandomNumber();

		WebDriver driver = null;

		// Step 3: Launch the Browser - RUNTIME POLYMORPHISM
		if (BROWSER.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else 
		{
		
			System.out.println("invalid browser name");
		}

		Reporter.log("browser is launched");
		
		
		
		
		
		
		

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);

		// Step 4: Login to App
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		Reporter.log("logged in to App");
		//wUtil.takeScreenShot(driver,"screenshot1");

		// Step 5: Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();
		Reporter.log("navigated to organisation link");
	}
		
	}
	