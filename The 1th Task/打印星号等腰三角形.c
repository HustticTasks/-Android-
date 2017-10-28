#include <stdio.h>

int main()
{
    int n , i , j, k, temp;

    printf("Enter a number of lines:");
    scanf("%d",&n);

    temp = n;

    for (i=0;i<n;i++)
    {
        for (j=0;j<2*(temp-1);j++)
            printf(" ");
            temp--;

        printf("*");

        for (k=0;k< 2*i;k++)
            printf(" *");

        printf("\n");
    }
    getchar();
    getchar();
    return 0;
}
