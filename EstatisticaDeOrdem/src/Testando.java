import java.util.Scanner;
import java.util.Arrays;

public class Testando {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] array = getArrayInteiros(sc);
		System.out.println(estatisticaDeOrdem(array));
		System.out.println(Arrays.toString(array));
		sc.close();
	}

	private static int estatisticaDeOrdem(int[] array) {
		int first = array[0];
		int ordem = 1;
		int aux = 0;
		boolean found = false;
		
		for(int i = ordem;i<array.length;i++) {
			if(array[i] < first) {
				ordem++;
			}
		}
		while(aux < array.length && !found) {
			
			int minIndex = aux;
			
			for(int j=aux+1;j<array.length;j++) {
				if(array[j] < array[minIndex]) {
					minIndex = j;
				}
			}
			swap(array, minIndex, aux);
			
			if(first == array[aux]) {
				found = true;
			}
			aux++;
		}
		return ordem;
		
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