package com.test.stepDefination;



import java.io.IOException;

import org.openqa.selenium.By;

import com.aventstack.extentreports.MediaEntityBuilder;

import com.aventstack.extentreports.Status;
import com.test.TestBase.TestBase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SingleInput extends TestBase {
	
		
	public SingleInput() throws IOException{
		
		initialization();
	}
	
	@Given("^User has navigated to single input form page$")
	public void User_has_navigated_to_single_input_form_page() throws IOException{
				
		driver.get(prop.getProperty("URL"));
		log.info("URL has been launched");
		extentTest.log(Status.INFO, "URL has been launched", MediaEntityBuilder.createScreenCaptureFromPath(utility.takeScreenshots(driver)).build());
		String title = driver.getTitle();
		if(title.contains(prop.getProperty("Title"))){
			log.debug("User navigated to Test Page");
			extentTest.pass("User navigated to Test Page", MediaEntityBuilder.createScreenCaptureFromPath(utility.takeScreenshots(driver)).build());
		}
		else{
			log.error("User navigation failed");
			extentTest.fail("User navigation failed", MediaEntityBuilder.createScreenCaptureFromPath(utility.takeScreenshots(driver)).build());
		}
		
	}
	
	@When("^user submits the form$")
	public void user_submits_the_form() throws IOException{
		
		driver.findElement(By.id("user-message")).sendKeys(prop.getProperty("InputMessage"));
		driver.findElement(By.xpath("//*[@type='button' and text()='Show Message']")).click();
		log.debug("User submits form");
		extentTest.pass("User submits form", MediaEntityBuilder.createScreenCaptureFromPath(utility.takeScreenshots(driver)).build());
	}
	
	@Then("^user validates the result$")
	public void user_validates_the_result() throws IOException{
		
		String msg = driver.findElement(By.id("display")).getText();
		//System.out.println("Message displayed===>" + msg);
		if(msg.contains(prop.getProperty("InputMessage"))){
			log.debug("Message displayed===>" + msg);
			extentTest.pass("Message displayed", MediaEntityBuilder.createScreenCaptureFromPath(utility.takeScreenshots(driver)).build());
		}
		else{
			log.error("Message not displayed");
			extentTest.fail("Message not displayed", MediaEntityBuilder.createScreenCaptureFromPath(utility.takeScreenshots(driver)).build());
			
		}
		
		driver.quit();
		extentReport.flush();
		
	}

}
