#include<iostream>
#include<vector>
using namespace std;

// int main()
// {   cout<<"hi bro";
//     return 0;
// }


 //Definition of linked list
  class Node {
 
  public:
     int data;
      Node* next;
      Node() : data(0), next(nullptr) {}//
    //default constructor with data=0 and next pointing to NULL.
      Node(int x) : data(x), next(nullptr) {}
 //parametric constructor, with data==argument given and next pointing to null

  Node(int x, Node* next) : data(x), next(next) {}
 //di parametric constructor, with data=value given, and next=the argument given.
  };
 
// #include<iostream>


//     class NewNode{
//         public:
//         int data;
//         NewNode *next;

//         NewNode(int val) {
//           data = val;
//           next = NULL;
//         }
//     }

// void insertAtTail(NewNode* &head, int val){

//     //
//     // int n=arr

//     NewNode Node1(val);
//     if(head=NULL){
//         NewNode Node1(val);
//        // Node1->data=val;
//         head=Node1
//     }

//     else{
//         while(head->next!=NULL){
//             head=head->next;
//         }
//         head->next=Node1;
//     }


// }

void display(Node*&head){
    Node *tt=head;//storing the initial head, actual head into a temp
while(tt!=NULL){
    
    cout<<tt->data<<"->";
    tt=tt->next;
}
//now the head is pointing to the NULL
//swipe back to the had to the original head value(tt in this case)
//to avoid problems when we use the display fucntion again the 
//head has to be pointing to the initial node only.

//instead we can not change the value of the head
//let's take the temp, and run through it without messing with the original 
//head pointer.
//head=tt;

}

Node* constructLL(vector<int>& arr) {

    //'n' be the size of the array 'arr'
    int n=arr.size();

    //this is also called as dynamic memory allocation
    //whose syntax goes like this.
    Node *head=new Node(arr[0]);//Node will be created with the value
    //arr[0], and next pointing to NULL,the address of that node created will be 
    //stored in the new head pointer created.
    //Node *head--->means it will create a head pointer which can only store the
    //addresses of the Node.
    //in the above case , a node is being created with the value of the initial
    //element of the arr, and it's address is given to the head pointer.
    // and head pointer is storing the address of the node(which is created
    // with the first element of the array.) 

    Node *temp=head;//we are storing this head which we created for this single node
    //into the temp pointer which stores the addresses of the Nodes.

    //we will start with int i =1 because i=0 node is already created and the pointer
    //(head pointer) has been already pointed to that first node.

    for(int i=1 ; i<n ;i++){
        // we are creating nodes for every element in the array
        //and storing them in the curNode pointer.

        Node *curNode=new Node(arr[i]);

        //after creation of that Node, we are attaching the temp->next(in the sense the
        //next of the existing single node to the new node created in the curNode.)
        temp->next=curNode;

        temp=temp->next;
        //now temp is pointing to the curNode, so that it will be ready to attach the 
        //the next node to the existing node,with the help of 
        //temp-next=nextNode. kinda of a thing.
    }

    return head;//this head will be the head
    //pointing to the initial pointer(the head,initial node of the
    //linkedlist ) 
    //we have given this to the temp
    //temp goes all its wat to make the changes into the former linkedlist
    //meanwhile not changing the value of the position of the original
    //head pointer which always points to the initial node of the linklist.
    
    //this display fucniton 

    // Write your code here
}

int main(){
    vector<int> arr={2,5,8,7};

    Node*t=constructLL(arr);

    display(t);
    return 0;
}

//other linklist basic operations.

//creating a linklist and adding an element to it at the end of the linklist.as well as displaying the elements in the linklist.

//features
//adding at head.
//add at tail.

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

//Adding an element at the head of the link-list

void AddElementHead(Node*&head,int val){
    Node*n=new Node(val);
    n->next=head;
    head=n;
}

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

//delete an element with the value of the element.

void DeleteElement(Node*&head,int val){
    Node*temp=head;

    //if you want to delete the first node of the linklist.
    if(head->data==val){
        Node*ToBeDeleted=head;//over here you need to change the head 
        head=head->next;//that's why we are taking head instead of temp
        delete ToBeDeleted;//as we took temp in the tradional code of deletion.
        return;
    }

    //if the given head == NULL
    //then there is nothing we can do.
    if(head==NULL){
        return;
    }

    //If there is only one node in the linked-list

    if(head->next==NULL){
        delete head;//we will delete that also.
    }

    while(temp->next->data!=val){//traditional code for deletion of linklist node.
        temp=temp->next;//with respect to the value given in the nodes.
    }
    Node*ToBeDeleted=temp->next;
    temp->next=temp->next->next;

    delete ToBeDeleted;
}

void Display(Node*head){

    Node*temp=head;

    while(temp!=NULL){
        cout<<temp->data<<"->";
        temp=temp->next;
    }

    cout<<"NULL"<<endl;

}

int main(){

    Node*head=NULL;
for(int i=1;i<6;i++){
    AddElementTail(head,i);
}
    Display(head);

    DeleteElement(head,5);
    AddElementHead(head,0);
    Display(head);
    return 0;
}



