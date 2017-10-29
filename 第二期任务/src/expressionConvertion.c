/*
 * @Author: victor 
 * @Date: 2017-10-29 00:46:59 
 * @Last Modified by: victor
 * @Last Modified time: 2017-10-29 16:16:46
 */

#include "Stack/Stack.h"

//获取优先级
int getCode(char ch) {
    switch (ch) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        default:
            return 0;
    }
}
//字符串倒置
char *reverse(char *str) {
    int i = 0;
    char *result = (char *) malloc(sizeof(char) * (strlen(str)+1));
    for (i = 0; i < strlen(str); i++) {
        result[i] = str[strlen(str) - i - 1];
    }
    result[i] = '\0';
    return result;
}

//中缀变后缀
char *infix2suffix(char *str) {
    char *result = (char *) malloc(sizeof(char) * (strlen(str) * 2));
    Stack pStack;
    initStack(&pStack);
    push(pStack, '@');
    int i = 0, j = 0;
    char ch, temp;
    while (i <= strlen(str) - 1) {
        ch = str[i];
        if (ch == '(') {
            push(pStack, ch);
            ++i;
        } else if (ch == ')') {
            while (getTop(pStack) != '(') {
                pop(pStack, &result[j++]);
                result[j++] = ' ';
            }
            pop(pStack, &temp);
            ++i;
        } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            char topChar = getTop(pStack);
            while (getCode(topChar) >= getCode(ch)) {
                result[j++] = topChar;
                result[j++] = ' ';
                pop(pStack, &temp);
                topChar = getTop(pStack);
            }
            push(pStack, ch);
            ++i;
        } else {
            //处理错误输入
            if (!((ch >= '0' && ch <= '9') || ch == '.')) {
                i++;
            }
            while ((ch >= '0' && ch <= '9') || ch == '.') {
                result[j++] = ch;
                ch = str[++i];
            }
            result[j++] = ' ';
        }
    }
    ch = getTop(pStack);
    pop(pStack, &temp);
    while (ch != '@') {
        result[j++] = ch;
        result[j++] = ' ';
        pop(pStack, &ch);
    }
    result[j++] = '\0';
    return result;
}


//中缀变前缀
char *infix2preffix(char *str) {
    char *result = (char *) malloc(sizeof(char) * (strlen(str) * 2));
    Stack pStack;
    initStack(&pStack);
    push(pStack, '@');
    int i = 0, j = 0;
    char ch, temp;
    str = reverse(str);
    while (i < strlen(str)) {
        ch = str[i];
        if (ch == ')') {
            push(pStack, ch);
            ++i;
        } else if (ch == '(') {
            while (getTop(pStack) != ')') {
                pop(pStack, &result[j++]);
                result[j++] = ' ';
            }
            pop(pStack, &temp);
            ++i;
        } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            char topChar = getTop(pStack);
            while (getCode(topChar) >= getCode(ch)) {
                result[j++] = topChar;
                result[j++] = ' ';
                pop(pStack, &temp);
                topChar = getTop(pStack);
            }
            push(pStack, ch);
            ++i;
        } else {
            //处理错误输入
            if (!((ch >= '0' && ch <= '9') || ch == '.')) {
                i++;
            }
            while ((ch >= '0' && ch <= '9') || ch == '.') {
                result[j++] = ch;
                ch = str[++i];
            }
            result[j++] = ' ';
        }
    }
    ch = getTop(pStack);
    pop(pStack, &temp);
    while (ch != '@') {
        result[j++] = ch;
        result[j++] = ' ';
        pop(pStack, &ch);
    }
    result[j++] = '\0';
    return reverse(result);
}

//计算后缀表达式的值,缺点是表达式的运算结果不能大于125(stack中数据域为char类型,最大存储容量为125),
// 改进方法为将Stack中数据类型变为int,这里c语言不支持泛型,就懒得改了,,
int calSuffix(const char *exp) {
    Stack stack;
    initStack(&stack);
    int i = 0;
    while (exp[i] != '\0') {
        if (exp[i] >= '0' && exp[i] <= '9') {
            char result = exp[i];
            //处理数字为两位数
            while (exp[i + 1] >= '0' && exp[i + 1] <= '9') {
                result = (char) ((result - '0') * 10 + exp[++i]);
            }
            push(stack, result);
        } else if (exp[i] == '-' || exp[i] == '+' || exp[i] == '*' || exp[i] == '/') {
            char m;
            pop(stack, &m);
            char n;
            pop(stack, &n);
            switch (exp[i]) {
                case '-':
                    push(stack, (char) (n - m + '0'));
                    break;
                case '+':
                    push(stack, (char) ((n - '0' + m - '0') + '0'));
                    break;
                case '*':
                    push(stack, (char) (((n - '0') * (m - '0')) + '0'));
                    break;
                case '/':
                    push(stack, (char) (((n - '0') / (m - '0')) + '0'));
                    break;
                default:
                    break;

            }
        }
        i++;
    }
    return getTop(stack) - '0';
}

int main() {
    char *str;
    str = (char *) malloc(sizeof(char) * 100);
    scanf("%s", str);
    char *  result = infix2preffix(str);
    printf("前缀: %s\n",result);
    result = infix2suffix(str);
    printf("后缀: %s\n", result);
    printf("结果: %d\n",calSuffix(result));
    return 0;
}