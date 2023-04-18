package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage
{
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryDropDwn;
	
	@FindBy(name="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}


	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}


	public WebElement getIndustryDropDwn() {
		return IndustryDropDwn;
	}


	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	 
	public void createNewOrganizationPage(String ORGNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		SaveBtn.click();
		
	}
	//public void createNewOrganization(String ORGNAME,String INDUSTRY)
	//{
		//OrgNameEdt.sendKeys(ORGNAME);
		//handleDropdown(IndustryDropDwn,INDUSTRY);
		//SaveBtn.click();
		
	//}

		
	
	
	
	
	

}
