
/*
You are given a binary tree with unique values for its nodes and two distinct nodes p and q. 
Your task is to find the Lowest Common Ancestor (LCA) of these two nodes.

The Lowest Common Ancestor is defined as the deepest node in the binary tree 
that has both p and q as descendants (where a node can be a descendant of itself).

Input Format:
-------------
Line-1: A list of integers (space-separated) representing the binary tree in level order traversal. 
Line-2: Two integers p and q, representing the values of the two nodes for which the LCA is to be determined.

NOTE: Use -1 for null nodes.

Output Format:
--------------
Line-1: Print the value of the Lowest Common Ancestor.

Sample Input-1:
---------------
3 5 1 6 2 0 8 -1 -1 7 4
5 1

Sample Output-1:
----------------
3

Sample Input-2:
---------------
3 5 1 6 2 0 8 -1 -1 7 4
5 4

Sample Output-2:
----------------
5
*/
import java.util.*;

class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class LCA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read tree nodes and target nodes
        String[] arr = sc.nextLine().split(" ");
        String[] persons = sc.nextLine().split(" ");

        List<Integer> values = new ArrayList<>();
        for (String s : arr) {
            values.add(Integer.parseInt(s));
        }

        int pVal = Integer.parseInt(persons[0]);
        int qVal = Integer.parseInt(persons[1]);

        // Build the binary tree from level order input
        Node root = buildTree(values);

        // Find and print the LCA
        Node lca = new Solution().lowestCommonAncestor(root, pVal, qVal);
        System.out.println(lca.data);
    }

    // Helper method to build tree from level order list
    private static Node buildTree(List<Integer> values) {
        if (values.isEmpty() || values.get(0) == -1)
            return null;
        Node root = new Node(values.get(0));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < values.size()) {
            Node current = queue.poll();
            if (i < values.size() && values.get(i) != -1) {
                current.left = new Node(values.get(i));
                queue.add(current.left);
            }
            i++;
            if (i < values.size() && values.get(i) != -1) {
                current.right = new Node(values.get(i));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
}

class Solution {
    // Finds the LCA of two nodes given their values
    Node lowestCommonAncestor(Node root, int p, int q) {
        if (root == null)
            return null;
        if (root.data == p || root.data == q)
            return root;
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left != null ? left : right;
    }
}
