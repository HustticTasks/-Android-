#include <stdio.h>

int main() {
  int n, i = 0, j = 0;
  printf("请输入输入数字的个数:");
  scanf("%d", &n);
  int a[n];
  while (i < n) {
    scanf("%d", &a[i]);
    i++;
  }
  for (i = 0; i < n; i++)
    for (j = 0; j < n; j++)
      if (a[j] < a[j + 1]) {
        int temp = a[j];
        a[j] = a[j + 1];
        a[j + 1] = temp;
      }
  for (i = 0; i < n; i++)
    printf("%d\t", a[i]);
  return 0;
}
