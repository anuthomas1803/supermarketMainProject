package testscript;

import org.testng.annotations.Test;

import Utility.ExcelUtility;

import static org.testng.Assert.assertEquals;
	import java.awt.AWTException;
	import java.io.IOException;
	import constants.Constant;
import pages.Home;
import pages.LoginPage;
	
	public class HomeTest extends Base{
	public Home Homepage;
	@Test
	public void verifyifUserIsAbleToLogOut() throws AWTException, IOException
	{
		  String username=ExcelUtility.readStringData(1,0,"login");
		  String password=ExcelUtility.readStringData(1,1,"login");
		  
		  LoginPage login=new LoginPage(driver);
		  login.enter_credentials(username,password);
		  Homepage=login.click_signinbuton();
		  Homepage.logout();
		     String expectedresult="Login | 7rmart supermarket";
			 String actualresult=driver.getTitle();
			 assertEquals(actualresult,expectedresult,Constant.LOGOUTERRORMESSAGE);
	}}
