#include <iostream>
#define N 5
using namespace std;
int arr[5];   // declared them globally
int top = -1; // the last element in the stack
void push(int x)
{
    if (top == N - 1)
    {                                    // normally the size is N, indexing starts from 0.N-1 indicates the
        cout << "Stack is Full" << endl; // last element, you can't add anything more to it
        return;
    }
    top++;
    arr[top] = x;
}

void pop()
{
    if (top == -1)
    { // then there is nothing to pop from cuz the stack itself if empty.
        cout << "Stack is empty" << endl;
        return;
    }
    top--;
}

int peek()
{
    return arr[top];
}

bool isempty()
{
    if (top == -1)
    {
        return true;
    }
    return false;
}

void display()
{
    int i = top;
    while (i >= 0)
    {
        cout << arr[i] << ", ";
        i--;
    }
    return;
}

int main()
{   push(0);
    push(1);
    push(2);
    push(3);
    display();
    pop();
    display();
    pop();
    display();
    cout<<peek()<<endl;
    return 0;
}
//when i change the top value it will change it globally so need not worry about it
