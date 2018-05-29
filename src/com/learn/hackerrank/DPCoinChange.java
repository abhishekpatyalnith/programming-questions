/*
 * Given a number of dollars, , and a list of dollar values for distinct coins, , find and print the number of different ways you can make change for dollars if each coin is available in an infinite quantity.
 */
package com.learn.hackerrank;

import java.util.Scanner;

public class DPCoinChange {
	public static long makeChange(int[] coins, int money) {
		
		return makeChangeUtilityDP(coins, coins.length, money);
	//	return makeChangeUtilityRecursive(coins, coins.length, money);
	}
	
	private static long makeChangeUtilityDP(int[] coins, int length, int money) {
		
		long[][] aux = new long[length+1][money+1];
		for(int i=0;i<length+1;i++){
			aux[i][0]=1;
		}
		for(int i=1;i<=length;i++){
			for(int j=1;j<=money;j++){
				if(coins[i-1] > j){
					aux[i][j] =aux[i-1][j];
				}else{
					aux[i][j] =aux[i-1][j] + aux[i][j-coins[i-1]];
				}
			}
		}
		return aux[length][money];
	}

	private static long makeChangeUtilityRecursive(int[] coins, int length, int money) {
		if (money == 0) {
			return 1;
		}
		if (money < 0) {
			return 0;
		}
		if(length<=0 && money >0){
			return 0;
		}
		return makeChangeUtilityRecursive(coins, length - 1, money) + makeChangeUtilityRecursive(coins, length, money - coins[length - 1]);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int coins[] = new int[m];
		for (int coins_i = 0; coins_i < m; coins_i++) {
			coins[coins_i] = in.nextInt();
		}
		System.out.println(makeChange(coins, n));
	}
}
