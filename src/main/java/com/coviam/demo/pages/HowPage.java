package com.coviam.demo.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.coviam.demo.utils.BaseWebdriver;
import com.coviam.demo.utils.FunctionLib;

public class HowPage extends BasePage {

	public static final String pageValidation = "Coviation";

	public HowPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(FunctionLib.isTextPresent(pageValidationElmnt, pageValidation),
				"Failed to validate page as \"Coviation\" is not visable on How Page and url to page is "
						+ BaseWebdriver.getDriver().getCurrentUrl());
	}

}
