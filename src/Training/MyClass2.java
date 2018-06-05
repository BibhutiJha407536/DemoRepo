package Training;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyClass2 {
	static WebDriver driver;

	static String processName = "chrome.exe";
	
	String demo = "chrome.exe";
	public List <WebElement> c ;
	public static void main(String[] args) {

		if (ReusableClass.isProcessRunning(processName)) {
			ReusableClass.killProcess(processName);
		}
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--enable-extensions");
		driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement e;
		// String mob = "999999999";
		String text = "this sms is sent through Selenium";
		
		// Login Page
		driver.get("http://www.160by2.com/");
		e = driver.findElement(By.xpath("//*[@id='username']"));
		e.sendKeys("9748108547");
		e = driver.findElement(By.xpath("//*[@id='password']"));
		e.sendKeys("8923");
		e = driver.findElement(By.xpath(".//button[@class='ind-reg-but ind-but-butns']"));
		e.click();
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("by2Frame"));

		driver.switchTo().defaultContent();
		List <WebElement> a = driver.findElements(By.tagName("iframe"));
		int a1  = a.size();
		List <WebElement> b = driver.findElements(By.tagName("input"));
		int b1 = b.size();
		 List <WebElement> c = null ;
	     c.addAll(a);
	     c.addAll(b);
		 int c1 = c.size();
		
		int size = driver.findElements(By.tagName("iframe")).size();

		for (int i = 0; i < size; i++) {

			driver.switchTo().frame(i);
			int total = driver
					.findElements(
							By.xpath(".//*[text()='Send Free SMS']/parent::div/div[1]/div[1]/p[2]/input[@type='text']"))
					.size();
			// String xpath="//td/font[contains(text(),'"+businessProcess+"')]";

			System.out.println(total);
			if (total == 1) {
				e = driver.findElement(
						By.xpath(".//*[text()='Send Free SMS']/parent::div/div[1]/div[1]/p[2]/input[@type='text']"));
				e.sendKeys(text);
				System.out.println("The no is written");
			}

		}

	}
}
