//my solution.
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

Node* removeKthNode(Node* head, int K)
{
    // Write your code here.
    int n=0;
    Node* temp=head;
    while(temp!=NULL){
        n+=1;
        temp=temp->next;
    }
    //delete at nth node
    n=n-K;
    Node* temp2=head;
     if(n==0){
        head=temp2->next;
        return head;
    }
    while(n>1){
        n-=1;
    temp2=temp2->next;
    }
    temp2->next=temp2->next->next;
    return head;
}
