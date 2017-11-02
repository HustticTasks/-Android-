#include <stdio.h>

int main() {
  int n;
  printf("请输入行数:");
  scanf("%d", &n);
  int i = 1, j = 0;
  for (i = 1; i <= n; i++) {
    printf("\t");
    for (j = 0; j < 2 * (n - i); j++)
      putchar(' ');
    for (j = 0; j < 2 * i - 1; j++) {
      putchar('*');
      putchar(' ');
    }
    printf("\n");
  }
  return 0;
}