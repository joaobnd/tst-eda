import java.util.Scanner;

public class PilhaComArray {
	
	private int[] array;
	private int top;
	
	
	
	
	public PilhaComArray (int tam) {
		array = new int[tam];
		top = -1;
	}
	
	public int peek() {
		int peek = -1;
		
		if(!isEmpty()) {
			peek = array[top];
		}
		return peek;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == array.length-1;
	}
	
	public void push(int n) {
		if (!isFull()) {
			top++;
			array[top] = n;
		} else {
			System.out.println("full");
		}
	}
	
	public int pop() {
		
		int pop = -1;
		if(!isEmpty()) {
			pop = array[top];
			top--;
		}
		return pop;
	}
	
	public String print() {
		String print = "empty";
		if (!isEmpty()) {
			print = "";
			for (int i = 0; i < top; i++) {
				print += array[i] + " ";
			}
			print += array[top] + "";
		}
		return print;
	}
	
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tam = Integer.parseInt(sc.nextLine());
		PilhaComArray pilha = new PilhaComArray(tam);

		String operacao = "";
		while (!operacao.equals("end")) {
		
			operacao = sc.nextLine();
			if (operacao.equals("pop")) {
				int i = pilha.pop();
				if (i == -1) {
					System.out.println("empty");
				}
			} else if (operacao.equals("peek")) {
				System.out.println(pilha.peek());
			} else if (operacao.equals("print")) {
				System.out.println(pilha.print());
			} else {
				String[] op = operacao.split(" ");
				if (op[0].equals("push")) {
					pilha.push(Integer.parseInt(op[1]));
				}
			}
			
		}

		sc.close();
	}

}