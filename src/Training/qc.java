package Training;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.jacob.com.LibraryLoader;

import atu.alm.wrapper.ALMServiceWrapper;
import atu.alm.wrapper.enums.StatusAs;
import atu.alm.wrapper.exceptions.ALMServiceException;

public class qc {
      WebDriver driver;

      @BeforeClass
      public void init() {
    	String A =   System.getProperty("os.arch");
    	
    	
    	  System.setProperty("jacob.dll.path", "C:\\Users\\bj053527\\workspace\\TrainingProject\\jacob-1.17-M2-x86.dll");
    	  LibraryLoader.loadJacobLibrary();
    	  System.setProperty("webdriver.gecko.driver","C:\\geckodriver16\\geckodriver.exe");
			driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      }

      @Test
      public void login() throws InterruptedException, ALMServiceException {
            // Open Wordpress App
            driver.get("https://www.google.co.in/?gfe_rd=cr&dcr=0&ei=M7yuWesd0YvxB7i0uLAB");
            updateResults();
            // Enter UserName
            Thread.sleep(3000);
            driver.findElement(By.id("user_login")).clear();
            driver.findElement(By.id("user_login")).sendKeys("admin");
            // Enter Password
            driver.findElement(By.id("user_pass")).clear();
            driver.findElement(By.id("user_pass")).sendKeys("demo123");
            // Click on Submit button
            driver.findElement(By.id("wp-submit")).submit();
            
            System.out.println("Done Updating Results");
      }

      public void updateResults() throws ALMServiceException {
            ALMServiceWrapper wrapper = new ALMServiceWrapper(
            		"https://qualitycentermlvn.cerner.com/qcbin/start_a.jsp");
            wrapper.connect("bj053527", "Cerner2017", "DEFAULT", "RCS_Sorian_Financials");
            wrapper.updateResult("SampleTestSetFolder\\SubTestSetFolder1",
                        "TestSet3", 62, "Login", StatusAs.PASSED);
            wrapper.close();
      }
     
      @AfterClass
      public void close(){
            driver.quit();
      }
}