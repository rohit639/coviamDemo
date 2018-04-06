package com.imdb.topList.utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendedReport {

	public static final ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/extent.html"));
	public static final ExtentReports extent = new ExtentReports();
	public static ExtentTest test;
	
	static {
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/extend-config.xml"));
		htmlReporter.setAppendExisting(false);
		extent.attachReporter(htmlReporter);
	}
	
	

}
