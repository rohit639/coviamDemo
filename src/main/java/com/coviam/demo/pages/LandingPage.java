package com.coviam.demo.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.coviam.demo.utils.BaseWebdriver;
import com.coviam.demo.utils.FunctionLib;

public class LandingPage extends BasePage {

	private static final String title = "nCoviam Technologies - Innovate Digital | Innovative Technology Startup, Bangalore";

	public LandingPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(FunctionLib.isTitlePresent(title),
				"Failed as title is not same as provided for test : " + title + " on page " + this);
		Assert.assertTrue(FunctionLib.isElemntVisble(homeLogo), "Failed as home logo is not visiable on the screen");
	}

}
