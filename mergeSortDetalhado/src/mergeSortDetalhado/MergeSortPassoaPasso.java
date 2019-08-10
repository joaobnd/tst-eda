package mergeSortDetalhado;

import java.util.Arrays;
import java.util.Scanner;

class MergeSortPassoAPasso {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] array = getArrayInteiros(sc);
		mergeSort(array);
		System.out.println(Arrays.toString(array));
		sc.close();
	}

	private static void mergeSort(int[] array) {
		mergeSort(array, 0, array.length - 1);

	}

	private static void mergeSort(int[] array, int leftIndex, int rightIndex) {
		printArray(array, leftIndex, rightIndex);
		if (leftIndex < rightIndex) {

			int mid = (leftIndex + rightIndex) / 2;
			mergeSort(array, leftIndex, mid);
			mergeSort(array, mid + 1, rightIndex);
			merge(array, leftIndex, mid, rightIndex);

			if (rightIndex - leftIndex < array.length-1) {
				printArray(array, leftIndex, rightIndex);
			}

		}
	}

	private static void merge(int[] array, int leftIndex, int mid, int rightIndex) {
		int[] aux = Arrays.copyOf(array, array.length);

		int i = leftIndex;
		int j = mid + 1;
		int indexAtual = leftIndex;

		while (i <= mid && j <= rightIndex) {
			if (aux[i] < aux[j]) {
				array[indexAtual] = aux[i];
				i++;
			} else {
				array[indexAtual] = aux[j];
				j++;
			}
			indexAtual++;
		}

		while (i <= mid) {
			array[indexAtual] = aux[i];
			i++;
			indexAtual++;
		}

		while (j <= rightIndex) {
			array[indexAtual] = aux[j];
			j++;
			indexAtual++;
		}

	}

	private static int[] getArrayInteiros(Scanner sc) {
		String[] dados = sc.nextLine().split(" ");
		int[] array = new int[dados.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(dados[i]);
		}
		return array;
	}

	private static void printArray(int[] array, int leftIndex, int rightIndex) {
		System.out.println(Arrays.toString(Arrays.copyOfRange(array, leftIndex, rightIndex + 1)));
	}

}