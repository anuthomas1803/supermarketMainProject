package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.PageUtility;
import Utility.WaitUtility;

public class AdminUsersAdd {
	public WebDriver driver;

	public AdminUsersAdd(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='username']")
	WebElement usernameField;
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;
	@FindBy(xpath = "//select[@name='user_type']")
	WebElement user_Typedropdwn;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertSaveSuccess;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertSaveFail;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']")
	WebElement searchButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement Searchoption;

	public AdminUsersAdd createnew() {
		newbutton.click();
		return this;
	}

	public AdminUsersAdd enter_credentials(String username, String password) {
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		return this;
	}

	public AdminUsersAdd userType() {
		PageUtility page = new PageUtility();
		page.selectByIndex(user_Typedropdwn, 2);
		return this;
	}

	public AdminUsersAdd savedetails() {
		save.click();
		return this;
	}

	public boolean isSavesuccess() {
		return alertSaveSuccess.isDisplayed();
	}

	public boolean isAlertDisplayed() {
		return alertSaveFail.isDisplayed();
	}

	public AdminUserSearch searchbutton() {
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("arguments[0].click();", searchButton);
		return new AdminUserSearch(driver);
	}
}
