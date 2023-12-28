/****************************************************************

    Following is the class structure of the Node class:

    template <typename T>
    class Node
    {
    public:
        T data;
        Node<T> *next;
        Node()
        {
            this->data = 0;
            this->next = NULL;
        }
        Node(T data)
        {
            this->data = data;
            this->next = NULL;
        }
        Node(T data, T* next)
        {
            this->data = data;
            this->next = next;
        }
    };

*****************************************************************/

int searchInLinkedList(Node<int> *head, int k) {
    // Write your code here.
    Node<int> *temp=head;

   if (head == NULL)
    {
        return 0;
    }

    while(temp!=NULL){
        if(temp->data==k){
            return 1;
        }
        temp=temp->next;

    }
    return 0;
}

// with recursion

/*
    Time Complexity: O(N)
    Space Compexity: O(N)

    Where 'N' is the total nodes in Linked List.
*/

int searchInLinkedList(Node<int> *head, int k)
{

    // Check if we reach the end of the Linked List.
    if (head == NULL)
    {
        return 0;
    }

    // If value found so will end our search.
    if (head->data == k)
    {
        return 1;
    }

    // Recurring for the next node.
    return searchInLinkedList(head->next, k);
}
