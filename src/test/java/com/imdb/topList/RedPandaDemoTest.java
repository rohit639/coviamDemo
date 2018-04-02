package com.imdb.topList;

import org.testng.annotations.Test;

import com.imdb.topList.pages.LandingPage;
import com.imdb.topList.utils.BaseWebdriver;
import com.imdb.topList.utils.SqLiteDB;

public class RedPandaDemoTest extends BaseWebdriver {

	@Test(enabled = true)
	public void testing() {
		LandingPage homePage = new LandingPage();
		homePage.navigateToTopList().getAllList();
	}

	@Test(enabled = true, dependsOnMethods = "testing")
	public void testing1() {
		SqLiteDB.printResult();
	}

}
