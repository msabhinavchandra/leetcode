// optimal approach
//optimal using recursion.

// tc->O(n) for every node it is calling n times.
// sc->O(n) for resursive stack space.

import java.util.* ;
import java.io.*; 
// they are static because we are not creating any objects here
//we need to able to use the methods withour creating objects also
// that's why we kept both the methods as static.
// an only a static method can call another static method.

public class Solution {

	public static  int addHelper(Node temp){
		if(temp==null){
			return 1;
		}
		int carry=addHelper(temp.next);
		temp.data+=carry;
		if(temp.data<10){
			return 0;
		}
		temp.data=0;
		return 1;
	}
	public static Node addOne(Node head) {
		int carry;
		// Write your code here.
		Node temp=head;
		carry=addHelper(temp);
		if(carry==1){
			Node newNode=new Node(1);
			newNode.next=head;
			// head=newNode;
			return	newNode;
		}
		return head;
		
	}
}