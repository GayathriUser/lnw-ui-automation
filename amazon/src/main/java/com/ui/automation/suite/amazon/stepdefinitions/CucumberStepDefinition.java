package com.ui.automation.suite.amazon.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ui.automation.suite.amazon.action.AddCartPageAction;
import com.ui.automation.suite.amazon.action.HomePageAction;
import com.ui.automation.suite.amazon.action.ProductPageAction;
import com.ui.automation.suite.amazon.config.UISuiteConfiguration;
import com.ui.automation.suite.amazon.data.World;
import com.ui.automation.suite.amazon.pom.AddCartPage;
import com.ui.automation.suite.amazon.pom.HomePage;
import com.ui.automation.suite.amazon.pom.ProductPage;
import com.ui.automation.suite.amazon.validation.HomePageValidation;
import com.ui.automation.suite.amazon.validation.ProductPageValidation;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = UISuiteConfiguration.class)
public class CucumberStepDefinition {

	@Autowired
	WebDriver driver;
	
	@Autowired
	HomePage homePage;
	
	@Autowired
	AddCartPage addCartPage;
	
	@Autowired
	ProductPage productPage;
	
	@Autowired
	HomePageAction homePageAction;
	
	@Autowired
	AddCartPageAction addCartPageAction;
	
	@Autowired
	ProductPageAction productPageAction;
	
	@Autowired
	HomePageValidation homePageValidation;
	
	@Autowired
	ProductPageValidation productPageValidation;
	
	@Autowired
	World world;
}
