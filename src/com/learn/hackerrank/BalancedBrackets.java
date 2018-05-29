package com.learn.hackerrank;
import java.util.Scanner;
import java.util.Stack;

/*
 * A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

By this logic, we say a sequence of brackets is considered to be balanced if the following conditions are met:

    It contains no unmatched brackets.
    The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.

Given strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, print YES on a new line; otherwise, print NO on a new line.
 */
public class BalancedBrackets {

	static boolean isMatchingPair(char c1, char c2){
		if(c1=='(' && c2==')'){
			return true;
		}
		if(c1=='[' && c2==']'){
			return true;
		}if(c1=='{' && c2=='}'){
			return true;
		}
		return false;
	}
	static String isBalanced(String s) {
		
		Stack<Character> stack = new Stack<>();
		
		char[] arr = s.toCharArray();
		int i=0;
		while(i<arr.length){
			
			if(arr[i]=='{' || arr[i]=='(' || arr[i]=='['){
				stack.push(arr[i]);
			}else{
				if(stack.isEmpty()){
					return "NO";
				}else{
					char temp = stack.pop();
					if(!isMatchingPair(temp,arr[i])){
						return "NO";
					}
				}
			}
			i++;
		}
		if(!stack.isEmpty()){
			
			return "NO";
		}
		return "YES";
		
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            String result = isBalanced(s);
            System.out.println(result);
        }
        in.close();
    }
}
