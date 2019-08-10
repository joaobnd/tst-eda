import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortRecursive {
	
	public static void recursiveInsertion(int[] valores) {
		recursiveInsertion(valores, 1, valores.length);
	}
	
	public static void recursiveInsertion(int[] valores, int i, int n) {
		if(i <= n-1) {
			int aux = valores[i];
			int j = i;
			
			while((j>0) && (valores[j-1] > aux)) {
				valores[j] = valores[j-1];
				j--;
			}
			valores[j] = aux;
			System.out.println(Arrays.toString(valores));
			recursiveInsertion(valores, i+1, n);
		}
		
	}

	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		String[] dados = ler.nextLine().split(" ");
		int[] valores = new int[dados.length];
		ler.close();
		
		for (int i=0;i<valores.length;i++) {
			valores[i] = Integer.parseInt(dados[i]);
		
		}
		
		recursiveInsertion(valores);
	}

}
