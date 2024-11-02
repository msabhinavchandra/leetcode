// Using Recursion – O(nlogn) Time and O(n) Space
//The time complexity of this recursive solution is 𝑂(𝑛log𝑛) due to the sorting step, 
//while the recursive traversal of the tree itself takes 𝑂(𝑛)

/*In the worst case, for a skewed binary tree, the recursion stack can go as deep as 

O(n) because each node would be visited sequentially down a single path (like a linked list).
For a balanced binary tree, the depth of the recursion would be 
O(logn). 
Thus, the space required for result is 
O(n).
Space Complexity: 
O(n) due to the result list and the recursive call stack.
*/

/*  A Binary Tree nodea
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Tree
{
    ArrayList<Integer> noSibling(Node node)
    {
        // code here
        ArrayList<Integer> result=new ArrayList<>();
        
        noSibling(node,result);
        Collections.sort(result);
        return (result.size()!=0)?result:new ArrayList<>(Collections.singletonList(-1));
        
    }
    //Writing a Recursive function to find the nodes, which don't have
    //any siblings.
    //it inputs the node(curr node) and the result Array as an Argument.
    public static void noSibling(Node node,ArrayList<Integer> result){
        //base case, if we reach the end of the tree.
        if(node==null) return;
        
        //if that node has siblings
        
        if(node.right!=null && node.left!=null){
            //apply the recursion for both it's children.
            noSibling(node.right,result);
            noSibling(node.left,result);
        }
        
        //The best case scenario where a parent(node has only one child)
        
        if((node.right!=null && node.left==null)
        ||(node.right==null && node.left!=null)){
            
        Node ans=(node.right!=null)?(node.right):(node.left);
            
        result.add(ans.data);
        
        noSibling(ans,result);
        
        }
        
    }
}

//Using a Queue.