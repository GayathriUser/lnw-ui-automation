package com.ui.automation.suite.amazon.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ui.automation.suite.amazon.pom.AddCartPage;


@Component
@Scope("cucumber-glue")
public class AddCartPageAction {
	
	@Autowired
	AddCartPage addCartPage;

private static Logger logger = LogManager.getLogger(AddCartPageAction.class);
	

	public void clickOnAddToCartButton(WebDriver driver){
		addCartPage.clickAddToCartButton(driver);
		logger.info("Clicked add to cart");
	}

	public void NavigateToOpenCart() {
		addCartPage.clickOnCartButton();
		logger.info("Clicked cart button");
	}

	public void clickOnDeleteProduct() {
		logger.info("Clicked delete link");
		addCartPage.clickOnDeleteLink();
	}
}
