import java.util.*;

public class ReversePairsTreap_290 {

    static class TreapNode {
        double key;
        double priority;
        long count; // size of subtree
        TreapNode left, right;

        TreapNode(double key, double priority) {
            this.key = key;
            this.priority = priority;
            this.count = 1;
        }
    }

    // Count subtree size
    static long getCount(TreapNode node) {
        return (node == null) ? 0 : node.count;
    }

    // Update size of subtree
    static void updateCount(TreapNode node) {
        if (node != null)
            node.count = 1 + getCount(node.left) + getCount(node.right);
    }

    // Split into two treaps: left contains keys < given key, right contains >= key
    static TreapNode[] split(TreapNode root, double key) {
        if (root == null) return new TreapNode[] {null, null};

        TreapNode[] result;
        if (root.key < key) {
            result = split(root.right, key);
            root.right = result[0];
            result[0] = root;
        } else {
            result = split(root.left, key);
            root.left = result[1];
            result[1] = root;
        }
        updateCount(root);
        return result;
    }

    // Merge two treaps where all keys in left < all keys in right
    static TreapNode merge(TreapNode left, TreapNode right) {
        if (left == null || right == null) return (left != null) ? left : right;

        if (left.priority > right.priority) {
            left.right = merge(left.right, right);
            updateCount(left);
            return left;
        } else {
            right.left = merge(left, right.left);
            updateCount(right);
            return right;
        }
    }

    // Insert a node into the treap
    static TreapNode insert(TreapNode root, TreapNode node) {
        if (root == null) return node;

        if (node.priority > root.priority) {
            TreapNode[] split = split(root, node.key);
            node.left = split[0];
            node.right = split[1];
            updateCount(node);
            return node;
        }

        if (node.key < root.key)
            root.left = insert(root.left, node);
        else
            root.right = insert(root.right, node);

        updateCount(root);
        return root;
    }

    // Count how many elements are strictly less than given key
    static long countLessThan(TreapNode root, double key) {
        TreapNode[] split = split(root, key);
        long count = getCount(split[0]);
        // Merge them back
        root = merge(split[0], split[1]);
        return count;
    }

    // Main function to count reverse pairs
    public static int reversePairs(int[] nums) {
        TreapNode root = null;
        int count = 0;
        Random rand = new Random();

        for (int i = nums.length - 1; i >= 0; i--) {
            // Count elements in treap where nums[j] < nums[i]/2
            double target = nums[i] / 2.0;
            count += countLessThan(root, target);

            // Insert current element into treap
            TreapNode newNode = new TreapNode(nums[i], rand.nextDouble());
            root = insert(root, newNode);
        }

        return count;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int result = reversePairs(nums);
        System.out.println("Number of reverse pairs: " + result);
    }
}
