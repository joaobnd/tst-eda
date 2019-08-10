import java.util.Scanner;
import java.util.Arrays;

public class EstatisticaDeOrdem {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] array = getArrayInteiros(sc);
		System.out.println(estatisticaDeOrdem(array));
		sc.close();
		System.out.println(Arrays.toString(array));
	}

	private static int estatisticaDeOrdem(int[] array) {
		int first = array[0];
		boolean found = false;
		int i = 0;
		while (i < array.length && !found) {

			int indexMin = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[indexMin]) {
					indexMin = j;
				}
			}
			swap(array, i, indexMin);

			if (first == array[i]) {
				found = true;
			}
			i++;
		}
		return i;
	}

	private static void swap(int[] array, int i, int j) {
		int aux = array[j];
		array[j] = array[i];
		array[i] = aux;
	}

	private static int[] getArrayInteiros(Scanner sc) {
		String[] entrada = sc.nextLine().split(" ");
		int[] array = new int[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		return array;
	}
}