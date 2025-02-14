//brute force tc->O(n) and sc->O(n)
//using 2 arrayLists and reversing them.

import java.util.*;

class Node{    
	int data;    
	Node next;    
		
	public Node(int data) {    
		this.data = data;    
		this.next = null;    
	}    
}    

class Solution
{
	//Write if any supporting methods here
	
    //O(n)->tc and sc->O(n)
	boolean isPalindrome(Node head) 
	{
		//Write your code here and return boolean value
		Node firstRef=head;
		List<Integer> initial=new ArrayList<>();//O(n)
		List<Integer> modified=new ArrayList<>();//O(n)
		while(firstRef!=null){//O(n)
		    initial.add(firstRef.data);
		    modified.add(firstRef.data);
		    firstRef=firstRef.next;
		}
		Collections.reverse(modified);//O(n)
		for(int i=0;i<initial.size();i++){
		    if(initial.get(i)!=modified.get(i)){
		        return false;
		    }
		}
		return true;
		
		
	}    
	
	Node findMiddle(Node head){
	    Node slow=head;
	    Node fast=head;
	    while(fast.next!=null && fast.next.next!=null){
	        slow=slow.next;
	        fast=fast.next.next;
	    }
	    return slow;
	}
	
	Node reverseLinkedlist(Node head){
	    
	    Node curr=head;
	    Node prev=null;
	    Node next;
	    
	    while(curr!=null){
	        next=curr.next;
	        curr.next=prev;
	        prev=curr;
	        curr=next;
	    }
	    return prev;
	    
	}
	
}

public class PalindromeList 
{    
	public Node head = null;    
	public Node tail = null;    

	public void addNode(int data) 
	{    
		Node newNode = new Node(data);    
		if(head == null) 
		{    
			head = newNode;    
			tail = newNode;    
		}    
		else 
		{    
			tail.next = newNode;    
			tail = newNode;    
		}    
	}    
        
	public static void main(String[] args) 
	{    
		Scanner sc=new Scanner(System.in);
		PalindromeList list = new PalindromeList();       
		String list2[]=sc.nextLine().split(" "); 
		for(int i=0;i<list2.length;i++)
			list.addNode(Integer.parseInt(list2[i]));
		Solution sl=new Solution();
		System.out.println(sl.isPalindrome(list.head));
	}    
}    

//Using StringBuilder and a String
//Time complexity O(n) and Space complexity O(n) same as above 
// i just using a stringBuilder and a string instead.

import java.util.*;

class Node{    
	int data;    
	Node next;    
		
	public Node(int data) {    
		this.data = data;    
		this.next = null;    
	}    
}    

class Solution
{
	//Write if any supporting methods here
	
    //O(n)->tc and sc->O(n) 
	boolean isPalindrome(Node head) 
	{
		//Write your code here and return boolean value
		Node firstRef=head;

		StringBuilder sb=new StringBuilder();
		while(firstRef!=null){//tc-> O(n)
		    sb.append(firstRef.data);

		    firstRef=firstRef.next;
		}
		String s1=sb.toString();//sc->O(n)
		String s2=sb.reverse().toString();//sc->O(n)
		for(int i=0;i<sb.length();i++){//tc->O(n)
		    if(s1.charAt(i)!=s2.charAt(i)){
		        return false;
		    }
		}
		return true;
		
		
	}    
	
	Node findMiddle(Node head){
	    Node slow=head;
	    Node fast=head;
	    while(fast.next!=null && fast.next.next!=null){
	        slow=slow.next;
	        fast=fast.next.next;
	    }
	    return slow;
	}
	
	Node reverseLinkedlist(Node head){
	    
	    Node curr=head;
	    Node prev=null;
	    Node next;
	    
	    while(curr!=null){
	        next=curr.next;
	        curr.next=prev;
	        prev=curr;
	        curr=next;
	    }
	    return prev;
	    
	}
	
}

public class PalindromeList 
{    
	public Node head = null;    
	public Node tail = null;    

	public void addNode(int data) 
	{    
		Node newNode = new Node(data);    
		if(head == null) 
		{    
			head = newNode;    
			tail = newNode;    
		}    
		else 
		{    
			tail.next = newNode;    
			tail = newNode;    
		}    
	}    
        
	public static void main(String[] args) 
	{    
		Scanner sc=new Scanner(System.in);
		PalindromeList list = new PalindromeList();       
		String list2[]=sc.nextLine().split(" "); 
		for(int i=0;i<list2.length;i++)
			list.addNode(Integer.parseInt(list2[i]));
		Solution sl=new Solution();
		System.out.println(sl.isPalindrome(list.head));
	}    
}    

//using stack

import java.util.*;

class Node{    
	int data;    
	Node next;    
		
	public Node(int data) {    
		this.data = data;    
		this.next = null;    
	}    
}    

class Solution
{
	//Write if any supporting methods here
	
    //O(n)->tc and sc->O(n)
	boolean isPalindrome(Node head) 
	{
		//Write your code here and return boolean value
		Node firstRef=head;
        Stack<Integer> stk=new Stack<>();// space O(n)
		while(firstRef!=null){//time O(n)
		    stk.push(firstRef.data);
            
		    firstRef=firstRef.next;
		}
		
		firstRef=head;
		
		while(firstRef!=null){ //time O(n)
		    int i=stk.pop();
		    if(i!=firstRef.data){
		        return false;
		    }
		    firstRef=firstRef.next;
		}
		
		return true;

	}    
	
}

public class PalindromeList 
{    
	public Node head = null;    
	public Node tail = null;    

	public void addNode(int data) 
	{    
		Node newNode = new Node(data);    
		if(head == null) 
		{    
			head = newNode;    
			tail = newNode;    
		}    
		else 
		{    
			tail.next = newNode;    
			tail = newNode;    
		}    
	}    
        
	public static void main(String[] args) 
	{    
		Scanner sc=new Scanner(System.in);
		PalindromeList list = new PalindromeList();       
		String list2[]=sc.nextLine().split(" "); 
		for(int i=0;i<list2.length;i++)
			list.addNode(Integer.parseInt(list2[i]));
		Solution sl=new Solution();
		System.out.println(sl.isPalindrome(list.head));
	}    
}    

//optimal time O(n) to find the mid 
//time O(n) to reverse the linkedlist
// time O(n) to traverse the half half of the linkedlist
// space O(1) no extra space used.

import java.util.*;

class Node{    
	int data;    
	Node next;    
		
	public Node(int data) {    
		this.data = data;    
		this.next = null;    
	}    
}    

class Solution
{
	//Write if any supporting methods here
	
    
	boolean isPalindrome(Node head) 
	{
		//Write your code here and return boolean value
		Node firstRef=head;
		Node middle=findMiddle(head);
		Node secondRef=reverseLinkedlist(middle.next);
		
		while(firstRef!=null&&secondRef!=null){
		    if(firstRef.data!=secondRef.data){
		        return false;
		    }firstRef=firstRef.next;
		    secondRef=secondRef.next;
		}
		return true;
		
	}    
	
	Node findMiddle(Node head){
	    Node slow=head;
	    Node fast=head;
	    while(fast.next!=null && fast.next.next!=null){
	        slow=slow.next;
	        fast=fast.next.next;
	    }
	    return slow;
	}
	
	Node reverseLinkedlist(Node head){
	    
	    Node curr=head;
	    Node prev=null;
	    Node next;
	    
	    while(curr!=null){
	        next=curr.next;
	        curr.next=prev;
	        prev=curr;
	        curr=next;
	    }
	    return prev;
	    
	}
	
}

public class PalindromeList 
{    
	public Node head = null;    
	public Node tail = null;    

	public void addNode(int data) 
	{    
		Node newNode = new Node(data);    
		if(head == null) 
		{    
			head = newNode;    
			tail = newNode;    
		}    
		else 
		{    
			tail.next = newNode;    
			tail = newNode;    
		}    
	}    
        
	public static void main(String[] args) 
	{    
		Scanner sc=new Scanner(System.in);
		PalindromeList list = new PalindromeList();       
		String list2[]=sc.nextLine().split(" "); 
		for(int i=0;i<list2.length;i++)
			list.addNode(Integer.parseInt(list2[i]));
		Solution sl=new Solution();
		System.out.println(sl.isPalindrome(list.head));
	}    
}    