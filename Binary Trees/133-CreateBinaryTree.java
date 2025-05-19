// Time Complexity: O(n), where n is the number of elements in the array.
// Space Complexity:
// O(n) for the space required to store the tree.
// O(log n) to O(n) for the recursion stack, depending on how balanced the tree is 
// (from a completely balanced to a completely unbalanced scenario).


class Solution {
    // i need not create an ibject to call this method that is the reason
    // i am creating it a public static method.
    public static Node insertLevelOrder(int[] Arr, Node root, int i, int n) {
        if (i < n) {
            Node temp = new Node(Arr[i]);
            root = temp;

            root.left = insertLevelOrder(Arr, root.left, 2 * i + 1, n);
            root.right = insertLevelOrder(Arr, root.right, 2 * i + 2, n);
        }
        return root;
    }

    public static Node createTree(int[] arr) {
        // Write your code here.
        // Node troot=null;
        if (arr.length == 0) {
            return null;
        }
        int i = 0;
        Node troot = new Node(arr[i]);
        Node result = insertLevelOrder(arr, troot, i, arr.length);
        return result;
    }
}