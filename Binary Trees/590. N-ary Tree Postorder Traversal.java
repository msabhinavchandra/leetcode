/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};156
*/ 

class Solution {
    List<Integer> result=new ArrayList<>();
    public List<Integer> postorder(Node root) {
        dfs(root,result);
        return result;
    }
    public void dfs(Node r,List<Integer> res){
        if(r==null) return;
        for(Node n:r.children){
            dfs(n,res);
        }
        res.add(r.val);
    }

}