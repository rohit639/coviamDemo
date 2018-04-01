package com.imdb.topList.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.imdb.topList.utils.BaseWebdriver;
import com.imdb.topList.utils.FunctionLib;

public class LandingPage extends BasePage{
	
	@FindBy(linkText="Top 250 Movies")
	WebElement top250List;
	
	private static final String title = "IMDb - Movies, TV and Celebrities - IMDb";
	
	public LandingPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(),this);
		Assert.assertTrue(FunctionLib.isTitlePresent(title),"Failed as title is not same as provided for test : "+title+" on page "+this);
	}

	
	public TopRatingListPage navigateToTopList() {
		Assert.assertTrue(FunctionLib.isElemntVisble(top250List));
		top250List.click();
		return new TopRatingListPage();
	}
/*	
 * WebElement top250List = getDriver().findElement(By.linkText("Top 250 Movies"));
		FunctionLib.isElemntVisble(top250List);
		top250List.click();
	*/
}
