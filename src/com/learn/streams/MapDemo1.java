package com.learn.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//converting stream of person to stream of strings
public class MapDemo1 {

	public static void main(String[] args) {
		List<Person> list = Arrays.asList(new Person(1, "Abhishek", 24), new Person(2, "Atul", 25), new Person(3, "Archie", 23), new Person(4, "shalu", 26));

		String anotherList = list.stream().filter(person -> person.getName().startsWith("A")).map(person -> person.getName()).findAny().orElse(null);
		//anotherList.forEach(person -> System.out.println(person.getName()))
		System.out.println(anotherList);
		Stream<Integer> intStream = Arrays.stream(new Integer[]{1,2,3,4,5});
	}
}
