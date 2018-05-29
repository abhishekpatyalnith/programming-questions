import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * A binary tree is a tree which is characterized by any one of the following properties:

    It can be an empty (null).
    It contains a root node and two subtrees, left subtree and right subtree. These subtrees are also binary tree.

Inorder traversal is performed as

    Traverse the left subtree.
    Visit root (print it).
    Traverse the right subtree.

(For an Inorder traversal, start from the root and keep visiting the left subtree recursively until you reach the leaf,then you print the node at which you are and then you visit the right subtree.)

We define depth of a node as follow:

    Root node is at depth 1.
    If the depth of parent node is d, then the depth of current node wll be d+1.

Swapping: Swapping subtrees of a node means that if initially node has left subtree L and right subtree R, then after swapping left subtree will be R and right subtree L.

Eg. In the following tree, we swap children of node 1.
 */
public class SwapNodes {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Node[] nodes = new Node[n+1];
		for(int i=0;i<n+1;i++){
			nodes[i] = new Node(i);
		}
		for(int i =1;i<=n;i++){
			String[] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			if(a!=-1){
				nodes[i].left = nodes[a];
			}
			if(b!=-1){
				nodes[i].right = nodes[b];
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		for(int i=0;i<m;i++){
			int k = Integer.parseInt(br.readLine());
			swap(k,nodes[1],1);
			printInOrder(nodes[1]);
			System.out.println();
		}
	}

	private static void printInOrder(Node node) {

		if(node == null){
			return;
		}
		printInOrder(node.left);
		System.out.print(node.data+" ");
		printInOrder(node.right);
	}

	private static void swap(int k, Node node, int level) {
		
		if(node == null){
			return;
		}
		swap(k,node.left,level+1);
		swap(k,node.right,level+1);
		if(level%k==0){
			Node temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
	}
}
