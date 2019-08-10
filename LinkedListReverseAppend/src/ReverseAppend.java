
public class ReverseAppend {

	Node head = new Node();
	
	public void reverse(Integer elem) {
		
		Node previous = new Node();
		Node aux = head;
		
		while(!aux.isNIL()) {
			Node tempNext = aux.next;
			
			aux.setNext(previous);
			previous = aux;
			aux = tempNext;
		}
		
		aux.setValue(elem);
		aux.setNext(previous);
		this.head = aux;
	}
	
	public String toString(Node node) {
		return node.toString() + " -> " + toString(node.next);
	}
	
	
}

class Node {
	Integer value;
	Node next;
	
	public Node() {
		this.value = null;
		this.next = null;
	}
	public Node(Integer value, Node next) {
		this.value = value;
		this.next = next;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public boolean isNIL() {
		return (this.value == null);
	}
	public String toString() {
		return value.toString();
	}
	
}
