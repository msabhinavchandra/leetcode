//brute
//save into an array
//merge sort it
//re arrange into a new linklist.
//time complexity->O(n+nlogn+n) and space complexity->O(n+n) for the array
// and a new linklist. 


//optimal
//time complexity->O(n1 +n2) space->O(1)
#include <bits/stdc++.h>

/************************************************************

    Following is the linked list node structure.
    
    template <typename T>
    class Node {
        public:
        T data;
        Node* next;

        Node(T data) {
            next = NULL;
            this->data = data;
        }

        ~Node() {
            if (next != NULL) {
                delete next;
            }
        }
    };

************************************************************/

Node<int>* sortTwoLists(Node<int>* first, Node<int>* second)
{
    // Write your code here.
    Node<int>* temp1=first;
    Node<int>* temp2=second;

    Node<int>* dummy=new Node<int>(-1);
    Node<int>* temp=dummy;
    while(temp1!=NULL && temp2!=NULL){

        if(temp1->data<=temp2->data){

            temp->next=temp1;
            temp=temp1;
            temp1=temp1->next;

        } else {
            temp->next = temp2;
            temp = temp2;
            temp2 = temp2->next;
        }
    }//end of while.
//because they are already sorted.
    if(temp1!=NULL){
        temp->next=temp1;
    }
    else{
        temp->next=temp2;
    }

    return dummy->next;
    
}
