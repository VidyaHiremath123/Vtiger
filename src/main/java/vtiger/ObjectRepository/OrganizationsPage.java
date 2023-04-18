package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateOrgLookUpImg;
	
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}
	
	
	
	

//business library

    public void clickOnCreateOrganizationLookUpImg()
      {
	    CreateOrgLookUpImg.click();
     }
	
}