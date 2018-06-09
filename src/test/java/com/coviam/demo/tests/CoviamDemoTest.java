package com.coviam.demo.tests;

import org.testng.annotations.Test;

import com.coviam.demo.pages.LandingPage;
import com.coviam.demo.utils.BaseWebdriver;

public class CoviamDemoTest extends BaseWebdriver {

	@Test(enabled = true,alwaysRun=true,priority=1,groups= {"smokeTest","regression"})
	public void gettingAllRatitngs() {
		LandingPage homePage = new LandingPage();
		
	}

	
}
