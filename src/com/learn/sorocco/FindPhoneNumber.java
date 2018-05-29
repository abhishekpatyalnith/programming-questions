package com.learn.sorocco;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindPhoneNumber {
	
	static String find_phone_number(String text) {

		Pattern pat = Pattern.compile("(\\(\\d{3}\\)|\\d{3})(\\s|-)\\d{3}-\\d{4}");
		Matcher mat = pat.matcher(text);
		if(mat.find()){
			return mat.group(0);
		}
		return "NONE";
    }

	public static void main(String[] args) {
		System.out.println(find_phone_number("123-456-7890"));
	}
}
