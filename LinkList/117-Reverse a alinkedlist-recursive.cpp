//recursive approach:
// TC->O(n) cuz ur calling it n times,cuz ur traversing to every node.
//SC->O(n) the stack space it is storing is also n times 
//recursive stack space 

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

//Equivalent Java
'''
class Solution {
    public ListNode reverseList(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }
        ListNode newhead=reverseList(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newhead;


        
    }
}
'''
