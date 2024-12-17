package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public WebDriver driver;

	public void selectByIndex(WebElement dropdown, int index) {
		Select Selobj = new Select(dropdown);
		Selobj.selectByIndex(index);

	}

	public void selectByValue(WebElement dropdown, String value) {
		Select Selobj = new Select(dropdown);
		Selobj.selectByValue(value);

	}

	public void dragNDrop(WebElement dragdrop1, WebElement destination) {
		Actions actions = new Actions(driver);
		actions.moveToElement(dragdrop1);
		actions.doubleClick(dragdrop1).perform();
		actions.dragAndDrop(dragdrop1, destination).build().perform();
	}

	public void singleclick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click(element).build().perform();
	}

	public void doubleclick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.doubleClick(element).build().perform();
	}

	public void contextClick(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.contextClick(element).build().perform();
	}

}