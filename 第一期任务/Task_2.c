#include <stdio.h>

int jiecheng(int n) {
  static int result = 1;
  result *= n;
  return result;
}

int main() {
  int n = 10;
  int i = 1;
  while (i++ < n) {
    printf("%d:  %6d\n", i, jiecheng(i));
  }
  return 0;
}