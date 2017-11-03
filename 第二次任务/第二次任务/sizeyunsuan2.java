package demo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class sizeyunsuan2 {
    public static void main(String[] args){
        Stack s1=new Stack();
        Stack s2=new Stack();
        Stack s3=new Stack();
        Scanner input=new Scanner(System.in);
        String x;
        x=input.nextLine();
        double[] s=new double[x.length()+1];
        boolean[] juedge=new boolean[x.length()+1];
        boolean BeforePoint;
        Arrays.fill(s,0);
        Arrays.fill(juedge,false);
        int i=0,j=0,t=0,PointNumber;


        while (i<=x.length()-1){
            PointNumber=0;  BeforePoint=true;
            if (Character.isDigit(x.charAt(i))){
                j=i;
                while (Character.isDigit(x.charAt(j))||x.charAt(j)=='.'){
                    if (Character.isDigit(x.charAt(j))&&(BeforePoint==false)) {
                        PointNumber++;
                        s[t]+=(((double)x.charAt(j))/(10*PointNumber));
                    }
                    if (x.charAt(j)=='.')
                        BeforePoint=false;
                    if (Character.isDigit(x.charAt(j))&&BeforePoint) {
                        s[t] = s[t] * 10 + (int) x.charAt(j) - 48;
                    }
                    j++;
                    if (j>x.length()-1)
                        break;
                }
                t++;
                i=j-1;
            }
            else {
                s[t]=(int)x.charAt(i);juedge[t]=true;t++;
            }
            i++;
        }

  //      for (j=0;j<=t-1;j++){
  //          System.out.println(s[j]);
   //     }

        t--;           //此时，t表示数组中元素个数
        int m;
        int pushN=0;
        for (i=t;i>=0;i--){
            pushN=0;
            if (juedge[i]==false){
                s2.push(s[i]);
            }
            if (juedge[i]&&(int)s[i]!=40&&(int)s[i]!=41){
                if (s1.empty()==false){
                    m=(char)(s1.peek());
                    if (yusuanfubijiao((int)s[i],m))
                        s1.push((char)((int)s[i]));
                    else{
                        while (yusuanfubijiao((int)s[i],m)==false&&s1.empty()==false){
                            s2.push(s1.pop());
                            if (s1.empty()==false)
                                m=(char)s1.peek();
                        }
                        s1.push((int)s[i]);
                    }
                }

                if (s1.empty())
                    s1.push((char)((int)s[i]));

            }
            if ((int)s[i]==41&&juedge[i])
                s1.push((char)s[i]);
            if ((int)s[i]==40&&juedge[i]){
                pushN=0;
                m=(char)s1.peek();
                while (m!=41){
                    s2.push(s1.pop());
                    m=(char)(s1.peek());
                }
                s1.pop();
            }
          //  printStack(s1);
        }
       //使用while循环将栈s1中剩余元素压入s2;

        while (s1.empty()==false)
            s2.push(s1.pop());
     //   printStack(s2);

        //已将原式转化为前缀表达式 将栈s2中的元素再次压入s1中
        while (s2.empty()==false){
            s1.push(s2.pop());
        }
        //开始计算
   //     printStack(s2);
// printStack(s1);
        double sum;

        Stack judge=new Stack();
        while (s1.empty()==false){
            judge.push('/');judge.push('*');judge.push('-');judge.push('+');
            if ((s1.peek().equals(judge.pop()))||(s1.peek().equals(judge.pop()))||(s1.peek().equals(judge.pop()))||(s1.peek().equals(judge.pop()))){
                sum=jisuan((char)(s1.pop()),(double)s2.pop(),(double)s2.pop());
                s2.push(sum);
        }
            else{
                s2.push(s1.pop());
            }
        }
        System.out.println(s2.pop());






    }
    //   运算符的ascall码：  +:43  -:45   *:42    /:47   (:40  ):41

    //方法作用：对于a,b两个运算符优先级的比较，如果a<b 则返回为假，否则为真
    public static boolean yusuanfubijiao(int a,int b){
        if (a==42)
            a=48;
        if (b==42)
            b=48;
        if (a>=b)
            return true;
        if (a<b)
            return false;

        return false;

    }
    private static void printStack(Stack test ){
        if (test.empty())
            System.out.println("栈是空的，没有元素");
        else {
            System.out.print("栈中的元素：");
            while (test.empty()==false) //显示枚举（stack ） 中的所有元素
                System.out.print(test.pop()+" ");
        }
        System.out.println();
    }
    public static double jisuan(char yusuanfu,double a,double b){
        if (yusuanfu=='+')
            return a+b;
        if (yusuanfu=='-')
            return a-b;
        if (yusuanfu=='*')
            return a*b;
        if (yusuanfu=='/')
            return a/b;
        return 1;
    }
}
