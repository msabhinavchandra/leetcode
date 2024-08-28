// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class HelloWorld {
    
    public static List<List<Integer>> CAL(int V,int E,Scanner sc){
        
        List<List<Integer>> adjls=new ArrayList<>();
        
        for(int i=0;i<V+1;i++){
            adjls.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<E;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            adjls.get(u).add(v);
            adjls.get(v).add(u);
        }
        
        return adjls;
        
    }
    
    public static List<Integer> bfs(int start,int V,List<List<Integer>> adj){
        boolean[] vis=new boolean[V+1];
        List<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        vis[start]=true;
        q.add(start);
        while(!q.isEmpty()){
            int i=q.poll();
            ans.add(i);
            for(int a:adj.get(i)){
                if(vis[a]==false){
                    vis[a]=true;
                    q.add(a);
                }
            }
        }
        return ans;
    }
    
    public static List<Integer> dfs(int start,int V,List<List<Integer>> adj){
        //set visited array and initialize the list of lists
        boolean[] vis=new boolean[V+1];
        List<Integer> ans=new ArrayList<>();
        dh(start,vis,adj,ans);
        return ans;
    }
    
    public static void dh(int start,boolean[] vis,List<List<Integer>> adj,List<Integer> ans){
        // if(start==null)
        ans.add(start);
        vis[start]=true;
        for(int n:adj.get(start)){
            if(vis[n]==false) dh(n,vis,adj,ans);
        }
        
    }
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        List<List<Integer>> adj=CAL(V,E,sc);
        System.out.println("DFS :"+dfs(1,V,adj));
        System.out.println("BFS :"+bfs(4,V,adj));
        
        
        
    }
}