package com.ui.automation.suite.amazon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestAmazonApplication {

	public static void main(String[] args) {
		SpringApplication.from(AmazonApplication::main).with(TestAmazonApplication.class).run(args);
	}

}
