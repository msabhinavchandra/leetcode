import java.util.*;

class Treenode {
    int val;
    Treenode left;
    Treenode right;

    Treenode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

class Main {

    static List<Integer> preorder = new ArrayList<>();
    static List<Integer> levelord = new ArrayList<>();

    public static List<Integer> levelorder(Treenode root) {
        if (root == null)
            return new ArrayList<>();
        Queue<Treenode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Treenode curr = q.poll();
            levelord.add(curr.val);
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
        return levelord;
    }

    public static Treenode BuildBinaryTree(int[] arr) {

        if (arr.length == 0)
            return null;
        Treenode root = new Treenode(arr[0]);
        Queue<Treenode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < arr.length) {
            Treenode curr = q.poll();
            // left
            if (i < arr.length) {
                curr.left = new Treenode(arr[i]);
                q.add(curr.left);
                i++;
            }// end of if
            // right
            if (i < arr.length) {
                curr.right = new Treenode(arr[i]);
                q.add(curr.right);
                i++;
            }// end of if
        }//end of while
        return root;
    }

    public static List<Integer> PreorderTraversal(Treenode root) {
        preorderHelper(root);
        return preorder;
    }

    public static void preorderHelper(Treenode r) {
        if (r == null)
            return;
        preorder.add(r.val);
        preorderHelper(r.left);
        preorderHelper(r.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
            sc.nextLine();
        }
        for (int i = 0; i < size; i++) {
            System.out.print(+arr[i] + " ");
        }
        System.out.println();

        Treenode roo = BuildBinaryTree(arr);
        System.out.println("Preorder " + PreorderTraversal(roo));
        System.out.println("Level order " + levelorder(roo));

        // System.out.println("Hello, World!");
    }
}