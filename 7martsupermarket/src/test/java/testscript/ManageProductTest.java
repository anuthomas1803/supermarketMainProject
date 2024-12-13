package testscript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import Utility.ExcelUtility;
import constants.Constant;
import pages.AdminUserSearch;
import pages.AdminUsersAdd;
import pages.Home;
import pages.LoginPage;
import pages.ManageProduct;

public class ManageProductTest extends Base{  
		public Home Homepage;
		ManageProduct delete;
	   
		 @Test
	 public void verifyifAdminIsAbletoDeleteAProductFromList() throws AWTException, IOException 
	 {	

				String username = ExcelUtility.readStringData(1, 0, "login");
				String password = ExcelUtility.readStringData(1, 1, "login");
		
				LoginPage login = new LoginPage(driver);
				login.enter_credentials(username, password);
					
				Homepage = login.click_signinbuton();
				delete = Homepage.gotoManageProduct();   
				delete.selectProduct();
				delete.deleteProduct();
				delete.confirmDelete();
				boolean IsAlertDisplayed = delete.isDeleteSuccess();
				assertTrue(IsAlertDisplayed, Constant.NOALERTMESSAGE);
				
	 }	 
}
