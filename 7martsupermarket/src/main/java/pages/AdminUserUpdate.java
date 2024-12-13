package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminUserUpdate {
 
	public WebDriver driver;
	String username;
	public AdminUserUpdate(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
		
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]") WebElement seachdetailsTable;
	@FindBy(xpath="//input[@name='password']") WebElement passwordfield;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successAlertUpdate;
	@FindBy(xpath="	//button[@name='Update']") WebElement  detailsUpdate; 

public AdminUserUpdate enterpassword(String password)
{
passwordfield.sendKeys(password);
	 return this;
}

public AdminUserUpdate update()
{
	  detailsUpdate.click();
	 return this;
}
public boolean isuserabletupdate()
{
	
   return seachdetailsTable.isDisplayed();
}

}