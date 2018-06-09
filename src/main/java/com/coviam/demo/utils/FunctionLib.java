package com.imdb.topList.utils;

import static org.testng.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FunctionLib {

	private final static WebDriverWait wait = new WebDriverWait(BaseWebdriver.getDriver(), Configuration.getExplicit());

	public static boolean isElemntVisble(WebElement webElement) {
		try {
			wait.until(ExpectedConditions.visibilityOf(webElement));
			return true;
		} catch (ElementNotVisibleException e) {
			System.out.println("Could not find visablity of element " + webElement + " " + e.getMessage());
			return false;
		}
	}

	public static boolean isTextPresent(WebElement webElement, String textToValidate) {
		try {
			Assert.assertTrue(isElemntVisble(webElement), "Failed as element is not visiable ");
			wait.until(ExpectedConditions.textToBePresentInElement(webElement, textToValidate));
			return true;
		} catch (Exception e) {
			System.out.println("Could not find Text " + textToValidate + " of element " + ". But found "
					+ webElement.getText() + " " + e.getMessage());
			return false;
		}
	}

	public static boolean isAllElemntVisble(List<WebElement> webElements) {
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(webElements));
			return true;
		} catch (ElementNotVisibleException e) {
			System.out.println("Could not find visablity of all elements " + webElements + " " + e.getMessage());
			return false;
		}
	}

	public static boolean isTitlePresent(String title) {
		try {
			wait.until(ExpectedConditions.titleIs(title));
			return true;
		} catch (Exception e) {
			System.out.println("Could not find title as provided : " + title + " " + e.getMessage());
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
			System.out.println("Failed to select due to " + e.toString());
			return false;
		}
	}

	public static boolean switchToFrame(WebElement webElement) {
		try {

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(webElement));
			return true;

		} catch (NoSuchFrameException e) {
			System.out.println("Failed to switch to frame as  " + e.toString());
			return false;
		}
	}

	public static String getToDayDate(String format) {
		final DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		LocalDateTime now = LocalDateTime.now();
		String todayDate = dtf.format(now);
		return todayDate;
	}

}
