package lchen.action.datafile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	
	private static WebDriver driver = null;
	private static TestBase instance = null;
	
	private TestBase(){
		
		
	}
	
	
	public static WebDriver getdriver(){
		
		if(driver == null)
		{
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\bj053527\\Documents\\My Received Files\\IEDriverServer_Win32_3.1.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		
		
		return driver;
		
		
	}


	

	
	
	
	
	
	
	
	

}
