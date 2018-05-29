package com.learn.hibernate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.jboss.jandex.Main;

class Base extends Exception {
}

class Derived extends Base {
}

public class Test {

	public static void main(String[] args) {

		int[] a = new int[3];
		Arrays.stream(a).forEach(i -> System.out.println(i));
		func(a);
		Arrays.stream(a).forEach(i -> System.out.println(i));
	}

	static void func(int[] b) {
		b[2] = 12;
	}
}