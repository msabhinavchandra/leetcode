package Rev_2;

import java.util.*;

class FindingBridges {
    private int time;
    private int V;
    private List<List<Integer>> adj;

    // Constructor
    FindingBridges(int vertices) {
        this.V = vertices;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        time = 0;
    }

    // Add an undirected edge
    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // DFS Utility to find Bridges
    void dfs(int u, int[] disc, int[] low, int[] parent) {
        disc[u] = low[u] = time++;
        for (int v : adj.get(u)) {
            if (disc[v] == -1) { // If v is not visited
                parent[v] = u;
                dfs(v, disc, low, parent);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) 
                    System.out.println(u + " " + v);
            } else if (v != parent[u]) 
                low[u] = Math.min(low[u], disc[v]);
        }
    }

    void findBridges() {
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                dfs(i, disc, low, parent);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        FindingBridges graph = new FindingBridges(vertices);
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        System.out.println("Bridges in graph");
        graph.findBridges();
    }
}
