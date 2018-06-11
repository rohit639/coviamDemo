package com.coviam.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.coviam.demo.utils.BaseWebdriver;
import com.coviam.demo.utils.Locators;

public class BlogPage extends BasePage {

	@FindBy(className=Locators.BlogPageLocators.homeLogoBlogPage)
	private WebElement blogLogoElmnt;
	
	private static final String url = "http://blog.coviam.com/";
	
	public BlogPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(switchToWindow(url,blogLogoElmnt),"Failed as could not switch to blog page");
		
	}

}
