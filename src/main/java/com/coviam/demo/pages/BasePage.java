package com.coviam.demo.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.coviam.demo.utils.BaseWebdriver;
import com.coviam.demo.utils.FunctionLib;
import com.coviam.demo.utils.Locators;
import com.coviam.demo.utils.LoggerClass;

public class BasePage {

	@FindBy(id = Locators.BasePage.homeLoGoLocator)
	WebElement homeLogo;
	
	protected static final Logger logger =LoggerClass.createLogger();
	
	public BasePage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(FunctionLib.isElemntVisble(homeLogo), "Failed as home logo is not visiable on the screen");
	}

}
