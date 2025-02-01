class Solution {
    class Pair {
        int row;
        int col;

        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    int[] rowBuf = { 0, 1, -1, 0 };
    int[] colBuf = { 1, 0, 0, -1 };

    public int shortestBridge(int[][] grid) {
        // traverse through the whole grid to find the first island
        int R = grid.length;
        int C = grid[0].length;
        // universal visited grid helps for dfs as well as bfs
        boolean[][] vis = new boolean[R][C];
        // i need a queue for BFS which initially contains the whole 1st island
        Queue<Pair> queue = new LinkedList<>();
        boolean found = false;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    // find the island using dfs
                    DFS(i, j, grid, vis, queue);
                    found = true;
                    break;
                }
            }
            if (found)
                break;
        }

        // Apply BFS for the island
        return BFS(grid, vis, queue);

    }

    // recursive DFS
    public void DFS(int r, int c, int[][] grid, boolean[][] vis, Queue<Pair> queue) {
        int R = grid.length;
        int C = grid[0].length;
        vis[r][c] = true;
        queue.add(new Pair(r, c));
        // check for all the neighbours
        for (int i = 0; i < 4; i++) {
            int nr = r + rowBuf[i];
            int nc = c + colBuf[i];
            if (inBound(nr, nc, R, C) && vis[nr][nc] == false && grid[nr][nc] == 1) {
                DFS(nr, nc, grid, vis, queue);
            }
        }
    }

    public int BFS(int[][] grid, boolean[][] vis, Queue<Pair> queue) {
        int R = grid.length;
        int C = grid[0].length;
        int res = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Pair p = queue.poll();
                int r = p.row;
                int c = p.col;
                for (int k = 0; k < 4; k++) {
                    int nr = r + rowBuf[k];
                    int nc = c + colBuf[k];
                    if (inBound(nr, nc, R, C) && vis[nr][nc] == false && grid[nr][nc] == 0) {
                        vis[nr][nc] = true;
                        queue.add(new Pair(nr, nc));
                    }
                    if (inBound(nr, nc, R, C) && vis[nr][nc] == false && grid[nr][nc] == 1)
                        return res;

                }
            } // only do for that respective level this is for the level-wise things that's it
              // after every level is done increment the res
            res += 1;

        }
        return res;

    }

    public boolean inBound(int r, int c, int rl, int cl) {
        if (r >= 0 && r < rl && c >= 0 && c < cl)
            return true;
        return false;
    }

    /*
     * Again one of the best DFS+BFS problems i had solved so far
     * 1-> will do dfs/bfs i can do anything to find the first island
     * 2-> while i was marking that 1st island visited will add all those into
     * the queue of the for the bfs which i will be doing in the future for result
     * 3-> will do bfs for the 1st found island
     * 4-> for every-level i visit i will increment the result
     * 5-> whenever i found the 1 i will return the result
     * which would be my least distance required between both the islands
     * hurray!!
     */
}