// Reverse a linkedList brute force

// Time Complexity: O(2N) This is because we traverse the linked list twice: once to push the values onto 
// the stack, and once to pop the values and update the linked list. Both traversals take O(N) time, 
// hence time complexity  O(2N) ~ O(N).

// Space Complexity: O(N) We use a stack to store the values of the linked list, and in the worst case, the 
// stack will have all N values,  ie. storing the complete linked list. 

#include <stack>
#include <bits/stdc++.h>
Node* reverseLinkedList(Node *head)
{
    // Write your code here
    Node* temp=head;
    stack<int> stk;

    while(temp!=NULL){
        stk.push(temp->data);
        temp=temp->next;
    }
    temp=head;
    while(temp!=NULL)
    {
        temp->data=stk.top();
        stk.pop();
        temp=temp->next;

    }

    return head;

}


// optimal iterative
// 
//Time Complexity: O(N) The code traverses the entire linked list once, where 'n' is the number of nodes 
// in the list. This traversal has a linear time complexity, O(n).

// Space Complexity: O(1) The code uses only a constant amount of additional space, regardless of the linked
// list's length. This is achieved by using three pointers (prev, temp and front) to reverse the list without
// any significant extra memory usage, resulting in constant space complexity, O(1).


#include <bits/stdc++.h>



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

//Equivalent Java 
'''
class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode curr=head;
        ListNode prev=null;
        ListNode next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;

            prev=curr;
            curr=next;
        }

        return prev;

    }
}
'''
