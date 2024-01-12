// brute

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

#include <stack>
bool isPalindrome(Node *head) {
  stack<int> stk;
  Node *temp1 = head;
  Node *temp2 = head;

  while (temp1 != NULL) {
    stk.push(temp1->data);
    temp1 = temp1->next;
  }

  while (temp2 != NULL) {
    int t = stk.top();
    if (t == temp2->data) {
      stk.pop();
      temp2 = temp2->next;
      continue;
    } else {
      return false;
    }
  }

  return true;

  // write your code here
}

   
// optimal

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

Node* reverse(Node *head){
    Node *prev=NULL;
    Node *curr=head;
    Node *next;

    while(curr!=NULL){
        next=curr->next;
        curr->next=prev;

        prev=curr;
        curr=next;
    }

    return prev;

}

bool isPalindrome(Node *head)
{   
    Node* slow=head;
    Node* fast=head;

    while(fast->next!=NULL && fast->next->next!=NULL){
        fast=fast->next->next;
        slow=slow->next;
    }

    Node* newHead=reverse(slow->next);

    Node* first=head;
    Node* second=newHead;

    while(second!=NULL){
        if(first->data!=second->data){
            reverse(newHead);
            return false;
        }
        first=first->next;
        second=second->next;

    }

    reverse(newHead);
    return true;
    // write your code here


}

































