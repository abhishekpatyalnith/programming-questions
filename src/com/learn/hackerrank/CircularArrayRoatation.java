package com.learn.hackerrank;
import java.util.Scanner;

/*
 * John Watson performs an operation called a right circular rotation on an array of integers, . After performing one right circular rotation operation, the array is transformed from to .

Watson performs this operation times. To test Sherlock's ability to identify the current element at a particular position in the rotated array, Watson asks queries, where each query consists of a single integer, , for which you must print the element at index in the rotated array (i.e., the value of ).

Input Format

The first line contains space-separated integers, , , and , respectively.
The second line contains space-separated integers, where each integer describes array element (where ).
Each of the subsequent lines contains a single integer denoting .
 */
public class CircularArrayRoatation {

	public static void main(String[] args) {
		System.out.println(-1%3);
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int q = in.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextInt();
		}
		k = k % n;
		int d[] = new int[a.length];
        k=k%n;
        for(int i =n-1;i>=0;i--){
            d[i]=a[(i-k)%n];
        }
        for(int i =n-1;i>=0;i--){
            a[i]=d[i];
        }
		for (int a0 = 0; a0 < q; a0++) {
			int m = in.nextInt();
			System.out.println(a[m]);
		}
	}
}
