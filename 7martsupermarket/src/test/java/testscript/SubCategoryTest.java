package testscript;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import Utility.ExcelUtility;
import constants.Constant;
import pages.Home;
import pages.LoginPage;
import pages.SubCategory;

public class SubCategoryTest extends Base {
 
public Home Homepage;
public SubCategory category;

@Test
public void verifyifAdminIsAbletoaddCategory() throws AWTException, IOException {
	LoginPage login = new LoginPage(driver); 
String username1 = ExcelUtility.readStringData(1, 0, "login");
String password1 = ExcelUtility.readStringData(1, 1, "login");

String subcategory1 = ExcelUtility.readStringData(2, 0, "category");
	login.enter_credentials(username1, password1);
	Homepage = login.click_signinbuton();
	category = Homepage.gotosubcategory();
	category.createNewCategory();
	category.Selcategory();
	category.enterdataSubcategory(subcategory1);
	category.uploadimage();
	category.savedetails();
	
	boolean isnewusersaved = category.isSavesuccess();
	assertTrue(isnewusersaved, Constant.CATEGORYALERTMESSAGE);
}
}