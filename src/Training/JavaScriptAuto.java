package Training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaScriptAuto {
	
	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.ie.driver", "C:/SS_personal/IEDriverServer_Win32_3.1.0/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MICROSECONDS);
		//driver.navigate().to("http://demo.automationtesting.in/Index.html");
		driver.navigate().to("http://demo.automationtesting.in");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
//		js.executeScript("document.getElementById('email').value='swagatasinha16@yahoo.in'");
//		
//		js.executeScript("document.getElementById('enterimg').click();");
//		js.executeScript("document.querySelector(\"input[placeholder='First Name']\").value='swagata'");
//		Thread.sleep(5000);
//		js.executeScript("history.go(0)");
		String text = js.executeScript("return document.getElementById('btn2').innerHTML").toString();
		System.out.println("WebElement Text is : "+ text);
		String text1 = js.executeScript("return document.title").toString();
		System.out.println("WebElement Text is : "+ text1);

		driver.quit();

	}

}
