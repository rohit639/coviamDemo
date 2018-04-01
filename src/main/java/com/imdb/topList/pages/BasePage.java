package com.imdb.topList.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.imdb.topList.utils.BaseWebdriver;
import com.imdb.topList.utils.FunctionLib;

public class BasePage {
	
	@FindBy(id="home_img_holder")
	WebElement homeLogo;
	
	public BasePage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(FunctionLib.isElemntVisble(homeLogo), "Failed as home logo is not visiable on the screen");
	}

}
