
class NodeClass {
	int data;
	NodeClass left, right;

	public NodeClass(int data) {
		this.data = data;
		left = right = null;
	}
}

public class ConvertTreeToCircularDLL {
	NodeClass root = null;

	public void display(NodeClass head) {
		System.out.println("Circular Linked List is :");
		NodeClass itr = head;
		do {
			System.out.print(itr.data + " ");
			itr = itr.right;
		} while (itr != head);
		System.out.println();
	}

	private NodeClass bTreeToCList(NodeClass root) {

		if (root == null) {
			return null;
		}
		NodeClass left = bTreeToCList(root.left);
		NodeClass right = bTreeToCList(root.right);
		root.left = root.right = root;
		return concatenate(concatenate(left, root), right);
	}

	private NodeClass concatenate(NodeClass leftList, NodeClass rightList) {
		if(leftList == null){
			return rightList;
		}
		if(rightList == null){
			return leftList;
		}
		
		NodeClass leftLast = leftList.left;
		NodeClass rightLast = rightList.left;
		
		leftLast.right = rightList;
		rightList.left = leftLast;
		
		leftList.left = rightLast;
		rightLast.right = leftList;
		
		
		return leftList;
	}

	public static void main(String[] args) {
		ConvertTreeToCircularDLL tree = new ConvertTreeToCircularDLL();
		tree.root = new NodeClass(10);
		tree.root.left = new NodeClass(12);
		tree.root.right = new NodeClass(15);
		tree.root.left.left = new NodeClass(25);
		tree.root.left.right = new NodeClass(30);
		tree.root.right.left = new NodeClass(36);

		// head refers to the head of the Link List
		NodeClass head = tree.bTreeToCList(tree.root);

		// Display the Circular LinkedList
		tree.display(head);

	}

}
