package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.PageUtility;
import Utility.WaitUtility;

public class AdminUserSearch {

		public WebDriver driver;
		String username;
		public AdminUserSearch(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
	
	@FindBy(xpath="//input[@id='un']")WebElement searchUsernamefield;
	@FindBy(xpath="//select[@id='ut']") WebElement Searchusertypedropdown;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]") WebElement searchDetailsTable;
	@FindBy(xpath="//center[text()='.........RESULT NOT FOUND.......']") WebElement resultnotfound;	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]") List<WebElement> searchcolumn;
	@FindBy(xpath="//button[@name='Search']") WebElement searchbutton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/user/edit?edit=10827&page_ad=1']") WebElement editUSerDetails;
	
	public AdminUserSearch usernameSearch(String username)
	{
	searchUsernamefield.sendKeys(username);
		return this;
	}
	public AdminUserSearch usertypeSearch()
	{
		PageUtility page=new PageUtility();
		page.selectByIndex(Searchusertypedropdown,2);
		return this;
		}
	public AdminUserSearch searchoption()
	{
	searchbutton.click();
	return this;
	}
	
	public AdminUserSearch Search_ParticularElements()
	{
	for(WebElement element: searchcolumn)
	{
	if(element.getText().equalsIgnoreCase(username))
	{
	System.out.println("Searched username is " +element.getText());
	}
	} return this;
	}
	public boolean Iserrormessagedisplayed()
	{
		System.out.println("Search detail is" +resultnotfound.getText());
	   return searchDetailsTable.isDisplayed();
	}
	public boolean Issearchdetailsdisplayed(){
		
		System.out.println("Search detail is" +searchDetailsTable.getText());
	   return searchDetailsTable.isDisplayed();
	}


public AdminUserUpdate editdetails()
{
	searchDetailsTable.isSelected();
	 System.out.println("Details of user searched " +	searchDetailsTable.getText());
	 editUSerDetails.click();
	 return new AdminUserUpdate(driver);
}
public AdminUserSearch usernameSearch()
{
searchoption.click();
	return this;
}
@FindBy(xpath="//button[@name='Search']") WebElement searchoption;

}
