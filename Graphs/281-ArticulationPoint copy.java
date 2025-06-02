import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    int time = 0; // Global time tracker

    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] ap = new boolean[V]; // Articulation point flags
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);
        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                dfs(i, disc, low, parent, ap, adj);
            }
        }
        for (int i = 0; i < V; i++) {
            if (ap[i])
                result.add(i);
        }
        if (result.isEmpty())
            result.add(-1);
        return result;
    }

    void dfs(int u, int[] disc, int[] low, int[] parent, boolean[] ap,
            ArrayList<ArrayList<Integer>> adj) {
        disc[u] = low[u] = time++;
        int children = 0;
        for (int v : adj.get(u)) {
            if (disc[v] == -1) {
                children++;
                parent[v] = u;
                dfs(v, disc, low, parent, ap, adj);
                low[u] = Math.min(low[u], low[v]);
                if (parent[u] == -1 && children > 1)
                    ap[u] = true;
                if (parent[u] != -1 && low[v] >= disc[u])
                    ap[u] = true;
            } else if (v != parent[u])
                low[u] = Math.min(low[u], disc[v]);
        }
    }
}