package testscript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import Utility.ExcelUtility;
import constants.Constant;
import pages.CategoryAdd;
import pages.CategorySearch;
import pages.Home;
import pages.LoginPage;

public class CategorySearchTest extends Base {
  
  public Home Homepage;
	public CategoryAdd category;
	public CategorySearch search;

	@Test
	public void verifyifAdminIsAbletoSearchCategory() throws AWTException, IOException {
		LoginPage login = new LoginPage(driver); 
	String username1 = ExcelUtility.readStringData(1, 0, "login");
	String password1 = ExcelUtility.readStringData(1, 1, "login");
    login.enter_credentials(username1, password1);
	
        Homepage = login.click_signinbuton();
		category = Homepage.gotocategory();
        search=category.searchbutton();    
	   String usernametosearch = ExcelUtility.readStringData(2, 0, "Category");
	   search.searchCategory(usernametosearch).search();
	   boolean IsSearchDisplayed=search.Issearchdetailsdisplayed();
	   assertTrue(IsSearchDisplayed, Constant.NOTABLEMESSAGE);
}}
