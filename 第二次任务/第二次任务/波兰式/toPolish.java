package demo.第二次任务;

import java.util.Scanner;
import java.util.Stack;

public class toPolish {
    static int i=0;
    public static void main(String[] args){
        Stack<Character> operater=new Stack<Character>();
        Stack<Integer> s1=new Stack<Integer>();
        Stack<Object> s2=new Stack<Object>();
        Scanner input=new Scanner(System.in);
        String expression=input.nextLine();
        int length=expression.length()-1;

        for (i=length;i>=0;i--){
            double num=0;
            if (Character.isDigit(expression.charAt(i))){
                num=getnumber(expression);
                s2.push(num);
            }
            if (i>=0) {
                if (isOpereater(expression.charAt(i))) {
                    char ready = expression.charAt(i);
                    if (operater.empty() || (operater.empty()==false && operater.peek()==')')) operater.push(expression.charAt(i));
                    else {
                        char havein = operater.peek();
                        if (priority(ready, havein)) operater.push(ready);
                        else {
                            while (!priority(ready, operater.peek())) {
                                s2.push(operater.pop());
                            }
                            operater.push(ready);
                        }
                    }
                }
                if (expression.charAt(i) == ')' && i >= 0) operater.push(')');
                if (expression.charAt(i) == '(' && i >= 0) {
                    while (operater.peek() != ')')
                        s2.push(operater.pop());
                    operater.pop();
                }
            }
        }
        while (!operater.empty())
            s2.push(operater.pop());
        printStack(s2);

    }
    public static double getnumber(String s){
        boolean point=false;
        int placeOfpoint=i+1;
        int endOfNum=i;
        double theNum=0;double decimal=0;
        while ((Character.isDigit(s.charAt(i))) || (s.charAt(i)=='.')){
            if (s.charAt(i)=='.'){
                point=true;placeOfpoint=i;
            }
            i--;
            if(i==-1) break;
        }
        for (int j=i+1;j<placeOfpoint;j++) theNum=theNum*10+(int)s.charAt(j)-48;
        if (point){
            int digit=0;double part;
            decimal=0;
            for (int j=placeOfpoint+1;j<=endOfNum;j++) {
                digit++;
                part=(int)s.charAt(j)-48;
                for (int k=1;k<=digit;k++) part/=10;
                decimal+=part;
            }
        }
        theNum=theNum+decimal;
        return theNum;

    } //获取数字
    public static boolean isOpereater(char get){
        if (get=='+' || get=='-' || get=='*'  ||get =='/') return true;
        else return false;
    } //判断是否为运算符
    public static boolean priority(char ready,char havein){
        if ((ready=='+' || ready=='-')&&(havein=='/' || havein=='*')) return false;
        else return true;
    }    //判断待进入栈的符号与栈顶符号的优先级，若前者更高或相等则返回真，否则为假
    public static void printStack(Stack t){
        if (t.empty()) System.out.println("空栈！");
        else{
            System.out.println("栈中的元素有");
            while (!t.empty())
                System.out.print(t.pop()+"  ");
            System.out.println();
        }
    }


}
