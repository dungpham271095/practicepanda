package reportConfig;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.text.SimpleDateFormat;

import commons.BaseTest;


public class ReportNGListener implements ITestListener{
	
	public void onTestFailures(ITestResult iTestResult) {
		
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		// lay driver ra
		Object testClass = iTestResult.getInstance();
		WebDriver driver = ((BaseTest) testClass).getDriver();
		
		// chup hinh 
		String screenshotPath = captureScreenshot(driver, iTestResult.getName());
		
		// trang thai cua tescase pass/fail/skip
		Reporter.getCurrentTestResult();
		Reporter.log("<br><a target=\"_blank\" href=\"file:///" + screenshotPath + "\">" + "<img src=\"file:///" + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
		Reporter.setCurrentTestResult(null);
		
		// dua vao report HTML
		
	}
	public String captureScreenshot(WebDriver driver, String screenshotName) {
		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String screenPath = System.getProperty("user.dir") + "\\screenshotReportNG\\" + screenshotName + "_" + formater.format(calendar.getTime()) + ".png";
			FileUtils.copyFile(source, new File(screenPath));
			return screenPath;
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot: " + e.getMessage());
			return e.getMessage();
		}
	}
}
