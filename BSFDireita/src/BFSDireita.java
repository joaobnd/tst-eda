import java.util.ArrayList;


import java.util.Scanner;

class BFSDireita {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		
		int[] elements = getArray(entrada);

		BSTBFSDireita bst = new BSTBFSDireita();

		for (int element : elements) {
			bst.add(element);
		}
		
		ArrayList<Integer> ret = new ArrayList<Integer>();
		ArrayList<Node> queue = new ArrayList<Node>();

		int ind = -1, qtdElements = bst.qtdElements - 1;
		queue.add(bst.getRoot());

		while (ind < qtdElements) {
			ret.add(queue.get(++ind).value);
			if (queue.get(ind).right != null)
				queue.add(queue.get(ind).right);
			if (queue.get(ind).left != null)
				queue.add(queue.get(ind).left);
		}

		for (int i = 0; i <= qtdElements; i++) {
			if (i != 0)
				System.out.print(" ");
			System.out.print(ret.get(i));
		}
		System.out.println();
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

class BSTBFSDireita {

	private Node root;
	int qtdElements = 0;

	public boolean isEmpty() {
		return this.root == null;
	}

	public void add(int element) {
		qtdElements++;
		if (isEmpty()) {
			this.root = new Node(element);
		} else {
			this.root.add(element);
		}
	}

	public Node getRoot() {
		return this.root;
	}

}

