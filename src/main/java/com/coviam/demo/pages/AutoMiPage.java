package com.coviam.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.coviam.demo.utils.BaseWebdriver;
import com.coviam.demo.utils.Locators;

public class AutoMiPage extends BasePage{

	@FindBy(className=Locators.AutoMiPageLocators.homeLogoAutoMiPage)
	private WebElement homeLogoElmnt;
	
	private static final String url = "http://www.automi.io/";
	
	public AutoMiPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(switchToWindow(url,homeLogoElmnt),"Failed as could not switch to AutoMi page");
	}

}
