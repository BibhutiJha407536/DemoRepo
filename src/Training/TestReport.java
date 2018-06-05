package Training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestReport  {

	public static WebDriver driver;
	public static WebDriverWait wait;
	Reporter report;

	@BeforeTest
	public void beforeTest() {

	
		driver = TestBase.getdriver();
		System.out.println(driver.toString());
		report = new Reporter();
		report.startTest("Demo", "TestingDemo", false, driver);
	}

	@AfterTest
	public void afterTest() {

		//driver.quit();
	}

	@Test(priority = 1)
	public void f1() {

		report.getInstance();

		wait = new WebDriverWait(driver, 10);

		driver.navigate().to("www.google.com");

		String webpage = driver.getTitle();
		System.out.println(webpage);

		report.Pass("validated successfully", true, driver);

	}

	@Test(priority = 2)
	public void f2() {

		report.getInstance();

		WebElement searchField = driver.findElement(By.id("lst-ib"));
		searchField.sendKeys("Selenium");
		System.out.println("Text entered in search Field");

		// report.Pass("validated successfully", true, driver);

		report.Fail("failed", true, driver);

	}

	@Test(priority = 3)
	public void f3() {

		report.getInstance();

		System.out.println("Search Button clicked");

		// report.Fail("failed", true, driver);

		report.Fail("failed again", true, driver);

	}

	@Test(priority = 4)
	public void f4() {

		report.getInstance();
		report.endTest("Demo", driver);
	}

}
