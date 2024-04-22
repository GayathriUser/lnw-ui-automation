package com.ui.automation.suite.amazon.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.annotations.BeforeTest;

import com.ui.automation.suite.amazon.action.ProductPageAction;
import com.ui.automation.suite.amazon.handlers.WebDriverHandler;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CucumberStepDefinition{
	
	@Autowired
	WebDriverHandler handler;
	
	private static Logger logger = LogManager.getLogger(Hooks.class);

	public void setUp(Scenario scenario) {
		try {
			MDC.put("scenarioName", scenario.getName());
			logger.info("Started scenario: " + scenario.getName());
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			logger.info("Driver object initialized and launching web application");
		} catch (Exception e) {
			logger.error("Exception occurred during setup: " + e.getMessage());
			throw new RuntimeException("Error during setup", e);
		}
	}

	@After
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed())
		{
		TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshotBytes, "image/png", "Screenshot after step: ");
			
		}
		try {
			if (driver != null) {
				driver.quit();
				logger.info("Quitting web Driver object");
			}
			MDC.remove(scenario.getName());
			logger.info("Finished scenario: " + scenario.getName());
		} catch (Exception e) {
			logger.error("Exception occurred during teardown: " + e.getMessage());
			throw new RuntimeException("Error during teardown", e);
		}
	}
	
	@AfterStep
	public void takeScreenshotAfterStep(Scenario scenario) {
		if(scenario.isFailed())
		{
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotBytes, "image/png", "Screenshot after step: ");
		} catch (Exception e) {
			System.out.println("Exception occurred while taking screenshot: " + e.getMessage());
		}
		}

	}
}
