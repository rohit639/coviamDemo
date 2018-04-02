package com.imdb.topList.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.sun.javafx.PlatformUtil;

public class BaseWebdriver {

	public static WebDriver driver;

	@BeforeSuite(alwaysRun = true)
	public void initializeDriver() {
		setDriverPath();
		driver = new ChromeDriver();
	}

	@BeforeMethod(alwaysRun = true)
	public void print() {
		driver.get(Configuration.getUrl());
		settingBrowser();
	}

	@AfterMethod(alwaysRun = true)
	public static void closeBrowser() {
		System.out.println("Closeing Browser...");
		driver.close();
	}

	@AfterSuite(alwaysRun = true)
	public static void closeWebDriver() {
		if (driver != null)
			driver.quit();
	}

	private static void settingBrowser() {
		getDriver().manage().timeouts().implicitlyWait(Configuration.getImplicit(), TimeUnit.MINUTES);
		getDriver().manage().timeouts().pageLoadTimeout(Configuration.getPageload(), TimeUnit.MINUTES);
		getDriver().manage().timeouts().setScriptTimeout(Configuration.getScript(), TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
	}

	private void setDriverPath() {
		if (PlatformUtil.isMac()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
		} else if (PlatformUtil.isWindows()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		} else if (PlatformUtil.isLinux()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
		}

		else
			System.out.println("Platform should be one of these Mac/Windows/linux. Failed as test platform is :"
					+ System.getProperty("os.name"));

	}

	public static WebDriver getDriver() {
		return driver;
	}

}
