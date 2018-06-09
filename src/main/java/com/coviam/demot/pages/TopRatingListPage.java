package com.imdb.topList.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.imdb.topList.utils.BaseWebdriver;
import com.imdb.topList.utils.FunctionLib;
import com.imdb.topList.utils.Locators;
import com.imdb.topList.utils.SqLiteDB;

public class TopRatingListPage extends BasePage {

	@FindBy(className = Locators.TopRatingListPage.pageValidationLocator)
	WebElement pageValidation;

	@FindBy(className = Locators.TopRatingListPage.imdbRatingsLocator)
	List<WebElement> imdbRatings;

	@FindBy(className = Locators.TopRatingListPage.titleWithYearsLocator)
	List<WebElement> titleWithYears;

	private static final String title = "IMDb Top 250 - IMDb";
	private static final String pageValidationText = "Top 250 as rated by IMDb Users";

	public TopRatingListPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(FunctionLib.isTitlePresent(title),
				"Failed as title is not same as provided for test : " + title + " on page " + this);
		Assert.assertTrue(FunctionLib.isTextPresent(pageValidation, pageValidationText),
				"Failed as could not validatge page " + this);
	}

	public void getAllList() {
		Assert.assertEquals(imdbRatings.size(), titleWithYears.size(), "Failed as Rating and tilte not equals in size");
		SqLiteDB.createConnection();
		SqLiteDB.creatTable();
		saveIntoDB();
	}

	private void saveIntoDB() {
		int i = 0;
		for (WebElement webElement : titleWithYears) {
			WebElement title = webElement.findElement(By.tagName("a"));
			WebElement year = webElement.findElement(By.className("secondaryInfo"));
			String movieName = title.getText();
			String yearS = year.getText().substring(1, year.getText().length() - 1);// replaceAll("[()]", "");
			int yearOfRelease = Integer.parseInt(yearS);
			double rating = Double.parseDouble(imdbRatings.get(i).getText());
			SqLiteDB.addIntoTable(movieName, yearOfRelease, rating);
			i++;
		}
	}

}
