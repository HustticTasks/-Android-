package AndroidTeamTasks;

import java.util.Scanner;
import java.util.Stack;

public class SolveTheExpression
{
    private Stack<Character> tokenStack = new Stack<Character>(); //运算符栈
    private Stack<Double> numStack = new Stack<Double>(); //数字栈
    private static boolean useDouble = false; //标记，判断最后结果用int还是double输出

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        SolveTheExpression solve = new SolveTheExpression();
        System.out.println("Input the Expression:");
        StringBuilder e = new StringBuilder(in.next()).append("|"); //末尾加上结束标记'|'
        String expression = e.toString();
        double x = solve.count(expression);
        int y = (int)x;
        if(useDouble) System.out.println(x); //如果有标记，说明除不尽，按double输出
        else System.out.println(y); //如果没有标记，说明除得尽，按int输出
    }

    public double count(String ex)
    {
        StringBuilder str = new StringBuilder().append(ex);  //待处理的表达式
        StringBuilder num = new StringBuilder();  //暂时存储多位数字
        String temp;  //当前处理的字符

        while(str.length() != 0)
        {
            temp = str.substring(0, 1);
            str.delete(0, 1);
            if (isNum(temp))
            {
                num.append(temp);
            }
            else
            {
                if (!"".equals(num.toString()))
                {
                    double number = Double.parseDouble(num.toString());
                    numStack.push(number);
                    num.delete(0, num.length());
                }

                while ((!isHigher(temp.charAt(0))) && (tokenStack.lastElement().charValue() != '('))
                {
                    double a = numStack.pop().doubleValue();
                    double b = numStack.pop().doubleValue();
                    char ch = tokenStack.pop().charValue();
                    double result = 0;
                    switch (ch)
                    {
                        case '*':
                            result = b * a;
                            numStack.push(result);
                            break;
                        case '/':
                            result = b / a;
                            if(b%a != 0)
                                useDouble = true; //如果除不尽，最后输出就用浮点型
                            numStack.push(result);
                            break;
                        case '+':
                            result = b + a;
                            numStack.push(result);
                            break;
                        case '-':
                            result = b - a;
                            numStack.push(result);
                            break;
                    }
                }

                /*终止符号'|'*/
                if (temp.charAt(0) != '|')
                {
                    tokenStack.push(temp.charAt(0));
                    if (temp.charAt(0) == ')') //如果读到后括号，说明括号计算完了，删掉(和)
                    {
                        tokenStack.pop();
                        tokenStack.pop();
                    }
                }
            }
        }
        return numStack.pop();
    }
    public boolean isNum(String temp)
    {
        return temp.matches("[0-9]");
    }

    public boolean isHigher(char token)
    {
        if(tokenStack.empty())
            return true;
        char top = tokenStack.lastElement();
        if(top == '(')
            return true;
        switch (token)
        {
            /*终止符号'|'*/
            case '|':
                return false;
            case '(':
                return true;
            case ')':
                return false;
            case '*':
                if(top=='+'||top=='-')
                    return true;
                else
                    return false;
            case '/':
                if(top=='+'||top=='-')
                    return true;
                else
                    return false;
            case '+':
                return false;
            case '-':
                return false;
        }
        return false;
    }
}
