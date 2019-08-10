

public class SingleLinkedList<T> {
	
	SLKNode<T> head = new SLKNode<T>();
	int size;
	
	public SingleLinkedList() {
		this.head = new SLKNode<T>();
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return this.head.isNIL();
	}
	public void addLast(T value) {
		
		if(this.isEmpty())
			head.setValue(value);
		else
			this.addLast(head ,value);
	}
	
	public void addLast(SLKNode<T> node, T value) {
		if(node.getNext().isNIL()) {
			node.getNext().setValue(value);
			node.getNext().setNext(new SLKNode<T>());
			this.size +=1;
		}
		else {
			addLast(node.getNext(), value);
		}
	}
	
	@SuppressWarnings("unused")
	private SLKNode<T> search(T value) {
		return search(this.head, value);
	} 
	
	private SLKNode<T> search(SLKNode<T> node, T value) {
		
		if(node.getValue().equals(value)) {
			return node;
		}
		else
			return search(node.getNext(), value);
		}
	
	
	public boolean remove(T value) {
		boolean done = false;
		if(!this.isEmpty()) {
			
			if(this.head.getValue().equals(value)) {
				this.head = head.getNext();
				this.size --;
				done = true;
			}
			else {
				SLKNode<T> prev = new SLKNode<T>();
				SLKNode<T> aux = this.head;
				
				while(!aux.getValue().equals(value) && !aux.isNIL()) {
					prev = aux;
					aux = aux.getNext();
				}
				
				prev.setNext(aux.getNext());
				this.size--;
				done = true;
			}
		}
		
		return done;
	}	
	
	public void removeLast() {
		if(!this.isEmpty()) {
			SLKNode<T> aux = this.head;
			SLKNode<T> prev = new SLKNode<T>();
			
			while(!aux.getNext().isNIL()) {
				prev = aux;
				aux = aux.getNext();
				
			}
			prev.setNext(new SLKNode<T>());
			
		}
		this.size--;
			
	}
	
	public int size() {
		return this.size;
	}
	
	public String toString() {
		String resp = "";
		SLKNode<T> aux = this.head;
		
		while(!aux.isNIL()) {
			resp += aux.getValue() + " ";
			aux = aux.getNext();
		}
		
		return resp.trim();
	}
	
	
	

}