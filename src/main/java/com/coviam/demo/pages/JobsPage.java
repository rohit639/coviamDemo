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
	
	@FindBy(id = Locators.JobsPageLocators.homeLogoJobsPage)
	private WebElement logoElmnt;
	
	

	private static final String url = "http://talent.coviam.com/";

	public JobsPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		switchToJobs();
	}

	public BasePage switchToJobs() {
		final String mainPage = BaseWebdriver.getDriver().getWindowHandle();
		int counter =1;
		for (String window : BaseWebdriver.getDriver().getWindowHandles()) {
			BaseWebdriver.getDriver().switchTo().window(window);
			FunctionLib.javaScriptToWaitForPage();
			if (BaseWebdriver.getDriver().getCurrentUrl().equalsIgnoreCase(url)) {
				counter++;
				Assert.assertTrue(FunctionLib.isElemntVisble(logoElmnt),"Failed as could not Validate logo in Jobs page");
				Assert.assertTrue(verifyLocatoionBangalore(), "Failed to verify location Bangalore in Jobs portal");
				BaseWebdriver.closeBrowser();
				BaseWebdriver.getDriver().switchTo().window(mainPage);
			}
		}
		Assert.assertEquals(2, counter, "Failed as could not find URL :" + url + " to switch and validate page");
		return new BasePage();
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
