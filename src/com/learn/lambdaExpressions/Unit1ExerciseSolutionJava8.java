package com.learn.lambdaExpressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Unit1ExerciseSolutionJava8 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(new Person("Charles", "Dicken", 60), new Person("Lewis", "Carroll", 42), new Person("Thomas", "Carlyle", 51), new Person("Charlotte", "Brontte", 45),
				new Person("Matthew", "Arnold", 39));
		// sort array by last name
		Collections.sort(people, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));

		// create a method that prints all elements in the list
		printConditionally(people, p -> true);

		System.out.println();
		// create a method that prints all people having last name beginning
		// with c
		printConditionally(people, p -> p.getLastName().startsWith("C"));

	}

	private static void printConditionally(List<Person> people, Condition condition) {
		for (Person p : people) {
			if (condition.test(p)) {
				System.out.println(p);
			}
		}
	}
}
