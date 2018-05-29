package com.learn.hackerrank;

import java.util.Scanner;
import java.util.Stack;

public class SuperReducedString {

    static String super_reduced_string(String s) {
        Stack<Character> stack = new Stack();
        char[] arr = s.toCharArray();
        if(arr.length==0){
            return "Empty String";
        }
        stack.push(arr[0]);
        int i=1;
        while(i<arr.length){
            if(stack.isEmpty() || arr[i] != stack.peek()){
                stack.push(arr[i]);
            }else{
            	if(!stack.isEmpty()){
            		stack.pop();
            	}else{
            		stack.push(arr[i]);
            	}
            }
            i++;
        }
        String result = "";
        while(!stack.isEmpty()){
            result = result + stack.pop();
        }
        if(result == ""){
            return "Empty String";
        }
        return new StringBuffer(result).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}

