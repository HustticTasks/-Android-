/*
 * @Author: victor
 * @Date: 2017-10-29 00:48:31
 * @Last Modified by: victor
 * @Last Modified time: 2017-10-29 09:31:04
 */
#include "Stack.h"

int initStack(Stack *pStack) {
  (*pStack) = (Stack)malloc(sizeof(struct STACK));
  (*pStack)->top = (Node)malloc(sizeof(sNode));
  if ((*pStack)->top == NULL)
    return FALSE;
  (*pStack)->bottom = (*pStack)->top;
  (*pStack)->top->next = NULL;
  (*pStack)->length = 0;
  return TRUE;
}

//进栈操作
int push(Stack pStack, DataType data) {
  Node newNode = (Node)malloc(sizeof(sNode));
  if (newNode == NULL)
    return FALSE;
  newNode->data = data;
  newNode->next = pStack->top;
  pStack->top = newNode;
  pStack->length++;
  return TRUE;
}

//判断栈是否为空
int stackEmpty(Stack pStack) {
  return pStack->bottom == pStack->top ? TRUE : FALSE;
}

//出栈操作
int pop(Stack pStack, DataType *data) {
  if (stackEmpty(pStack)) {
    printf("the Stack is empty, cannot pop!");
    return FALSE;
  }
  *data = pStack->top->data;
  Node temp = pStack->top;
  pStack->top = pStack->top->next;
  free(temp);
  pStack->length--;
  return TRUE;
}

//清空栈
void clear(Stack pStack) {
  Node temp;
  while (pStack->top != pStack->bottom) {
    temp = pStack->top;
    pStack->top = pStack->top->next;
    free(temp);
  }
  pStack->length = 0;
}

//打印栈中所有元素
void printAll(Stack pStack) {
  if (stackEmpty(pStack)) {
    printf("the stack is empty");
    return;
  }
  Node temp = pStack->top;
  while (temp != pStack->bottom) {
    printf("%c\t", temp->data);
    temp = temp->next;
  }
  printf("\n");
}

DataType getTop(Stack pStack) { return pStack->top->data; }
