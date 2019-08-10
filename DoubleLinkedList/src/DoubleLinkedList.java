
public class DoubleLinkedList {

	private Node head;
	private Node tail;
	private int size;
	
	public DoubleLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void addLast(int value) {
		if(head == null) {
			this.head = new Node(value);
			this.tail = head;
			size += 1;
		}
		else {
			tail.next = new Node(value);
			tail = tail.next;
	}
}
	
	public Node search(int value) {
		Node resp;
		if(head.value == value)
			resp = head;
		else if (tail.value == value)
			resp = tail;
		
			
		
	}
	

class Node {
	int value;
	Node next;
	Node prev;
	
	public Node(int value) {
		this.value = value;
		this.next = null;
		this.prev = null;
	}
	
}}