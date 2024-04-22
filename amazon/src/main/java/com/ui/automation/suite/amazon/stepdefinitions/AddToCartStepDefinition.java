package com.ui.automation.suite.amazon.stepdefinitions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ui.automation.suite.amazon.config.UISuiteConfiguration;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;


public class AddToCartStepDefinition extends CucumberStepDefinition {

	@Given("I Search for an item {string} and click on search button")
	public void seachItem(String product) {
		homePageAction.setProductInSearchBoxAndClicked(product);
	}

	@And("verify the search result displays a list of products")
	public void isResultsDisplayed() {
		homePageValidation.validateProductsListIsDiplayed();
	}

	@When("I Select the {int} item from the product list")
	public void selectProduct(Integer item) {
		homePageAction.clickOnSearchedProduct(item);
	}

	@And("I navigate to the product page and save the product {string}")
	public void navigateToProductPageAndSavePrice(String productPrice) {
		productPageValidation.validateProductIsDisplayed(productPrice);
		productPageAction.saveProductPrice(productPrice);
	};

	@And("I add the item to the cart by clicking on add to cart button")
	public void addItemToCart() {
		addCartPageAction.clickOnAddToCartButton(driver);
	}

	@And("I navigate to cart page by clicking cart icon")
	public void navigatToCartPage() {
		addCartPageAction.NavigateToOpenCart();
	}

	@Then("verify the subtotal price on cart page is same as product page {string}")
	public void verifyProductPriceWithSubTotal(String productPrice) {
		productPageValidation.validateSubTotalPriceIsMatching(productPrice);
	}

	@And("verify the subtotal price on the cart page matches the product sum {string}")
	public void verifyProductPricesWithSumOfSubTotal(String productPrice){
		productPageValidation.validateTwoSumProductIsMatchingSubTotalPrice(productPrice);

	}

	@Then("verify the cart page price is same as product page {string}")
	public void verifyProductPagePriceAndCartItemPriceAreSame(String productPrice) {
		productPageValidation.validateCartPagePriceIsMatching(productPrice);
	}

	@And("I navigate to home page and verify the home page is displayed")
	public void isHomePageDisplayed() {
		homePageValidation.HomePageIsDisplayed();
	}

}
