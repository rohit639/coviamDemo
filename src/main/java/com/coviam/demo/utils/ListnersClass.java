package com.coviam.demo.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class ListnersClass implements WebDriverEventListener, ITestListener {
	public static final Logger logger = LoggerClass.createLogger();
	static String imageLocation = "images/";
	static String reportLocation = "logs/";

	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub

	}

	public void afterClickOn(WebElement arg0, WebDriver arg1) {

	}

	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {

	}

	public void afterNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void afterNavigateTo(String arg0, WebDriver arg1) {
		logger.info("Navigated to page : " + arg0.trim());

	}

	public void afterScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	public void afterSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub

	}

	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		logger.info("About to click on element : " + arg0.getText());

	}

	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateBack(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateForward(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateRefresh(WebDriver arg0) {
		// TODO Auto-generated method stub

	}

	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		logger.info("About to navigate page :" + arg0.trim());

	}

	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {

	}

	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub

	}

	public void onTestStart(ITestResult result) {
		String line = new String(new char[130]).replace('\0', '-');
		logger.info("\n");
		logger.info(line);
		logger.info("Test case :-->  \"" + result.getName() + "\"  <--: about to start...");
		logger.info(line + "\n\n");
		ExtendedReport.test = ExtendedReport.extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		ExtendedReport.test.log(Status.PASS, "**passed**");
		String line = new String(new char[120]).replace('\0', '-');
		logger.info(line);
		logger.info(String.format("|%30s|", result.getTestClass()) + String.format("|%20s|", result.getName())
				+ String.format("|%10S|", "passed"));
		logger.info(line + "\n");
	}

	public void onTestFailure(ITestResult result) {
		String screenShots = createScreenshot(BaseWebdriver.getDriver());
		Path resourceDirectory;
		resourceDirectory = Paths.get("logs", screenShots);

		try {
			ExtendedReport.test.log(Status.FAIL, result.getThrowable());
			ExtendedReport.test.fail("*ScreenShot*",
					MediaEntityBuilder.createScreenCaptureFromPath(resourceDirectory.toString()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = new String(new char[120]).replace('\0', '-');
		logger.info(line);
		logger.info(String.format("|%30s|", result.getTestClass()) + String.format("|%20s|", result.getName())
				+ String.format("|%10S|", "failed"));
		logger.info(line + "\n");
	}

	public void onTestSkipped(ITestResult result) {

		ExtendedReport.test.log(Status.SKIP, "**Skipped**");
		String line = new String(new char[120]).replace('\0', '-');
		logger.info(line);
		logger.info(String.format("|%30s|", result.getTestClass()) + String.format("|%20s|", result.getName())
				+ String.format("|%10S|", "skipped"));
		logger.info(line + "\n");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		ExtendedReport.extent.flush();
		String line = new String(new char[80]).replace('\0', '-');
		logger.info(line);
		logger.info(StringUtils.center(
				"|Total Number of Test cases Executed ||" + " " + context.getAllTestMethods().length + " ||", 80));
		logger.info(line);
		logger.info(String.format("|%5S|", "Total Passed") + String.format("|%5s|", context.getPassedTests().size())
				+ String.format("|%5S|", "Total Failed") + String.format("|%5s|", context.getFailedTests().size())
				+ String.format("|%5S|", "Total skipped") + String.format("|%5s|", context.getSkippedTests().size()));
		logger.info(line + "\n");
	}

	public static String createScreenshot(WebDriver driver) {

		UUID uuid = UUID.randomUUID();

		// generate screenshot as a file object
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// copy file object to designated location
			FileUtils.copyFile(scrFile, new File(reportLocation + imageLocation + uuid + ".png"));
		} catch (IOException e) {
			logger.error("Error while generating screenshot:\n" + e.toString());
		}
		logger.info("imageLocation + uuid + .png : " + imageLocation + uuid + ".png");
		return imageLocation + uuid + ".png";
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> arg0, X arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> arg0) {
		// TODO Auto-generated method stub
		
	}

}
