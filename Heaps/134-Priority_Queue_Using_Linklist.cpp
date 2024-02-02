#include <iostream>
using namespace std;

class Node
{
public:
    int data;
    int priority;
    Node *next = NULL;
    Node(int data, int priority)
    {
        this->data = data;
        this->priority = priority;
        this->next = NULL;
    }
};

class Queue
{
    Node *front;

public:
    // constructor for the priority queue.
    Queue(int data, int priority)
    { // constructor with parameters
        Node *newnode = new Node(data, priority);
        // a new node is created and that will be added to the queue
        // will be the first element of the queue.
        front = newnode;
    }
    Queue()
    { // constructor without parameters
        front = NULL;
    }
    // a method for this prioirity queue to append(push) another element into the queue
    void insert(int data, int priority)
    {
        // before inserting a Node into the priority queue, u need to create one.
        Node *newnode = new Node(data, priority);
        if (front == NULL || priority < front->priority)
        {
            // if the front is NULL(means the queue is empty)
            // if the priority(means lesser the number of the priority)
            // higher it should be.in the queue.
            newnode->next = front; // even if front is NULL, it will take care.
            front = newnode;
            return;
        }
        // if the priority is not higher(lesser in value) then it comes down.

        // now the point is you the queue is non-empty and it's higher in value then
        // we need to add it before that element whoose priority is greater than the
        // Node(which is needed to be added)
        Node *temp = front;
        // so we need a temporary head which tranverses till we get a node whose priority or
        // greater than the curr(the node which we want to add) , so that we can add this
        // previous of that node.till we reach the last node.
        // if the node is reached to the end and we didn't find any node, whose priority is
        // greater than ours,means this is the greatest,so
        // we will add this at the end of the queue,otherwise we will keep this
        // in before the greather priority one(value vise speaking).
        while (temp->next != NULL && temp->next->priority <= priority)
        {
            temp = temp->next;
        }
        newnode->next = temp->next;
        temp->next = newnode;
    }
    // a method to delete stuff
    void del()
    {
        if (front == NULL)
        { // dude i mean honestly,should i write this?
            // if the front is NULL,then obviously it we can delete any element
            // cuz the queue is empty
            cout << "Queue Underflow" << endl;
            return;
        }
        // if not
        Node *temp = front;
        front = front->next;
        delete temp;
    }

    void Display()
    {
        if (front == NULL)
        {
            cout << "Queue is empty" << endl;
            return;
        }
        Node *temp = front;
        cout << "The Queue is:" << endl;
        cout << "Priority , Item\n";
        while (temp != NULL)
        { // we are going it till the end(in the end,it doesn't even matter)
            cout << temp->priority << " , " << temp->data << endl;
            temp = temp->next;
        }
    }
};

int main()
{       //data  , then priority.
    Queue q1(10,1);
    q1.Display();
    q1.insert(15, 5);
    q1.insert(20, 2);
    q1.insert(30, 4);
    q1.Display();
    q1.insert(30, 3);
    q1.Display();
    q1.del();
    q1.Display();
    q1.del();
    q1.Display();
    return 0;
}