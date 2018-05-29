package com.learn.hackerrank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AlgorithmicCrush {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		long[] arr = new long[n];
		Arrays.fill(arr, 0);
		for(int i=0;i<m;i++){
			String[] q = br.readLine().split(" ");
			int a = Integer.parseInt(q[0]);
			int b = Integer.parseInt(q[1]);
			int k = Integer.parseInt(q[2]);
			
			arr[a-1] += k;
			if(b<arr.length)
				arr[b] -= k;
		}
		long sum=arr[0],max=arr[0];
		for(int i=1;i<n;i++){
			sum+=arr[i];
			if(sum>max){
				max = sum;
			}
		}
		
		System.out.println(max);
	}
}
