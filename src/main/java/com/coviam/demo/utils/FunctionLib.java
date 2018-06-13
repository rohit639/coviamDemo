package com.coviam.demo.utils;

import static org.testng.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FunctionLib {

	private final static WebDriverWait wait = new WebDriverWait(BaseWebdriver.getDriver(), Configuration.getExplicit());
	private static final Logger logger = LoggerClass.createLogger();
	public static boolean isElemntVisble(WebElement webElement) {
		try {
			wait.until(ExpectedConditions.visibilityOf(webElement));
			return true;
		} catch (ElementNotVisibleException e) {
			logger.info("Could not find visablity of element " + webElement + " " + e.getMessage());
			return false;
		}
	}

	public static boolean isElemntclickable(WebElement webElement) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(webElement));
			return true;
		} catch (ElementClickInterceptedException e) {
			logger.info("Could not find visablity of element " + webElement + " " + e.getMessage());
			return false;
		}
	}
	
	public static boolean isTextPresent(WebElement webElement, String textToValidate) {
		try {
			Assert.assertTrue(isElemntVisble(webElement), "Failed as element is not visiable ");
			wait.until(ExpectedConditions.textToBePresentInElement(webElement, textToValidate));
			return true;
		} catch (Exception e) {
			logger.info("Could not find Text " + textToValidate + " of element " + ". But found "
					+ webElement.getText() + " " + e.getMessage());
			return false;
		}
	}

	public static boolean isAllElemntVisble(List<WebElement> webElements) {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(webElements));
			return true;
		} catch (ElementNotVisibleException e) {
			logger.info("Could not find visablity of all elements " + webElements + " " + e.getMessage());
			return false;
		}
	}

	public static boolean isTitlePresent(String title) {
		try {
			wait.until(ExpectedConditions.titleIs(title));
			return true;
		} catch (Exception e) {
			logger.info("Could not find title as provided : " + title + " " + e.getMessage());
			return false;
		}
	}

	public static boolean selectBasedOnVisibleText(WebElement webElement, String visibleText) {
		try {
			assertTrue(isElemntVisble(webElement), "Failed to view select option");
			Select select = new Select(webElement);
			select.selectByVisibleText(visibleText);
			return true;

		} catch (ElementNotSelectableException e) {
			logger.info("Failed to select due to " + e.toString());
			return false;
		}
	}

	public static boolean switchToFrame(WebElement webElement) {
		try {

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(webElement));
			return true;

		} catch (NoSuchFrameException e) {
			logger.info("Failed to switch to frame as  " + e.toString());
			return false;
		}
	}
	
	public static void javaScriptToWaitForPage() {
		String pageLoadStatus;
		do {
			JavascriptExecutor js = (JavascriptExecutor) BaseWebdriver.getDriver();
			pageLoadStatus = (String) js.executeScript("return document.readyState");
		} while (!pageLoadStatus.endsWith("complete"));
	}

	public static String getToDayDate(String format) {
		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		LocalDateTime now = LocalDateTime.now();
		String todayDate = dtf.format(now);
		return todayDate;
	}

}
