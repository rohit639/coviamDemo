package com.coviam.demo.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.coviam.demo.utils.BaseWebdriver;
import com.coviam.demo.utils.FunctionLib;

public class ContactPage extends BasePage {

	private static final String pageValidation ="Get In Touch";
	
	public ContactPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(FunctionLib.isTextPresent(pageValidationElmnt, pageValidation), "Failed to validate page Contact as \"Get In Touch\" is not visable");
	}

}
