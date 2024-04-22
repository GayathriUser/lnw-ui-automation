package com.ui.automation.suite.amazon.utils;

import java.util.HashMap;

public class Constants {
	
	public static int timeout = 30;
	public static int polltime = 5;
	
	public static HashMap<String, String> savedValues = new HashMap<String, String>();
	/**
	 * This static method is used for get the savedvalue from haspmap usng key.
	 */
	public static String getSavedValues(String key) {
		return savedValues.get(key);
	}

}
