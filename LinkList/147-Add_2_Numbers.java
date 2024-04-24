// there is no brute force
//there is only optimal for this problem
//so ask interviewer more questions to pass more time.

//i found 1 brute , where i am getting stack overflow this is the case with recursion as reversing the 
//LinkedLists.

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

    static LinkedListNode reverseLinkedList(LinkedListNode head){
        if(head==null || head.next==null)
        {
            return head;
        }
        LinkedListNode newHead=reverseLinkedList(head.next);
        LinkedListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }

    static LinkedListNode Add2LinkedLists(LinkedListNode thead1,LinkedListNode thead2)
    {
        LinkedListNode temp1=thead1;
        LinkedListNode temp2=thead2;

        LinkedListNode newHead1=reverseLinkedList(temp1);
        LinkedListNode newHead2=reverseLinkedList(temp2);

        LinkedListNode dummy1=new LinkedListNode(-1);
        LinkedListNode traverseHead=null;
        int sum=0;
        int carry=0;

        while(newHead1!=null || newHead2!=null)
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

        return dummy1.next;

    }
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        // Write your code here.
        LinkedListNode t1=head1;
        LinkedListNode t2=head2;
        LinkedListNode temp=Add2LinkedLists(t1, t2);
        LinkedListNode result=reverseLinkedList(temp);
        return result;


    }
}