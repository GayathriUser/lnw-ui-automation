package com.ui.automation.suite.amazon.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ui.automation.suite.amazon.utils.BrowserType;
import com.ui.automation.suite.amazon.utils.CommonUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

@Component
@Scope("cucumber-glue")
public class Init extends CucumberStepDefinition {
	private static Logger logger = LogManager.getLogger(Init.class);
	
	
//	@AfterSuite
//	public void teardown() {
//		try {
//			driver.close();
//			driver.quit();
//			logger.info("cleaning up browser session");
//		} catch (Exception e) {
//			Thread.currentThread().interrupt();
//		}
//
//	}
	
}
