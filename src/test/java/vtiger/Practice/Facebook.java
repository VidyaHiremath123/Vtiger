package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) throws IOException {
		FileInputStream Fis=new FileInputStream(".\\src\\test\\resources\\CRMCommonData.properties");
		Properties p=new Properties();
		p.load(Fis);
		String BROWSER=p.getProperty("browser");
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		
		WebDriver driver=null;
		if (BROWSER.equalsIgnoreCase("chrome"))
				{
			       WebDriverManager.chromiumdriver().setup();
			       driver=new ChromeDriver();
				}
		
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("invalid browser name");
				
	   	}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.findElement(By.id("//input [@id='m_login_email']")).sendKeys(USERNAME);
		driver.findElement(By.id("//input [@id='m_login_password']")).sendKeys(PASSWORD);
		
	}		
		
		

}
