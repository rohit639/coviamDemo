package com.coviam.demo.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.coviam.demo.utils.BaseWebdriver;
import com.coviam.demo.utils.FunctionLib;
import com.coviam.demo.utils.Locators;

public class ChatBotPage extends BasePage {

	private static final String pageValidation = "Coviam Technologies";

	@FindBy(className = Locators.ChatBotPageLocators.title)
	WebElement titleElnmt;
	
	@FindBy(className = Locators.ChatBotPageLocators.ChatBOtImge)
	WebElement chatBotImg;


	public ChatBotPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(FunctionLib.isTextPresent(titleElnmt, pageValidation),
				"Failed to validate page chat-bot as \"Coviam Technologies\" is not visable");
	}

	public BasePage closeBot() {
		Assert.assertTrue(FunctionLib.isElemntVisble(chatBotImg),
				"failed not wait for chat bot image on element : chat bot" );
		Assert.assertTrue(FunctionLib.isElemntclickable(closeBotElmnt),
				"failed not click on element : " + closeBotElmnt.getText());
		((JavascriptExecutor) BaseWebdriver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", closeBotElmnt);
		((JavascriptExecutor) BaseWebdriver.getDriver()).executeScript("arguments[0].click();", closeBotElmnt);
		// Not working with firefox so simply used javascript
		//closeBotElmnt.click(); 
		return new BasePage();
	}

}
