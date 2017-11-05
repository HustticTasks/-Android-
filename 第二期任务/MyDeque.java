package t1;
import java.util.*;

public class MyDeque {
	public static void main(String[] argv) {
		System.out.print("The number of students:");
		Scanner in = new Scanner(System.in);
		int n,i,size;
		n = in.nextInt();
		size = n;
		in.close();
		Queue<Integer> line = new LinkedList<>();
		for(i=1;i<=n;++i) {
			line.offer(i);
		}
		while(size != 1) {
			line.offer(line.peek());
			line.poll();
			line.offer(line.peek());
			line.poll();
			line.poll();
			size--;
		}
		System.out.println(line.peek());
	}
}
