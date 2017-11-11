#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

struct queuedata{
    int data;
    int length;
    struct queuedata *nextpointer;
};
typedef struct queuedata Dqueue;

struct CreateQueue{
    Dqueue *front;
    Dqueue *rear;
};
typedef struct CreateQueue Cqueue;

void putin(Cqueue *,int );
void getout(Cqueue *);
int getLength(Cqueue *);
int getQueueFront(Cqueue *);
bool isEmpty(Cqueue *);
void deleteQueue(Cqueue *);
void printQueue(Cqueue *);

int main(){
    Cqueue *p;
    p=(Cqueue *)malloc(sizeof(Cqueue));
    p->front=NULL;p->rear=NULL;
    putin(p,10);
    putin(p,20);
    printQueue(p);
    deleteQueue(p);
    return 0;
}

//从队尾添加元素
void putin(Cqueue *temp,int Num){

    if (temp->front==NULL){
        Dqueue *put;
        put=temp->front;
        put=(Dqueue *)malloc(sizeof(Dqueue));
        put->data=Num;put->length=1;put->nextpointer=NULL;
        temp->front=put;temp->rear=put;
    }
    else{
        Dqueue *put;
        put=(Dqueue *)malloc(sizeof(Dqueue));
        put->data=Num;put->length=((temp->rear)->length)+1;put->nextpointer=NULL;
        ((temp->rear)->nextpointer)=put;
        (temp->rear)=put;
    }
}

//元素从队首出去
void getout(Cqueue *temp){
    if (temp->rear->length==1){
        Dqueue *test;
        test=temp->front;
        free(test);
        temp->front=NULL;temp->rear=NULL;
    }
    else{
        Dqueue *get;
        get=temp->front;
        temp->front=get->nextpointer;
        free(get);
    }
}

//返回队列中元素个数
int getLength(Cqueue *temp){
    if (isEmpty(temp)) return 0;
    else return (temp->rear)->length;
}

//获取队首
int getQueueFront(Cqueue *temp){
    if (!isEmpty(temp))
       return temp->front->data;
    else return '\0';
}

//判断是否为空对列
bool isEmpty(Cqueue *temp){
    if (temp->front==NULL && temp->rear==NULL)
        return true;
    else return false;
}

//删除队列
void deleteQueue(Cqueue *temp){
    if (!isEmpty(temp)){
        int i;
        Dqueue *de;
        i=temp->rear->length;
        for (;i>=2;i--){
            de=temp->front;
            temp->front=de->nextpointer;
            free(de);
        }
        free(temp->rear);
        free(temp);
    }
}

//打印队列
void printQueue(Cqueue *temp){
    if (isEmpty(temp))
        printf("此队列无元素！\n");
    else{
        int i,t;
        Dqueue *point;
        i=(temp->rear)->length;
        point=temp->front;
        printf("此队列的元素有：\n");
        for(;i>=1;i--){
            t=point->data;
            printf("%-6d",t);
            if (i>1) point=(point->nextpointer);
        }
    }
}
