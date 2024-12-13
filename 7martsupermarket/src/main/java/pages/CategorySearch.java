package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategorySearch {
		public WebDriver driver;

		public CategorySearch(WebDriver driver)
		{  this.driver=driver;
		PageFactory.initElements(driver,this);
		}
		 
	@FindBy(xpath="//input[@class='form-control']")	WebElement enterCategoryField;
	@FindBy(xpath="//button[@type='submit']") WebElement search;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]") WebElement searchDetailsTable;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")WebElement editbutton;
	
public CategorySearch searchCategory(String category)
{
	enterCategoryField.sendKeys(category);
	return this;
}
public CategorySearch search()
{
	search.click();
	return this;
}		

public boolean Issearchdetailsdisplayed(){
	
	System.out.println("Search detail is " +searchDetailsTable.getText());
   return searchDetailsTable.isDisplayed();
}}