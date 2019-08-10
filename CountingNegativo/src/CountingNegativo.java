import java.util.Scanner;
import java.util.Arrays;

public class CountingNegativo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = getArrayInteiros(sc);
		int max = Integer.parseInt(sc.nextLine());
		int min = Integer.parseInt(sc.nextLine());
		countingSort(array, max, min);
		sc.close();
	}

	private static void countingSort(int[] A, int max, int min) {

		int aux = -min;
		int k = max - min;

		int[] C = new int[k + 1];
		int[] B = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			C[A[i] + aux]++;
			printArray(C);
		}

		for (int i = 1; i < C.length; i++) {
			C[i] += C[i - 1];
		}
		printCumulative(C);

		int a;
		int posicao;
		for (int i = A.length - 1; i >= 0; i--) {
			a = A[i];
			posicao = --C[a + aux];
			B[posicao] = a;
		}

		for (int i = 0; i < B.length; i++) {
			A[i] = B[i];
		}

		printArray(C);
		printArray(A);

	}

	private static int[] getArrayInteiros(Scanner scan) {
		String[] entrada = scan.nextLine().split(" ");
		int[] array = new int[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		return array;
	}

	private static void printArray(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	private static void printCumulative(int[] array) {
		String result = "Cumulativa do vetor de contagem - " + Arrays.toString(array);
		System.out.println(result);
	}

}