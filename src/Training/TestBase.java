package Training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	
	static private WebDriver driver = null;
	private static TestBase instance = null;
	
	private TestBase(){
		
		
	}
	
	
	static public WebDriver getdriver(){
		
		if(driver == null)
		{
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\bj053527\\Documents\\My Received Files\\IEDriverServer_Win32_3.1.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		
		
		return driver;
		
		
	}


	

	
	
	
	
	
	
	
	

}
