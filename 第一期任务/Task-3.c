#include <stdio.h>
#include <stdlib.h>

int main()
{
    int arr[]={1,2,4,334,55,32,12};
    int j,i;
    for(i=0;i<7;i++)
    {
        if(i!=6)
            printf("%d,",arr[i]);
        else
            printf("%d\n",arr[i]);
    }
    for(i=6;i>=0;i--)
    {
        for(j=0;j<=i;j++)
        {
            if(arr[i]>arr[j])
            {
                int a;
                a=arr[i];
                arr[i]=arr[j];
                arr[j]=a;
            }
        }
    }
    for(i=0;i<=6;i++)
    {
        if(i!=6)
        {
            printf("%d,",arr[i]);
        }
        else
        {
            printf("%d",arr[i]);
        }
    }
    return 0;
}
