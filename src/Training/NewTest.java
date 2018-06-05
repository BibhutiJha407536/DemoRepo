package Training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

public class NewTest {
 WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  System.out.println("dssds");

  }

}


