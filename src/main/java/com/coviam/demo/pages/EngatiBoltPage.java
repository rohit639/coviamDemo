package com.coviam.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.coviam.demo.utils.BaseWebdriver;
import com.coviam.demo.utils.FunctionLib;
import com.coviam.demo.utils.Locators;

public class EngatiBoltPage extends BasePage {

	@FindBy(id = Locators.EngatiBoltPageLocators.homeLogoEngatiPage)
	private WebElement homeLogoElmnt;

	private static final String url = "https://www.engati.com/";

	public EngatiBoltPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(switchToWindow(url, homeLogoElmnt), "Failed as could not switch to EngatiBolt page");
	}

}
