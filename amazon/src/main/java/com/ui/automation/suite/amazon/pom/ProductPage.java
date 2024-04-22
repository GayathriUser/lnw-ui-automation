package com.ui.automation.suite.amazon.pom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ui.automation.suite.amazon.utils.CommonUtils;
import com.ui.automation.suite.amazon.utils.Constants;

@Component
@Scope("cucumber-glue")
public class ProductPage extends AbstractPage{
	
public ProductPage(WebDriver driver, CommonUtils utils) {
		super(driver, utils);
	}

private static Logger logger = LogManager.getLogger(ProductPage.class);
	
	private static final String PRODUCT_PAGE_PRICE = "//div//div[starts-with(@id , 'corePriceDisplay_')]//span[@class='a-price-whole']";
	private static final By PRODUCT_PAGE_PRICE_XPATH = By.xpath(PRODUCT_PAGE_PRICE);

	/**
	 * This method is used for get productPageIsDisplayen
	 * 
	 * @param String product
	 * @return boolean value as true or false
	 */
	public boolean productPageIsDisplayed(String product ) {
		boolean productPage = driver.getCurrentUrl().contains(product.replaceAll("_price", ""));
		return productPage;
	}	
	
	/**
	 * This method is used for get product price
	 * 
	 * @param String product price
	 * @return void
	 */

	public void getPriceFromProductPage(String productPrice) {
		utils.switchToWindowTab();
		logger.info("focus moved to child window");
		utils.waitforElementToBePresent(PRODUCT_PAGE_PRICE_XPATH, Constants.timeout);
		logger.info("product price elemt is present");
		Constants.savedValues.put(productPrice, utils.getElementText(PRODUCT_PAGE_PRICE_XPATH));
		logger.info("save the product price as "+ utils.getElementText(PRODUCT_PAGE_PRICE_XPATH));
	}

}
