#include <stdio.h>

int main()
{
    int a1,a2,i,n;
    long long arr[1000];

    printf("Warning!\nIf you enter a too large number,the program will probably overflow.\n");
    printf("\nEnter a number of terms:");

    while (scanf("%d",&n) == 1)
    {
        if (n<=0)
        {
            printf("\nError! The number you enter must be bigger than 0.\n");
            printf("\nYou can try again:");
            continue;
        }
        else if (n<3)
        {
            if (n==1)
                printf("1 ");
            else
                printf("1, 1");
        }
        else
        {
            arr[0] = arr[1] = 1;

            printf("1, 1");

            for (i=2 ; i<n ; i++)
            {
                arr[i] = arr[i-1] + arr[i-2];
                printf(", %d",arr[i]);
            }
        }
        printf("\n\nEnter the next number of terms(Press 'q' to quit):");
    }
    printf("\nDone!\n");
    getchar();
    getchar();
    getchar();
    return 0;
}
