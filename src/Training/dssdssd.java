package Training;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class dssdssd {
	static WebDriver driver;
	private static WebElement userName;
	private static WebElement password;
	private static WebElement logOnButton;

	public static void main(String... args) throws InterruptedException {

		String s = "Ram -123";
		System.out.println(s);
		/* You don't need the + because you are using the replaceAll method */
		s = s.replaceAll("[^0-9-]", ""); // or you can also use [0-9]
		System.out.println(s);

		String WS = System.getProperty("user.dir");

		System.setProperty("webdriver.ie.driver",
				"C:\\Users\\bj053527\\Documents\\My Received Files\\IEDriverServer_Win32_3.1.0\\IEDriverServer.exe");

		driver = new InternetExplorerDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		driver.get("https://sfet-nprodnstg.dm50.dev.smed.net/sf-qa1547/dynamic/soarian/logon.pba");
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\""));

		WebElement e = driver.findElement(By.xpath(".//span[@id='moreInfoContainer']/a"));
		e.click();
		WebElement e1 = driver.findElement(By.xpath(".//a[@id='overridelink']"));
		e1.click();
		e = driver.findElement(By.xpath(".//span[@id='moreInfoContainer']/a"));
		e.click();
		e1 = driver.findElement(By.xpath(".//a[@id='overridelink']"));
		e1.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctlusernameText__")));

		userName = driver.findElement(By.id("ctlusernameText__"));
		userName.sendKeys("SFET_User00501");

		password = driver.findElement(By.id("ctlpasswordText__"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Setting value for "value" attribute
		js.executeScript("arguments[0].value='Pa55w0rd00501'", password);

		logOnButton = driver.findElement(By.id("ctllogonBtnButton__"));
		logOnButton.click();

		driver.switchTo().defaultContent();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("sframeInner")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("wellFrame")));
		driver.switchTo().frame("tabWell0");
		String mainWindowHandle = driver.getWindowHandle();
		// String xpath1 = "//div[contains(text(),'Provider Accounting Home
		// Page')]";
		String xpath1 = ".//td/font[contains(text(),'Provider Accounting Home Page')]";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath1)));
		WebElement taskLink1 = driver.findElement(By.xpath(xpath1));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", taskLink1);
		taskLink1.click();

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		boolean windowFound = false;
		Set<String> openedWindowHandles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		// logger.info("Set before removal current:"+openedWindowHandles);
		openedWindowHandles.remove(currentWindowHandle);
		// logger.info("Current window handle before loop :
		// "+currentWindowHandle);
		Iterator<String> it = openedWindowHandles.iterator();
		// logger.info("Set after removal current:"+openedWindowHandles);
		while (it.hasNext()) {
			String nextWindowHandle = it.next();
			// logger.info("Inside while - handle:"+nextWindowHandle);
			driver.switchTo().window(nextWindowHandle);

			driver.switchTo().frame("wellFrame");
			// logger.info("Window content:"+driver.getPageSource());
			if (driver.getPageSource().contains("Business Office Name")) {

				windowFound = true;
				break;
			}
		}

		WebElement shortNameBox = driver.findElement(
				By.xpath("//td/div[contains(@title,'Automation BO')]/parent::td/preceding-sibling::td/input"));
		shortNameBox.click();

		WebElement btnOk = driver.findElement(By.xpath("//td/button[@id='ctlOK']"));
		btnOk.click();

		driver.switchTo().window(mainWindowHandle);

		driver.switchTo().defaultContent();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("sframeInner")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("wellFrame")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("thetabA")));

		WebElement tabA = driver.findElement(By.id("thetabA"));
		List<WebElement> tabWellFrames = tabA.findElements(By.tagName("iframe"));
		for (WebElement frame : tabWellFrames) {
			if (frame.isDisplayed()) {

				driver.switchTo().frame(frame);
				break;
			}
		}

		WebElement inquiryFunctions = driver.findElement(By.id("ctlInquiryFunctions"));
		String functionXpath = ".//label[contains(text(),'Guarantor Financial Overview for a Person')]";
		WebElement function = inquiryFunctions.findElement(By.xpath(functionXpath));
		function.click();

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		boolean windowFound1 = false;
		Set<String> openedWindowHandles1 = driver.getWindowHandles();
		String currentWindowHandle1 = driver.getWindowHandle();
		// logger.info("Set before removal current:"+openedWindowHandles);
		openedWindowHandles1.remove(currentWindowHandle1);
		// logger.info("Current window handle before loop :
		// "+currentWindowHandle);
		Iterator<String> it1 = openedWindowHandles1.iterator();
		// logger.info("Set after removal current:"+openedWindowHandles);
		while (it1.hasNext()) {
			String nextWindowHandle1 = it1.next();
			// logger.info("Inside while - handle:"+nextWindowHandle);
			driver.switchTo().window(nextWindowHandle1);

			driver.switchTo().frame("wellFrame");
			// logger.info("Window content:"+driver.getPageSource());
			if (driver.getPageSource().contains("Name and Demographics")) {

				windowFound1 = true;
				break;
			}
		}

		WebElement Lastname = driver.findElement(By.xpath("//td/span/input[contains(@name,'cmpLastName')]"));

		Lastname.sendKeys("QMW07162015_0255");
		Lastname.sendKeys(Keys.TAB);

		/*WebElement Fastname = driver.findElement(By.xpath("//td/span/input[contains(@name,'cmpFirstName')]"));

		Fastname.sendKeys("Adam");
		Fastname.sendKeys(Keys.TAB);*/

		WebElement searchButton = driver.findElement(By.xpath("//td/button[@id='ctlFindNowButton']"));
		searchButton.click();

		/*
		 * driver.findElement(By.id("ctlGuarantorLocatorSelectButtonButton__")).
		 * click();
		 */

		driver.switchTo().window(mainWindowHandle);

		driver.switchTo().defaultContent();

		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("sframeInner")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("wellFrame")));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("tabWell2")));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td/div[@title='Auto Guar Acct']")));
		WebElement Roll = driver.findElement(
				By.xpath("//td/div[@title='Auto Guar Acct']"));

		Roll.click();

		WebElement mangListButton = driver.findElement(By.id("ctlAccountActionsPopupBtn"));
		mangListButton.click();

		Thread.sleep(4000);

		/*
		 * driver.switchTo().defaultContent();
		 * driver.switchTo().frame("sframeInner");
		 */

		/*
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(
		 * "ctlAccountActionsPopupPopup"))); WebElement AccountOptionsmenu =
		 * driver.findElement(By.id("ctlAccountActionsPopupPopup"));
		 */

		selectMenuOption(driver, mangListButton, "Assign collection profile");

		/*
		 * Thread.sleep(2000); List < WebElement> Optionsmenu
		 * =AccountOptionsmenu.findElements(By.tagName("table"));
		 * System.out.println(Optionsmenu.get(0).getAttribute("id"));
		 * System.out.println(Optionsmenu.get(0).findElement(By.xpath(
		 * "./tr[3]/td")).getAttribute("id"));
		 * driver.findElement(By.xpath(".//table")).click();
		 */

		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		System.out.println("clicked");
	}

	public static boolean scrollPage(WebDriver driver, WebElement scrollBar, int scrollPoints) {

		try {
			Actions dragger = new Actions(driver);
			// Drag scrollbar downwards
			dragger.moveToElement(scrollBar).clickAndHold().moveByOffset(0, scrollPoints).release(scrollBar).build()
					.perform();
			Thread.sleep(500);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static void selectMenuOption(WebDriver driver, WebElement menuButton, String optionToSelect) {
		try {
			System.out.println("Waiting 2 sec before selecting menu option");
			Thread.sleep(2000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		WebElement buttonOptionsContainer = menuButton.findElement(By.xpath(".//parent::span"));
		// String
		// menuOptionxPath=".//following-sibling::span[@class='IccPopUpSpan']";
		// WebElement
		// menuOptionsContainer=menuButton.findElement(By.xpath(menuOptionxPath));
		// List<WebElement>
		// menuOptions=menuOptionsContainer.findElements(By.xpath(".//td"));
		int optionItemNo = 0;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int cmdsSize = ((Long) js.executeScript("return arguments[0]. TntObject.iccObject.Cmds.length;",
				new Object[] { buttonOptionsContainer })).intValue();
		outer: while (optionItemNo < cmdsSize) {

			String javaScriptForDisabledIndicator = "return arguments[0].TntObject.iccObject.Cmds[" + optionItemNo
					+ "].disabled;";
			boolean disabled = (Boolean) js.executeScript(javaScriptForDisabledIndicator,
					new Object[] { buttonOptionsContainer });
			String optionValue = (String) js.executeScript(
					"return arguments[0]. TntObject.iccObject.Cmds[" + optionItemNo + "].caption;",
					new Object[] { buttonOptionsContainer });

			if (!disabled) {
				System.out.println("disable");
				if (optionItemNo != 0) {
					menuButton.sendKeys(Keys.ARROW_DOWN);

					try {
						Thread.sleep(1000);
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				}
				if (optionValue.equalsIgnoreCase(optionToSelect))
					break outer;
			}
			optionItemNo++;

		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		menuButton.sendKeys(Keys.ENTER);

	}

}
