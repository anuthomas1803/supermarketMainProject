package testscript;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import Utility.ExcelUtility;
import constants.Constant;
import pages.Home;
import pages.LoginPage;
import pages.ManageNews;
import retry.Retry;

public class ManageNewsTest extends Base {
	public Home Homepage;
	public ManageNews News;

	@Test(retryAnalyzer = retry.Retry.class)
	public void verifyifAdminIsAbletoaddnewuser() throws AWTException, IOException {
		LoginPage login = new LoginPage(driver);
		String username1 = ExcelUtility.readStringData(1, 0, "login");
		String password1 = ExcelUtility.readStringData(1, 1, "login");

		login.enter_credentials(username1, password1);
		Homepage = login.click_signinbuton();
		News = Homepage.gotomanagenews();
		News.newoption();
		String news = ExcelUtility.readStringData(0, 0, "News");
		News.enternews(news);
		News.saveoption();
		News.isnewsdisplayed();
		boolean isnewssaved = News.isnewsdisplayed();
		assertTrue(isnewssaved, Constant.NEWSALERTMESSAGE);

	}

}