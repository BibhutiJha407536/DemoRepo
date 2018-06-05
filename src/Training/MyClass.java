package Training;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.*;
//import java.util.List;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;



public class MyClass {
	static WebDriver driver ;
	static WebElement UserName ;
	static WebElement Password ;
	static WebElement SignedIn ;
	static By UserL = By.xpath("//*[@id='user_login']");
	static By UserP = By.xpath("//*[@name='pwd']");
	static By RememberMe = By.xpath("//input[@type='checkbox']");
	static String processName = "firefox.exe";
	 
	public static void main(String[] args) {
		
		// WebDriverWait mywaitVar = new WebDriverWait(driver, 10);
		
		if (ReusableClass.isProcessRunning(processName))
		{
			ReusableClass.killProcess(processName);
		}
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver16\\geckodriver.exe");
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.setCapability("marionette", true);
		  driver = new FirefoxDriver(dc);
		
		try {
			driver.get("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F%2F");
			//driver.get("https://www.google.co.in/");
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		driver.manage().window().maximize();
		String expectedurl = "https://wordpress.com/wp-login.php?redirect_to=https%3A%2F%2Fwordpress.com%2F";
		String strurl = driver.getCurrentUrl();
		System.out.println("The current url is " +strurl);
			 if (strurl.contains(expectedurl)){
			            System.out.println("Test Passed!");
			        } else {
			            System.out.println("Test Failed");
			        }
			
			 
			 ReusableClass exist = new ReusableClass();
			 
				try {
					exist.checkexistence(UserL, "admin", UserName, driver);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
	 
				try {
					exist.checkexistence(UserP, "demo123", Password, driver);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			
			 try {
				exist.DeSelect_The_Checkbox(RememberMe, SignedIn, driver );
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			 try {
				exist.Select_The_Checkbox(RememberMe, SignedIn, driver );
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			 
			 WebElement dropdown = driver.findElement(By.id("swag"));

				Select Sel = new Select (dropdown);
				Sel.selectByVisibleText("7");
				
			List <WebElement> Swag = 	Sel.getOptions(); 
			
		int size = 	Swag.size();
	
		Sel.selectByIndex(size-1);
		
		driver.switchTo().alert().accept();
		
		
	}
	
	
	
}	
	
	

	
	
	
	



