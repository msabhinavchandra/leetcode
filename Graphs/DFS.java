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