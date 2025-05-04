
import java.util.*;
public class DFS {

    public static void dfsOfaGraph(int start, List<List<Integer>> AdjLs, boolean[] vis, List<Integer> ans)
    {
        //Mark the node a visited
        vis[start]=true;//make it infected.
        //you might get a doubt where won't we check and if it was already true?
        //dfs won't even be called if it is true, dfs is only called if it is false
        ans.add(start);//bus ekkiyyu.

        //traverse all it's neighbours, check for it's friends
        for(int n:AdjLs.get(start)){
            if(vis[n]==false){
              //if friends are not infected call dfs(friend)
                dfsOfaGraph(n,AdjLs,vis,ans);
            }//if they are true means they are already in the bus
        }
    }

}

// Iterative



class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int noOfVertices = sc.nextInt();
        for (int i = 0; i < noOfVertices; i++) {
            adj.add(new ArrayList<>());
        }

        int noOfEdges = sc.nextInt();

        for (int i = 0; i < noOfEdges; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adj.get(v1).add(v2);
            // adj.get(v2).add(v1);
        }

        int src = sc.nextInt();

        List<Integer> result = dfs(src, adj);

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }

    }

    public static List<Integer> dfs(int src, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> stk = new Stack<>();
        boolean[] vis = new boolean[adj.size()];// for those many no of edges.
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        stk.push(src);
        vis[src] = true;
        while (!stk.isEmpty()) {
            int n = stk.pop();
            result.add(n);
            temp = adj.get(n);
            for (int i = temp.size() - 1; i >= 0; i--) {
                int k = temp.get(i);
                if (!vis[k]) {
                    stk.push(k);
                    vis[k] = true;
                }
            }
        }
        return result;
    }
}

class DFS_Directed_graph_AdjMatrix{

    

}