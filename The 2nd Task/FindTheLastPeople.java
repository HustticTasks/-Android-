package for循环练习;

import java.util.Scanner;

public class _3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("How many people are there?");
        int n = in.nextInt();

        int[] arr = new int[n]; //总共n个人
        for(int i=0;i<n;i++) arr[i] = i+1;

        int j,k;
        j=n;k=0;

        finish: //跳出这两层循环的标签
        while(true) //不断查找
        {
            for(int i=0;i<n;i++) //for一次，就查找这n个人一圈
            {
                if(arr[i] != 0) //遍历找出非0的数（即没有退出圈的人）
                    k++;
                else continue;

                if(k%3 == 0) //找满三个就踢掉一个
                {
                    arr[i] = 0;
                    j--;
                }

                if(j == 1) //踢到j只剩1个，说明只有一个数是原值，其他的都被标记成0
                    break finish; //跳出两层循环
            }
        }
        for(int i=0;i<n;i++)
        {
            if(arr[i] != 0)
                System.out.println("The last people is No."+arr[i]+" !");
        }
    }
}
