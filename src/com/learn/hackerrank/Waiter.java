package com.learn.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Waiter {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int q = Integer.parseInt(arr[1]);
		int[] a = new int[n];
		String[] array = br.readLine().split(" ");
		for(int i=0;i<n;i++){
			a[i] = Integer.parseInt(array[i]);
		}
		Stack<Integer>[] aStackArray = (Stack<Integer>[]) new Stack[q+1];
		Stack<Integer>[] bStackArray = (Stack<Integer>[]) new Stack[q+1];
		
		int[] primeNumbers = new int[q];
		boolean[] sieve = new boolean[1000001];
		for(int i=0;i<100000;i++){
			sieve[i] = true;
		}
		for(int i=2;i*i<100000;i++){
			if(sieve[i] == true){
				for(int p=i*2;p<=100000;p+=i){
					sieve[p] =false;
				}
			}
		}
		
		for(int i=2,j=0;i<100000 && j<q;i++){
			if(sieve[i]==true){
				primeNumbers[j++] = i;
			}
		}
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<n;i++){
			stack.push(a[i]);
		}
		aStackArray[0] = stack;
		for(int i = 1;i<=q;i++){
			Stack<Integer> aStack = new Stack<>();
			Stack<Integer> bStack = new Stack<>();
			while(!aStackArray[i-1].isEmpty()){
				int item = aStackArray[i-1].pop() ;
				if(item%primeNumbers[i-1]==0){
					bStack.push(item);
				}else{
					aStack.push(item);
				}
			}
			aStackArray[i] = aStack;
			bStackArray[i] = bStack;
		}
		for(int i=1;i<=q;i++){
			Stack<Integer> bStack = bStackArray[i];
			while(!bStack.isEmpty()){
				int item = bStack.pop();
				System.out.println(item);
			}
		}
		while(!aStackArray[q].isEmpty()){
			System.out.println(aStackArray[q].pop());
		}
	}
}
