package com.ui.automation.suite.amazon.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ui.automation.suite.amazon.pom.ProductPage;

@Component
@Scope("cucumber-glue")
public class ProductPageAction {
private static Logger logger = LogManager.getLogger(ProductPageAction.class);
	@Autowired
	ProductPage productPage;

	public void saveProductPrice(String productPrice) {
		logger.info("amazon icon element is clickable");
		productPage.getPriceFromProductPage(productPrice);
	}
}
