package testscript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.ExcelUtility;
import constants.Constant;
import pages.LoginPage;

public class LoginPageTest extends Base {
	@Test
	public void verifyUserIsAbleToLoginWithValidCredentials() throws AWTException, IOException {
		
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(1, 0, "login");
		String password = ExcelUtility.readStringData(1, 1, "login");
		login.enter_credentials(username, password);
		login.click_signinbuton();
		boolean isHomepageLoaded = login.isDashBoardLoaded();
		assertTrue(isHomepageLoaded, Constant.HOMEPAGEERRORMEGGASE);
		}

	
	@Test
	@Parameters({ "username", "password" })
	public void verifyUserIsAbleToLoginWithInvalidUsername(String username, String password) throws AWTException {
		
		LoginPage login = new LoginPage(driver);
		login.enter_credentials(username, password);
		login.click_signinbuton();
		boolean IsAlertDisplayed = login.alert();
		assertTrue(IsAlertDisplayed, Constant.LOGINALERTMEGGASE);
		}


	@Test
	public void verifyUserIsAbleToLoginWithInValidPassword() throws AWTException, IOException {

			
		String username3 = ExcelUtility.readStringData(3, 0, "Sheet1");
		String password3 = ExcelUtility.readStringData(3, 1, "Sheet1");
		LoginPage login = new LoginPage(driver);
		login.enter_credentials(username3, password3);
		login.click_signinbuton();
		boolean IsAlertDisplayed = login.alert();
		assertTrue(IsAlertDisplayed, Constant.LOGINALERTMEGGASE);// actual result=expected result

	}


	@DataProvider(name = "credentials")
	public Object[][] testData()
	{
		Object data[][] = { { "admin12", "1q2w3e4r" }, { "admin123", "admin123" }, { "shefeena", "19dte4r" } };
		return data;
	}

	@Test(dataProvider = "credentials")
	public void verifyUserIsAbleToLoginWithInValidCredentials(String username, String password) throws AWTException {
		LoginPage login = new LoginPage(driver);
		login.enter_credentials(username, password);
		boolean isHomepageLoaded = login.isDashBoardLoaded();
		assertTrue(isHomepageLoaded, Constant.LOGINALERTMEGGASE);}

}
