package com.test.Utils;

import java.io.File;
import java.io.IOException;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class TestUtility {

	
	public String takeScreenshots(WebDriver driver) throws IOException{
		String destination = "C:\\Stuff\\Reetu\\WorkSpace\\CucumberBDDJUnitSingleInputField\\screenshots\\img"+System.currentTimeMillis()+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyDirectory(src, new File(destination));
		FileUtils.copyFile(src, new File(destination));
		return destination;
		
	}
	
	

}
