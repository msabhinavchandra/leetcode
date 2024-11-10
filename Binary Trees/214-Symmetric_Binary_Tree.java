class Solution {
    public boolean isSymmetric(TreeNode root) {
        // first things first, if the root is null then it is symmetric
        return root == null || isSymmetricHelp(root.left, root.right);
        // else let me have a helper function to figure out wheather a tree is
        // symmetric or not.
    }

    public boolean isSymmetricHelp(TreeNode left, TreeNode right) {
        // this is a base condition, of the recursive function
        // if we reach the null
        if (left == null || right == null)
            return left == right;
        /*the above statement does three things effortlessly
        1)if both are null returns true
        2)if left is null and right has a node right isn't then it returns false
        3)if the right is null and the left is not null, means if it has a node,
        then it returns false.
         */

        // if we are on a node which contains the data we will check it's
        // values.
        if (left.val != right.val)
            return false;

        // if they are equal enough then the above statement won't be executed
        // so we will check for it's both respective left and right children

        return isSymmetricHelp(left.left, right.right)
            && isSymmetricHelp(left.right, right.left);
    }
}