import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		int[] v = {4,6,3,5,8,9,7,1,2};
		countingSort(v);
		System.out.println(Arrays.toString(v));
		

	}

	private static void countingSort(int[] v) {
		int leftIndex = 0;
		int rightIndex = v.length-1;
		//encontra o maior elemento
		int k = 0;
		for(int i=leftIndex;i<rightIndex;i++)
			if(v[i] > k)
				k = v[i];
		//cria um vetor temporario com o tamanho do maior elemento
		int[] tempV = new int[k];
		//inicia o vetor temporario com todos os elementos iguais a 0
		for(int i=0;i<tempV.length;i++) {
			tempV[i] = 0;
		}
		//conta as ocorrencias de cada elemento
		for(int j=leftIndex;j<rightIndex;j++) {
			tempV[v[j]] +=1;
		}
		//incrementa as ocorrencias de um elemento
		//com as ocorrencias do elemento anterior
		for(int i=leftIndex;i<k;i++) {
			tempV[i] = tempV[i] + tempV[i-1];
		}
		//ordena da direita pra esquerda
		int[] aux = new int[v.length];
		for(int j = rightIndex;j>leftIndex;j--) {
			aux[tempV[v[j]]] = v[j];
			tempV[v[j]] -= 1;	
		}
		//troca os valores da entrada pelos valores ordenados
		for(int i=leftIndex;i<rightIndex;i++) {
			v[i] = tempV[i];
		}
		
	}
	
	

}
