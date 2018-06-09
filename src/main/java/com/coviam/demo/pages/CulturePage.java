package com.coviam.demo.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.coviam.demo.utils.BaseWebdriver;
import com.coviam.demo.utils.FunctionLib;

public class CulturePage extends BasePage{

	private static final String pageValidation = "Talent @ coviam";
	
	public CulturePage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(FunctionLib.isTextPresent(pageValidationElmnt, pageValidation), "Failed to validate page Culture as \"Talent @ coviam\" is not visable");
	}

}
