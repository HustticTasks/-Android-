#include <stdio.h>
#include <stdlib.h>

    int jiecheng(int n)
{
    int i;
    int num=n;
    for (i=1;i<n;i++)
    {
    num*=(n-i);
    }
    printf("%d\n",num);
    return 0;
}
int main ()
{
    int j;
    for(j=10;j>=0;j--)
    {
    jiecheng(j);
    }

return 0;
}

