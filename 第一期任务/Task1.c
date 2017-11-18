#include <stdio.h>
#include <stdlib.h>
int a(int n)
{
    int i,j,m;
    for(i=0;i<=n;i++)
    {
        for(m=n-1;m>i;m--)

            {printf(" ");}

        for(j=0;j<i*2+1;j++)

                {printf("*");}


    printf("\n");
    }
    return 0;
}
int main()
{
    a(50);
    return 0;
}
