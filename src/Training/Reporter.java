package Training;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporter {
	static boolean bool_LogDetailed;
	private static ExtentReports extent;
	private static String Pod = "", Client_Env = "", test_Type = "", reportFilePath = "", rootFolderPath = "";
	private ExtentTest test;
	// singleton class
	private static Reporter reporter;
	private String fileName;

	public static Reporter getInstance() {
		if (reporter == null) {
			reporter = new Reporter();
		}
		return reporter;
	}

	public Reporter() {
		if (extent == null) {

			Date d = new Date();

			rootFolderPath = "C://Users//bj053527//workspace//Trainingproject";
			fileName = "MyExtentReport";
			// reportFilePath = rootFolderPath + "//Reports//" + Root.buildInfo
			// + "//" + Root.testName + "//" + Root.testStartedOn +
			// "//ExecutionReports//"+fileName+".html";
			reportFilePath = "C://Users//bj053527//workspace//Trainingproject//reports//" + fileName + ".html";
			extent = new ExtentReports(reportFilePath, true, DisplayOrder.OLDEST_FIRST);

			extent.loadConfig(new File(rootFolderPath + "//Dependencies//extent-config.xml"));
			// optional
			extent.addSystemInfo("Selenium Version", "2.53.0").addSystemInfo("Environment", "QA");

		}
	}

	// -----------

	public void startTest(String testName, String description, Boolean ScreenShotStatus, WebDriver d) {

		test = extent.startTest(testName, description);
		Pass("Starting " + testName, ScreenShotStatus, d);
	}

	public void endTest(String testName, WebDriver d) {

		Pass("Terminating " + testName, false, d);
		extent.endTest(test);
		extent.flush();
	}

	//// ----------------------
	public void Pass(String Message, Boolean ScreenshotRequired, WebDriver d) {

		if (ScreenshotRequired) {
			Date dt = new Date();
			String screenshotFile = dt.toString().replace(":", "_").replace(" ", "_") + ".png";

			screenshotFile = rootFolderPath + "//reports//Screenshots//" + screenshotFile;

			// store screenshot in that file
			File scrFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File(screenshotFile));
				
				/*FileOutputStream fos = new FileOutputStream(screenshotFile);
			      PdfWriter writer = PdfWriter.getInstance(document, fos);
			      writer.open();
			      document.open();
			      document.add(Image.getInstance(input));
			      document.close();
			      writer.close();*/
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test.log(LogStatus.PASS,
					Message + ".  Screenshot file->" + screenshotFile + ". " + test.addScreenCapture(screenshotFile));

		} else {
			test.log(LogStatus.PASS, Message);
		}
		extent.flush();
	}

	public void Fail(String Message, Boolean ScreenshotRequired, WebDriver d) {

		if (ScreenshotRequired) {
			Date dt = new Date();
			String screenshotFile = dt.toString().replace(":", "_").replace(" ", "_") + ".png";

			screenshotFile = rootFolderPath + "//reports//Screenshots//" + screenshotFile;
			// store screenshot in that file
			File scrFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File(screenshotFile));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test.log(LogStatus.FAIL,
					Message + ".  Screenshot file->" + screenshotFile + ". " + test.addScreenCapture(screenshotFile));
			// Assert.fail(Message);
		} else {
			test.log(LogStatus.FAIL, Message);
			// Assert.fail(Message);
		}
		extent.flush();

	}

	public void FailAndExit(String TestName, String Message, Boolean ScreenshotRequired, WebDriver d) {
		if (ScreenshotRequired) {
			Date dt = new Date();
			String screenshotFile = dt.toString().replace(":", "_").replace(" ", "_") + ".png";

			screenshotFile = rootFolderPath + "//reports//Screenshots//" + screenshotFile;

			// store screenshot in that file
			File scrFile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File(screenshotFile));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test.log(LogStatus.FAIL,
					Message + ".  Screenshot file->" + screenshotFile + ". " + test.addScreenCapture(screenshotFile));
			endTest(TestName, d);
			Assert.fail(Message);
		} else {
			test.log(LogStatus.FAIL, Message);
			endTest(TestName, d);
			Assert.fail(Message);
		}
		extent.flush();

	}

}
