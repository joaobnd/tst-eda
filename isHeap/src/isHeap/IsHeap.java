package isHeap;

import java.util.Scanner;

class IsHeap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		
		int[] elements = getArray(entrada);
		System.out.println(ChecaHeap(elements));
		sc.close();
	}

	private static int[] getArray(String[] entrada) {
	
		int[] array = new int[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		return array;
	}
	
	public static boolean ChecaHeap(int[] elements) {
		boolean result = true;
		
		int i = 0;
		while (result && left(i) < elements.length && right(i) < elements.length) {
			if (elements[left(i)] > elements[parent(i)] || elements[right(i)] > elements[parent(i)]) {
				result = false;
			}
			i++;
		}

		return result;
	}

	private static int parent(int i) {
		return (i - 1) / 2;
	}

	private static int left(int i) {
		return (2 * i + 1);
	}

	private static int right(int i) {
		return (2 * i + 1) + 1;
	}


}