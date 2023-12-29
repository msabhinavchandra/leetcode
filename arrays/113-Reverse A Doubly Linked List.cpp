/*
Following is the class structure of the Node class:

class Node
{
public:
    int data;
    Node *next,*prev;
    Node()
    {
        this->data = 0;
        next = NULL;
        prev= NULL;
    }
    Node(int data)
    {
        this->data = data; 
        this->next = NULL;
        this->prev= NULL;
    }
    Node(int data, Node* next, Node *prev)
    {
        this->data = data;
        this->next = next;
        this->prev= prev;
    }
};

*/

Node* reverseDLL(Node* head)
{   Node*temp=head;
    if(temp->next==NULL && temp->prev==NULL){
        //in the only case where you have only 1 node.
        return temp;
    }
    Node *Preced=new Node();
    while(temp!=NULL){
        Preced=temp->prev;
        temp->prev=temp->next;
        temp->next=Preced;
        temp=temp->prev;
        // Preced=temp->prev;
    }
    // Write your code here  
    return Preced->prev; 
}

