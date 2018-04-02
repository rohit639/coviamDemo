package com.imdb.topList.utils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

	}

	@BeforeMethod(alwaysRun = true)
	public void print() {
		if (Configuration.getbrowser().equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (Configuration.getbrowser().equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
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
		if (Configuration.getbrowser().equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", getPlatform() + "/chromedriver");
		}

		else if (Configuration.getbrowser().equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", getPlatform() + "/geckodriver");
		}

		else {
			System.out.println("Please check browser name provided. it should be eitehr firefox or chrome");
			System.exit(1);
		}

	}

	private Path getPlatform() {
		ClassLoader classLoader = BaseWebdriver.class.getClassLoader();
		Path resourceDirectory;
		if (PlatformUtil.isMac()) {
			resourceDirectory = Paths.get("src", "main", "resources", "mac");
			return resourceDirectory.toAbsolutePath();
		} else if (PlatformUtil.isWindows()) {
			resourceDirectory = Paths.get("src", "main", "resources", "windows");
			return resourceDirectory.toAbsolutePath();
		} else if (PlatformUtil.isLinux()) {
			resourceDirectory = Paths.get("src", "main", "resources", "linux");
			return resourceDirectory.toAbsolutePath();
		}

		else
			System.out.println("Platform should be one of these Mac/Windows/linux. Failed as test platform is :"
					+ System.getProperty("os.name"));
		return null;
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
