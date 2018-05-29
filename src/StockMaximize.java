
/*
 * Your algorithms have become so good at predicting the market that you now know what the share price of Wooden Orange Toothpicks Inc. (WOT) will be for the next N days.

Each day, you can either buy one share of WOT, sell any number of shares of WOT that you own, or not make any transaction at all. What is the maximum profit you can obtain with an optimum trading strategy?

Input Format

The first line contains the number of test cases T. T test cases follow:

The first line of each test case contains a number N. The next line contains N integers, denoting the predicted price of WOT shares for the next N days.

Constraints

    All share prices are between 1 and 100000

Output Format

Output T lines, containing the maximum profit which can be obtained for the corresponding test case.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StockMaximize {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			int[] arr = new int[n];
			int[] max = new int[n];
			String[] str = br.readLine().split(" ");
			for (int k = 0; k < n; k++) {
				arr[k] = Integer.parseInt(str[k]);
			}
			max[n - 1] = arr[n - 1];
			for (int k = n - 2; k >= 0; k--) {
				if (arr[k] > max[k + 1]) {
					max[k] = arr[k];
				} else {
					max[k] = max[k + 1];
				}
			}
			long profit = 0;
			for (int k = 0; k < n; k++) {
				if (arr[k] < max[k]) {
					profit = profit + (max[k] - arr[k]);
				}
			}
			System.out.println(profit);
		}
	}
}
