package com.coviam.demo.tests;

import org.testng.annotations.Test;

import com.coviam.demo.pages.LandingPage;
import com.coviam.demo.utils.BaseWebdriver;

public class CoviamDemoTest extends BaseWebdriver {

	@Test(enabled = true, alwaysRun = true, priority = 4, groups = { "smokeTest", "regression" })
	public void verifyBasicPages() {
		LandingPage homePage = new LandingPage();
		 homePage.navigateToWhoPage().navigateToWhatPage().navigateToHowPage()
		 .navigateToContactPage().navigateToChatPage().closeBot().navigateToCulturePage();
	}
	
	@Test(enabled = true, alwaysRun = true, priority = 2, groups = { "smokeTest", "regression" })
	public void verifyWhatPage() {
		LandingPage homePage = new LandingPage();
		homePage.navigateToWhatPage().navigateToEngatiPage().navigateToWhatPage().navigateToAutoMiPage();
	}

	@Test(enabled = true, alwaysRun = true, priority = 3, groups = { "smokeTest", "regression" })
	public void verifyBlogNewsPage() {
		LandingPage homePage = new LandingPage();
		homePage.navigateToBlogPage().navigateToNewsPage();
	}
	
	@Test(enabled = true, alwaysRun = true, priority = 1, groups = { "smokeTest", "regression" })
	public void verifyJobLocationBangalore() {
		LandingPage homePage = new LandingPage();
		homePage.navigateToJobsPage();
	}
}
