 package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.WaitUtility;

public class LoginPage {

		public WebDriver driver;
		
	public LoginPage(WebDriver driver)
	{
	this.driver=driver; 
	PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@placeholder='Username']") WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement password;
	@FindBy(xpath="//button[@type='submit']") WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']") WebElement dashboard; 
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") WebElement alert;
	public LoginPage enter_credentials(String usernamefield,String passwordfield)
	{
	username.sendKeys(usernamefield);
	password.sendKeys(passwordfield);
	return this;
	}

	public Home click_signinbuton()
	{
		WaitUtility  wait=new WaitUtility();
		wait.waitForELementsToClick(driver, signin);
		signin.click();
		return new Home(driver);
	}
	public boolean isDashBoardLoaded()
	{
		return dashboard.isDisplayed();
	}
	public boolean alert()
	{
		return alert.isDisplayed();
	}
	}


