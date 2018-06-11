package com.coviam.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.coviam.demo.utils.BaseWebdriver;
import com.coviam.demo.utils.Locators;

public class NewsPage extends BasePage {

	@FindBy(id = Locators.NewsPageLocators.homeLogoNewsPage)
	private WebElement newsLogoElmnt;

	private static final String url = "http://news.coviam.com/";

	public NewsPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(switchToWindow(url, newsLogoElmnt), "Failed as could not switch to News Page");
	}

}
