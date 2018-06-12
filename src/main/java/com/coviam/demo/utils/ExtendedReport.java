package com.coviam.demo.utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendedReport {
 
	public static final ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(new File(Configuration.getAppName()+".html"));
	public static final ExtentReports extent = new ExtentReports();
	public static ExtentTest test;
	
	static {
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/report-config.xml"));
		htmlReporter.config().setDocumentTitle(Configuration.getAppName()+"-Automation Report");
		htmlReporter.config().setReportName(Configuration.getAppName()+" -- Test Cases Execution Result");
		htmlReporter.setAppendExisting(false);
		extent.attachReporter(htmlReporter);
	}
	
	

}
