/*
 * @Author: victor
 * @Date: 2017-10-29 00:17:51
 * @Last Modified by: victor
 * @Last Modified time: 2017-10-29 17:03:35
 */
#include "Queue.h"

int initQueue(Queue *qQueue, int maxSize) {
  (*qQueue) = (Queue)malloc(sizeof(struct QUEUE));
  (*qQueue)->data = (DataType *)malloc(sizeof(DataType) * maxSize);
  if (qQueue == NULL)
    return FALSE;
  (*qQueue)->front = 0;
  (*qQueue)->rear = 0;
  (*qQueue)->maxSize = maxSize + 1;
  return TRUE;
}

int queueFull(Queue qQueue) {
  return (qQueue->front) == ((qQueue->rear + 1) % qQueue->maxSize) ? TRUE
                                                                   : FALSE;
}
//入队操作
int enQueue(Queue qQueue, DataType data) {
  if (queueFull(qQueue)) {
    printf("the queue is full! Cannot enqueue!");
    return FALSE;
  }
  qQueue->data[qQueue->rear] = data;
  qQueue->rear = (qQueue->rear + 1) % (qQueue->maxSize);
  return TRUE;
}

//判断队列是否为空
int queueEmpty(Queue qQueue) {
  return qQueue->front == qQueue->rear ? TRUE : FALSE;
}

//出队操作
int deQueue(Queue qQueue, DataType *data) {
  if (queueEmpty(qQueue)) {
    printf("the Queue is empty, cannot dequeue!");
    return FALSE;
  }
  *data = qQueue->data[qQueue->front];
  qQueue->data[qQueue->front] = 0;
  qQueue->front = (qQueue->front + 1) % (qQueue->maxSize - 1);
  return TRUE;
}

//清空队列
void clear(Queue qQueue) {
  int i = 0;
  for (i = 0; i < qQueue->maxSize - 1; i++)
    qQueue->data[i] = 0;
  qQueue->front = qQueue->rear = 0;
}

//打印队列中所有元素
void printAll(Queue qQueue) {
  if (queueEmpty(qQueue)) {
    printf("the queue is empty\n");
    return;
  }
  int temp = qQueue->front;
  while (temp != qQueue->rear) {
    printf("%5d", qQueue->data[temp]);
    temp++;
  }
}