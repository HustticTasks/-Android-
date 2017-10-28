package demo;

import java.util.Scanner;

public class _2hw1 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int i,t,j,x=n;
        boolean[] key=new boolean[n+1];

        for (i=1;i<=n;i++)
            key[i]=true;

        while (x>2){
            t=0;j=0;
            for (i=1;i<=n;i++){
                if (key[i]){
                    t++;
                    if (t%3==0){
                        j++;
                        key[i]=false;
                    }
                }
            }
            x=x-j;
        }
        for (i=1;i<=n;i++){
            if (key[i])
                System.out.println(i);
        }
    }
}
