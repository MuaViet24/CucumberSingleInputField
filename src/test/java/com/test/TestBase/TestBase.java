package com.test.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.test.Utils.TestUtility;

public class TestBase {
	public WebDriver driver;
	public Properties prop;
	public Logger log;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	public TestUtility utility;

	public TestBase() throws IOException {
		prop = new Properties();
		FileInputStream fip = new FileInputStream("C:\\Stuff\\Reetu\\WorkSpace\\CucumberBDDJUnitSingleInputField\\src\\main\\java\\com\\test\\Utils\\configure.properties");
		prop.load(fip);
		log= Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("C:\\Stuff\\Reetu\\WorkSpace\\CucumberBDDJUnitSingleInputField\\src\\main\\java\\com\\test\\Utils\\log4j.properties");
		utility = new TestUtility();
		testReport();
		
	}

	public void initialization() throws IOException{
		System.setProperty("webdriver.chrome.driver", "C:\\Stuff\\Reetu\\BrowserDriver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		log.info("Browser has been launched");
		extentTest.log(Status.INFO, "Browser has been launched", MediaEntityBuilder.createScreenCaptureFromPath(utility.takeScreenshots(driver)).build());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void testReport(){

		htmlReporter = new ExtentHtmlReporter("C:\\Stuff\\Reetu\\WorkSpace\\CucumberBDDJUnitSingleInputField\\extentReport\\extent.html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		extentTest = extentReport.createTest("Cucumber BDD JUnit Single Input Field Test", "Single Input Field Test");
		

	}

}
