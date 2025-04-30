//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    class DSU {
        int[] parent, rank;
        int size;

        DSU(int size) {
            this.size = size;
            parent = new int[size];
            rank = new int[size];
            initialize();
        }

        void initialize() {
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        int find(int node) {
            if (node == parent[node])
                return node;
            else
                return parent[node] = find(parent[node]);//path compression
        }

        void union(int x, int y) {
            int xprnt = find(x);
            int yprnt = find(y);
            if (xprnt == yprnt)
                return;
            if (rank[xprnt] > rank[yprnt]) {

                parent[yprnt] = xprnt;

            } else if (rank[xprnt] < rank[yprnt]) {

                parent[xprnt] = yprnt;

            } else {//if the ranks are equal
                parent[yprnt] = xprnt;
                rank[xprnt] += 1;
            }

        }

    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int rows=grid.length;int cols=grid[0].length;
        List<int[]> ones=new ArrayList<>();
        int[][] dirs = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
        DSU dsu=new DSU(rows*cols);
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    int[] pos=new int[2];
                    pos[0]=i;
                    pos[1]=j;
                    ones.add(pos);
                    //explore it's neighbours, union if one's are found
                    
                for (int k = 0; k < 4; k++) {
                        int nr = i + dirs[k][0];
                        int nc = j + dirs[k][1];
                        // check for ones
                        if (inBound(nr, nc, rows, cols) && grid[nr][nc] == 1) {
                            // unite them
                            dsu.union(i * cols + j, nr * cols + nc);
                        }
                    }
                }
            }
        }
        
        // make a queue for every single parent, parent->queue(int[])
        // for parent and it's children kind of a scenario
        
        Map<Integer,Queue<int[]>> map=new HashMap<>();
        
        for(int[] one:ones){
            
            int x=one[0];int y=one[1];
            // parent of this thing
            int parent=dsu.find(x*cols+y);
            
            //create a queue or push into existing queue
            Queue<int[]> queue=map.getOrDefault(parent,new LinkedList<int[]>());
            
            queue.add(one);
            
            map.put(parent,queue);
            
        }
        
        HashSet<String> strs = new HashSet<>();
        for (int k : map.keySet()) {
            Queue<int[]> queue = map.get(k);
            int[] dd = queue.peek();
            int dx = dd[0], dy = dd[1];
            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty()) {
                int[] cur = queue.remove();
                sb.append(cur[0] - dx);
                sb.append(",");
                sb.append(cur[1] - dy);
                sb.append(";");
            }
            strs.add(sb.toString());
        }

        return strs.size();
        
        
    }
    
    boolean inBound(int r, int c, int rl, int cl) {
        if (r >= 0 && r < rl && c >= 0 && c < cl)
            return true;
        return false;
    }
}


















