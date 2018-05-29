package com.learn.lambdaExpressions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1Exercise {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(new Person("Charles", "Dicken", 60), new Person("Lewis", "Carroll", 42), new Person("Thomas", "Carlyle", 51), new Person("Charlotte", "Brontte", 45),
				new Person("Matthew", "Arnold", 39));
		// sort array by last name

		Collections.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}

		});

		// create a method that prints all elements in the list
		printAll(people);

		// create a method that prints all people having last name beginning
		// with c
		System.out.println();
		printConditionally(people);
	}

	private static void printConditionally(List<Person> people) {

		for (Person person : people) {
			if (person.getLastName().startsWith("C")) {
				System.out.println(person);
			}
		}
	}

	private static void printAll(List<Person> people) {
		for (Person person : people) {
			System.out.println(person);
		}

	}
}
