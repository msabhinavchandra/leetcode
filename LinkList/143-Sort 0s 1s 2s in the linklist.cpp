//striver way.
//more optimized.

/*
TC->O(n) only for traversal, for just changing nodes no time is required.
SC->O(1) we are not using any extra space,explore this
why does he always say that?, cuz your using extra variables right?
*/

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

Node* sortList(Node *head){
    // Write your code here.
    if(head==NULL || head->next==NULL){
        return head;
    }
    Node* dummy0=new Node(-1);
    Node* temp0=dummy0;
    Node* dummy1=new Node(-1);
    Node* temp1=dummy1;
    Node* dummy2=new Node(-1);
    Node* temp2=dummy2;

    Node* temp=head;

    while(temp!=NULL){

        if(temp->data==0){
            temp0->next=temp;
            temp0=temp;
            // temp=temp->next;

        }
        else if(temp->data==1){
            temp1->next=temp;
            temp1=temp;
            // temp=temp->next;

            
        }
        else if(temp->data==2){
            temp2->next=temp;
            temp2=temp;
            // temp=temp->next;

        }

        temp=temp->next;

    }//end of while loop.

    temp0->next=(dummy1->next)? (dummy1->next):(dummy2->next);
    //do a visual dry run , everything will be alright
    temp1->next=(dummy2->next);
    temp2->next=NULL;
    //do a dry run
    Node* newhead=dummy0->next;
    delete dummy0;
    delete dummy1;
    delete dummy2;

    return newhead;
   
}










//brute
//tc->O(2n) for 2 traversals of the whole LL
//sc->O(1) no extra space is used.

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

Node* sortList(Node *head){
    // Write your code here.
    int count0=0;
    int count1=0;
    int count2=0;
    Node* temp=head;
    while(temp!=NULL){

        if(temp->data==0){
            count0++;
        }
        else if(temp->data==1){
                        count1++;

        }
        else if(temp->data==2){
                        count2++;

        }

        temp=temp->next;
    }

    temp=head;
    while(temp!=NULL){

        if (count0 != 0) {
                        temp->data=0;
                        count0--;
        }
        else if (count1 != 0) {
                        temp->data=1;
                        count1--;
        }
        else if (count2 != 0) {
                        temp->data=2;
                        count2--;
        }
        temp=temp->next;
    }

    return head;
}



//more optimal way is
/*using the same sort a linklist code
which we had done for the optimal approach of 
sorting a linkedlist.
using merge sort of linkedlists
where 
tc->O((n+n/2)logn)
n/2 to find the middle
n->for every element and node merge being called
logn->calls for the merge every time, recursion tree space.for every node.
sc->O(1)no extra space used for this.
*/

//code is same as the optimal way of sorting the linkedlist.
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

Node* FindMiddle(Node* head){
    Node* slow=head;
    Node* fast=head->next;
    while(fast!=NULL && fast->next!=NULL){
        slow=slow->next;
        fast=fast->next->next;
    }
    return slow;
}

Node* Sort2lists(Node* left,Node *right){
    Node* temp1=left;
    Node* temp2=right;
    Node* dummy=new Node(-1);
    Node* temp=dummy;
    while(temp1!=NULL && temp2!=NULL){
        if(temp1->data<=temp2->data){
            temp->next=temp1;
            temp=temp1;
            temp1=temp1->next;
        }
        else{
            temp->next=temp2;
            temp=temp2;
            temp2=temp2->next;
        }

    }
    if(temp1!=NULL){
        temp->next=temp1;
    }
    else{
        temp->next=temp2;
    }

    return dummy->next;

}

Node* MergeSort(Node* head){
    if(head==NULL || head->next==NULL){
        return head;
    }
    Node* left=head;
    Node* middle=FindMiddle(head);
    Node* right=middle->next;
    middle->next=NULL;
    left=MergeSort(left);
    right=MergeSort(right);
    return Sort2lists(left,right);

}

Node* sortList(Node *head){
    // Write your code here.

    return MergeSort(head);



}



//brute force
/*take it into an array
merge sort it
put it into a linklist
return the head
tc->O(n+nlogn+n)
sc->O(n) for the array,i will reuse the linklist so no extra n.
for more info refer sort a linklist 141 problem
*/