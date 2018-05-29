package com.learn.java8;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class StringJoinerExample {
	public static void main(String[] args) {
		StringJoiner stringJoiner = new StringJoiner(",");
		stringJoiner.add("abhishek");
		stringJoiner.add("patyal");
		String string = stringJoiner.toString();
		System.out.println(string);
		
		List<String> list = Arrays.asList("foo", "bar", "baz");
		String joined = String.join(";", list);
		System.out.println(joined);
		
	}

}
