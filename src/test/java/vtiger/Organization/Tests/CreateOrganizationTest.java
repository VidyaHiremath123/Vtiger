package vtiger.Organization.Tests;



import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger_GenericUtilities.ExcelSheetUtility;
import vtiger_GenericUtilities.JavaUtility;
import vtiger_GenericUtilities.PropertyFileUtility;
import vtiger_GenericUtilities.WebDriverUtility;

public class CreateOrganizationTest 
		{
			
			@Test
			public void createOrganizationTest() throws IOException
			
			{
		
				
				
				//Step 1: Create Object of Generic Utilities
				ExcelSheetUtility eUtil = new ExcelSheetUtility();
				PropertyFileUtility pUtil = new PropertyFileUtility();
				JavaUtility jUtil = new JavaUtility();
				WebDriverUtility wUtil = new WebDriverUtility();
				
				//Step 2: Read all the required Data
				//String URL = pUtil.readDataFromPropertyFile("url");
				//String BROWSER = pUtil.readDataFromPropertyFile("browser");
				String USERNAME = pUtil.readDataFromPropertyFile("username");
				String PASSWORD = pUtil.readDataFromPropertyFile("password");
				
				String ORGNAME = eUtil.readDataFromExcelSheetFile("Organisation", 1, 2)+jUtil.getRandomNumber();

				WebDriverManager.firefoxdriver().setup();
				WebDriver driver = new FirefoxDriver();
				
				
				
				wUtil.maximizeWindow(driver);
				wUtil.waitForPageLoad(driver);
				driver.get("http://localhost:8888");
				
				//Step 4: Login to App
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//Step 5: Navigate to Organizations link
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step 6: Click on Create Organization Look up Image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//Step 7: Create organization with mandatory Fields
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				
				//Step 8: Save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				
				
				//Step 9: Validate for Organization
				String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(OrgHeader.contains(ORGNAME))
				{
					System.out.println(OrgHeader+" ---- PASS ----");
				}
				else
				{
					System.out.println(" ---- Failed ----");
				}
				
				//Step 10: Logout of app
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wUtil.mouseHoverAction(driver, ele);
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("Sign out successful");
			}
			 // @Test
			  
				public void demo1()
				{
				System.out.println("demo");	
				}
				//Step 11: close the browser
				//driver.quit();
				
				
				
			

			
			

			
			}

		

	


