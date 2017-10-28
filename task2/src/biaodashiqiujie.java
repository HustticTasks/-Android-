import java.util.*;
public class biaodashiqiujie
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String biaodashi = scan.nextLine();
            System.out.print(biaodashi+"=");
            Stack<Integer> number = new Stack<Integer>();
            Stack<Character> operator = new Stack<Character>();
            for (int i = 0; i < biaodashi.length(); i++) {
                char c = biaodashi.charAt(i);
                switch (c) {
                    case '+':
                        while (!operator.empty() && ((operator.peek() == '+' || operator.peek() == '-' || operator.peek() =='*'|| operator.peek() == '/')))
                        {
                            cal(number, operator);
                        }
                        operator.push(c);
                        break;
                    case '-':
                        while (!operator.empty() && ((operator.peek() == '+' || operator.peek() == '-' || operator.peek() =='*'|| operator.peek() == '/')))
                    {
                        cal(number, operator);
                    }
                    operator.push(c);
                    break;
                    case '*':
                        while (!operator.empty() &&( (operator.peek() == '*') || operator.peek() == '/')) {
                            cal(number, operator);
                        }
                        operator.push(c);
                        break;
                    case '/':
                        while (!operator.empty() && ((operator.peek() == '*') || operator.peek() == '/')) {
                            cal(number, operator);
                        }
                        operator.push(c);
                        break;
                    default:
                        String num = String.valueOf(c);
                        while (i + 1 < biaodashi.length() && Character.isDigit(biaodashi.charAt(i + 1))) {
                            num = num + String.valueOf(biaodashi.charAt(i + 1));
                            i++;
                        }
                        Integer a = new Integer(num);
                        number.push(a);
                }
            }
            while (!operator.empty()) {
                cal(number, operator);
            }
            System.out.println(number.pop());
        }
        scan.close();
    }
    public static void cal(Stack<Integer>number,Stack<Character>operator)
    {
        char op=operator.pop();
        Integer n1=number.pop();
        Integer n2=number.pop();
        switch(op)
        {
            case '+':
                number.push(n1+(n2));
                break;
            case '-':
                number.push(n2-n1);
                break;
            case '*':
                number.push(n1*(n2));
                break;
            case '/':
                number.push(n2/n1);
                break;
        }
    }
}
