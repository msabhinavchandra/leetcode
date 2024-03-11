//optimal:
//TC-> O(n/2) SC->O(1)
/****************************************************************
Following is the Linked list node structure already written

class Node
{
public:
    int data;
    Node* next;
    Node(int data)
    { 
        this->data = data;
        next = NULL;
    }
};
*****************************************************************/

Node* oddEvenList(Node* head)
{
	// Write your code here.
    if(head==NULL || head->next==NULL){
        return head;
    }
    Node* odd=head;
    Node* even=head->next;
    Node* inter=even;
    while(even!=NULL && even->next!=NULL){
        odd->next=odd->next->next;
        even->next=even->next->next;

        odd=odd->next;
        even=even->next;
    }
    odd->next=inter;
    return head;

}





//brute force:
//tc->O(2n) SC->O(n)
/****************************************************************
Following is the Linked list node structure already written

class Node
{
public:
    int data;
    Node* next;
    Node(int data)
    { 
        this->data = data;
        next = NULL;
    }
};
*****************************************************************/

Node* oddEvenList(Node* head)
{   vector<int> arr;
	// Write your code here.
    if(head==NULL ||head->next==NULL){
        return head;
    }
    Node*temp=head;
    //for odd
    while(temp!=NULL && temp->next!=NULL){
        arr.push_back(temp->data);
        temp=temp->next->next;
    }
    if(temp) arr.push_back(temp->data);
    //for even 
    temp=head->next;
    while(temp!=NULL && temp->next!=NULL){
        arr.push_back(temp->data);
        temp=temp->next->next;
    }
    if(temp) arr.push_back(temp->data);

    temp=head;
    for(int i=0;i<arr.size();i++){
        temp->data=arr[i];
        temp=temp->next;
    }
    return head;

    
}