
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

//Follow up
// find the largest element in every row of the tree

public List<Integer> largestValues(BinaryTreeNode root) 
	{
        //Write your code here and return a list
        // Write your code here and return a list
        List<Integer> result = new ArrayList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            // i should add my result these many no of times
            // and divide my sum these many no of times
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                BinaryTreeNode node = queue.poll();
                max=Math.max(max,node.data);
                // after adding the nodes, check for it's neighbours and add them too.
                if (node.right != null && node.right.data!=-1) {
                    queue.add(node.right);
                }
                if (node.left != null && node.left.data!=-1) {
                    queue.add(node.left);
                }
            }
            
            result.add(max);

        }
        return result;
    }

//Largest Values using DFS

class Solution 
{
    public List<Integer> largestValues(BinaryTreeNode root) 
	{
        //Write your code here and return a list
        List<Integer> result=new ArrayList<>();
        getLargeValues(root,result,0);
        return result;
    }

    //Your supporting methods(if any) goes here
    
    public void getLargeValues(BinaryTreeNode root,List<Integer> result,int level){
        if(root==null|| root.data==-1){
            return;
        }
        else if(level==result.size()){
            result.add(root.data);
        }
        else{
            result.set(level,Math.max(root.data,result.get(level)));
        }
        
        getLargeValues(root.left,result,level+1);
        getLargeValues(root.right,result,level+1);
        
        
    }
}