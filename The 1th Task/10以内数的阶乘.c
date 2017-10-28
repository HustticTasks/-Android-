#include <stdio.h>
int temp(int n); //函数temp求n的阶乘并返回该值

int main()
{
    int n,outcome;

    printf("Enter a number no more than 10(Enter 'q' to quit):");

    while (scanf("%d",&n) == 1)
    {
        if (n<=0)
        {
            printf("\nError! The number must be bigger than 0.\n");
            printf("\nPlease try again(Enter 'q' to quit):");
            continue;
        }
        else if (n>10)
        {
            printf("\nError! The number must be no more than 10.\n");
            printf("\nPlease try again(Enter 'q' to quit):");
            continue;
        }
        else
        {
            outcome = temp(n);
            printf("\n%d! = %4d.\n",n,outcome);
            printf("\nEnter the next number(Enter 'q' to quit):");
        }
    }
    printf("\nDone!\n");
    return 0;
}

int temp(int n)
{
    int i,all;

    for (i=1,all=1 ; i<=n ; i++)
    {
        all *= i;
    }

    return all;
}
