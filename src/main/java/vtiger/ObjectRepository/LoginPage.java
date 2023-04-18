package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//Create a separate POM class for every element
	//Rule2:Identify all the web elements using annotations
	@FindBy(name="user_name")
	private WebElement UserNameEdt;
	
	@FindBy(name="user_password")
	private WebElement PasswordEdt;

	
    @FindAll ({@FindBy(id= "submitButton"), @FindBy(xpath="//input[@type='submit']")})
	private WebElement SubmitBtn;
	
	//Rule3:Initialize these web elements with a constructor
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	//rule 4 provide getters to access these elements

	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}
	//Business Library Generic methods project specific
	 /*this method will login to applicatin
	  * 
	  */
	public void loginToApp(String USERNAME,String PASSWORD)
	{
		UserNameEdt.sendKeys(USERNAME);
		PasswordEdt.sendKeys(PASSWORD);
		SubmitBtn.click();
		
	}

}
