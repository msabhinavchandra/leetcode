// my approach
/*
Following is the class structure of the Node class:

class Node
{
public:
    int data;
    Node *next;
    Node()
    {
        this->data = 0;
        next = NULL;
    }
    Node(int data)
    {
        this->data = data; 
        this->next = NULL;
    }
    Node(int data, Node* next)
    {
        this->data = data;
        this->next = next;
    }
};
*/

Node* deleteMiddle(Node* head){
    // Write your code here.
    int n=0;
    Node* temp=head;
    while(temp!=NULL){
        n+=1;
        temp=temp->next;
    }
    Node* temp2=head;

    if(n%2==0){
        n=(n/2)+1;
    }
    else if(n==1){
        temp2->data=-1;
        return head;
    }
    else{
        n=(n+1)/2;
    }
    // Node* temp2=head;

    while(n>2){
        n-=1;
        temp2=temp2->next;
    }
    temp2->next=temp2->next->next;
return head;
}
