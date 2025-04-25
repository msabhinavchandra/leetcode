class Solution {

    class DSJ {
        int size;
        int[] parent;
        int[] rank;

        public DSJ(int size) {
            this.size = size;
            rank = new int[size];
            parent = new int[size];
            initialize();
        }

        public int find(int node) {
            if (node == parent[node]) return node;
            else return parent[node] = find(parent[node]);
        }

        public void union(int x, int y) {
            int xparent = find(x);
            int yparent = find(y);

            if (rank[xparent] > rank[yparent]) {
                parent[yparent] = xparent;
            } else if (rank[xparent] < rank[yparent]) {
                parent[xparent] = yparent;
            } else {
                parent[yparent] = xparent;
                rank[xparent] += 1;
            }
        }

        private void initialize() {
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

    }

    public boolean isCycle(int V, int[][] edges) {
        // Code here
        DSJ dsj = new DSJ(V);

        for (int i = 0; i < edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];

            int firstParent = dsj.find(first);
            int secondParent = dsj.find(second);

            // if they are same return true if the cycle exists

            if (firstParent == secondParent) return true;

            // else union it

            dsj.union(first, second);

        }

        //if you didn't get it till now return false;

        return false;


    }
}