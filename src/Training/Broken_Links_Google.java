package Training;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Broken_Links_Google {
 static int invalidimg;
 static WebDriver driver ;
 public static void main(String[] args) {
  try {
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver16\\geckodriver.exe");
    driver = new FirefoxDriver();
   driver.get("http://www.quackit.com/html/codes/html_radio_button.cfm");
   invalidimg = 0;
   
   
   Set<String> windowHandle = driver.getWindowHandles();
   
   for(String singlewindow : windowHandle ){
	
	   driver.switchTo().window(singlewindow);
	   
	   if(driver.getPageSource().contains("Groups of Radio Buttons")){
		System.out.println("switched");
	   }
	   
   }
   
   List allImages  = driver.findElements(By.tagName("a"));
   System.out.println("Total  images are " + allImages.size());
   for (int i = 0; i < allImages.size(); i++) {
    WebElement img = (WebElement) allImages.get(i);
    if (img != null) {
     try {
		verifyimgActive(img.getAttribute("href").trim());
	} catch (Exception e) {
		System.out.println("no href");
	}
    }
   }
  
 
   driver.quit();
  } catch (Exception e) {
   e.printStackTrace();
   System.out.println(e.getMessage());
  }
 }



 public static void verifyimgActive(String linkUrl) {
	 try 
     {
        URL url = new URL(linkUrl);
        
        HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
        
        httpURLConnect.setConnectTimeout(3000);
        
        httpURLConnect.connect();
        
        if(httpURLConnect.getResponseCode()==200)
        {
            System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
         }
       if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
        {
            System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
         }
     } catch (Exception e) {
        
     }
 }
}