//queue implementation using the array
#include<iostream>
using namespace std;
#define N 4
int arr[N];//initializing string.
int front =-1;
int rear=-1;
void en(int x){
    if(rear==N-1){
        cout<<"Overflow"<<endl;
    }
    else if(front==-1 && rear==-1){//nothing is still present over here
        front=rear=0;//we are initializing the queue,we are starting the queue
        arr[rear]=x;//adding the first element to it.
    }
    else{//when it is not empty or overflow, we will just simply append.
        rear++;
        arr[rear]=x;
    }
}

void de(){
    if(front==-1 && rear==-1){//you can't delete any element if there is none there
        cout<<"Underflow"<<endl;
    }
    else if(front==rear){//front will be equal to rear in only ine case that is
    front=rear=-1;//when only 1 element is present in the queue,so we are removing 
                    //that element from here now.
    }
    else{//so that the first element is deleted in the queue.
        front++;//because this is a queueu first in first out.
    }
}

void display(){
    if(front==-1 && rear==-1){
        cout<<"Underflow"<<endl;//there is nothing to display,when there are no
    }   //element in the queue.
    else{
        for(int i=front;i<=rear;i++){//rear is the final index of the queue to 
            cout<<arr[i]<<", ";//we are printing from the starting to the 
        }   //ending.
    cout<<endl;
    }
}


int main()
{
    en(9);
    en(2);
    en(3);
    en(7);
    display();
    de();
    cout<<"After Dequeueing"<<endl;
    display();
    de();
    cout<<"After Dequeueing"<<endl;
    display();
    return 0;
}