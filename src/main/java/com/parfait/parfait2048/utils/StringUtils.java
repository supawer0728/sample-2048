package com.parfait.parfait2048.utils;

public class StringUtils {
	
	static boolean equals(String str1, String str2) {
		
		// hello java
		if (str1 == null) {
			return str2 == null;
		}
		
		if (str2 == null) {
			return false;
		}
		
		return str1.equals(str2);
	}
	
	static boolean isNumeric(String str) {
		return org.apache.commons.lang3.StringUtils.isNumeric(str);
	}

}
