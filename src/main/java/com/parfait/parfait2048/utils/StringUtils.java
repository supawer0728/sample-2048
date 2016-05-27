package com.parfait.parfait2048.utils;

public class StringUtils {
	
	static boolean equals(String str1, String str2) {
		
		if (str1 == null) {
			return str2 == null;
		}
		
		if (str2 == null) {
			return false;
		}
		
		return str1.equals(str2);
	}

}
