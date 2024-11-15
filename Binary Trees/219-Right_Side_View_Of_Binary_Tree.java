//Using DFS
class Solution 
{
	public List<Integer> rightSideView(BinaryTreeNode root) 
	{
        //Write your code here and return a list of nodes
        List<Integer> result=new ArrayList<>();
        getRightView(root,result,0);
        return result;
        
    }
    
    //Your supporting methods(if any) goes here
    public void getRightView(BinaryTreeNode root,List<Integer> result,int level){
        if(root==null||root.data==-1){
            return;
        }
        if(level==result.size()){
            result.add(root.data);
        }
        getRightView(root.right,result,level+1);
        getRightView(root.left,result,level+1);
    }
}

//Using BFS
class Solution 
{
	public List<Integer> rightSideView(BinaryTreeNode root) 
	{
        //Write your code here and return a list of nodes
        List<Integer> result=new ArrayList<>();
        getRightView(root,result);
        return result;
    }
    
    //Your supporting methods(if any) goes here
    public void getRightView(BinaryTreeNode root,List<Integer> result){
        Queue<BinaryTreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            BinaryTreeNode curr=queue.poll();
            result.add(curr.data);
            //add it's children into the queue
            if(curr.right!=null && curr.right.data!=-1){
                queue.add(curr.right);
            }if(curr.left!=null && curr.left.data!=-1){
                queue.add(curr.left);
            }
            //pop out the remaining elements from the queue but don't forget to add it's
            //children
            for(int i=0;i<n-1;i++){
                curr=queue.poll();
                if(curr.right!=null && curr.right.data!=-1){
                queue.add(curr.right);
                }if(curr.left!=null && curr.left.data!=-1){
                queue.add(curr.left);
                }
            }
        }
    }
}