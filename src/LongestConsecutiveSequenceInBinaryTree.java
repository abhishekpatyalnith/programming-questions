
/*Longest consecutive sequence in Binary tree*/
class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}
public class LongestConsecutiveSequenceInBinaryTree {
	
	Node root;
	static int shared = 0;
	
	
	private void longestConsecutiveUtil(Node root, int currentLength, int expected, int max){
		if(root == null){
			return;
		}
		if(root.data == expected){
			currentLength++;
		}else{
			currentLength = 1;
		}
		max = Math.max(max, currentLength);
		shared = Math.max(max, shared);
		longestConsecutiveUtil(root.left, currentLength, root.data+1, max);
		longestConsecutiveUtil(root.right, currentLength, root.data+1, max);

	}
	
	private void longestConsecutive(LongestConsecutiveSequenceInBinaryTree tree) {
		
		longestConsecutiveUtil(tree.root,0,tree.root.data,shared);
		System.out.println(shared);
	}
	
	public static void main(String[] args) {
		
		LongestConsecutiveSequenceInBinaryTree tree = new LongestConsecutiveSequenceInBinaryTree();
		
		tree.root = new Node(1);
		tree.root.right = new Node(2);
		tree.root.right.left = new Node(3);
		tree.root.right.right = new Node(4);
		tree.root.right.right.right = new Node(5);
		
		tree.longestConsecutive(tree);
		
	}


}
