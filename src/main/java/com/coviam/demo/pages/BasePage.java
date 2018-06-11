package com.coviam.demo.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.coviam.demo.utils.BaseWebdriver;
import com.coviam.demo.utils.FunctionLib;
import com.coviam.demo.utils.Locators;
import com.coviam.demo.utils.LoggerClass;

public class BasePage {

	@FindBy(className = Locators.BasePageLocators.homeLoGoLocator)
	WebElement homeLogo;

	@FindBy(linkText = Locators.BasePageLocators.who)
	WebElement whoElmnt;

	@FindBy(linkText = Locators.BasePageLocators.what)
	WebElement whatElmnt;

	@FindBy(linkText = Locators.BasePageLocators.how)
	WebElement howElmnt;

	@FindBy(linkText = Locators.BasePageLocators.blog)
	WebElement blogElmnt;

	@FindBy(linkText = Locators.BasePageLocators.news)
	WebElement newsElmnt;

	@FindBy(linkText = Locators.BasePageLocators.culture)
	WebElement cultureElmnt;

	@FindBy(linkText = Locators.BasePageLocators.jobs)
	WebElement jobsElmnt;

	@FindBy(linkText = Locators.BasePageLocators.contact)
	WebElement contactElmnt;

	@FindBy(id = Locators.BasePageLocators.pageHeadingValidation)
	WebElement pageValidationElmnt;

	@FindBy(className = Locators.BasePageLocators.career)
	WebElement careerElmnt;

	@FindBy(id = Locators.BasePageLocators.ChatBOT)
	WebElement chatBotElmnt;

	@FindBy(id = Locators.BasePageLocators.ChatBOtClose)
	WebElement closeBotElmnt;
	
	protected static final Logger logger = LoggerClass.createLogger();

	public BasePage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
	}

	public WhoPage navigateToWhoPage() {
		Assert.assertTrue(FunctionLib.isElemntclickable(whoElmnt),
				"failed not click on element : " + whoElmnt.getText());
		whoElmnt.click();
		return new WhoPage();
	}

	public WhatPage navigateToWhatPage() {
		Assert.assertTrue(FunctionLib.isElemntclickable(whatElmnt),
				"failed not click on element : " + whoElmnt.getText());
		whatElmnt.click();
		return new WhatPage();
	}

	public HowPage navigateToHowPage() {
		Assert.assertTrue(FunctionLib.isElemntclickable(howElmnt),
				"failed not click on element : " + howElmnt.getText());
		howElmnt.click();
		return new HowPage();
	}

	public ContactPage navigateToContactPage() {
		Assert.assertTrue(FunctionLib.isElemntclickable(contactElmnt),
				"failed not click on element : " + contactElmnt.getText());
		contactElmnt.click();
		return new ContactPage();
	}

	public ChatBotPage navigateToChatPage() {
		Assert.assertTrue(FunctionLib.isElemntclickable(chatBotElmnt),
				"failed not click on element : " + chatBotElmnt.getText());
		chatBotElmnt.click();
		return new ChatBotPage();
	}

	public JobsPage navigateToJobsPage() {
		gotoCareer();
		Assert.assertTrue(FunctionLib.isElemntclickable(jobsElmnt),
				"failed not click on element : " + contactElmnt.getText());
		jobsElmnt.click();
		return new JobsPage();
	}
	
	public BlogPage navigateToBlogPage() {
		Assert.assertTrue(FunctionLib.isElemntclickable(blogElmnt),
				"failed not click on element : " + blogElmnt.getText());
		blogElmnt.click();
		return new BlogPage();
	
	}
	
	public NewsPage navigateToNewsPage() {
		Assert.assertTrue(FunctionLib.isElemntclickable(newsElmnt),
				"failed not click on element : " + blogElmnt.getText());
		newsElmnt.click();
		return new NewsPage();
	
	}

	public CulturePage navigateToCulturePage() {
		gotoCareer();
		Assert.assertTrue(FunctionLib.isElemntclickable(cultureElmnt),
				"failed not click on element : " + cultureElmnt.getText());
		cultureElmnt.click();
		return new CulturePage();
	}

	private void gotoCareer() {
		Assert.assertTrue(FunctionLib.isElemntclickable(careerElmnt),
				"failed not click on element : " + careerElmnt.getText());
		careerElmnt.click();
	}
	
	public BasePage NavigateToMainWindow(String pageName) {
		BaseWebdriver.closeBrowser();
		BaseWebdriver.getDriver().switchTo().window(pageName);
		return new BasePage();
	}
	
	public boolean switchToWindow(String url,WebElement verifyElement) {
		final String mainPage = BaseWebdriver.getDriver().getWindowHandle();
		int counter = 0;
		for (String window : BaseWebdriver.getDriver().getWindowHandles()) {
			BaseWebdriver.getDriver().switchTo().window(window);
			if (BaseWebdriver.getDriver().getCurrentUrl().equalsIgnoreCase(url)) {
				counter++;
				System.out.println("URL looking for is : "+url+" & getting title as "+BaseWebdriver.getDriver().getCurrentUrl());
				Assert.assertTrue(FunctionLib.isElemntVisble(verifyElement),
						"Failed as element is not visable : " + verifyElement.getText() + " on page ");
				NavigateToMainWindow(mainPage);
				}
		}
		Assert.assertEquals(1, counter,"Failed as could not find URL :"+url+" to switch and validate page");
		return true;
	}

}
