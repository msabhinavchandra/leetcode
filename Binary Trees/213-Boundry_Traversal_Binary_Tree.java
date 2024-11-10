class Solution {
    ArrayList<Integer> boundary(Node node) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(node.data);
        if (isLeaf(node)) { // if the root is the leaf node
            return result;
        } // base condition.

        // to add the left boundry we use left boundry
        leftBoundry(node, result);
        addLeaves(node, result);
        ArrayList<Integer> temp = new ArrayList<>();
        rightBoundry(node, temp);
        Collections.reverse(temp);
        result.addAll(temp);

        return result;
    }

    public static void leftBoundry(Node node, ArrayList<Integer> result) {
        Node curr = node.left;
        while (curr != null) {
            // base condition: if you reach the leaf node on left
            // root->parent and the child is leaf return

            if (!isLeaf(curr))
                result.add(curr.data);

            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    public static void addLeaves(Node node, ArrayList<Integer> result) {
        // base condition.
        if (isLeaf(node)) {
            result.add(node.data);
            return;
        }

        if (node.left != null)
            addLeaves(node.left, result);

        if (node.right != null)
            addLeaves(node.right, result);
    }

    public static void rightBoundry(Node node, ArrayList<Integer> result) {
        Node curr = node.right;
        while (curr != null) {
            // base condition: if you reach the leaf node on left
            // root->parent and the child is leaf return

            if (!isLeaf(curr))
                result.add(curr.data);

            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }
    }

    public static boolean isLeaf(Node node) {
        if (node.left == null && node.right == null)
            return true;
        return false;
    }
}