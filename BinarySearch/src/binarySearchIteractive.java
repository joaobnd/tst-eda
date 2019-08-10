import java.util.Scanner;

public class binarySearchIteractive {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		int n = sc.nextInt();

		int[] v = getArray(entrada);
		
		System.out.println(Search(v, n));

		sc.close();
	}

	
	
	private static int Search(int[] v, int n) {
		int resp = -1;
		int left = 0;
		int right = v.length-1;
		
		while(left < right) {
			int meio = (left + right) / 2;
			
			if(v[meio] == n) {
				resp = v[meio];
			}
			else if (v[meio] < n) {
				left = meio+1;
			}
			else {
				right = meio -1;
			}
		}
		
		return resp;
		
		
	
	}

	
	private static int[] getArray(String[] entrada) {
		
		int[] array = new int[entrada.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(entrada[i]);
		}
		return array;
	}
	
	
}