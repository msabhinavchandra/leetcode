// brute force striver
// tc->O(3n)
//cuz i am reversing, traversing, and again reversing.
//sc->O(1) i am adding 1 to that given linkedList.

 Node* reverseLinkedList(Node *head)
{
    // Write your code here
    if (head == NULL || head->next == NULL) {
      return head;
    }
    Node *newhead = reverseLinkedList(head->next);
    Node *front = head->next;
    front->next = head;
    head->next = NULL;
    return newhead;
 }

Node *addOne(Node *head)
{
    Node* temp=head;
    // Node* rest=temp;
    // Node* prev;
    temp=reverseLinkedList(temp);
    Node* rest=temp;

    int carry=1;
    while(temp!=NULL)
    {
        temp->data=temp->data+carry;
        if(temp->data<10){
            carry=0;
            break;
        }
        else{
            temp->data=0;
            carry=1;
        }
        // prev=temp;
        temp=temp->next;
    }
    if(carry==1){
        Node* newNode=new Node(1);
            //  newNode->next=rest;

        temp=reverseLinkedList(rest);
        newNode->next=temp;
        return newNode;
    }
    
    temp=reverseLinkedList(temp);
    return temp;   
}

//optimal using recursion.

// tc->O(n) for every node it is calling n times.
// sc->O(n) for resursive stack space.

