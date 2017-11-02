/*
 * @Author: victor 
 * @Date: 2017-10-29 00:48:39 
 * @Last Modified by:   victor 
 * @Last Modified time: 2017-10-29 00:48:39 
 */

#include "Stack.h"

int main(){
    Stack pStack;
    initStack(&pStack);
    push(pStack,'a');
    push(pStack,'b');
    printAll(pStack);
    char x;
    pop(pStack,&x);
    printf("%c\n",x);
    printAll(pStack);
    clear(pStack);
    printAll(pStack);

    return 0;
}