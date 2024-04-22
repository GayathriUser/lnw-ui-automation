package com.ui.automation.suite.amazon.pom;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ui.automation.suite.amazon.pom.AddCartPage;
import com.ui.automation.suite.amazon.utils.Constants;
import com.ui.automation.suite.amazon.utils.CommonUtils;

@Component
@Scope("cucumber-glue")
public class AddCartPage extends AbstractPage {

	public AddCartPage(WebDriver driver, CommonUtils utils) {
		super(driver, utils);
	}

	private static final Logger logger = LogManager.getLogger(AddCartPage.class);

	private static final String OPEN_CART = "//div[@id='nav-cart-count-container']//span";
	private static final String SUBTOTAL_PRICE = "(//span[@id='sc-subtotal-amount-buybox']//span[contains(@class, 'currency')]//..)[1]";
	private static final String ADD_TO_CART = "//div[@id='desktop_qualifiedBuyBox']//input[@id='add-to-cart-button']";
	private static final String PROCEED_TO_CHECKOUT_BUTTON = "//div[@id='attach-sidesheet-checkout-button']";
	private static final String DELETE_LINK = "//div[@class='sc-item-content-group']//input[@value ='Delete']";
	private static final String SKIP_WARRANTY = "//*[@id='attachSiNoCoverage']//span//input";
	private static final String CART_PAGE_PRICE = "//div[@class='sc-badge-price-to-pay']";
//	private static final String ATTACHED_SLIDE_SHEET = "//div[@id='attach-desktop-sideSheet']";
//	private static final String CART_COUNT = "//span[@id='nav-cart-count']";
	private static final String SLIDER_LINK = "//a[@id='attach-close_sideSheet-link']";
	private static final By OPEN_CART_XPATH = By.xpath(OPEN_CART);
	private static final By SUBTOTAL_PRICE_XPATH = By.xpath(SUBTOTAL_PRICE);
	private static final By ADD_TO_CART_XPATH = By.xpath(ADD_TO_CART);
//	private static final By ATTACHED_SLIDE_SHEET_XPATH = By.xpath(ATTACHED_SLIDE_SHEET);
//	private static final By PROCEED_TO_CHECKOUT_BUTTON_XPATH = By.xpath(PROCEED_TO_CHECKOUT_BUTTON);
	private static final By SLIDER_LINK_XPATH = By.xpath(SLIDER_LINK);
	private static final By SKIP_WARRANTY_XPATH = By.xpath(SKIP_WARRANTY);
	private static final By DELETE_LINK_XPATH = By.xpath(DELETE_LINK);
	private static final By CART_PAGE_PRICE_XPATH = By.xpath(CART_PAGE_PRICE);
//	private static final By CART_COUNT_XPATH = By.xpath(CART_COUNT);
	/**
	 * This method is used for Click on AddToCart.
	 * 
	 * @param no param
	 * @return void
	 */
	public void clickAddToCartButton(WebDriver driver) {
		logger.debug("wait for add_to_cart element is loaded");
		utils.waitforPageToLoad(Constants.timeout);
		utils.waitforElementToBeVisible(ADD_TO_CART_XPATH, Constants.timeout);
		logger.debug("wait for add_to_cart element is loaded");
		utils.javaScriptExecutorClick(ADD_TO_CART_XPATH);
		utils.waitforPageToLoad(Constants.timeout);
		utils.waitforElementToBeVisible(SLIDER_LINK_XPATH);

		if (!utils.waitforElementToBeInVisible(SKIP_WARRANTY_XPATH, Constants.polltime)) {
			utils.clickElement(SKIP_WARRANTY_XPATH);
		} else {
			driver.navigate().refresh();
			utils.waitforPageToLoad(Constants.timeout);
		}
	}

	/**
	 * This method is used for Click on Cart Icon.
	 * 
	 * @param no param
	 * @return void
	 */
	public void clickOnCartButton() {
		utils.waitTime(Constants.polltime);
		utils.waitforElementToBeClickable(OPEN_CART_XPATH, Constants.timeout);
		logger.debug("wait for open_cart element is loaded");
		utils.javaScriptExecutorClick(OPEN_CART_XPATH);
	}

	/**
	 * This method is used for getSubTotalPrice.
	 * 
	 * @param no param
	 * @return String value
	 */

	public String getSubTotalPrice() {
		utils.waitforElementToBeVisible(SUBTOTAL_PRICE_XPATH, Constants.timeout);
		logger.debug("wait for subtotal element is loaded");
		String subTotalPrice = utils.getElementText(SUBTOTAL_PRICE_XPATH);
		logger.debug("subtotal price is " + subTotalPrice);
		return subTotalPrice;
	}

	/**
	 * This method is used for getCartPagePrice.
	 * 
	 * @param no param
	 * @return String value
	 */

	public String getCartPagePrice() {
		utils.waitforElementToBeVisible(CART_PAGE_PRICE_XPATH, Constants.timeout);
		logger.debug("wait for cart page price element is loaded");
		String cartPagePrice = utils.getElementText(CART_PAGE_PRICE_XPATH);
		logger.debug("cart page price is " + cartPagePrice);
		return cartPagePrice;
	}

	/**
	 * This method is used for getCartPagePrice.
	 * 
	 * @param no param
	 * @return cart price value list
	 */

	public List<String> getCartPriceList() {
		List<String> cartPageList = new ArrayList<String>();
		List<WebElement> element = utils.getWeElements(CART_PAGE_PRICE_XPATH);
		logger.debug("wait for cart page price element list is loaded");
		for (WebElement ele : element) {
			cartPageList.add(ele.getText());
		}
		return cartPageList;
	}

	/**
	 * @param no param
	 * @return void
	 */

	public void clickOnDeleteLink() {
		utils.waitforElementToBeVisible(DELETE_LINK_XPATH);
		utils.javaScriptExecutorClick(DELETE_LINK_XPATH);
	}
	
}
