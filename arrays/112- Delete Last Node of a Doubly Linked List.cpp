/**
 * Definition of doubly linked list:
 *
 * struct Node {
 *      int data;
 *      Node *prev;
 *      Node *next;
 *      Node() : data(0), prev(nullptr), next(nullptr) {}
 *      Node(int val) : data(val), prev(nullptr), next(nullptr) {}
 *      Node(int val, Node *p, Node *n) : data(val), prev(p), next(n) {}
 * };
 *
 *************************************************************************/

Node * deleteLastNode(Node *head) {
    Node*temp=head;
    if(temp->next==NULL){
        Node*tobedeleted=temp;
    delete tobedeleted;
        return NULL;
    }
    while(temp->next->next!=NULL){
        temp=temp->next;
    }
    Node*tobedeleted= temp->next;
        temp->next=NULL;
        tobedeleted->prev=NULL;
        delete tobedeleted;
        return head;
    // Write your code here
}
