//optimal approach




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
