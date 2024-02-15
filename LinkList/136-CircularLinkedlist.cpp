#include <iostream>
using namespace std;

class Node
{
public:
    int data;
    Node *next;

    Node(int val)
    {
        this->data = val;
        this->next = NULL;
    }
};

void InsertAtHead(Node *&head, int val)
{
    Node *newnode = new Node(val);

    if (head == NULL)
    {
        newnode->next = newnode;
        head = newnode;
        return;
    }

    Node *temp = head;

    while (temp->next != head)
    {
        temp = temp->next;
    }
    temp->next = newnode;
    newnode->next = head;
    head = newnode;
}

void InsertAtTail(Node *&head, int val)
{

    if (head == NULL)
    {
        InsertAtHead(head, val);
        return;
    }

    Node *newnode = new Node(val);
    Node *temp = head;

    while (temp->next != head)
    {
        temp = temp->next;
    }
    temp->next = newnode;
    newnode->next = head;
}

void deleteAthead(Node *&head)
{
    Node *temp = head;
    while (temp->next != head)
    {
        temp = temp->next;
    }
    Node *tobedeleted = temp->next;
    temp->next = head->next;
    head = head->next;
    delete tobedeleted;
}

void deletion(Node *&head, int pos)
{

    if (pos == 1)
    {
        deleteAthead(head);
        return;
    }

    Node *temp = head;
    int count = 1;

    while (count != pos - 1)
    {                      // this fails at deleting at the position 1 because
        temp = temp->next; // i need to traverse till position(preceding) before
        count++;           // deleting that respective position,due to which,the preceding
        // element for the position 1 does not exist so i need a
        // separate condition for position 1
    }

    Node *tobedeleted = temp->next;
    temp->next = temp->next->next;
    delete tobedeleted;
}

void Display(Node *head)
{
    Node *temp = head;
    while (temp->next != head)
    {
        cout << temp->data << "->";
        temp = temp->next;
    }
    cout << temp->data << " ";
    cout << endl;
}

int main()
{
    Node *head = NULL;
    InsertAtTail(head, 1);
    InsertAtTail(head, 2);
    InsertAtTail(head, 3);
    InsertAtTail(head, 4);
    InsertAtHead(head, 0);
    Display(head);
    deletion(head,1);
    cout<<"After deletion at 1st position"<<endl;
    Display(head);
    cout<<"After deletion at last position"<<endl;
    
    deletion(head,4);
    Display(head);
    cout<<"After deletion at 2nd  position"<<endl;
    deletion(head,2);
    Display(head);

    return 0;
}