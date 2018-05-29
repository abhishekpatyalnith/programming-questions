import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 
 * @author abhishek.patyal
 *
 */
/*
 * Given an array, print the Next Greater Element (NGE) for every element. The
 * Next greater Element for an element x is the first greater element on the
 * right side of x in array. Elements for which no greater element exist,
 * consider next greater element as -1.
 * 
 * For the input array [4, 5, 2, 25}, the next greater elements for each element
 * are as follows.
 * 
 * Element --> NGE
 * 
 * 4 --> 5
 * 
 * 5 --> 25
 * 
 * 2 --> 25
 * 
 * 25 --> -1
 * 
 * For the input array [13, 7, 6, 12}, the next greater elements for each
 * element are as follows.
 * 
 * Element --> NGE
 * 
 * 13 --> -1
 * 
 * 7 --> 12
 * 
 * 6 --> 12
 * 
 * 12 --> -1
 */
public class NextGreaterElement {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] str = br.readLine().split(" ");
		for(int i =0;i<n;i++){
			arr[i] = Integer.parseInt(str[i]);
		}
		int[] result = new int[n];
		Stack<Integer> stack = new Stack<>();

		result[n - 1] = -1;
		stack.push(arr[n - 1]);
		int i = n - 2;
		while (i >= 0) {
			while(!stack.isEmpty() && stack.peek() < arr[i]){
				stack.pop();
			}
			if(stack.isEmpty()){
				result[i] = -1;
			}else{
				result[i] = stack.peek();
			}
			stack.push(arr[i]);
			i--;
		}
		for(i =0;i<n;i++){
			System.out.println(arr[i]+" "+result[i]);
		}
	}
}
