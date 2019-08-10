
import java.util.Scanner;


public class binarySearchRecursive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		int n = sc.nextInt();

		int[] v = getArray(entrada);
		
		System.out.println(Search(v, n, 0, v.length));

		sc.close();
	}

	
	
	private static int Search(int[] v, int n, int init, int fim) {
		
		if(init<fim) {
			int meio = (init+fim) / 2;
			
			if(v[meio] == n)
				return meio;
			if(v[meio] > n)
				return Search(v, n, init, meio-1);
			else
				return Search(v, n, meio+1, fim);
		}
		return -1;
	}

	
	private static int[] getArray(String[] entrada) {
		
		int[] array = new int[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		return array;
	}
	
	
}