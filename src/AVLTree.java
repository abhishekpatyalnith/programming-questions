class AVLNode {

	public AVLNode left, right;
	public int data;
	public int height;

	public AVLNode() {
		left = right = null;
		data = height = 0;
	}

	public AVLNode(int item) {
		left = right = null;
		data = item;
		height = 1;
	}

	public AVLNode getLeft() {
		return left;
	}

	public void setLeft(AVLNode left) {
		this.left = left;
	}

	public AVLNode getRight() {
		return right;
	}

	public void setRight(AVLNode right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}

public class AVLTree {

	private AVLNode root;

	public boolean isEmpty() {
		return root == null;
	}

	public void makeEmpty() {
		root = null;
	}

	public int height(AVLNode root) {
		return root == null ? 0 : root.height;
	}

	public int max(int x, int y) {
		return x > y ? x : y;
	}

	public int getBalance(AVLNode root) {
		if (root == null) {
			return 0;
		}
		return height(root.left) - height(root.right);
	}

	public AVLNode rightRotate(AVLNode root) {
		
		AVLNode x = root.left;
		AVLNode T2 = x.right;
 
        // Perform rotation
        x.right = root;
        root.left = T2;
		
		x.height = max(height(x.left),height(x.right))+1;
		root.height = max(height(root.left),height(root.right))+1;
		
		return x;
	}

	public AVLNode leftRotate(AVLNode root) {
		AVLNode y = root.right;
		AVLNode T2 = y.left;
 
        // Perform rotation
        y.left = root;
        root.right = T2;
		
		y.height = max(height(y.left),height(y.right))+1;
		root.height = max(height(root.left),height(root.right))+1;
		
		return y;	
	}

	public AVLNode insert(AVLNode root, int key) {

		if (root == null) {
			return new AVLNode(key);
		}
		if (key < root.data) {
			root.left = insert(root.left, key);
		} else if (key > root.data) {
			root.right = insert(root.right, key);
		} else {
			return root;
		}

		root.height = max(height(root.left), height(root.right)) + 1;

		int balance = getBalance(root);

		// left left case
		if (balance > 1 && key < root.left.data) {
			return rightRotate(root);
		}

		// right right case
		if (balance < -1 && key > root.right.data) {
			return leftRotate(root);
		}

		// left right case
		if (balance > 1 && key > root.left.data) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		if (balance < -1 && key < root.right.data) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}

	void preOrder(AVLNode node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();

		/* Constructing tree given in the above figure */
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 30);
		tree.root = tree.insert(tree.root, 40);
		tree.root = tree.insert(tree.root, 50);
		tree.root = tree.insert(tree.root, 25);

		/*
		 * The constructed AVL Tree would be 30 / \ 20 40 / \ \ 10 25 50
		 */
		System.out.println("Preorder traversal" + " of constructed tree is : ");
		tree.preOrder(tree.root);
	}

}
