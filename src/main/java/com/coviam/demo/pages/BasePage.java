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
		Assert.assertTrue(FunctionLib.isElemntclickable(whatElmnt), "failed not click on element : "+whoElmnt.getText());
		whatElmnt.click();
			return new WhatPage();
		}

	public HowPage navigateToHowPage() {
		Assert.assertTrue(FunctionLib.isElemntclickable(howElmnt), "failed not click on element : "+howElmnt.getText());
		howElmnt.click();
			return new HowPage();
		}
	
	public ContactPage navigateToContactPage() {
		Assert.assertTrue(FunctionLib.isElemntclickable(contactElmnt), "failed not click on element : "+contactElmnt.getText());
		contactElmnt.click();
			return new ContactPage();
		}
	
	public JobsPage navigateToJobsPage() {
		gotoCareer();
		Assert.assertTrue(FunctionLib.isElemntclickable(jobsElmnt), "failed not click on element : "+contactElmnt.getText());
		jobsElmnt.click();
		return new JobsPage();		
	}
	
	public CulturePage navigateToCulturePage() {
		gotoCareer();
		Assert.assertTrue(FunctionLib.isElemntclickable(cultureElmnt), "failed not click on element : "+cultureElmnt.getText());
		cultureElmnt.click();	
	return new CulturePage();		
	}


	private void gotoCareer() {
		Assert.assertTrue(FunctionLib.isElemntclickable(careerElmnt), "failed not click on element : "+careerElmnt.getText());
		careerElmnt.click();
	}
	
}
