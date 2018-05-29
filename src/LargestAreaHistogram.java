import java.util.Stack;

public class LargestAreaHistogram {
	static int largestRectangleAreaBruteForce(int[] arr) {
		int maxArea = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i, mn = arr[i]; j < arr.length; j++) {
				mn = Math.min(mn, arr[j]);
				maxArea = Math.max(maxArea, (j - i + 1) * mn);
			}
		}
		return maxArea;
	}

	static int largestRectangleAreaUsingStack(int[] arr) {

		Stack<Integer> stack = new Stack<>();
		int n = arr.length;
		int i = 0;
		int maxArea = 0;
		while (i < n) {
			if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
				stack.push(i++);
			} else {
				int area = 0;
				stack.pop();
				area = arr[i] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				if(maxArea<area){
					maxArea = area;
				}
			}
		}
		while(!stack.isEmpty()){
			int top = stack.pop();
			int area = arr[i] * (stack.isEmpty() ? i : i - stack.peek() - 1);
			if(maxArea<area){
				maxArea = area;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int hist[] = { 2, 3, 3, 1 };
		System.out.println(largestRectangleAreaUsingStack(hist));
	}

}
