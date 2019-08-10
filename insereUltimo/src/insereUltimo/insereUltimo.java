package insereUltimo;


import java.util.Scanner;
import java.util.Arrays;

public class insereUltimo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] dados = sc.nextLine().split(" ");
		int[] array = new int[dados.length];
		sc.close();
		
		for(int i=0;i<array.length;i++) {
			array[i] = Integer.parseInt(dados[i]);
		}
		
		System.out.println(Arrays.toString(ordenaUltimo(array)));
	}
	
	public static int[] ordenaUltimo(int[] array) {
		
		int k = array.length-1;
		int i = k-1;
		
		while(i >= 0 && array[k] < array[i]) {
			int aux = array[i];
			array[i] = array[k];
			array[k] = aux;
			i--;
			k--;
		}
		return array;
	}
}
