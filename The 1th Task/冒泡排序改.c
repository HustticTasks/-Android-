#include <stdio.h>
void pop(void);

int main()
{
    int test;
    printf("To start,please enter '0'.");

    while (scanf("%d",&test) == 1)
    {
        pop();
        printf("\nEnter '0' to continue;Enter 'q' to quit:");
    }

    printf("\nDone!\n");
    return 0;
}

void pop(void)
{
    int n,i,j;
    printf("\nEnter a number of members:");
    scanf("%d",&n);
    int arr[n+1],temp1[n+1];

    printf("\nThen enter %d numbers(divide numbers by using blanks):",n);
    i=0;
    while (i < n)
    {
        scanf("%d",&arr[i]);
        i++;
    }

    for (j=n;j>0;j--)
    {
        for (i=0;i<j;i++)
        {
            if (arr[i] > arr[i+1])
            {
                temp1[i] = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp1[i];
            }
        }
    }

    printf("\nThey are listed from little to large like this order:");

    for (i=0;i<n;i++)
        printf("%d ",arr[i]);

    printf("\n");
}
