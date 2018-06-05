package Training;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyClass3 {
	static WebDriver driver;

	static String processName = "chrome.exe";

	public static void main(String[] args) throws AWTException {

		if (ReusableClass.isProcessRunning(processName)) {
			ReusableClass.killProcess(processName);
		}
		Robot robot = new Robot();
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--enable-extensions");
		driver = new ChromeDriver(options);
		robot.setAutoDelay(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.setAutoDelay(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		StringSelection s = new StringSelection("Nike");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		robot.setAutoDelay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.setAutoDelay(3000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("end");
	}
}
