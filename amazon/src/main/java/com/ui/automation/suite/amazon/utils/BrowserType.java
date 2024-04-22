package com.ui.automation.suite.amazon.utils;

public enum BrowserType {
	CHROME("chrome"), FIREFOX("firefox"), CHROME_HEADLESS("chrome_headless"), FIREFOX_HEADLESS("firefox_headless");

	private String browserName;

	private BrowserType(String browserName) {
		this.browserName = browserName;
	}

	public static BrowserType fromString(String browserName) {
		for (BrowserType type : values()) {
			if (type.getBrowserName().equalsIgnoreCase(browserName)) {
				return type;
			}
		}
		throw new IllegalArgumentException("Invalid display name: " + browserName);
	}

	public String getBrowserName() {
		return browserName;
	}
}
