package com.imdb.topList.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
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

public class ListnersClass implements WebDriverEventListener,ITestListener{
	public static final Logger logger =LoggerClass.createLogger();
	static String imageLocation = "images/";
	static String reportLocation = "reports/";
	
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
		logger.info("Navigated to page : "+arg0.trim());
		
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
		logger.info("About to click on element : "+arg0.getText());
		
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
		logger.info("About to navigate page :"+arg0.trim());
		
	}

	public void beforeScript(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void beforeSwitchToWindow(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onException(Throwable arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		logger.info("Test case "+result.getName()+" about to start...");
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String line = new String(new char[100]).replace('\0', '-');
		logger.info(line);
		logger.info(String.format("|%30s|",result.getTestClass())+String.format("|%20s|",result.getName())+String.format("|%10S|", "passed"));
		logger.info(line+"\n");
	}

	public void onTestFailure(ITestResult result) {
		createScreenshot(BaseWebdriver.getDriver());
		
		String line = new String(new char[100]).replace('\0', '-');
		logger.info(line);
		logger.info(String.format("|%30s|",result.getTestClass())+String.format("|%20s|",result.getName())+String.format("|%10S|", "failed"));
		logger.info(line+"\n");		
	}

	public void onTestSkipped(ITestResult result) {
		
		
		String line = new String(new char[100]).replace('\0', '-');
		logger.info(line);
		logger.info(String.format("|%30s|",result.getTestClass())+String.format("|%20s|",result.getName())+String.format("|%10S|", "skipped"));
		logger.info(line+"\n");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		
		
	}

	public static String createScreenshot(WebDriver driver) {

		UUID uuid = UUID.randomUUID();

		// generate screenshot as a file object
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			// copy file object to designated location
			FileUtils.copyFile(scrFile, new File(reportLocation + imageLocation + uuid + ".png"));
		} catch (IOException e) {
			logger.error("Error while generating screenshot:\n" + e.toString());
		}
		logger.info("imageLocation + uuid + .png : " + imageLocation + uuid + ".png");
		return imageLocation + uuid + ".png";
	}


}
