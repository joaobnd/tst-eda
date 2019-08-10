import java.util.Scanner;
import java.util.Stack;

public class Parenteses {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(parenteses(str));
		sc.close();
	}
	
	
	private static String parenteses(String str) {
		Stack<String> pilha = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(')
				pilha.push("(");
			else {
				if (pilha.isEmpty())
					return "N";
				else
					pilha.pop();
			}
		}
		
		if (pilha.isEmpty())
			return "S";
		else
			return "N";
	}

}