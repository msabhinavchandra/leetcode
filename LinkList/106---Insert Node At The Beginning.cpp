/**
 * Definition of linked list
 * class Node {
 *
 * public:
 *     int data;
 *     Node* next;
 *     Node() : data(0), next(nullptr) {}
 *     Node(int x) : data(x), next(nullptr) {}
 *     Node(int x, Node* next) : data(x), next(next) {}
 * };
 */

Node* insertAtFirst(Node* list, int newValue) {

    Node *temp=new Node(newValue);

    Node *head=temp;

    temp->next=list;

    list=head;

    // delete head;

    //never delete the address of the head , because of it , the node initial node
    // which we have inserted will be vanished , because as you are deleting the 
    // head , you are deleting that address, means the whole node will be deleted in
    // the result.

    return list;

    // Write your code here
}
