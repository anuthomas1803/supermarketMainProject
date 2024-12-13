package pages;

import java.util.Locale.Category;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Home {
	 
		public WebDriver driver;
		public Home(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		@FindBy(xpath="//img[@class='img-circle']")WebElement Admin;
		@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")WebElement logout;
		@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement moreinfoAdminUser;	
		@FindBy(xpath="/html/body/div/div[1]/section/div/div/div[4]/div/a") WebElement moreinfoSubCategory;
		@FindBy(xpath="/html/body/div/div[1]/section/div/div/div[9]/div/a") WebElement managenewsmoreinfo;
		@FindBy(xpath="/html/body/div/div[1]/section/div/div/div[3]/div/a") WebElement moreinfoCategory;
		@FindBy(xpath="/html/body/div/div[1]/section/div/div/div[8]/div/a") WebElement manageProductMoreInfo;
		
		public Home logout()
		{
			Admin.click();
			logout.click();
			return this;
		}
		public  AdminUsersAdd gotoadminUser()
		{
			
			JavascriptExecutor javascript=(JavascriptExecutor)driver;
			javascript.executeScript("arguments[0].click();",moreinfoAdminUser);
			
			return new AdminUsersAdd(driver);
		}
		
		public SubCategory gotosubcategory()
		{
			JavascriptExecutor javascript=(JavascriptExecutor)driver;
			javascript.executeScript("arguments[0].click();",moreinfoSubCategory);
			return new SubCategory(driver); 
		}
		

		public CategoryAdd gotocategory()
		{
			JavascriptExecutor javascript=(JavascriptExecutor)driver;
			javascript.executeScript("arguments[0].click();",moreinfoCategory);
			return new CategoryAdd(driver); 
		}
		
		
		public ManageProduct gotoManageProduct()
		{
			JavascriptExecutor javascript=(JavascriptExecutor)driver;
			javascript.executeScript("arguments[0].click();",manageProductMoreInfo);
			return new  ManageProduct(driver);
		}
		
		public ManageNews gotomanagenews()

		{
			JavascriptExecutor javascript=(JavascriptExecutor)driver;
			javascript.executeScript("arguments[0].click();",managenewsmoreinfo);
			return new ManageNews(driver); 
		}
		
			}


