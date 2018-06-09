package com.coviam.demo.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.coviam.demo.utils.BaseWebdriver;
import com.coviam.demo.utils.FunctionLib;

public class WhatPage extends BasePage {

public static final String pageValidation ="Stuff we do";
	
	 public WhatPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(FunctionLib.isTextPresent(pageValidationElmnt, pageValidation), "Failed to validate page What as \"Stuff we do\" is not visable");
	}
	
}
