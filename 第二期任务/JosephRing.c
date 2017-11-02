/*
 * @Author: victor
 * @Date: 2017-10-29 17:01:26
 * @Last Modified by: victor
 * @Last Modified time: 2017-10-29 17:11:06
 */

#include "Queue/Queue.h"

int main() {
  int n, i = 1;
  printf("请输入n的个数:");
  scanf("%d", &n);
  Queue qQueue;
  initQueue(&qQueue, n);
  while (i <= n) {
    enQueue(qQueue, i);
    i++;
  }
  int remain = n;  //剩余的人数
  int quitNumber;  //出队的人员编号
  while (remain != 1) {
    i = 1;
    while (i != 3) {
      qQueue->front = (qQueue->front + 1) % (qQueue->maxSize - 1);
      if (qQueue->data[qQueue->front] != 0)
        i++;
    }
    deQueue(qQueue, &quitNumber);
    while (qQueue->data[qQueue->front] == 0)
      qQueue->front = (qQueue->front + 1) % (qQueue->maxSize - 1);
    printf("%d号出队\n", quitNumber);
    remain--;
  }
  deQueue(qQueue, &quitNumber);
  printf("剩余的人的号数是: %d\n", quitNumber);
  return 0;
}