package com.coviam.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.coviam.demo.utils.BaseWebdriver;
import com.coviam.demo.utils.FunctionLib;
import com.coviam.demo.utils.Locators;

public class LandingPage extends BasePage {

	@FindBy(linkText = Locators.LandingPage.top250Locators)
	WebElement top250List;

	private static final String title = "IMDb - Movies, TV and Celebrities - IMDb";

	public LandingPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(FunctionLib.isTitlePresent(title),
				"Failed as title is not same as provided for test : " + title + " on page " + this);
	}

	/*public TopRatingListPage navigateToTopList() {
		Assert.assertTrue(FunctionLib.isElemntVisble(top250List));
		top250List.click();
		return new TopRatingListPage();
	}*/
}
