package Training;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class redbus {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--enable-extensions");
		driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// String mob = "999999999";

		// Login Page
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		/*
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * ".//*[@id='i-icon-profile']")));
		 */
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 *
		 * 
		 * if (optionscount.contains(ele.getText())) {
		 * System.out.println("failed"+ele.getText()); }
		 * optionscount.add(ele.getText()); }
		 */
		WebElement count = driver.findElement(By.id("day")) ; Select select =
				  new Select (count);
		 ArrayList<String> optionscount = new ArrayList<String>();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='src']")));

		driver.findElement(By.xpath(".//*[@id='src']")).click();

		driver.findElement(By.xpath(".//*[@id='src']")).sendKeys("Ahmedabad");
		driver.findElement(By.xpath(".//*[@id='src']")).sendKeys(Keys.ENTER);

		System.out.println(System.identityHashCode(driver));
		
		
		
		List<WebElement> optionsstate = driver
				.findElements(By.xpath(".//*[@id='src']/following-sibling::ul[@class='autoFill']/li"));

		for (WebElement os : optionsstate) {
			System.out.println(os.getText());
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='signInLink']")));
		driver.findElement(By.xpath(".//*[@id='signInLink']")).click();

		int Size = driver.getWindowHandles().size();
		driver.switchTo().defaultContent();

		WebElement iframeElement = driver.findElement(By.xpath(".//*[@class='modalIframe']"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeElement));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				".//button[contains(text(),'signup with')]//preceding::div[@id='googlePlusBtn1']/following-sibling::div[3]/span[2]/a")));
		driver.findElement(By
				.xpath(".//button[contains(text(),'signup with')]//preceding::div[@id='googlePlusBtn1']/following-sibling::div[3]/span[2]/a"))
				.click();

		System.out.println("passed");
		
	}

}























