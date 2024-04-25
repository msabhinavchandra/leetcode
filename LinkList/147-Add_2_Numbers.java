//there is no brute 
//the way, the reason this works the way it does because 
//when we are normally adding any 2 numbers
// we will start by adding the least significant digits and then move to the 
//msb's when then we go on taking the carry on carry and by carry
//so when we are addign these 2 linkedlists we are getting started by adding from the lsb's 
//and then go on moving on till the msb's and then carry
//so that is the reason for this question the way,this way of approach works for this question
//that is normally adding from the lsb's to the msb's and then carry.

// Time Complexity: O(max(m,n)). Assume that m and n represent the length of l1 and l2 respectively,
//  the algorithm above iterates at most max(m,n) times.

// Space Complexity: O(max(m,n)). The length of the new list is at most max(m,n)+1.

import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

    class LinkedListNode {
        int data;
        LinkedListNode next;
        
        public LinkedListNode(int data) {
            this.data = data;
        }
    }

*****************************************************************/


public class Solution {

    // static LinkedListNode reverseLinkedList(LinkedListNode head){
    //     if(head==null || head.next==null)
    //     {
    //         return head;
    //     }
    //     LinkedListNode newHead=reverseLinkedList(head.next);
    //     LinkedListNode front=head.next;
    //     front.next=head;
    //     head.next=null;
    //     return newHead;
    // }

    static LinkedListNode Add2LinkedLists(LinkedListNode thead1,LinkedListNode thead2)
    {
        LinkedListNode temp1=thead1;
        LinkedListNode temp2=thead2;

        LinkedListNode newHead1=temp1;
        LinkedListNode newHead2=temp2;

        LinkedListNode dummy1=new LinkedListNode(-1);
        LinkedListNode traverseHead=null;
        int sum=0;
        int carry=0;

        while(newHead1!=null && newHead2!=null)
        {
            sum=newHead1.data+newHead2.data+carry;
            int newNodeData=sum%10;
            carry=sum/10;
            sum=0;
            LinkedListNode newNode=new LinkedListNode(newNodeData);
            if(dummy1.next==null)
            {
                dummy1.next=newNode;
                traverseHead=newNode;
            }else{
                traverseHead.next=newNode;
                traverseHead=newNode;
            }

            newHead1=newHead1.next;
            newHead2=newHead2.next;

        }

        while(newHead1!=null)
        {
            sum=newHead1.data+carry;
            int newNodeData=sum%10;
            carry=sum/10;
            sum=0;
            LinkedListNode newNode=new LinkedListNode(newNodeData);
            if(dummy1.next==null)
            {
                dummy1.next=newNode;
                traverseHead=newNode;
            }else{
                traverseHead.next=newNode;
                traverseHead=newNode;
            }

            newHead1=newHead1.next;

        }

         while(newHead2!=null)
        {
            sum=newHead2.data+carry;
            int newNodeData=sum%10;
            carry=sum/10;
            sum=0;
            LinkedListNode newNode=new LinkedListNode(newNodeData);
            if(dummy1.next==null)
            {
                dummy1.next=newNode;
                traverseHead=newNode;
            }else{
                traverseHead.next=newNode;
                traverseHead=newNode;
            }

            newHead2=newHead2.next;

        }

        if(carry==1){
            LinkedListNode newNode=new LinkedListNode(carry);
            traverseHead.next=newNode;
        }

        return dummy1.next;

    }
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        // Write your code here.
        LinkedListNode t1=head1;
        LinkedListNode t2=head2;
        LinkedListNode temp=Add2LinkedLists(t1, t2);
        // LinkedListNode result=reverseLinkedList(temp);
        return temp;
    }
}