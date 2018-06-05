package Training;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyClass4 {
	static WebDriver driver;

	static String processName = "chrome.exe";

	public static void main(String[] args) throws InterruptedException {

		
		
		String name = "Anu";
		System.out.println(System.identityHashCode(name));
		 name = "Anu1";
			System.out.println(System.identityHashCode(name));
		
		/*String name = new String("Anu");
		
		String name1 = new String("Anu");*/
		
		

			StringBuffer sb1 = new StringBuffer("CherChr.tech");
			System.out.println("Address of str1 : "+System.identityHashCode(sb1));
			sb1.replace(0, sb1.length()-1, "selenium-webdriver.com");
			System.out.println("Address of str1 after change : "+System.identityHashCode(sb1));
		
		
		
		/*
		 * if (ReusableClass.isProcessRunning(processName)) {
		 * ReusableClass.killProcess(processName); }
		 */
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--enable-extensions");
		
		options.addArguments("--disable-notifications");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// String mob = "999999999";

		// Login Page

		driver.manage().window().maximize();
		
		driver.navigate().to("https://www.makemytrip.com/");
      
		
		WebElement noOfviews=driver.findElement(By.xpath(".//input[@id='hp-widget__sfrom']"));
        

        
       // wait.until(ExpectedConditions.presenceOfElementLocated(noOfviews));
        
        noOfviews.click();
        noOfviews.sendKeys("Goa");
        List<WebElement> list=driver.findElements(By.xpath(".//ul[@id='ui-id-1']/li"));
       
        System.out.println(list.size());
        boolean flag = false;
        for(WebElement l : list)
        {
               if(flag){
                     break;
        }   
                
             System.out.println(l.getAttribute("aria-label"));
               //wait.until(ExpectedConditions.elementToBeClickable(l));
               if(l.getAttribute("aria-label")!=null){
               if(l.getAttribute("aria-label").contains("Goa")){
                     l.click();
                     
                     flag = true;
               }
               }
               else{
            	   System.out.println("not an option");
               }
        }
               
        System.out.println("yo");


		Thread.sleep(3000);
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*WebElement drpDown = driver.findElement(By.id("multi-select"));
		
	WebElement first_WebElement  = drpDown.findElement(By.xpath("./option[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(first_WebElement));
		
		List<WebElement> optionsList = drpDown.findElements(By.tagName("option"));

		
		
		WebElement button  = driver.findElement(By.id("printAll"));
		
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.LEFT_CONTROL)
	    .click(optionsList.get(3))
	    .click(optionsList.get(7))
	    .click(optionsList.get(1))
	    .click(optionsList.get(3))
	    .keyUp(Keys.LEFT_CONTROL)
	    .moveToElement(button)
	    .click(button)
	    .build()
	    .perform();
		System.out.println("clicked");
		
		HashMap<String,String> hm = new HashMap<String,String>();*/
		
		
		
		
		
		
		

		/*driver.findElement(By.xpath("//span[@aria-label='Open the date view']")).click();
		WebElement table = driver.findElement(By.xpath(
				"//div[@id='datetimepicker_dateview']//following::table[@role='grid'][@class='k-content k-month']/tbody"));

		List<WebElement> row = table.findElements(By.tagName("tr"));
		System.out.println("The size of row is::" + row.size());
		boolean flag = false;
		for (int i = 0; i < row.size()&& flag==false; i++) {
			List<WebElement> column = row.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < column.size() && flag==false; j++) {

				String text = column.get(j).findElement(By.tagName("a")).getText();
				System.out.println("The value of i is ::"+i+"::and the value of J is ::"+j+"::The date is :: " + text);
				if (text.contains("25") && !(column.get(j).getAttribute("class").contains("other")) ) {
					column.get(j).findElement(By.tagName("a")).click();

					flag = true;
				}

			}
		}*/

		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].removeAttribute('disabled');",
		 * DisElement);
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//button[contains(text(),'Click Me!')]"))); DisElement.click();
		 * 
		 * driver.findElement(By.xpath("//a[@class='btn J_proBtn']")).click();
		 * driver.findElement(By.xpath("//a[@class='btn J_btnNext']")).click();
		 * 
		 * WebElement User = driver.findElement(By.xpath(
		 * "//input[@class='item_account'][@id='username']")); User.sendKeys(
		 * "u can give ur username"); WebElement pass
		 * =driver.findElement(By.xpath(
		 * "//input[@class='item_account'][@id='pwd']"));
		 * pass.sendKeys("password"); WebElement passc
		 * =driver.findElement(By.xpath(
		 * "//div[@class='btns_bg']//input[@class='btnadpt btn_orange']"));
		 * passc.click(); String popup=driver.getWindowHandle();
		 * System.out.println(popup); Set<String>windows
		 * =driver.getWindowHandles(); System.out.println(windows.size());
		 * Iterator iterator =windows.iterator(); String current;
		 * while(iterator.hasNext()) { current =iterator.next().toString();
		 * System.out.println(current); if(current.equals(current)) {
		 * driver.switchTo().window(current); WebElement No=
		 * driver.findElement(By.xpath("//input[@class='J_pinCode']"));
		 * No.sendKeys("560076"); } }
		 * 
		 * 
		 * driver.findElement(By.xpath("/html/body/div[8]/div/div[2]/div/a")).
		 * click();
		 */
	}

}
