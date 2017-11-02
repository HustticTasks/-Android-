/*
 * @Author: victor 
 * @Date: 2017-10-29 00:26:11 
 * @Last Modified by: victor
 * @Last Modified time: 2017-10-29 00:48:21
 */
#include "Queue.h"

int main() {
    Queue qQueue;
    initQueue(&qQueue, 2);
    int x;
    enQueue(qQueue, 4);
    enQueue(qQueue, 5);
    deQueue(qQueue, &x);
    printf("%d\n", x);
    clear(qQueue);
    printAll(qQueue);
    return 0;
}