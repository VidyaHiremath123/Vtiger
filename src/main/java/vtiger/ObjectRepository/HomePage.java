package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger_GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	//Create a separate POM class for every element
	//Rule2:Identify all the web elements using annotations
	@FindBy(linkText="Contacts")
	private WebElement ContactsLtxt;
	
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLtxt;
	
	@FindBy(linkText="Sign Out")
	private WebElement LogOutLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}


	public WebElement getContactsLtxt() {
		return ContactsLtxt;
	}


	public WebElement getOrganizationsLtxt() {
		return OrganizationsLtxt;
	}
	public WebElement getLogOutLink() {
		return LogOutLink;
	}
	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}
	
	
	
	
	//business library
	
	
	
	
	
	
	public void clickOnOrganizationLink() {
		OrganizationsLtxt.click();
		
	}
	
	public void clickOnContactsLink()
	{
		ContactsLtxt.click();
		
	}
	public void logOutOfApp(WebDriver driver)
	{
		mouseHoverAction(driver,AdministratorImg);
		LogOutLink.click();
		
	}
	

}
