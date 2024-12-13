package testscript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.ExcelUtility;
import constants.Constant;
import pages.AdminUserSearch;
import pages.AdminUsersAdd;
import pages.Home;
import pages.LoginPage;

public class AdminUserSearchTest extends Base{

	public Home Homepage;
	public AdminUsersAdd adminuser;
	public AdminUserSearch usersearch;
   
	 @Test
 public void verifyifAdminIsAbletosearchnewuser() throws AWTException, IOException 
				{

			String username = ExcelUtility.readStringData(1, 0, "login");
			String password = ExcelUtility.readStringData(1, 1, "login");
	
			LoginPage login = new LoginPage(driver);
			login.enter_credentials(username, password);
				
			Homepage = login.click_signinbuton();
			adminuser = Homepage.gotoadminUser();   
	    	usersearch=adminuser.searchbutton();
		    
		   String usernametosearch = ExcelUtility.readStringData(2, 0, "AddUser");
		    usersearch.usernameSearch(usernametosearch);
	   	    usersearch.usertypeSearch();
	   	    usersearch.searchoption();
	   	    usersearch.Search_ParticularElements();
	   	    usersearch.Issearchdetailsdisplayed();

			boolean isnewusersaved = usersearch.Issearchdetailsdisplayed();
         	assertTrue(isnewusersaved, Constant. ADDUSERALERTMESSAGE);

	  
}}