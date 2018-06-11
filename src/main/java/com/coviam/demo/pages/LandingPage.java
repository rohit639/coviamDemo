package com.coviam.demo.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.coviam.demo.utils.BaseWebdriver;
import com.coviam.demo.utils.FunctionLib;

public class LandingPage extends BasePage {

	public LandingPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(FunctionLib.isElemntVisble(homeLogo),
				"Failed as home logo is not visiable on Landing/Home Page and url to page is "
						+ BaseWebdriver.getDriver().getCurrentUrl());
	}

}
