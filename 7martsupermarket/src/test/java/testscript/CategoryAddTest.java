package testscript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;

import Utility.ExcelUtility;
import constants.Constant;
import pages.CategoryAdd;
import pages.Home;
import pages.LoginPage;

public class CategoryAddTest extends Base {
	 
	public Home Homepage;
	public CategoryAdd category;

	@Test
	public void verifyifAdminIsAbletoaddCategory() throws AWTException, IOException {
		LoginPage login = new LoginPage(driver); 
	String username1 = ExcelUtility.readStringData(1, 0, "login");
	String password1 = ExcelUtility.readStringData(1, 1, "login");

	
		login.enter_credentials(username1, password1);
		Homepage = login.click_signinbuton();
		category = Homepage.gotocategory();
		category.newCategory();
		String categorydata = ExcelUtility.readStringData(3, 0, "Category");
		category.enterCategoryField(categorydata);
		category.selectGroups();
		category.uploadImage();
		category.showOnMenuTop();
		category.showOnMenuLeft();
		category.saveDetails();
		boolean isnewusersaved = category.isUserAbleToSave();
		assertTrue(isnewusersaved, Constant.CATEGORYALERTMESSAGE);
	}
	}