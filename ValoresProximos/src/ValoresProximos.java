import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class ValoresProximos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		
		int[] elements = getArray(entrada);

		BSTValoresProximos bst = new BSTValoresProximos();

		for (int element : elements) {
			bst.add(element);
		}
		
		int value = sc.nextInt();
		Object[] array = bst.preOrder().toArray();
		System.out.println(Arrays.toString(array));
		System.out.println(bst.searchNext(value));
		bst.preOrder();
		sc.close();
		sc.close();
	}

	private static int[] getArray(String[] entrada) {
		
		int[] array = new int[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		return array;
	}
}

class BSTValoresProximos {

	private Node root;

	public boolean isEmpty() {
		return this.root == null;
	}

	public void add(int element) {
		if (isEmpty()) {
			this.root = new Node(element);
		} else {
			this.root.add(element);
		}
	}

	public int searchNext(int value) {
		if (isEmpty()) {
			return -1;
		}
		int result = this.root.value;
		int prox = Math.abs(this.root.value - value);
		return search(value, this.root, prox, result);
	}

	private int search(int value, Node node, int prox, int result) {
		if (node != null) {
			if (Math.abs(node.value - value) < prox) {
				prox = Math.abs(node.value - value);
				result = node.value;
			}
			if (node.value == value) {
				return result;
			} else if (node.value > value) {
				return search(value, node.left, prox, result);
			} else {
				return search(value, node.right, prox, result);
			}
		}
		return result;
	}

	public ArrayList<Integer> preOrder() {
		ArrayList<Integer> array = new ArrayList<Integer>();
		if (!isEmpty()) {
			return preOrder(this.root, array);
		}
		return array;
	}

	private ArrayList<Integer> preOrder(Node node, ArrayList<Integer> array) {
		array.add(node.value);
		if (node.left != null) {
			preOrder(node.left, array);
		}
		if (node.right != null) {
			preOrder(node.right, array);
		}
		return array;
	}}

class Node {

	int value;
	Node left;
	Node right;
	Node parent;

	public Node(int value) {
		this.value = value;
	}

	public Node(int value, Node parent) {
		this.value = value;
		this.parent = parent;
	}

	public void add(int value) {
		if (value > this.value) {
			if (this.right == null) {
				this.right = new Node(value, this);
			} else {
				this.right.add(value);
			}
		} else if (value < this.value) {
			if (this.left == null) {
				this.left = new Node(value, this);
			} else {
				this.left.add(value);
			}
		}
	}

}

