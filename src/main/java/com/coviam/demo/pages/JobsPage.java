package com.coviam.demo.pages;

import org.openqa.selenium.support.PageFactory;

import com.coviam.demo.utils.BaseWebdriver;

public class JobsPage extends BasePage {

	private static final String pageValidation = "INNOVATE\n"+"DIGITAL";
	
	public JobsPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
	}

}
