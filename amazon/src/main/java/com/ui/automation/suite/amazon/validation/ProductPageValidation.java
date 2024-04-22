package com.ui.automation.suite.amazon.validation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ui.automation.suite.amazon.data.World;
import com.ui.automation.suite.amazon.pom.AddCartPage;
import com.ui.automation.suite.amazon.utils.Constants;
import com.ui.automation.suite.amazon.pom.AddCartPage;
import com.ui.automation.suite.amazon.pom.ProductPage;

@Component
@Scope("cucumber-glue")
public class ProductPageValidation {
	
	@Autowired
	ProductPage productPage;
	
	@Autowired
	AddCartPage addCartPage;
	
	@Autowired
	World world;
	
	private static Logger logger = LogManager.getLogger(ProductPageValidation.class);
	
		
		public void validateProductIsDisplayed(String product ) {
			assertTrue(productPage.productPageIsDisplayed(product.replace("Price", "")), "Product page is not displayed");
			logger.info("product page is displayed as");
		}
		
		public void validateSubTotalPriceIsMatching(String productPrice) {
			String actualPrice = addCartPage.getSubTotalPrice();
			DecimalFormat decimalFormat = new DecimalFormat("#,##,###");
			String atualformattedValue = decimalFormat.format(Double.parseDouble(actualPrice.replace(",", "")));
			atualformattedValue = atualformattedValue.replace(",", "");
			String expectedPrice = world.get(productPrice).toString().replace(",", "");
			assertEquals(atualformattedValue, expectedPrice, "ProductPage Price and SubTotal Price is not matching");
		}	
		
		public void validateTwoSumProductIsMatchingSubTotalPrice(String productPrice) {
			List<String> expectedPriceKey = Arrays.asList(productPrice.split(","));
			double expectecSubTotal = 0;
			for (int i = 0; i < expectedPriceKey.size(); i++) {
				String value = world.get(expectedPriceKey.get(i)).toString().replace(",", "");
				expectecSubTotal += Double.parseDouble(value);
			}
			double actualSubTotal = Double.valueOf(addCartPage.getSubTotalPrice().replace(",", ""));
			assertEquals(actualSubTotal, expectecSubTotal, "Sum of Two Product Price and SubTotal Price is not matching");

		}	
		
		public void validateCartPagePriceIsMatching(String productPrice) {
			List<String> expectedPriceKeyList = Arrays.asList(productPrice.split(","));
			List<String> actualCartPriceList = new ArrayList<String>();
			List<String> expectedPriceList = new ArrayList<String>();
			for (int i = 0; i < expectedPriceKeyList.size(); i++) {
				DecimalFormat decimalFormat = new DecimalFormat("#,##,###");
				String atualformattedValue = decimalFormat
						.format(Double.parseDouble(addCartPage.getCartPriceList().get(i).replace(",", "")));
				actualCartPriceList.add(atualformattedValue.replace(",", ""));
				expectedPriceList.add(world.get(expectedPriceKeyList.get(i)).toString().replace(",", ""));
//				expectedPriceList.add(Constants.getSavedValues(expectedPriceKeyList.get(i)).replace(",", ""));
			}
			assertEquals(actualCartPriceList, expectedPriceList, "ProductPage Price and Cart Page Price is not matching");
		}
}
