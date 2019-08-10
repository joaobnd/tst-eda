public class SLKNode<T> {
	
	private T value;
	private SLKNode<T> next = null;
	
	public SLKNode(T value) {
		this.value = value;
		this.next = new SLKNode<T>();
	}
	
	public SLKNode() {
		this.value = null;
		this.next = null;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public SLKNode<T> getNext() {
		return next;
	}

	public void setNext(SLKNode<T> next) {
		this.next = next;
	}
	public boolean isNIL() {
		return this.value == null;
	}
}
	