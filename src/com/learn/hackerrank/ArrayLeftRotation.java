package com.learn.hackerrank;
import java.util.Scanner;

public class ArrayLeftRotation {
	public static int gcd(int a, int b){
        if(a == 0){
            return b;
        }
        return gcd(b%a,a);
    }
    public static int[] arrayLeftRotation(int[] arr, int n, int d) {
    	int i, j, k, temp;
        for (i = 0; i < gcd(d, n); i++) 
        {
        	j = i;
        	temp = arr[i];
        	while(true){
        		k = j+d;
        		if(k>=n){
        			k-=n;
        		}
        		if(k==i){
        			break;
        		}
        		arr[j] = arr[k];
        		j = k;
        	}
        	arr[j] = temp;
        }
        return arr;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
      
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k%n);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        System.out.println();
      
    }
}
