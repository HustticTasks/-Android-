#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>
struct Stack{
    int data;
    int length;
    struct Stack *stackpointer;
};
typedef struct Stack sStack;

struct Stackpointer{
 //   sStack *prev;
    sStack *current;
};
typedef struct Stackpointer CreateStack;

void Stackpush(int,CreateStack *);
int Stackpeek (CreateStack *);
int Stackpop(CreateStack *);
bool Stackempty(CreateStack *);
void StackPrint(CreateStack *);

//sStack *head=NULL,*prev;

int main(){

    CreateStack *s1;
  //  StackBuild(s1);
    s1=(CreateStack *)malloc(sizeof(CreateStack));
    s1->current=NULL;

    Stackpush(12,s1);
    StackPrint(s1);

    printf("\n%d\n%d\n",Stackpop(s1),Stackempty(s1));

    return 0;
}
//����ջ
/*void StackBuild (CreateStack *pointer){
    pointer=(CreateStack *) malloc(sizeof(CreateStack));
    pointer->current=NULL;
}*/

//Ԫ����ջ
void Stackpush(int pushNumber,CreateStack *pointer){
    sStack *temp;
    sStack *temp2;
 //   temp=(sStack *) malloc(sizeof(sStack));
    if (pointer->current==NULL){
      temp=(sStack *) malloc(sizeof(sStack));
      pointer->current=temp;
      (temp->data)=pushNumber;(temp->length)=1;(temp->stackpointer)=NULL;
    }
    else{
        temp2=pointer->current;
        temp=(sStack *) malloc(sizeof(sStack));
        pointer->current=temp;
        temp->data=pushNumber;temp->length++;
        temp->stackpointer=temp2;
    }
}

//�鿴ջ��Ԫ��
int Stackpeek(CreateStack *pointer){
    sStack *temp;
    temp=pointer->current;
    return temp->data;
}
//����ջ��Ԫ�أ������䵯��ջ
int Stackpop(CreateStack *pointer){
    int back;
    sStack *temp;
    temp=pointer->current;
    back=temp->data;
    (pointer->current)=(temp->stackpointer);
    free(temp);
    return back;
}


//�鿴ջ�Ƿ�Ϊ��ջ
bool Stackempty(CreateStack *pointer){
    sStack *temp;
    temp=pointer->current;
    if (temp->stackpointer==NULL) return true;
    else return false;
}

//��ӡջ
void StackPrint(CreateStack *pointer){
    sStack *i;
    if (Stackempty(pointer))
        printf("��ջ!\n");
    else{
        i=pointer->current;
        printf("��ջ��Ԫ����(��ջ����ջβ):\n");
        while(i!=NULL){
            printf("%-8d",i->data);
            i=(i->stackpointer);
        }
        printf("\n");
    }

}
