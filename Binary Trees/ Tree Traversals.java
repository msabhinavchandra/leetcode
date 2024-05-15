
/*********************************************************

 Following is the TreeNode structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;
     TreeNode() {
         this.data = 0;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
     TreeNode(int data, TreeNode left, TreeNode right) {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 };
 ********************************************************/

/*
The time complexity of traversing a binary tree using any of the traversal 
methods (inorder, preorder, or postorder) is O(n), where n is the number of 
nodes in the tree.

Here's why:

In each traversal method (inorder, preorder, or postorder), every node in the 
tree is visited exactly once.
Since each node is visited once, the time complexity is directly proportional to 
the number of nodes in the tree.
Therefore, the time complexity of traversing a binary tree using any of these 
methods is O(n), where n is the number of nodes in the tree.
So, the time complexity of the getTreeTraversal method in your code, which calls 
the three traversal methods and then adds the results to a list, is also O(n). 

*/

/*
The space complexity of your getTreeTraversal method mainly depends on the space required for the 
recursive function calls and the 
space needed to store the traversal results.

Recursive Function Calls:

Each recursive call consumes space on the call stack. In your case, you have three recursive 
functions (inorder, Preorder, and Postorder)
 which traverse the entire tree recursively.
The maximum depth of the call stack is determined by the height of the tree. For a balanced binary 
tree, the height is O(log n), where n 
is the number of nodes. For an unbalanced tree, the height can be O(n) in the worst case.
Therefore, the space complexity due to recursive calls is O(log n) on average for balanced trees and 
O(n) in the worst case for 
unbalanced trees.
Storage of Traversal Results:

You're storing the traversal results in three separate lists (in, pre, and post). The space required 
for each list is proportional to 
the number of nodes in the tree.
If the tree has n nodes, each list can potentially store all n nodes.
Therefore, the space complexity for storing traversal results is O(n).
Considering both factors, the overall space complexity of your getTreeTraversal method is O(n) in the 
worst case, where n is the number 
of nodes in the tree.*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void inorder(TreeNode r1, List<Integer> L) {
        if (r1 == null) {
            return;
        }
        inorder(r1.left, L);
        L.add(r1.data);
        inorder(r1.right, L);

    }

    public static void Preorder(TreeNode r1, List<Integer> L) {
        if (r1 == null) {
            return;
        }
        L.add(r1.data);
        Preorder(r1.left, L);
        Preorder(r1.right, L);
    }

    public static void Postorder(TreeNode r1, List<Integer> L) {
        if (r1 == null) {
            return;
        }
        Postorder(r1.left, L);
        Postorder(r1.right, L);

        L.add(r1.data);

    }

    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        // Write your code here.

        //1
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        List<Integer> in = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        inorder(root, in);
        Postorder(root, post);
        Preorder(root, pre);

        //2
        result.addAll(Arrays.asList(in, pre, post));

        return result;

    }
}

//follow-up preorder

import java.util.ArrayList;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> result=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return result;
    }

    private void preorder(TreeNode r){
        if(r==null){
            return;
        }
        result.add(r.val);
        preorder(r.left);
        preorder(r.right);
    }
}

//Follow-up inorder

import java.util.ArrayList;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> result=new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return result;
    }
    private void inorder(TreeNode r1){
        if(r1==null){
            return ;
        }
        inorder(r1.left);
        result.add(r1.val);
        inorder(r1.right);
    }

}

//follow-up postorder

import java.util.ArrayList;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> result=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return result;
    }
    private void postorder(TreeNode r){
        if(r==null){
            return;
        }
        postorder(r.left);
        postorder(r.right);
        result.add(r.val);

    }
}