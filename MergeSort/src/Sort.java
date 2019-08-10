import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		int[] v = {4,6,7,3,5,9,1,8};
		int[] w = new int[v.length];
		
		mergeSort(v, w, 0 , v.length-1);
		System.out.println(Arrays.toString(v));

	}

	private static void mergeSort(int[] v, int[] w, int ini, int fim) {
		
		if(ini < fim) {
			int meio = (ini+fim) / 2;
			mergeSort(v, w, ini, meio);
			mergeSort(v, w, meio+1, fim);
			merge(v, w, ini, meio , fim);
		}

	}

	private static void merge(int[] v, int[] w, int ini, int meio, int fim) {
		for(int k = ini;k <= fim;k++)
			w[k] = v[k];
		
		int i = ini;
		int j = meio+1;
		
		for(int k = ini;k<=fim;k++) {
			//um subarray terminou entao so coloca os elementos do outro subarray.
			if(i > meio)
				v[k] = w[j++];
			else if (j > fim)
				v[k] = w[i++];
			//intercala os elementos
			else if (w[i] < w[j])
				v[k] = w[i++];
			else
				v[k] = w[j++];
			
		}
		
	}

}
