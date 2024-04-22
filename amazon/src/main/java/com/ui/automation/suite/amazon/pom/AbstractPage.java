package com.ui.automation.suite.amazon.pom;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import com.ui.automation.suite.amazon.utils.CommonUtils;

@Component
public abstract class AbstractPage{
	
	protected WebDriver driver;
	protected CommonUtils utils;
	public AbstractPage(WebDriver driver, CommonUtils utils) {
		this.driver=driver;
		this.utils=utils;
	}
	

	public String getPageTitle() {
		return driver.getTitle();
	}
}
