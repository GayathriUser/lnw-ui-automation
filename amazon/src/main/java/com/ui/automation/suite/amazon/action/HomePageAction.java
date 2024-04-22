package com.ui.automation.suite.amazon.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ui.automation.suite.amazon.pom.HomePage;

@Component
@Scope("cucumber-glue")
public class HomePageAction {

	@Autowired
	HomePage homePage;
	
	private static Logger logger = LogManager.getLogger(HomePageAction.class);
	
	public void setProductInSearchBoxAndClicked(String product) {
		homePage.setProduct(product);
		logger.info("Enter product in search field");
		homePage.clickSearchIcon();
		logger.info("Search icon clicked");
	}
	
	
	public void clickOnSearchedProduct(int product) {
		logger.info("Choose the product from search");
		homePage.selectSearchedProducts(product);
	}
	
	public void navigateToHomePage() {
		homePage.ClickOnAmazonIcon();
		logger.info("Navigate to home page");		
	}
}
