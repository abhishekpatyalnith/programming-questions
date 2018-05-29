package com.learn.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindTheRunningMedian {

	private static double getMedian(PriorityQueue<Integer> highers, PriorityQueue<Integer> lowers) {
		PriorityQueue<Integer> biggerHeap = highers.size() > lowers.size() ? highers : lowers;
		PriorityQueue<Integer> smallerHeap = highers.size() > lowers.size() ? lowers : highers;

		if (biggerHeap.size() == smallerHeap.size()) {
			return ((double) biggerHeap.peek() + smallerHeap.peek()) / 2;
		} else {
			return biggerHeap.peek();
		}
	}

	private static void reBalance(PriorityQueue<Integer> highers, PriorityQueue<Integer> lowers) {

		PriorityQueue<Integer> biggerHeap = highers.size() > lowers.size() ? highers : lowers;
		PriorityQueue<Integer> smallerHeap = highers.size() > lowers.size() ? lowers : highers;

		if (biggerHeap.size() - smallerHeap.size() > 1) {
			smallerHeap.add(biggerHeap.poll());
		}
	}

	private static void addNumber(int number, PriorityQueue<Integer> highers, PriorityQueue<Integer> lowers) {

		if (lowers.isEmpty() || number < lowers.peek()) {
			lowers.add(number);
		} else {
			highers.add(number);
		}
	}

	private static double[] getMedianHeapWay(int[] arr) throws NumberFormatException, IOException {
		PriorityQueue<Integer> highers = new PriorityQueue<>();
		PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				return -1 * a.compareTo(b);
			}

		});
		double[] medians = new double[arr.length];

		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			addNumber(num, highers, lowers);
			reBalance(highers, lowers);
			medians[i] = getMedian(highers, lowers);
		}
		return medians;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(br.readLine());
		int[] arr = new int[t];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}
		double[] medians = getMedianHeapWay(arr);
		Arrays.stream(medians).forEach(System.out::println);
	}

}
