/*
Imagine you're the chief curator at a renowned museum that houses a rare collection 
of ancient artifacts. These artifacts are arranged in a special display that 
follows a strict rule: any artifact positioned to the left of another has a lower 
value, and any artifact on the right has a higher value. 

Your task is to transform this display into what is known as a "Greater Artifact 
Display." In this new arrangement, each artifact’s new value will be its original 
value plus the sum of the values of all artifacts that are more valuable than it.

Sample Input-1:
---------------
4 2 6 1 3 5 7

Sample Output-1:
----------------
22 27 13 28 25 18 7

Explanation:
-------------
Input structure 
       4
      / \
     2   6
    / \ / \
   1  3 5  7

Output structure:
        22
      /   \
     27   13
    / \   / \
   28 25 18  7

Reverse updates:
- Artifact 7: 7
- Artifact 6: 6 + 7 = 13
- Artifact 5: 5 + 13 = 18
- Artifact 4: 4 + 18 = 22
- Artifact 3: 3 + 22 = 25
- Artifact 2: 2 + 25 = 27
- Artifact 1: 1 + 27 = 28
 */

import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Solution {

    static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Node root = build(arr);
        Sum(root);
        bfs(root);
    }

    public static Node build(int[] arr) {
        Node root = null;
        for (int val : arr) {
            if(val == -1) continue;
            root = insert(root, val);
        }
        return root;
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void Sum(Node root) {
        if (root == null) {
            return;
        }
        Sum(root.right);
        root.val += sum;
        sum = root.val;
        Sum(root.left);
    }

    public static void bfs(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
            System.out.print(temp.val+" ");
        }
    }
}

// mine
import java.util.*;

class Node {
    int val;
    Node left, right;

    public Node(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class Solution {
    static int totalSum = 0; // To store running total for reverse in-order traversal

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Node root = null;
        for (int val : arr) {
            root = insert(root, val);
        }

        convertToGreaterTree(root);

        inorder(root);  // To print result in sorted order
    }

    // Function to insert a node in BST
    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    // Function to convert BST to Greater Tree using reverse in-order traversal
    public static void convertToGreaterTree(Node root) {
        if (root == null) return;

        convertToGreaterTree(root.right);

        // Update current node
        root.val += totalSum;
        totalSum = root.val;

        convertToGreaterTree(root.left);
    }

    // Function to print the tree in inorder traversal
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}
