package com.learn.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class LongestCommonSubsequence {

	private void findLCS() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);

		int[][] lcs = new int[m + 1][n + 1];
		int[] a = new int[m];
		String[] first = br.readLine().split(" ");
		String[] second = br.readLine().split(" ");
		int[] b = new int[n];
		for (int i = 0; i < m; i++) {
			a[i] = Integer.parseInt(first[i]);
		}
		for (int i = 0; i < n; i++) {
			b[i] = Integer.parseInt(second[i]);
		}

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
				} else if (a[i - 1] == b[j - 1]) {
					lcs[i][j] = 1 + lcs[i - 1][j - 1];
				} else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}

		int i = m;
		int j = n;
		int[] result = new int[lcs[m][n]];
		int count = result.length - 1;
		while (i > 0 && j > 0) {
			if (a[i - 1] == b[j - 1]) {
				result[count--] = a[i - 1];
				i--;
				j--;
			} else if (lcs[i - 1][j] > lcs[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
		for (i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}

	}

	public static void main(String[] args) throws IOException {
		LongestCommonSubsequence obj = new LongestCommonSubsequence();
		obj.findLCS();
	}

}
