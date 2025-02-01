class Tree
{
    ArrayList<Integer> noSibling(Node node)
    {
        // code here
        ArrayList<Integer> result=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        queue.add(node);
        
        while(!queue.isEmpty()){
            
            Node temp=queue.poll();
            
            //check for siblings
            if(temp.left!=null&&temp.right==null){
                result.add(temp.left.data);
            }
            if(temp.right!=null&& temp.left==null){
                result.add(temp.right.data);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
            if(temp.left!=null){
                queue.add(temp.left);
            }
            
        }
        
        Collections.sort(result);
        
        if(result.size()==0) result.add(-1);
        
        return result;
        
    }
}