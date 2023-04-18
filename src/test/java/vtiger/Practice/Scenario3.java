package vtiger.Practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario3 {

	public static void main(String[] args) {
		Random r=new Random();
		 int value = r.nextInt(10000);
		WebDriverManager.chromedriver().setup();
				ChromeDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver . get("http://localhost:8888");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		
		 driver.findElement(By.xpath("//a[.='Organizations']")).click();
		 driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		 driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys("facebook"+value);
		 WebElement ind = driver.findElement(By.name("industry"));
		 Select sel= new Select(ind);
		 sel.selectByValue("Chemicals");
		 driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		 String val = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 if(val.contains("facebook"))
		 {
			 System.out.println("passed");
		 }
		 else
		 {
			 System.out.println("failed");
		 }
		    Actions actions = new Actions(driver);
			WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			actions.moveToElement(ele).perform();
			driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			 
		 }
		 
	
				 
		 

	}


