package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProduct { 

	public WebDriver driver;
	public ManageProduct(WebDriver driver)
	{
	this.driver=driver;	
	PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[3]") WebElement selectAProduct;
	@FindBy(xpath="//i[@class='fas fa-trash-alt']") WebElement delete;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successAlert;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Product/stock?id=605&st=yes&page_ad=1']")  WebElement featured;
	public ManageProduct selectProduct()
	{
		selectAProduct.isSelected();
		return this;
	}
	public ManageProduct deleteProduct()
	{
	    delete.click();  
		return this;
	}
	
	public ManageProduct confirmDelete()
	{
		driver.switchTo().alert().accept();
	    return this;
	}

	public boolean isDeleteSuccess()
	{
		return successAlert.isDisplayed();
	}
	
	}
