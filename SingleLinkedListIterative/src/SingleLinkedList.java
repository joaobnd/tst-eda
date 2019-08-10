
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
		
		SLKNode<T> newNode = new SLKNode<T>(value);
		
		if(this.isEmpty()) {
			head = newNode;
		} else {
			SLKNode<T> last = head;
			
			while(!last.getNext().isNIL()) {
				last = last.getNext();
			}
			last.setNext(new SLKNode<T>(value));
		}
		this.size +=1;
	}
	
	@SuppressWarnings("unused")
	private SLKNode<T> search(T value) {
		SLKNode<T> aux = head;
		
		while(!aux.getValue().equals(value) && !aux.isNIL()) {
			aux = aux.getNext();
		}
		
		return aux;
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
