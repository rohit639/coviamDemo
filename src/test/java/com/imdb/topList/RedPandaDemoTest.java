package com.imdb.topList;

import org.testng.annotations.Test;

import com.imdb.topList.pages.LandingPage;
import com.imdb.topList.utils.BaseWebdriver;
import com.imdb.topList.utils.SqLiteDB;

public class RedPandaDemoTest extends BaseWebdriver {

	@Test(enabled = true,alwaysRun=true,priority=1,groups= {"smokeTest","regression"})
	public void gettingAllRatitngs() {
		LandingPage homePage = new LandingPage();
		homePage.navigateToTopList().getAllList();
	}

	@Test(enabled = true, alwaysRun=true,priority=2,groups= {"smokeTest","regression"})
	public void printingAllResults() {
		SqLiteDB.printResult();
	}

}
