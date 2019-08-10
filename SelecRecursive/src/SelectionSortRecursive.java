import java.util.Arrays;
import java.util.Scanner;

public class SelectionSortRecursive {
	
	public static void swap(int[] valores, int i, int j) {
		
		int aux = valores[j];
		valores[j] = valores[i];
		valores[i] = aux;
	}
	
	public static void recursiveSelection(int[] valores) {
		recursiveSelection(valores, 0, valores.length);
	}
	
	public static void recursiveSelection(int[] valores, int i, int n) {
		int min = i;
		for (int j=i+1;j<n;j++) {
			
			if(valores[j] < valores[min]) {
				min = j;
			}
		}
		swap(valores, i, min);
		System.out.println(Arrays.toString(valores));
		
		if (i+1 < n-1) {
			recursiveSelection(valores, i+1, n);
		}
	}

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		String[] dados = ler.nextLine().split(" ");
		int[] valores = new int[dados.length];
		
		
		for (int i=0;i<valores.length;i++) {
			valores[i] = Integer.parseInt(dados[i]);
		
		}
		
		recursiveSelection(valores);
		ler.close();
	}

}

