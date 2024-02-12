#include<iostream>
using namespace std;

class Node{
    public:
    int data;
    Node* next=NULL;
    Node(int data){
        this->data=data;
        this->next=NULL;
    }
};

class Queue{
    Node *front;
    Node *rear;
    public:
    Queue(int data){
        Node* newnode=new Node(data);
        front=newnode;
        rear=newnode;
    }
    Queue(){
        front=NULL;
        rear=NULL;
    }

    void enQueue(int data){
        Node* newnode=new Node(data);
        rear->next=newnode;
        rear=newnode;
    }
    void deQueue(){
        Node *temp=front;
        front=front->next;
        delete temp;
    }
    void Display(){
        if(front==NULL){
            cout<<"The Queue is Empty"<<endl;
            return;
        }
        Node* temp=front;
        while(temp!=rear){
            cout<<temp->data<<"->";
            temp=temp->next;
        }
        cout<<temp->data<<endl;
        return;
    }
};

int main()
{   //initialzing a queue of Q1
    Queue Q1(10);
    Q1.enQueue(9);
    Q1.enQueue(8);
    Q1.enQueue(7);
    Q1.Display();
    Q1.deQueue();
    cout<<"After dequeueing1"<<endl;
    Q1.Display();
    cout<<"After dequeueing2"<<endl;
    Q1.deQueue();
    Q1.Display();
    Q1.deQueue();

    cout<<"After dequeueing3"<<endl;
    Q1.Display();
    cout<<"After adding"<<endl;
    Q1.enQueue(9);
    Q1.Display();

    return 0;
}