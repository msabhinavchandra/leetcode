package TopoSort;

import java.util.*;

class GfG {

    private static void topologicalSortUtil(int v, List<Integer>[] adj,
            boolean[] visited,
            Stack<Integer> stack) {

        visited[v] = true;

        for (int i : adj[v]) {
            if (!visited[i]) {
                topologicalSortUtil(i, adj, visited, stack);
            }
        }

        stack.push(v);
    }

    static List<Integer>[] constructadj(int V,
            int[][] edges) {

        List<Integer>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
        }
        return adj;
    }

    static int[] topologicalSort(int V, int[][] edges) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        List<Integer>[] adj = constructadj(V, edges);
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, adj, visited, stack);
            }
        }

        int[] result = new int[V];
        int index = 0;
        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        int v = 6;
        int[][] edges = { { 2, 3 }, { 3, 1 }, { 4, 0 },
                { 4, 1 }, { 5, 0 }, { 5, 2 } };

        int[] ans = topologicalSort(v, edges);

        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println();
    }
}

// my way of writing

class Solution {

    public static ArrayList<Integer>[] constructAl(int V, int[][] edges) {

        ArrayList<Integer>[] adjList = new ArrayList[V];

        // initialing the internal list
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adjList[e[0]].add(e[1]);
        }

        return adjList;

    }

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        // construct a graph first
        boolean[] visited = new boolean[V];
        ArrayList<Integer>[] adjList = constructAl(V, edges);
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFS(i, visited, adjList, result);
            }
        }
        Collections.reverse(result);
        return result;

    }

    public static void DFS(int i, boolean[] visited, ArrayList<Integer>[] adjList, ArrayList<Integer> result) {
        visited[i] = true;

        // call dfs for all it's neighbours

        for (int n : adjList[i]) {
            // if univisited make the DFS call
            if (!visited[n]) {
                DFS(n, visited, adjList, result);
            }
        }

        // once all the neighbours are visited,all my friends are done
        // you should cross me first to go to them. so maybe i am the
        // first
        result.add(i);

    }

}

// using stack
class Solution2 {

    public static ArrayList<Integer>[] constructAl(int V, int[][] edges) {

        ArrayList<Integer>[] adjList = new ArrayList[V];

        // initialing the internal list
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adjList[e[0]].add(e[1]);
        }

        return adjList;

    }

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        // construct a graph first
        boolean[] visited = new boolean[V];
        ArrayList<Integer>[] adjList = constructAl(V, edges);
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFS(i, visited, adjList, stk);
            }
        }
        for (int i = 0; i < V; i++) {
            int n = stk.pop();
            result.add(n);
        }

        return result;

    }

    public static void DFS(int i, boolean[] visited, ArrayList<Integer>[] adjList, Stack<Integer> stk) {
        visited[i] = true;

        // call dfs for all it's neighbours

        for (int n : adjList[i]) {
            // if univisited make the DFS call
            if (!visited[n]) {
                DFS(n, visited, adjList, stk);
            }
        }

        // once all the neighbours are visited,all my friends are done
        // you should cross me first to go to them. so maybe i am the
        // first
        stk.push(i);

    }

}