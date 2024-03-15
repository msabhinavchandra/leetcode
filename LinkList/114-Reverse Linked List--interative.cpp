//recursive approach:
// TC->O(n) cuz ur calling it n times,cuz ur traversing to every node.
//SC->O(n) the stack space it is storing is also n times 
//recursive stack space 

/****************************************************************

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
        

*****************************************************************/

Node* reverseLinkedList(Node *head)
{
    // Write your code here
    if(head==NULL || head->next==NULL){
        return head;
    }
    Node* newhead=reverseLinkedList(head->next);
    Node* front=head->next;
    front->next=head;
    head->next=NULL;
    return newhead;

}




#include <bits/stdc++.h>

/****************************************************************

    Following is the class structure of the LinkedListNode class:

    template <typename T>
    class LinkedListNode
    {
    public:
        T data;
        LinkedListNode<T> *next;
        LinkedListNode(T data)
        {
            this->data = data;
            this->next = NULL;
        }
    };

*****************************************************************/

LinkedListNode<int> *reverseLinkedList(LinkedListNode<int> *head) 
{

    LinkedListNode<int> *curr=head;
    LinkedListNode<int> *prev=NULL;
        LinkedListNode<int> *next;


    while(curr!=NULL){
        next=curr->next;
        curr->next=prev;

        prev=curr;
        curr=next;
    }

    return prev;

    // Write your code here
}
