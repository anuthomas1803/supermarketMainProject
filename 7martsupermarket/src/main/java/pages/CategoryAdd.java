package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.FileUploadUtility;
import Utility.PageUtility;
import Utility.WaitUtility;
import constants.Constant;

public class CategoryAdd {
public WebDriver driver;

public CategoryAdd(WebDriver driver)
{  this.driver=driver;
PageFactory.initElements(driver,this);
}

@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newOption;
@FindBy(id="category") WebElement categoryField;
@FindBy(id="134-selectable") WebElement group1;
@FindBy(xpath="//div[@class='ms-selection")  WebElement group2;
@FindBy(xpath="//input[@type='file']") WebElement imageBrowse;
@FindBy(xpath="//label[text()='Show On Top Menu']") WebElement showOnTopMenu;
@FindBy(xpath="//label[text()='Show On Left Menu']") WebElement showOnLeftMenu;
@FindBy(xpath="//button[@name='create']") WebElement savebutton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successAlert;
@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement searchOption;

public CategoryAdd newCategory()
{
	newOption.click();
	return this;
}


public CategoryAdd enterCategoryField(String category)
{
	categoryField.sendKeys(category);
	return this;
}
public CategoryAdd selectGroups()
{
group1.click();
return this;
}
public CategoryAdd uploadImage()
{
	JavascriptExecutor javascript=(JavascriptExecutor)driver;
	javascript.executeScript("window.scrollBy(0,1000)", "");
	FileUploadUtility page=new FileUploadUtility();
	page.sendKeysProfileUpload(imageBrowse, Constant.SUBCATEGORYIMAGEPATH);
	return this;
}
public CategoryAdd showOnMenuTop()
{
	JavascriptExecutor javascript=(JavascriptExecutor)driver;
	javascript.executeScript("window.scrollBy(0,4500)", "");
	
	showOnTopMenu.click();
	return this;
}
public CategoryAdd showOnMenuLeft()
{

	JavascriptExecutor javascript=(JavascriptExecutor)driver;
	javascript.executeScript("window.scrollBy(0,2000)", "");
	showOnLeftMenu.click();
	return this;
	
}
public CategoryAdd saveDetails()
{

	
	WaitUtility wait=new WaitUtility();
	wait.waitForELementsToClick( driver,savebutton);
	
	JavascriptExecutor javascript1=(JavascriptExecutor)driver;
	javascript1.executeScript("arguments[0].click();",savebutton);
	return this;   
}
public boolean isUserAbleToSave()
{
return successAlert.isDisplayed();	
}

public CategorySearch searchbutton()
{
	
JavascriptExecutor javascript=(JavascriptExecutor)driver;
javascript.executeScript("arguments[0].click();",searchOption);
return new CategorySearch(driver);
}   
}