package Training;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;






public class ReusableClass {
	static WebDriver driver ;
	
	
	
	public static boolean isProcessRunning(String serviceName) 
	{
	    Process p;
	    try {
	        p = Runtime.getRuntime().exec(System.getenv("windir") +"\\system32\\"+"tasklist.exe");
	        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line;
	        while ((line = reader.readLine()) != null) 
	        {
	            if (line.contains(serviceName)) 
	            {
	                return true;
	            }
	        }
	    }
	    catch (Exception e) 
	    {

	        e.printStackTrace();
	    }
	    return false;
	}
	
	
	public static void killProcess(String serviceName) { 
	
	    try
	    {
	        Runtime.getRuntime().exec("taskkill /F /IM " + serviceName);
	    } 
	    catch (Exception e) 
	    {

	        e.printStackTrace();
	    }
	}
	
	
	
	
	public void checkexistence( By UserL, String Value, WebElement VariableName, WebDriver driver ) throws Exception  {
		   VariableName = driver.findElement(UserL);
		// Call reuse method
		   highLightElement(driver,VariableName);
				if (VariableName.isDisplayed()){
				
				
					//VariableName.sendKeys(Value);
					
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("document.getElementById('usernameOrEmail').value = 'Ripon Al Wasim';");
					//document.querySelector(\"input[placeholder='First Name']\").value = 'dddd'");
					 System.out.println("The element:: " +VariableName.getAttribute("id")+ " is set with a value of::" +Value );
		
	            }



}


public void Select_The_Checkbox(By RememberMe, WebElement VariableName, WebDriver driver ) throws Exception {
	VariableName = driver.findElement(RememberMe);
	highLightElement(driver,VariableName);
				try {
						if (VariableName.isSelected()) {
						System.out.println("Checkbox: " + VariableName + "is already selected");
						}     else {

									 VariableName.click();}
				}		

				catch (Exception e) {
System.out.println("Unable to select the checkbox: " + VariableName);
}
}

public void DeSelect_The_Checkbox(By RememberMe, WebElement VariableName,WebDriver driver ) throws Exception {
	VariableName = driver.findElement(RememberMe);
	highLightElement(driver,VariableName);
				try {
						if (VariableName.isSelected()) {
							VariableName.click();
						}     else {
									System.out.println("Checkbox: " + VariableName + "is already selected");
									 }
				}		

				catch (Exception e) {
System.out.println("Unable to select the checkbox: " + VariableName);
}
}

public static void highLightElement(WebDriver driver, WebElement element) throws InterruptedException
{
JavascriptExecutor js=(JavascriptExecutor)driver; 

for (int i=0;i<4;i++){
	
//js.executeScript("arguments[0].setAttribute('style', 'background: green; border: 2px solid black;');", element);
js.executeScript("arguments[0].setAttribute('style','border: 2px solid black');", element);
}
try 
{
Thread.sleep(500);
} 
catch (InterruptedException e) {
 
System.out.println(e.getMessage());
} 
 
js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
 
}

	// TODO Auto-generated method stub
	
}	

	
	
	
	

