import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * In this challenge, you must implement a simple text editor. Initially, your editor contains an empty string, . You must perform operations of the following types:

    append - Append string to the end of .
    delete - Delete the last characters of .
    print - Print the character of .
    undo - Undo the last (not previously undone) operation of type or , reverting to the state it was in prior to that operation.

 */
public class SimpleTextEditor {

	static class Operation {
		int operation;
		String s;

		public Operation(int operation, String s) {
			this.operation = operation;
			this.s = s;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine());
		String s = "";
		Stack<Operation> stack = new Stack<>();
		while (q > 0) {

			String[] query = br.readLine().split(" ");
			int operation = Integer.parseInt(query[0]);
			switch (operation) {
			case 1:
				String w = query[1];
				stack.push(new Operation(1, w));
				s = s + w;
				break;
			case 2:
				int k = Integer.parseInt(query[1]);
				if(k > s.length()){
					break;
				}
				String temp = s.substring(s.length() - k);
				stack.push(new Operation(2, temp));
				s = s.substring(0, s.length() - k);
				break;
			case 3:
				int m = Integer.parseInt(query[1]);
				if (s.length() < m) {
					break;
				} else {
					System.out.println(s.charAt(m - 1));
				}
				break;
			case 4:
				if (stack.isEmpty()) {
					break;
				} else {
					Operation op = stack.pop();
					int op1 = op.operation;
					if (op1 == 1) {
						int idx = s.lastIndexOf(op.s);
						if(idx <0){
							break;
						}
						s = s.substring(0, idx);
					} else {
						s = s + op.s;
					}
				}
				break;
			}
			q--;
		}
	}
}
