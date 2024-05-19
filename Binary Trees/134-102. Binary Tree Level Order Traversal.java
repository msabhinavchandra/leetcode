import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/* 
### Time Complexity:

The algorithm processes each node of the binary tree exactly once. For each 
node, it performs a constant amount of work (adding the node's value to the 
`temp` list, checking its children, and possibly adding its children to the 
queue).

- **Adding nodes to the queue**: Each node is added to the queue exactly once.
- **Removing nodes from the queue and processing them**: Each node is removed 
from the queue and processed exactly once.

Since there are `n` nodes in the binary tree, the overall time complexity is:

\[ O(n) \]

### Space Complexity:

The space complexity of the algorithm is determined by the space needed for 
the `queue` and the `result` list.

- **Queue**: In the worst case, the queue can hold all the nodes at the 
current level. For a complete binary tree, the maximum number of nodes at the 
last level is \( \lceil \frac{n}{2} \rceil \). Therefore, the space complexity 
for the queue is \( O(n) \).

- **Result List**: The `result` list contains all the node values, grouped by 
levels. The total number of values stored in `result` is `n`. Each level is 
stored as a separate list, and the number of levels in the binary tree is at 
most `n`. Therefore, the space complexity for `result` is also \( O(n) \).

Combining these, the overall space complexity is:

\[ O(n) \]

### Summary:

- **Time Complexity**: \( O(n) \)
- **Space Complexity**: \( O(n) \)

This analysis assumes that `n` is the total number of nodes in the binary 
tree.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    private void level(TreeNode r) {
        if (r == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> temp = new ArrayList<>();
        // initial.add(r)
        queue.add(r);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node != null) {
                temp.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else if (node == null) {

                result.add(new ArrayList<>(temp));
                temp.clear();

                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }

        }

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        level(root);
        return result;

    }
}