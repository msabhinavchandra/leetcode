//optimal approach
//time complexity->O((n+n/2)logn) ,n/2 because we are 
//finding the middle of the linklist which will take 
// n/2 tc
//later explore why it is logn? also
//recursion tree length->logn,length of the tree logn,recursion depth
//logarithmic of n
//and it is calling for every n,therefore the tc->nlogn
//space->O(1),no extra space used.
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

Node* middle(Node *head){
    Node* slow=head;
    Node* fast=head->next;//because we need the middle left element for the 
    //even number of nodes.
    while(fast!=NULL && fast->next!=NULL){
        slow=slow->next;
        fast=fast->next->next;
    }
    return slow;
}


//over here left indicates the tail
//but i need to give the head.
//left inidcates the left head 
Node* MergeSortLink(Node* left,Node* right){

    Node* temp1=left;
    Node* temp2=right;
    Node* dummy=new Node(-1);
    Node* temp=dummy;
    while(temp1!=NULL && temp2!=NULL){
        if(temp1->data<temp2->data){
            temp->next=temp1;
            temp=temp1;
            temp1=temp1->next;

        }
        else{
            temp->next=temp2;
            temp=temp2;
            temp2=temp2->next;
        }
        // temp=temp->next;
    }
    if(temp1!=NULL){
        temp->next=temp1;
        // temp=temp1;
    }
    else{
        temp->next=temp2;
        // temp=temp2;
    }

    return dummy->next;


}

Node* sortList(Node* head){
    // Write your code here.
    if(head==NULL || head->next==NULL){
        return head;
    }

    Node *left=head;
    Node *mid=middle(head);
    Node *right=mid->next;
    mid->next=NULL;
    left=sortList(left);
    right=sortList(right);
    // Node* lefthead=head;
    return MergeSortLink(left,right);
}




//brute force
//time complexity->O(n+nlogn+n) and space->O(n+n)
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



void Merge(vector<int> &arr,int low,int mid,int high){
    vector<int> temp;
    int left=low;
    int right=mid+1;

    while(left<=mid & right<=high){
        if(arr[left]<=arr[right]){
            temp.push_back(arr[left]);
            left++;
        }
        else{
            temp.push_back(arr[right]);
            right++;
        }
    }
    while(left<=mid){
        temp.push_back(arr[left]);
        left++;
    }
    while(right<=high){
        temp.push_back(arr[right]);
        right++;
    }
    for(int i=low;i<=high;i++){
        arr[i]=temp[i-low];
    }
}

void MergeSort(vector<int> &arr,int low,int high)
{
    if(low>=high){
        return;
    }
    int mid=(low+high)/2;
    MergeSort(arr, low, mid);
    MergeSort(arr, mid+1,  high);
    Merge(arr,low,mid,high);
    return;
}


Node* sortList(Node* head){
    // Write your code here.
    vector<int> arr;
    Node* temp=head;
    while(temp!=NULL){
        arr.push_back(temp->data);
        temp=temp->next;
    }
    MergeSort(arr, 0, arr.size()-1);

    temp=head;
    int i=0;
    while(temp!=NULL && i<arr.size()){
        temp->data=arr[i];
        temp=temp->next;
        i++;
    }
    return head;
    
}
