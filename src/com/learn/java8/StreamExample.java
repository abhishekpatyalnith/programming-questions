package com.learn.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		
	long startTime = System.currentTimeMillis();
	List<Integer> myList = new ArrayList<>();
	for(int i=0; i<100; i++) myList.add(i);
	
	Stream<Integer> sequentialStream = myList.stream();
	
	Stream<Integer> parallelSequentialStream = myList.parallelStream();
	
	Stream<Integer> parallelStream = myList.parallelStream();
	
	//using lambda with Stream API, filter example
	Stream<Integer> highNums = parallelStream.filter(p -> p > 90);
	//using lambda in forEach
	highNums.forEach(p -> System.out.println("High Nums parallel="+p));
	long endTime = System.currentTimeMillis();
	System.out.println("execution time "+(endTime-startTime));
	}
	
}
