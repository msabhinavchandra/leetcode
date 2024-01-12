#include<iostream>
using namespace std;

class Node{
    public:
    int data;
    Node *next;

    Node(){
        data=0;
        next=NULL;
    }
    Node(int val){
        data=val;
        next=NULL;
    }
    Node(Node*&head,int val){
        data=val;
        next=head;
    }
};

void AddElementTail(Node* &head,int val){
    Node*temp=head;
    Node*n=new Node(val);
    if(head==NULL){
        head=n;
        return;
    }

    while (temp->next!=NULL)
    {
        temp=temp->next;
    }

    temp->next=n;
    
}

void Display(Node*head){

    Node*temp=head;

    while(temp!=NULL){
        cout<<temp->data<<"->";
        temp=temp->next;
    }

    cout<<"NULL"<<endl;

}

int LengthLinkList(Node*&head){
    Node*temp=head;
    int count=0;
    while(temp!=NULL){
        temp=temp->next;
        count++;
    }
    return count;
}

Node* AppendNoNodes(Node*&head,int n){


    n=n%LengthLinkList(head);

    if(n==0){
        return head;
    }

    Node*NewTail;
    Node*NewHead;
    Node*Tail;

    Node* temp=head;
    int counter=1;
    while(temp!=NULL){
        if(counter==LengthLinkList(head)-n){
            NewTail=temp;
        }

        if(counter==LengthLinkList(head)-n+1){
            NewHead=temp ;
        }
        if(temp->next==NULL){
            Tail=temp;
        }
        temp=temp->next;
        counter+=1;
    }

    NewTail->next=NULL;
    Tail->next=head;

    return NewHead;

}

int main()
{
        Node*head=NULL;
for(int i=1;i<=7;i++){
    AddElementTail(head,i);
}

    //cout<<LengthLinkList(head)<<endl;
    Node*N=AppendNoNodes(head,6);
    Display(N);
    return 0;
}
