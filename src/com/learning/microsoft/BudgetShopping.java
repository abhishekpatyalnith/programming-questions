package com.learning.microsoft;

import java.util.Arrays;

public class BudgetShopping {
	static int budgetShopping(int n, int[] bundleQuantities, int[] bundleCosts) {
		int[] quantity = new int[n + 1];
		for (int i = 0; i < quantity.length; i++) {
			quantity[i] = 0;
		}
		for (int i = 0; i < quantity.length; i++) {
			for (int j = 0; j < bundleQuantities.length; j++) {
				if (i - bundleCosts[j] >= 0) {
					quantity[i] = Math.max(quantity[i - bundleCosts[j]] + bundleQuantities[j],
							quantity[i]);
				}
			}
		}
		/*int finalAnswer = 0;
		for (int i = 0; i < quantity.length; i++) {
			finalAnswer = Math.max(finalAnswer, quantity[i]);
		}*/
		return  Arrays.stream(quantity).max().getAsInt();

	}

	public static void main(String[] args) {

	}
}
