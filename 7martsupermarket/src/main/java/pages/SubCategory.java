package pages;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.FileUploadUtility;
import Utility.PageUtility;
import constants.Constant;

public class SubCategory {
	public WebDriver driver;
	public SubCategory(WebDriver driver)
	{
	this.driver=driver; 
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement NewButton;	
	@FindBy(id="cat_id") WebElement CategoryDropDown;
	@FindBy(id="subcategory") WebElement SubCategoryfield;
	@FindBy(id="main_img") WebElement  ImageChoose;
	@FindBy(xpath="//button[@type='submit']") WebElement SaveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement AlertSaveSuccess;

public SubCategory createNewCategory()
{
	NewButton.click();
return  this;
	}

public SubCategory Selcategory()
{
	CategoryDropDown.click();
	PageUtility page= new PageUtility();
	page.selectByIndex(CategoryDropDown,2);
    return  this;

}
public SubCategory enterdataSubcategory(String subcategory1)
{
	
	JavascriptExecutor javascript=(JavascriptExecutor)driver;
	javascript.executeScript("arguments[0].click();",SubCategoryfield);

	SubCategoryfield.sendKeys(subcategory1);
	return this;
}
public SubCategory Subcategoryclick()
{
ImageChoose.click(); return this;
}

public SubCategory uploadimage() throws AWTException
{
	String image2=Constant.SUBCATEGORYIMAGEPATH;
	
	JavascriptExecutor javascript=(JavascriptExecutor)driver;
	javascript.executeScript("window.scrollTo(0,1000)");
FileUploadUtility image=new FileUploadUtility(); 
image.sendKeysProfileUpload(ImageChoose,image2);
return this;
}
	public SubCategory savedetails()
{
		
	SaveButton.click();
    return  this;
} 
public boolean isSavesuccess() 
{
return 	AlertSaveSuccess.isDisplayed();
}
	
}



