/*
 * @Author: victor 
 * @Date: 2017-10-29 00:17:39 
 * @Last Modified by: victor
 * @Last Modified time: 2017-10-29 00:48:15
 */
#ifndef QUEUE_H
#define QUEUE_H

#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0

#define DataType int

typedef struct QUEUE {
  DataType *data;    //队列元素
  int front; //队首指针
  int rear;  //队尾指针
  int maxSize;
} * Queue;

int initQueue(Queue *o,int);
int enQueue(Queue, DataType);
int deQueue(Queue, DataType *);
int queueEmpty(Queue);
int queueFull(Queue);
void clear(Queue);
void printAll(Queue);

#endif