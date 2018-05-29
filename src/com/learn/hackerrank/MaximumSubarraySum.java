package com.learn.hackerrank;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * We define the following:

    A subarray of an -element array, , is a contiguous subset of 's elements in the inclusive range from some index to some index where .
    The sum of an array is the sum of its elements.

Given an -element array of integers, , and an integer, , determine the maximum value of the sum of any of its subarrays modulo . This means that you must find the sum of each subarray modulo , then print the maximum result of this modulo operation for any of the possible subarrays.

Input Format

The first line contains an integer, , denoting the number of queries to perform. Each query is described over two lines:

    The first line contains two space-separated integers describing the respective (the array length) and (the right operand for the modulo operations) values for the query.
    The second line contains space-separated integers describing the respective elements of array for that query.

 */
public class MaximumSubarraySum {
	static long maximumSum(long[] arr, long m) {
		long maxSum = 0;
		int n = arr.length;
		TreeSet<Long> prefix = new TreeSet<Long>();
		long currentSum = 0;
		for (int i = 0; i < n; i++) {
			currentSum = (currentSum % m + arr[i] % m) % m;
			SortedSet<Long> set = prefix.tailSet(currentSum + 1);
			Iterator<Long> itr = set.iterator();
			if (itr.hasNext()) {

				maxSum = Math.max(maxSum, (currentSum - itr.next() + m) % m);
			}

			maxSum = Math.max(maxSum, currentSum);
			prefix.add(currentSum);
		}

		return maxSum;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int n = in.nextInt();
			long m = in.nextLong();
			long[] a = new long[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextLong();
			}
			long result = maximumSum(a, m);
			System.out.println(result);
		}
		in.close();
	}
}
