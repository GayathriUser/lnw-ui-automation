package com.ui.automation.suite.amazon.pom;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ui.automation.suite.amazon.pom.HomePage;
import com.ui.automation.suite.amazon.utils.Constants;
import com.ui.automation.suite.amazon.utils.CommonUtils;

@Component
@Scope("cucumber-glue")
public class HomePage extends AbstractPage{

	public HomePage(WebDriver driver, CommonUtils utils) {
		super(driver, utils);
		// TODO Auto-generated constructor stub
	}

	private static final Logger logger = LogManager.getLogger(HomePage.class);
	
	private static final String SEARCH_FIELD = "//input[@id='twotabsearchtextbox']";
	private static final String ITEM_ORDER = "(//a//span[@class='a-size-medium a-color-base a-text-normal'])[%s]";
	private static final String SEARCH_ICON = "//input[@value='Go']";
	private static final String SEARCHED_ITEM_LIST = "//div[@*='s-search-result']";
	private static final String AMAZON_ICON = "//a[@*='Amazon.in']";

	private static final By SEARCH_FIELD_XPATH = By.xpath(SEARCH_FIELD);
	private static final By SEARCH_ICON_XPATH = By.xpath(SEARCH_ICON);
	private static final By SEARCHED_ITEM_LIST_XPATH = By.xpath(SEARCHED_ITEM_LIST);
	private static final By AMAZON_ICON_XPATH = By.xpath(AMAZON_ICON);

	/**
	 * @param String product
	 * @return  void
	 */
	public void setProduct(String product) {
		utils.waitforElementToBeVisible(SEARCH_FIELD_XPATH, Constants.timeout);
		logger.info("search field is visible");
		utils.clearElement(SEARCH_FIELD_XPATH);
		logger.info("search field is cleared");
		utils.setElement(SEARCH_FIELD_XPATH, product);
	}

	/**
	 * This method is used for click on SearchIcon.
	 * 
	 * @param no param
	 * @return  void
	 */
	public void clickSearchIcon() {
		logger.info("search icon element is clickable");
		utils.waitforElementToBeClickable(SEARCH_ICON_XPATH);
		utils.clickElement(SEARCH_ICON_XPATH);
	}
	
	/**
	 * @param no param
	 * @return  return integer value
	 */

	public int getSearchItemList() {
		List<WebElement> itemList = utils.getWeElements(SEARCHED_ITEM_LIST_XPATH);
		logger.info("searched item elementlist is displayed as "+ itemList.size());
		return itemList.size();
	}
	
	/**
	 * @param int orderItem
	 * @return void
	 */

	public void selectSearchedProducts(int orderItem) {
		By ITEM_ORDER_XPATH = By.xpath(String.format(ITEM_ORDER, orderItem));
		WebElement product = utils.getWeElement(ITEM_ORDER_XPATH);
		logger.info("item element is visible");
		utils.waitforElementToBeVisible(ITEM_ORDER_XPATH, Constants.timeout);
		utils.moveToElement(product);
		logger.info("item element is clickable");
		utils.waitforElementToBeClickable(ITEM_ORDER_XPATH);
		utils.clickElement(ITEM_ORDER_XPATH);
		
	}
	
	/**
	 * @param no param
	 * @return boolean value as true or false
	 */
	public boolean ClickOnAmazonIcon() {
		logger.info("amazon icon element is clickable");
		utils.waitforElementToBeClickable(AMAZON_ICON_XPATH);
		utils.clickElement(AMAZON_ICON_XPATH);
		utils.waitforElementToBeVisible(SEARCH_FIELD_XPATH, Constants.timeout);
		return utils.getWeElement(SEARCH_ICON_XPATH).isDisplayed();
	}

}
