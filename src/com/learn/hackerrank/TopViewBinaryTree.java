package com.learn.hackerrank;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Node {
	int data;
	Node left;
	Node right;
}
class QNode{
    Node root;
    int hd;
    public QNode(Node root,int hd){
        this.root = root;
        this.hd = hd;
    }
}

public class TopViewBinaryTree {
	void topView(Node root) {
	      if(root == null){
	          return;
	      }
	       Queue<QNode> queue = new LinkedList<>();
	       QNode qnode = new QNode(root,0);
	       Set<Integer> set = new HashSet<>();
	       queue.add(qnode);
	       while(!queue.isEmpty()){
	         QNode temp = queue.remove();
	         int hd = temp.hd;
	         if(!set.contains(hd)){
	             System.out.print(temp.root.data+" ");
	             set.add(hd);
	         }
	         if(temp.root.left != null){
	             queue.add(new QNode(temp.root.left,hd-1));
	         }
	           if(temp.root.right != null){
	             queue.add(new QNode(temp.root.right,hd+1));
	         }
	       }
	      
	    }

	public static void main(String[] args) {

	}
}
