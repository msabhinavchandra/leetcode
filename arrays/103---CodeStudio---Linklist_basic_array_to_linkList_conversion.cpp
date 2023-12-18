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
