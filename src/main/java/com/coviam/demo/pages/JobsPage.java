package com.coviam.demo.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.coviam.demo.utils.BaseWebdriver;
import com.coviam.demo.utils.FunctionLib;
import com.coviam.demo.utils.Locators;

public class JobsPage extends BasePage {

	@FindBy(className = Locators.JobsPageLocators.location)
	private List<WebElement> loctionElmnt;

	private static final String title = "Talent @ Coviam &#8211; Coviam Technologies";

	public JobsPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(FunctionLib.isTitlePresent(title),
				"Failed as title is not same as provided for test : " + title + " on page " + this);
	}

	public JobsPage switchToWindow() {
		final String mainPage = BaseWebdriver.getDriver().getWindowHandle();
		for (String window : BaseWebdriver.getDriver().getWindowHandles()) {
			BaseWebdriver.getDriver().switchTo().window(window);
			if (BaseWebdriver.getDriver().getTitle().equalsIgnoreCase(title)) {
				Assert.assertTrue(verifyLocatoionBangalore(), "Failed to verify location Bangalore in Jobs portal");
				BaseWebdriver.closeBrowser();
				BaseWebdriver.getDriver().switchTo().window(mainPage);
			}
		}
		return this;
	}

	private boolean verifyLocatoionBangalore() {
		Assert.assertTrue(FunctionLib.isAllElemntVisble(loctionElmnt), "Failed as all locations are not visable");
		for (WebElement webElement : loctionElmnt) {
			if (webElement.getText().equals("Bangalore"))
				return true;
		}
		return false;
	}
}
