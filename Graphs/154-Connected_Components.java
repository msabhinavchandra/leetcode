class Solution {

    // Helper functions

    // BFS of a graph
    public static void bfsOfGraph(int start, ArrayList<ArrayList<Integer>> adjLs, boolean[] vis) {
        // Mark the node as visited
        vis[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            Integer n = q.poll();// return and remove element from the queue
            // in this question i need not store any answer or return i just have to
            // traverse so not (buss ekkivatledu becuz bus avasaram ledu)

            // call friends and check for them
            for (Integer a : adjLs.get(n)) {
                if (vis[a] == false) {
                    vis[a] = true;
                    q.add(a);// chamber after chamber then bus will come.
                }
            }
        }
    }

    // Converting the pairs of edges which are in an array into an adjacency list
    public static ArrayList<ArrayList<Integer>> PairstoAdjLs(int E, int V, List<List<Integer>> edges) {

        ArrayList<ArrayList<Integer>> AdjLs = new ArrayList<>(V);// )=based indexing in this question

        for (int i = 0; i < V; i++) {// 0-based indexing in this question
            AdjLs.add(new ArrayList<Integer>());// initializing inner lists.
        }

        for (int i = 0; i < E; i++) {
            AdjLs.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            // As this is an undirected graph
            AdjLs.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }

        return AdjLs;

    }

    public int findNumberOfComponent(int E, int V, List<List<Integer>> edges) {

        // Retrieve adjacency list
        ArrayList<ArrayList<Integer>> AdjLs = PairstoAdjLs(E, V, edges);

        // Visited Array
        boolean[] vis = new boolean[V];// if 1-indexing exists take V+1

        int cnt = 0;

        // Start Traversal
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                cnt++;
                bfsOfGraph(i, AdjLs, vis);
            }
        }

        return cnt;

    }
}
