package testscript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.ExcelUtility;
import constants.Constant;
import pages.AdminUsersAdd;
import pages.Home;
import pages.LoginPage;

public class AdminUsersAddTest extends Base {

	public Home Homepage;
	public AdminUsersAdd adminuser;

	@Test
	public void verifyifAdminIsAbletoaddnewuser() throws AWTException, IOException {
		LoginPage login = new LoginPage(driver);
		String username1 = ExcelUtility.readStringData(1, 0, "login");
		String password1 = ExcelUtility.readStringData(1, 1, "login");
		login.enter_credentials(username1, password1);
		Homepage = login.click_signinbuton();
		adminuser = Homepage.gotoadminUser();
		adminuser.createnew();

		String username2 = ExcelUtility.readStringData(1, 0, "AddUser");
		String password2 = ExcelUtility.readStringData(1, 1, "AddUser");
		adminuser.enter_credentials(username2, password2);
		adminuser.userType();
		adminuser.savedetails();

		boolean isnewusersaved = adminuser.isSavesuccess();
		assertTrue(isnewusersaved, Constant.ADDUSERALERTMESSAGE);
	}

	@Test
	public void verifyifAlertAppearsForNAmeThatAlreadyExist() throws AWTException, IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(1, 0, "login");
		String password = ExcelUtility.readStringData(1, 1, "login");
		login.enter_credentials(username, password);

		Homepage = login.click_signinbuton();
		adminuser = Homepage.gotoadminUser();
		adminuser.createnew();

		String username2 = ExcelUtility.readStringData(1, 0, "AddUser");
		String password2 = ExcelUtility.readStringData(1, 1, "AddUser");
		adminuser.enter_credentials(username2, password2);
		adminuser.userType();
		adminuser.savedetails();

		boolean isnewusersaved = adminuser.isAlertDisplayed();
		assertTrue(isnewusersaved, Constant.NOALERTMESSAGE);
	}

}
