//recursive
class DFS{

    public static void dfsOfaGraph(int start,List<List<<Integer>> AdjLs,boolean[] vis,List<Integer> ans)
    {
        //Mark the node a visited
        vis[start]=true;//make it infected.
        //you might get a doubt where won't we check and if it was already true?
        //dfs won't even be called if it is true, dfs is only called if it is false
        ans.add(start);//bus ekkiyyu.

        //traverse all it's neighbours, check for it's friends
        for(int n:adj.get(start)){
            if(vis[n]==false){
              //if friends are not infected call dfs(friend)
                dfsOfaGraph(n,AdjLs,vis,ans);
            }//if they are true means they are already in the bus
        }
    }

}

//using stack
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] vis = new boolean[adj.size()];
        dfs(0, vis, adj, result);
        return result;
    }

    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> result) {
        // Using a Stack for DFS
        Stack<Integer> stk = new Stack<>();
        stk.push(node);
        vis[node] = true;

        while (!stk.isEmpty()) {
            int n = stk.pop();
            result.add(n);

            // Traverse adjacent nodes in reverse to maintain DFS order.
            List<Integer> neighbors = adj.get(n);
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                int adjNode = neighbors.get(i);
                if (!vis[adjNode]) {
                    stk.push(adjNode);
                    vis[adjNode] = true;
                }
            }
        }
    }
}