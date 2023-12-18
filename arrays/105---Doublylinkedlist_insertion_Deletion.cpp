#include<iostream>
using namespace std;

//Insertion and deletion in Doubly linkedlist.

class Node{
    public:
    int data;
    Node*prev;
    Node*next;
    Node(){//default constructor
        data=0;
        prev=NULL;
        next=NULL;
    }
    Node(int val){
        data=val;
        prev=NULL;
        next=NULL;
    }
    Node(Node*&previous,Node*nextArg,int val){
        data=val;
        prev=previous;
        next=nextArg;
    }

};

void InsertAtHead(Node*&head, int val){//we have to have the power to change the head address
    Node*n=new Node(val);//so pass by it's reference.
    n->next=head;
    if(head!=NULL){
    head->prev=n;
    }
    head=n;
}

void InsertAtTail(Node*&head,int val){
    Node*n=new Node(val);
    Node*temp=head;

    //if head == NULL

    if(head==NULL){
        //head=n;
        InsertAtHead(head,val);
        return;
    }

    while(temp->next!=NULL){
        temp=temp->next;
    }

    temp->next=n;
    n->prev=temp;

}

void Display(Node*head){

    Node*temp=head;

    while(temp!=NULL){
        cout<<temp->data<<"->";
        temp=temp->next;
    }

    cout<<"NULL"<<endl;

}

void DeleteAtHead(Node*&head){
    Node*ToBeDeleted=head;
    head=head->next;
    head->prev=NULL;
    delete ToBeDeleted;
}
//for Deletion of an element at a specific position in 
//doubly linked-list. 
void Deletion(Node*&head, int pos){
    Node*temp=head;
    int count=1;

    while(count!=pos &&  temp!=NULL){
        temp=temp->next;
        count++;
    }

    if(pos==1){
        DeleteAtHead(head);
        return;
    }

    Node*ToBeDeleted=temp;
    temp->prev->next=temp->next;
    if(temp->next!=NULL){//because if the temp is pointing towards the last element
    temp->next->prev=temp->prev;//it can't access it's successive element
    }//because of which it can't properly delete stuff.
    //same applies for head, when the posto be deleted in at the head
    //we need to write a speacial condition.
    delete ToBeDeleted;

}

int main()
{
    Node*head=NULL;
    for(int i=1;i<=6;i++){
    InsertAtTail(head,i);
    //cout<<head;
    //Display(head);
    }
    Display(head);
    //InsertAtHead(head,0);
    Deletion(head,5);//in real 4 will be deleted.
    Display(head);
    return 0;
}
