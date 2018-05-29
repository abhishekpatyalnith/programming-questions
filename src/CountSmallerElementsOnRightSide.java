
class AVLNode1 {

	public int data;
	public int size;
	public int height;
	AVLNode1 left;
	AVLNode1 right;

	public AVLNode1() {
		left = right = null;
		data = height = 0;
	}

	public AVLNode1(int item) {
		left = right = null;
		data = item;
		height = 1;
		size = 1;
	}

	public AVLNode1 getLeft() {
		return left;
	}

	public void setLeft(AVLNode1 left) {
		this.left = left;
	}

	public AVLNode1 getRight() {
		return right;
	}

	public void setRight(AVLNode1 right) {
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

public class CountSmallerElementsOnRightSide {
	AVLNode1 root;

	public int height(AVLNode1 root) {
		return root == null ? 0 : root.height;
	}

	public int max(int x, int y) {
		return x > y ? x : y;
	}

	public int getBalance(AVLNode1 root) {
		if (root == null) {
			return 0;
		}
		return height(root.left) - height(root.right);
	}

	public int height(AVLNode root) {
		return root == null ? 0 : root.height;
	}

	public AVLNode1 rightRotate(AVLNode1 root) {

		AVLNode1 x = root.left;
		AVLNode1 T2 = x.right;

		// Perform rotation
		x.right = root;
		root.left = T2;

		x.height = max(height(x.left), height(x.right)) + 1;
		root.height = max(height(root.left), height(root.right)) + 1;

		return x;
	}
	public int size(AVLNode1 root){
		if(root == null){
			return 0;
		}
		return root.size;
	}

	public AVLNode1 leftRotate(AVLNode1 root) {
		AVLNode1 y = root.right;
		AVLNode1 T2 = y.left;

		// Perform rotation
		y.left = root;
		root.right = T2;

		y.height = max(height(y.left), height(y.right)) + 1;
		root.height = max(height(root.left), height(root.right)) + 1;

		return y;
	}

	public AVLNode1 insert(AVLNode1 root, int key, int[] res, int i) {
		if (root == null) {
			return new AVLNode1(key);
		}
		if (key < root.data) {
			root.left = insert(root.left, key, res,i);
		} else if (key > root.data) {
			root.right = insert(root.right, key, res,i);
			res[i] = res[i] + size(root.left) +1;
		} else {
			return root;
		}
		root.height = max(height(root.left), height(root.right)) + 1;
		root.size = size(root.left) + size(root.right) +1;
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

	private void constructLowerArray(int[] arr, int[] res, CountSmallerElementsOnRightSide tree) {
		for (int i = arr.length-1; i >= 0; i--) {
			tree.root = insert(tree.root, arr[i],res,i);
		}
	}

	public static void main(String[] args) {
		CountSmallerElementsOnRightSide tree = new CountSmallerElementsOnRightSide();

		int[] arr = new int[] { 10, 6, 15, 20, 30, 5, 7 };
		int[] res = new int[arr.length];
		tree.constructLowerArray(arr, res, tree);
		
		for (int i : res) {
			System.out.println(i);
		}
	}

}
