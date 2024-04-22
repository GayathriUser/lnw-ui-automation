package com.ui.automation.suite.amazon.validation;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ui.automation.suite.amazon.pom.HomePage;

@Component
@Scope("cucumber-glue")
public class HomePageValidation {
	
	@Autowired
	HomePage homePage;
	
	private static Logger logger = LogManager.getLogger(HomePageValidation.class);

	public void validateProductsListIsDiplayed() {
		assertTrue(homePage.getSearchItemList()>0, "Product Items List is not displayed");
		logger.info("product item is displayed as " + homePage.getSearchItemList());
	}
	
	public void HomePageIsDisplayed() {
		assertTrue(homePage.ClickOnAmazonIcon(), "Home Page is not displayed");
		logger.info("home page is displayed");	
	}

}
