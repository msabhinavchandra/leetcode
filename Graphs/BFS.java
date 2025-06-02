import java.util.*;
class Solution{//0-based indexing

    public ArrayList<Integer> bfsOfGraph(int St,int V,ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs=new ArrayList<>();
        boolean vis[]=new boolean[V+1];//+1 for 1-based indexing.
        Queue<Integer> q=new LinkedList<>();
        vis[St]=true;//Infect
        q.add(St);//Chamber
        while(!q.isEmpty()){//Till the chamber is empty
            Integer n=q.poll();//Take out from chamber
            bfs.add(n);//Because coming out from chamber...it is already infected
            //Bus ekkiyu
            for(Integer a:adj.get(n)){//check for the infected friend
                if(vis[a]==false){//if they aren't...infect them
                    vis[a]=true;
                    q.add(a);//Put them in chamber
                }//if they are already infected then no worries, we don't need them
            }
        }
        return bfs;//start bus...return it.

    }

}