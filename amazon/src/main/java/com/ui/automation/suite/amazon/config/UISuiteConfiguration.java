package com.ui.automation.suite.amazon.config;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.ui.automation.suite.amazon.data.World;
import com.ui.automation.suite.amazon.handlers.WebDriverHandler;
import com.ui.automation.suite.amazon.pom.HomePage;

@Configuration
@ComponentScan("com.ui.automation.suite.amazon")
public class UISuiteConfiguration {
	
	@Autowired
	WebDriverHandler handler;
	
	@Value("${browser.name}")
	private String browser;
	
	@Value("${base.url}")
	private String baseUrl;
	
	@Bean
	@Scope("cucumber-glue")
	public WebDriver webDriver() {
		System.out.println("Driver name "+browser);
		return handler.createWebDriver(browser, baseUrl);
	}

	@Bean
	@Scope("cucumber-glue")
	public World World() {
		return new World();
	}
}
