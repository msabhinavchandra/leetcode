//Adjacency Matrix undirected and directed
import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        //Taking input
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//No of nodes.
        int m=sc.nextInt();//No of edges.

        //Adjacency matrix for both directed and undirected graph
        int[][] adj=new int[n+1][n+1];//Hoping we are taking 1-based indexing

        //Add the edges to the matrix
        for(int i=0;i<m;i++){
            //taking input
            int u=sc.nextInt();//First
            int v=sc.nextInt();//Second

            //Adding the edges
            adj[u][v]=1;
            adj[v][u]=1;//will be commented for an undirected graph.
        }
        sc.close();
    }
}

//Adjacency Lists for directed as well as undirected graphs

import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        //Taking the input
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//No of Nodes
        int m=sc.nextInt();//No of Edges

        //Adjacency List for undirected graph as well as directed graph
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>(n+1);//initializes the 
        //Anticipating a 1-based indexing.
        //ArrayList...Yet an arrayList need not be initialzed but for 
        //for safety and convenience
        //And the above statement will intialize the outer list

        //The below loop is to intialize the inner Lists, which store integer values
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<Integer>());
        } 
//For directed m value is equal to the no of edges, but for directed it may increase
        //Add the edges to the list
        for(int i=0;i<m;i++){//loop the no of times the no of edges you have.

            //Taking the input
            int u=sc.nextInt();//First
            int v=sc.nextInt();//Second

            //Adding the edges
            adj.get(u).add(v);
            adj.get(v).add(u);//Ignored for directed graphs

        }

        sc.close();

        // Print the adjacency list
            for (int i = 1; i <= n; i++) {
                System.out.print("Node " + i + ": ");
                for (int j = 0; j < adj.get(i).size(); j++) {
                    System.out.print(adj.get(i).get(j) + " ");
                }
                System.out.println();
            }
    }

}

