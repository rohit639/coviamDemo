package com.imdb.topList.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.imdb.topList.utils.BaseWebdriver;
import com.imdb.topList.utils.FunctionLib;
import com.imdb.topList.utils.SqLiteDB;

public class TopRatingListPage extends BasePage {

	@FindBy(className="byline")
	WebElement pageValidation;
	
	@FindBy(className="imdbRating")
	List<WebElement> imdbRatings;
	
	@FindBy(className="titleColumn")
	List<WebElement> titleWithYears;
	
	/*@FindBy(tagName="a")
	WebElement movieTitle;
	
	@FindBy(className="secondaryInfo")
	WebElement year;*/
	
	String title = "IMDb Top 250 - IMDb";
	
	public TopRatingListPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(FunctionLib.isTitlePresent(title), "Failed as title is not same as provided for test : "+title+" on page "+this);
		Assert.assertTrue(FunctionLib.isTextPresent(pageValidation, "Top 250 as rated by IMDb Users"), "Failed as could not validatge page "+this);
	}
	
	
	public void getAllList() {
		Assert.assertEquals(imdbRatings.size(), titleWithYears.size(),"Failed as Rating and tilte not equals in size");
		SqLiteDB.getConnection();
		SqLiteDB.creatTable();
		//tbody[@class='lister-list']/tr
		int i=0;
		for (WebElement webElement : titleWithYears) {
			WebElement title = webElement.findElement(By.tagName("a"));
			WebElement year = webElement.findElement(By.className("secondaryInfo"));
			String movieName = title.getText();
			String yearS = year.getText().replaceAll("[()]", "");
			int yearOfRelease = Integer.parseInt(yearS);
			double rating = Double.parseDouble(imdbRatings.get(i).getText());
			SqLiteDB.addIntoTable(movieName, yearOfRelease, rating);
			//System.out.println((i+1)+" "+title.getText()+ "\t:\t"+year.getText().replaceAll("[()]", "")+"\t"+imdbRatings.get(i).getText());
			i++;
		}
		SqLiteDB.printResult();
	}

	
}
