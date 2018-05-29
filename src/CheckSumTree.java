
public class CheckSumTree {

	TreeNode root;
	
	
	public boolean checkSumTreeUtil(TreeNode root){
		if(root == null || (root.left == null && root.right == null)){
			return true;
		}
		int leftSum = getSum(root.left);
		int rightSum = getSum(root.right);
		
		if((leftSum + rightSum == root.data) && checkSumTreeUtil(root.left) && checkSumTreeUtil(root.right)){
			return true;
		}
		return false;
	}
	
	private int getSum(TreeNode root) {
		if(root == null){
			return 0;
		}
		if(root.left == null && root.right == null){
			return root.data;
		}
		return getSum(root.left)+getSum(root.right)+root.data;
	}

	public void checkSumTree(TreeNode root){
		boolean flag = false;
		flag = checkSumTreeUtil(root);
		if(flag == false){
			System.out.println("the tree is not a sum tree");
		}else{
			System.out.println("the tree is a sum tree");
		}
	}
	public static void main(String[] args) {
		CheckSumTree tree = new CheckSumTree();
		tree.root = new TreeNode(82);
		tree.root.left = new TreeNode(35);
		tree.root.right = new TreeNode(6);
		tree.root.left.left = new TreeNode(15);
		tree.root.left.right = new TreeNode(5);
		tree.root.left.left.left = new TreeNode(7);
		tree.root.left.left.right = new TreeNode(8);
		tree.root.right.right = new TreeNode(6);
		
		tree.checkSumTree(tree.root);
	}
}
