package testscript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import Utility.ExcelUtility;
import constants.Constant;
import pages.AdminUserSearch;
import pages.AdminUserUpdate;
import pages.AdminUsersAdd;
import pages.Home;
import pages.LoginPage;

public class AdminUserUpdateTest extends Base{
	public Home Homepage;
	public AdminUsersAdd adminuser;
	public AdminUserSearch usersearch;
	public AdminUserUpdate update;
	 @Test
public void verifyifAdminIsAbletUpdateUserDetails() throws AWTException, IOException 
				{

			String username = ExcelUtility.readStringData(1, 0, "login");
			String password = ExcelUtility.readStringData(1, 1, "login");
	
			LoginPage login = new LoginPage(driver);
			login.enter_credentials(username, password);
				
			Homepage = login.click_signinbuton();
			adminuser = Homepage.gotoadminUser();   
	    	usersearch=adminuser.searchbutton();

			   String usernametosearch = ExcelUtility.readStringData(3, 0, "AddUser");
			    usersearch.usernameSearch("Shefeena").usernameSearch();
			    update=usersearch.editdetails();
			    update.enterpassword("password");
			    update.update();
			    update.isuserabletupdate();
              boolean isnewusersaved = update.isuserabletupdate();
	          assertTrue(isnewusersaved, Constant. ADDUSERALERTMESSAGE);
				}
}
