package com.coviam.demo.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.coviam.demo.utils.BaseWebdriver;
import com.coviam.demo.utils.FunctionLib;

public class WhoPage extends BasePage {
	
	public static final String pageValidation ="Our Team";
	
	public WhoPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(FunctionLib.isTextPresent(pageValidationElmnt, pageValidation), "Failed to validate page who as \"Our Team\" is not visable");
	}

}
