package com.test.Utils;

import java.io.File;
import java.io.IOException;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.test.TestBase.TestBase;

public class TestUtility {

	/*public TestUtility() throws IOException {
		super();
		
	}*/
	
	public String takeScreenshots(WebDriver driver) throws IOException{
		String destination = "C:\\Stuff\\Reetu\\WorkSpace\\CucumberBDDJUnitSingleInputField\\screenshots\\img"+System.currentTimeMillis()+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyDirectory(src, new File(destination));
		FileUtils.copyFile(src, new File(destination));
		return destination;
		
	}
	
	/*public ExtentTest testReport(){
		
		htmlReporter = new ExtentHtmlReporter("C:\\Stuff\\Reetu\\WorkSpace\\CucumberBDDJUnitSingleInputField\\extentReport\\extent.html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		extentTest = extentReport.createTest("Cucumber BDD JUnit Single Input Field Test", "Single Input Field Test");
		return extentTest;
		
	}*/

}
