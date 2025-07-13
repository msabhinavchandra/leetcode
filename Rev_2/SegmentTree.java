package Rev_2;

import java.util.*;

public class SegmentTree {
    // Node of Segment Tree
    static class Node { 
        int start, end;
        int sum;
        Node left, right;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    } 

    Node root;

    // Constructor: build the tree from array
    public SegmentTree(int[] arr) {
        root = buildTree(arr, 0, arr.length - 1);
    }

    // Recursively build segment tree
    private Node buildTree(int[] arr, int start, int end) {
        Node node = new Node(start, end);
        if (start == end) {
            node.sum = arr[start];
            return node;
        }

        int mid = (start + end) / 2;
        node.left = buildTree(arr, start, mid);
        node.right = buildTree(arr, mid + 1, end);
        node.sum = node.left.sum + node.right.sum;
        return node;
    }

    // Query sum in range [l, r]
    public int query(int l, int r) {
        return queryRange(root, l, r);
    }

    private int queryRange(Node node, int l, int r) {
        if (node.start == l && node.end == r)
            return node.sum;
        // left=2 and right =7   
        int mid = (node.start + node.end) / 2;
        if (r <= mid)
            return queryRange(node.left, l, r);
        else if (l > mid)
            return queryRange(node.right, l, r);
        else {
            return queryRange(node.left, l, mid) + queryRange(node.right, mid + 1, r);
        }
    }

    // Point update
    public void update(int index, int newValue) {
        updatePoint(root, index, newValue);
    }

    private void updatePoint(Node node, int index, int value) {
        if (node.start == node.end) {
            node.sum = value;
            return;
        }

        int mid = (node.start + node.end) / 2;
        if (index <= mid)
            updatePoint(node.left, index, value);
        else
            updatePoint(node.right, index, value);

        node.sum = node.left.sum + node.right.sum;
    }
    // Main method for competitive programming
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // size of array
        int q = scan.nextInt(); // number of queries
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        } 
        SegmentTree st = new SegmentTree(nums);
        while (q-- > 0) {
            int opt = scan.nextInt();
            if (opt == 1) {
                int l = scan.nextInt();
                int r = scan.nextInt();
                System.out.println(st.query(l, r));
            } else {
                int idx = scan.nextInt();
                int val = scan.nextInt();
                st.update(idx, val);
            }
        }
        scan.close();
    }
}
