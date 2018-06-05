package Training;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fb {
	static WebDriver driver;

	static String processName = "chrome.exe";
	public List<WebElement> c;

	public static void main(String[] args) throws AWTException, InterruptedException {

		String value = "RAM232323223";

		value = value.replaceAll("[0-9]", "");

		Hashtable<String, String> Ht = new Hashtable<String, String>();
		Ht.put("sassa", "value");

		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver16\\geckodriver.exe");
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setCapability("marionette", true);
		driver = new FirefoxDriver(dc);

		WebDriverWait wait = new WebDriverWait(driver, 30);

		driver.get(
				"https://www.zillow.com/new-york-ny/real-estate-agent-reviews/?page=1&showAdvancedItems=false&regionID=6181&locationText=New%20York%20NY");

		/* driver.get("https://www.timesjobs.com"); */
		driver.manage().window().maximize();
		/* driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); */
		/*
		 * driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"
		 * )).click(); driver.switchTo().defaultContent();
		 * driver.switchTo().frame("GB_frame");
		 * wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.
		 * xpath(".//iframe[@id='GB_frame']")));
		 * 
		 * 
		 * 
		 * WebElement username =
		 * driver.findElement(By.xpath("//input[@id='j_username']"));
		 * username.sendKeys("username@gmail.com");
		 */

		WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath(".//li[@data-test-id='nav-item-agent']/a[contains(text(),'Agents')]")));
		wait.until(ExpectedConditions.elementToBeClickable(link));

		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);

		link.sendKeys(selectLinkOpeninNewTab);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tab.get(1));

		WebElement link1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				".//div[@data-test-id='ldb-featured-board-0']//div[not(contains(@class,'zsg-lg-hide'))]/h3/a[1]")));
		wait.until(ExpectedConditions.elementToBeClickable(link1));
		link1.click();

		for (int i = 1; i <= 25; i++) {

			WebElement activePagination = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(".//li[@class='zsg-pagination_active']/a[contains(text()," + i + ")]")));
			wait.until(ExpectedConditions.elementToBeClickable(activePagination));
			fetchvalue();

			if (i != 25) {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[text()='Next']")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//a[text()='Next']")));
				driver.findElement(By.xpath(".//a[text()='Next']")).click();
			}

		}

	}

	public static void fetchvalue() {

		List<WebElement> namesList = driver.findElements(By.xpath(
				".//div[@data-test-id='ldb-boards-results']/div[starts-with(@data-test-id,'ldb-board')]//p[@class='ldb-contact-name ldb-font-bold']/a"));

		for (WebElement names : namesList) {

			if (names.getText() != "") {
				WebElement telephone = names.findElement(By.xpath("./parent::p/following-sibling::p"));

				System.out.println(names.getText());
				System.out.println(telephone.getText());

			}

			else {
				System.err.println("Could Not Retrieve name and telephone ");
			}

		}

	}

}
