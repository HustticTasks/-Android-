#include <stdio.h>

int fibonaci(int n) {
  if (n == 1 || n == 2)
    return 1;
  return fibonaci(n - 1) + fibonaci(n - 2);
}
int main() {
  int n, i;
  printf("请输入n的个数:");
  scanf("%d", &n);
  for (i = 1; i <= n; i++)
    printf("%6d", fibonaci(i));
  return 0;
}
