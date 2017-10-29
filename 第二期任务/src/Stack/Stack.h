/*
 * @Author: victor 
 * @Date: 2017-10-29 00:48:36 
 * @Last Modified by: victor
 * @Last Modified time: 2017-10-29 09:31:22
 */
#ifndef STACK_H
#define STACK_H

#include <stdio.h>
#include <stdlib.h>

#define TRUE 1
#define FALSE 0

#define DataType char
// 节点域
typedef struct NODE {
  DataType data;     //数据域
  struct NODE *next; //指针域
} * Node, sNode;

typedef struct STACK {
  Node top;    //栈顶指针
  Node bottom; //栈底指针
  int length;  //栈的长度
} * Stack;

int initStack(Stack *);
int push(Stack, DataType);
int pop(Stack, DataType *);
int stackEmpty(Stack);
void clear(Stack);
void printAll(Stack);
DataType getTop(Stack);

#endif