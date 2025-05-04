import java.util.*;

class Node {
    int data;
    Node next;

    Node() {
        data = 0;
        next = null;
    }

    Node(int x) {
        data = x;
        next = null;
    }

    Node(int x, Node next) {
        data = x;
        this.next = next;
    }
}

class LinkedListOperations {

    public static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static Node constructLL(List<Integer> arr) {
        int n = arr.size();
        Node head = new Node(arr.get(0));
        Node temp = head;

        for (int i = 1; i < n; i++) {
            Node curNode = new Node(arr.get(i));
            temp.next = curNode;
            temp = temp.next;
        }

        return head;
    }

    public static Node addElementHead(Node head, int val) {
        Node n = new Node(val);
        n.next = head;
        head = n;
        return head;
    }

    public static Node addElementTail(Node head, int val) {
        Node n = new Node(val);
        
        if (head == null) {
            head = n;
            return head;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = n;
        return head;
    }

    public static Node deleteElement(Node head, int val) {
        if (head == null) {
            return null;
        }

        if (head.data == val) {
            Node toBeDeleted = head;
            head = head.next;
            toBeDeleted = null;
            return head;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != val) {
            temp = temp.next;
        }

        if (temp.next != null) {
            Node toBeDeleted = temp.next;
            temp.next = temp.next.next;
            toBeDeleted = null;
        }

        return head;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(2, 5, 8, 7);
        Node head = constructLL(arr);
        display(head);

        head = addElementTail(head, 1);
        head = addElementTail(head, 2);
        head = addElementTail(head, 3);
        head = addElementTail(head, 4);
        head = addElementTail(head, 5);
        display(head);

        head = deleteElement(head, 5);
        head = addElementHead(head, 0);
        display(head);
    }
}
