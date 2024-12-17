package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNews {
	public WebDriver driver;

	public ManageNews(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement textarea;
	@FindBy(xpath = "//button[@name='create']")
	WebElement save;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successalertmessage;

	public ManageNews newoption() {
		newbutton.click();
		return this;
	}

	public ManageNews enternews(String news) {
		textarea.sendKeys(news);
		return this;
	}

	public ManageNews saveoption() {
		save.click();
		return this;
	}

	public boolean isnewsdisplayed() {
		return successalertmessage.isDisplayed();
	}
}
