package com.learn.hackerrank.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchingDigitsNonDigits {

	public static void main(String[] args) {

		Regex_Test tester = new Regex_Test();
		tester.checker("\\d{1,2}[\\D\\/\\s]+[\\d]{1,2}\\D\\d{4}"); // Use \\ instead of using \

	}

}

class Regex_Test {
	public void checker(String pattern) {

		Scanner Input = new Scanner(System.in);
		String Test_String = Input.nextLine();
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(Test_String);
		System.out.println(m.find());
	}
}
