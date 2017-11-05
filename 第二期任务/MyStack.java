package t2;
import java.util.*;

public interface MyStack {
	public static void main(String[] argv) {
		Stack<Integer> number = new Stack<>();
		Stack<Sym> symbol = new Stack<>();
		String c;
		Sym sym;
		Scanner in = new Scanner(System.in);
		while(true){
			if(in.hasNextInt()) {
				number.push(in.nextInt());
			}
			else {
				c = in.next();
				if(c.equals("#"))
					break;
				sym = new Sym(c);
				if(symbol.isEmpty()||symbol.peek().getLevel() < sym.getLevel())
					symbol.push(sym);
				else if(symbol.peek().getLevel() > sym.getLevel()){
					int save = number.pop();
					int k;
					k = in.nextInt();
					number.push(sym.process(save, k));
				}
				else if(symbol.peek().getLevel() == sym.getLevel()) {
					int save = number.pop();
					int k = number.pop();
					number.push(sym.process(k, save));
				}
			}
		}
		while(!symbol.isEmpty()) {
			sym = symbol.pop();
			number.push(sym.process(number.pop(), number.pop()));
		}
		System.out.println(number.pop());
	}  
}
class Sym{
	private String symbol;
	private int level;
	
	public Sym(String symbol) {
		this.symbol = symbol;
		if(symbol.equals("+")||symbol.equals("-"))
			this.level = 1;
		else if(symbol.equals("*")||symbol.equals("/"))
			this.level = 2;
		else
			this.level = 3;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int process(int a,int b) {
		if(symbol.equals("+"))
			return a+b;
		else if(symbol.equals("-"))
			return a-b;
		else if(symbol.equals("*"))
			return a*b;
		else
			return (int)a/b;
	}
}