/*
class LinkedListEmptyException extends Error {
	public LinkedListEmptyException() {
		super();
	}

	public LinkedListEmptyException(String message) {
		super(message);
	}
}

class Node<T> {
	
	 T data;
	 Node<T> next;

	public Node(T data) {
		this.data = data;
	}

	public void displayNode() {
		System.out.print(data+" ");
	}
}

public class GenericLinkedList<T> {

	private Node<T> head;

	public GenericLinkedList() {
		head = null;
	}
	
	public void insertFirst(T item){
		Node<T> newNode = new Node<T>(item);
		newNode.next = head;
		head = newNode;
	}
	
	public Node<T> deleteFirst(){
		
		if(head == null){
			throw new LinkedListEmptyException("linked list is empty");
		}
		Node<T> tempNode = head;
		head = head.next;
		return tempNode;
	}
	
	public void displayList(){
		Node<T> tempNode = head;
		while(tempNode != null){
			tempNode.displayNode();
			tempNode = tempNode.next;
		}
	}
	
	
	public static void main(String[] args) {
		
		GenericLinkedList<String> linkedList = new GenericLinkedList<>();
		linkedList.insertFirst("abhishek");
		linkedList.insertFirst("patyal");
		linkedList.insertFirst("house no 367");
		linkedList.insertFirst("housing board colony");
		linkedList.insertFirst("hamirpur");
		linkedList.insertFirst("himachal pradesh");
		
		linkedList.deleteFirst();

		
	}
}
*/