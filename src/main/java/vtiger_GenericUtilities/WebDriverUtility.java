package vtiger_GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/** this class consist of generic method related to web driver actions
	 * @author Vidya
	 * 
	 * 
	 */
	public class WebDriverUtility 
	{ 
		public void waitForPageLoad(WebDriver driver)
		{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		/**This Method will maximize the window
		 * @author Vidya
		 * 
		 * 
		 */
		public void maximizeWindow(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
		/**this method will minimize the window
		 * @author Vidya
		 * 
		 */
		public void minimizeWindow(WebDriver driver)
		{
			driver.manage().window().minimize();
			
		}
		/**this method will perform mousehover action
		 * @author Vidya
		 */
	    public void mouseHoverAction(WebDriver driver ,WebElement element)
	    {
	    	Actions act=new Actions(driver);
	    	act.moveToElement(element).perform();
	    	
	    	
	    }
	    /**this method perform rightClick Action
	     * 
	     * @param driver
	     */
	    public void rightClickAction(WebDriver driver)
	    {
	    	Actions act=new Actions(driver);
	    	act.contextClick().perform();
	    	
	    	
	    }
	    public void rightClickAction(WebDriver driver,WebElement element)
	    {
	    	Actions act=new Actions(driver);
	    	act.contextClick(element).perform();
	    	
	    	
	    }
	    public void doubleClickAction(WebDriver driver)
	    {
	    	Actions act=new Actions(driver);
	    	act.doubleClick().perform();
	    	
	    }
	    public void doubleClickAction(WebDriver driver,WebElement element)
	    {
	    	Actions act=new Actions(driver);
	    	act.doubleClick(element).perform();

         }
	    public void dragAndDropAction(WebDriver driver,WebElement srcElement,WebElement destElement)
	    {
	    	Actions act=new Actions(driver);
	    	act.dragAndDrop(srcElement, destElement).perform();
	    	
	    }
	    public void pressEnterKey() throws AWTException
	    {
	    Robot r=new Robot();
	    r.keyRelease(KeyEvent.VK_ENTER);
	    }
	    public void acceptAlert(WebDriver driver)
	    {
	    	driver.switchTo().alert().accept();
	    }
	    public void dismissAlert(WebDriver driver)
	    {
	    	driver.switchTo().alert().dismiss();
	    	
	    }
	    public String getAlertText(WebDriver driver)
	    {
	    	return driver.switchTo().alert().getText();
	    
	    }
	    public void handleFrame(WebDriver driver,int index)
	    {
	    	driver.switchTo().frame(index);
	    }
	    public void handleFrame(WebDriver driver ,String nameOrId)
	    {
	    	driver.switchTo().frame(nameOrId);
	    }
	    public void handleFrame(WebDriver driver,WebElement element)
	    {
	    	driver.switchTo().frame(element);
	    }
	    public void handleParentFrame(WebDriver driver)
	    {
	    	driver.switchTo().parentFrame();
	    }
	    public String takeScreenShot(WebDriver driver,String screenShotName) throws IOException
	    
	    { 
	    	TakesScreenshot ts =(TakesScreenshot) driver;
	    	File src=ts.getScreenshotAs(OutputType.FILE);
	    	File dest=new File(".\\ScreenShot\\"+screenShotName+".png");
	        FileUtils.copyFile(src, dest);//common io dependency
	    	return dest.getAbsolutePath();//used in extent Report
	    }
	    public void switchToWindow(WebDriver driver,String partialWinTitle)
	    {
	    	//capture all the window ids
	    	Set<String> winIds=driver.getWindowHandles();
	    	//use for each loop and navigate to each window
	    	for(String win:winIds)
	    	{
	    		//capture the title of each window
	    		String currentTitle=driver.switchTo().window(win).getTitle();
	    		//compare the current title with partial window title
	    		if(currentTitle.contains(partialWinTitle))
	    		{
	    			break;
	    		}
	    	}
	    }
	    	public void scrollAction(WebDriver driver)
	    	{
	    		JavascriptExecutor js=(JavascriptExecutor) driver;
	    		js.executeScript("window.scrollBy(0,500)", "");
	    		
	    		
	    	}
	    	public void scrollAction(WebDriver driver,WebElement element)
	    	{
	    		JavascriptExecutor js=(JavascriptExecutor) driver;
	    		int y=element.getLocation().getY();
	    		js.executeScript("window,scrollBy(0,"+y+")",element);
	    	
	    	
	    	
	    	
	    	
	          }
	    	public void handleDropdown (String Text,WebElement element)
	    	{
	    		
	    	Select sel=new Select(element);
	    	sel.selectByVisibleText(Text);
	    	}
	    	
	    	public void handleDropdown( WebElement element,int index )
	    	{
	    		
	    	Select sel=new Select(element);
	    	sel.selectByIndex(index);
	    	}
	    	
	    	public void handleDropdown(WebElement element,String Value)
	    	{
	    		
	    	Select sel=new Select(element);
	    	sel.selectByValue(Value);
	    	}
	}
	    	
			
