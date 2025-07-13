package Rev_2;

//optimal time O(n) to find the mid 
//time O(n) to reverse the linkedlist
// time O(n) to traverse the half half of the linkedlist
// space O(1) no extra space used.

import java.util.*;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class PalindromeLinkedList {
	public Node head = null;
	public Node tail = null;

	public void addNode(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	boolean isPalindrome(Node head) {
		Node firstRef = head;
		Node middle = findMiddle(head);
		Node secondRef = reverseLinkedlist(middle.next);

		while (firstRef != null && secondRef != null) {
			if (firstRef.data != secondRef.data) {
				return false;
			}
			firstRef = firstRef.next;
			secondRef = secondRef.next;
		}
		return true;
	}

	Node findMiddle(Node head) {
		Node slow = head;
		Node fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	Node reverseLinkedlist(Node head) {
		Node curr = head;
		Node prev = null;
		Node next;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PalindromeLinkedList list = new PalindromeLinkedList();
		int size = sc.nextInt();
		for (int i = 0; i < size; i++) {
			list.addNode(sc.nextInt());
		}
		System.out.println(list.isPalindrome(list.head));
	}
}
