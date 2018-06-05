 package Training;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MyClass9 {

File file = null;

FileInputStream fis = null; 

Properties prop = null;

WebDriver driver = null;



public void reqFile() throws Exception
{
file = new File("C:\\Users\\diksha.gautam\\Selenium_Script\\workspace\\Selinium_Starting\\bin\\com\\hdfc\\bank\\hdfcValues.properties");

fis = new FileInputStream(file);

prop = new Properties();

prop.load(fis);
}




public void browser()
{
if(prop.getProperty("select_Browser").equalsIgnoreCase("mozilla"))

{
System.setProperty("webdriver.gecko.driver", "C:\\Softwares\\geckodriver-v0.15.0-win64\\geckodriver.exe");

driver = new FirefoxDriver();
}

else if(prop.getProperty("select_Browser").equalsIgnoreCase("chrome"))
{
System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\seleniumchrome&IE\\chromedriver_win32\\chromedriver.exe");

driver = new ChromeDriver();
}

else
{
System.setProperty("webdriver.ie.driver", "C:\\Softwares\\seleniumchrome&IE\\IEDriverServer_x64_3.4.0\\IEDriverServer.exe");

driver = new InternetExplorerDriver();
}

}




public void hit_URL()
{	
driver.manage().window().maximize();

driver.get(prop.getProperty("URL"));

if(!(prop.getProperty("Ad.class").isEmpty()))
{
driver.findElement(By.id(prop.getProperty("Ad.close.id"))).click();

}



//By executing a java script

JavascriptExecutor exe = (JavascriptExecutor) driver;

Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());

System.out.println("Number of iframes on the page are " + numberOfFrames);


//By finding all the web elements using iframe tag

java.util.List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));

System.out.println("The total number of iframes are " + iframeElements.size());



//switch to frame of Ad

//driver.switchTo().frame("viz_iframe3625598c2e7a02cf69401911100ONR");

WebElement ele = driver.findElement(By.xpath("//*[@id='prd-item-list-4']/div[1]/img"));

driver.switchTo().frame(ele);




//click on apply now within frame

driver.findElement(By.id("banner-button")).click();


}

}