import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode{
	public int data;
	public TreeNode left;
	public TreeNode right;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public TreeNode(int item){
		data = item;
		left = null;
		right = null;
	}
	
}
public class VerticalPrintBinaryTree {
	
	private TreeNode root;
	
	
	public void verticalPrint(VerticalPrintBinaryTree tree){
		Map<Integer,ArrayList<Integer>> map = new HashMap<>();
		
		verticalPrintUtil(tree.root,map,0);	

		System.out.println(map.entrySet());
	}

	private void verticalPrintUtil(TreeNode root, Map<Integer,ArrayList<Integer>> map,int distance) {
		if(root == null){
			return;
		}
		verticalPrintUtil(root.left,map,distance-1);
		verticalPrintUtil(root.right,map,distance+1);
		if(map.get(distance) == null){
			System.out.println("initializing element for index " + distance + " element " + root.data);
			ArrayList<Integer> list = new ArrayList<>();
            list.add(root.data);
            map.put(distance, list);
		}else{
			map.get(distance).add(root.data);
		}

	}

	public static void main(String[] args) {
		VerticalPrintBinaryTree tree = new VerticalPrintBinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		tree.root.right.left.right = new TreeNode(8);
		tree.root.right.right.right = new TreeNode(9);
		
		tree.verticalPrint(tree);
		
	}

	
}
