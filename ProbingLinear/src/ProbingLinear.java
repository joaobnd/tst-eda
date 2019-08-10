import java.util.Scanner;
import java.util.Arrays;

class ProbingLinear {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tam = Integer.parseInt(sc.nextLine());
		TabelaHash tabela = new TabelaHash(tam);
		
		int key;
		String value;
		String entrada[];
		String operacoes = "";
		
		while(!operacoes.equals("end")) {
			entrada = sc.nextLine().split(" ");
			operacoes = entrada[0];
			
			switch (operacoes) {
			case "put":
				key = Integer.parseInt(entrada[1]);
				value = entrada[2];
				System.out.println(tabela.put(key, value));
				break;
			
			case "remove":
				key = Integer.parseInt(entrada[1]);
				System.out.println(tabela.remove(key));
				break;
			
			case "keys":
				System.out.println(tabela.keys());
				break;
			
			case "values":
				System.out.println(tabela.values());
				break;
			}
		}
		sc.close();
				

	}

}

class Pair {
	
	private String value;
	private int key;
	private boolean deleted;
	
	public Pair(int key, String value) {
		this.key = key;
		this.value = value;
		deleted = false;
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	
	public void delete() {
		this.deleted = true;
	}
	public int getKey() {
		return this.key;
	}
	public String getValue() {
		return this.value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (deleted ? 1231 : 1237);
		result = prime * result + key;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (deleted != other.deleted)
			return false;
		if (key != other.key)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	public String toString() {
		String toString = null;
		if (!deleted) {
			toString = "<" + this.key + ", " + this.value + ">";
		}
		return toString;
	}
}

class TabelaHash {
	
	private Pair[] tabela;
	private int elementos;
	
	public TabelaHash(int tam) {
		this.tabela = new Pair[tam];
	}
	
	public boolean isFull() {
		return this.elementos == this.tabela.length;
	}
	public boolean isEmpty() {
		return this.elementos == 0;
	}
	public String toString() {
		return Arrays.toString(this.tabela);
	}
	public int hashFunction(int k, int i) {
		return (k+i) % this.tabela.length;
	}
	public String values() {
		String[] values = new String[this.elementos];
		int index = 0;
		for (int i=0;i<this.tabela.length;i++) {
			if (this.tabela[i] != null && !this.tabela[i].isDeleted()) 
				values[index++] = this.tabela[i].getValue();
		}
		Arrays.sort(values);
		return Arrays.toString(values);
	}
	public String keys() {
		Integer[] keys = new Integer[this.elementos];
		int index = 0;
		for(int i=0;i<this.tabela.length;i++) {
			if (this.tabela[i] != null && !this.tabela[i].isDeleted())
				keys[index++] = this.tabela[i].getKey();
		}
		Arrays.sort(keys);
		return Arrays.toString(keys);
	}
	
	public String remove(int key) {
		if (!this.isEmpty()) {
			int i = 0;
			int j;
			boolean removido = false;
			
			while (i<this.tabela.length && !removido) {
				j = this.hashFunction(key, i);
				if (this.tabela[j] != null && this.tabela[j].getKey() == key) {
					tabela[j].delete();
					elementos--;
					removido = true;
				}
				i++;
			}
		}
		return this.toString();
	}
	
	
	public String put(int key, String value) {
		if(!this.isFull()) {
			int i = 0;
			int j;
			boolean inserido = false;
			
			while (i<tabela.length && !inserido) {
				
				j = this.hashFunction(key, i);
				if (this.tabela[j] != null && this.tabela[j].getKey() == key)
					this.remove(key);
				if(this.tabela[j] == null || this.tabela[j].isDeleted()) {
					Pair pair = new Pair(key, value);
					tabela[j] = pair;
					elementos++;
					inserido = true;
				}
				i++;
			}
		}
		return this.toString();
	}
}