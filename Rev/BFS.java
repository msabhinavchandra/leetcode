import java.util.*;
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> result=new ArrayList<>();
        int start=0;
        boolean[] vis=new boolean[adj.size()];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        vis[0]=true;
        
        while(!queue.isEmpty()){
            int res=queue.poll();
            result.add(res);
            ArrayList<Integer> adjNodes=adj.get(res);
            
            for(Integer a:adjNodes){
                if(vis[a]==false){
                    vis[a]=true;
                    queue.add(a);
                }
            }
            
        } return result;
        
    }
}