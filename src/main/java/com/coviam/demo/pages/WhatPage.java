package com.coviam.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.coviam.demo.utils.BaseWebdriver;
import com.coviam.demo.utils.FunctionLib;
import com.coviam.demo.utils.Locators;

public class WhatPage extends BasePage {

	@FindBy(xpath = Locators.WhatPageLocators.engati)
	private WebElement engatiElmnt;

	@FindBy(xpath = Locators.WhatPageLocators.autoMI)
	private WebElement autoMiElmnt;

	private static final String pageValidation = "Stuff we do";

	public WhatPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(FunctionLib.isTextPresent(pageValidationElmnt, pageValidation),
				"Failed to validate page as \"Stuff we do\" is not visable on What Page and url to page is "
						+ BaseWebdriver.getDriver().getCurrentUrl());
	}

	public EngatiBoltPage navigateToEngatiPage() {
		Assert.assertTrue(FunctionLib.isElemntclickable(engatiElmnt),
				"failed not click on element : engati link on page" + this);
		engatiElmnt.click();
		return new EngatiBoltPage();
	}

	public AutoMiPage navigateToAutoMiPage() {
		Assert.assertTrue(FunctionLib.isElemntclickable(autoMiElmnt),
				"failed not click on element : engati link on page" + this);
		autoMiElmnt.click();
		return new AutoMiPage();
	}

}
