
class Interval {
	int low;
	int high;

	public Interval(int low, int high) {
		this.low = low;
		this.high = high;
	}
}

class IntervalTreeNode {
	Interval i;
	int max;
	IntervalTreeNode left, right;

	public IntervalTreeNode(int low, int high) {
		this.i = new Interval(low, high);
		this.max = Math.max(high, high);
		this.left = this.right = null;
	}

	public IntervalTreeNode insert(IntervalTreeNode root, Interval i) {
		if (root == null) {
			root = new IntervalTreeNode(i.low, i.high);
		} else if (root.i.low >= i.low) {
			root.left = insert(root.left, i);
		} else {
			root.right = insert(root.right, i);
		}
		if (i.high >= root.max) {
			root.max = i.high;
		}
		return root;
	}

}

public class IntervalTree {
	public void inorder(IntervalTreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.println(root.i.low + "," + root.i.high);
		inorder(root.right);

	}

	public void preorder(IntervalTreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.i.low + "," + root.i.high);
		preorder(root.left);
		preorder(root.right);

	}

	public boolean doOverlap(Interval x, Interval y) {
		return x.low <= y.high && x.high >= y.low;
	}

	public Interval overlapSearch(IntervalTreeNode root, Interval i) {
		if (root == null) {
			return null;
		}
		if(doOverlap(root.i, i)){
			return root.i;
		}
		if (root.left != null && root.left.max >= i.low) {
			return overlapSearch(root.left, i);
		}
		return overlapSearch(root.right, i);
	}

	public static void main(String[] args) {
		IntervalTree tree = new IntervalTree();
		IntervalTreeNode root = new IntervalTreeNode(15, 20);
		root.insert(root, new Interval(10, 30));
		root.insert(root, new Interval(5, 20));
		root.insert(root, new Interval(12, 15));
		root.insert(root, new Interval(17, 19));
		root.insert(root, new Interval(30, 40));

		//tree.preorder(root);
		
		Interval i = new Interval(39, 50);
		Interval result = tree.overlapSearch(root, i);
		System.out.println(result.low+","+result.high);
	}
}
