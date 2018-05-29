package com.learn.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Classic01Knapsack {
	private int getMaximumValue(int[] weight, int[] value, int capacity) {

		int length = weight.length;
		int[][] aux = new int[length + 1][capacity + 1];

		for (int wt = 0; wt <= length; wt++) {
			for (int w = 0; w <= capacity; w++) {
				if (wt == 0 || w == 0) {
					aux[wt][w] = 0;
				} else if (weight[wt - 1] <= w) {
					aux[wt][w] = Math.max(value[wt - 1] + aux[wt - 1][w - weight[wt - 1]], aux[wt - 1][w]);
				} else {
					aux[wt][w] = aux[wt - 1][w];
				}
			}
		}
		return aux[length][capacity];
	}

	private void getMaxValue() throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t > 0) {
			String[] first = br.readLine().split(" ");
			int capacity = Integer.parseInt(first[0]);
			int number = Integer.parseInt(first[1]);
			int[] weight = new int[number];
			int[] value = new int[number];
			for (int i = 0; i < number; i++) {
				String[] input = br.readLine().split(" ");
				weight[i] = Integer.parseInt(input[0]);
				value[i] = Integer.parseInt(input[1]);
			}
			System.out.println(getMaximumValue(weight, value, capacity));
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		Classic01Knapsack obj = new Classic01Knapsack();
		obj.getMaxValue();
	}

}
