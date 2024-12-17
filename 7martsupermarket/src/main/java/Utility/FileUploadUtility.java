package Utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public WebDriver driver;

	public void sendKeysProfileUpload(WebElement element, String path) {
		element.sendKeys(path);
	}

	public void robotForFileUpload(WebElement element, String path) throws AWTException {
		StringSelection fileselect = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileselect, null);
		Robot robot = new Robot();
		robot.delay(2);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
