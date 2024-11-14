
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        // Write your code here and return a list
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            // i should add my result these many no of times
            // and divide my sum these many no of times
            Double sum = 0.0;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                // after adding the nodes, check for it's neighbours and add them too.
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
            Double avg = sum / n;
            result.add(avg);

        }
        return result;

    }
}