/*
The time and space complexity of the `preorderTraversal` function can be 
analyzed as follows:

### Time Complexity:

The algorithm processes each node of the binary tree exactly once in a 
preorder fashion (node -> left -> right). For each node, it performs a 
constant amount of work (adding the node's value to the `preorder` list and 
pushing its children onto the stack if they exist).

Since there are `n` nodes in the binary tree, the overall time complexity 
is:

\[ O(n) \]

### Space Complexity:

The space complexity of the algorithm is determined by the space needed for 
the `preorder` list and the `stack`.

- **Preorder List**: The `preorder` list stores the values of all the nodes 
in the tree. Thus, it will contain `n` values, and its space complexity is 
\( O(n) \).

- **Stack**: In the worst case, the stack can hold all the nodes along the 
path from the root to the deepest leaf node. For a skewed binary tree 
(where each node has only one child), the maximum depth of the tree is `n`, 
and the stack can hold up to `n` nodes. Therefore, the space complexity for 
the stack is \( O(n) \).

Combining these, the overall space complexity is:

\[ O(n) \]

### Summary:

- **Time Complexity**: \( O(n) \)
- **Space Complexity**: \( O(n) \)

This analysis assumes that `n` is the total number of nodes in the binary 
tree.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

//Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<Integer>();
        if (root == null)
            return preorder;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while (!stk.isEmpty()) {
            root = stk.pop();
            preorder.add(root.val);
            if (root.right != null) {
                stk.push(root.right);
            }
            if (root.left != null) {
                stk.push(root.left);
            }
        }
        return preorder;
    }
}