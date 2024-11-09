//Examine what is time and space too.
// SC->O(M*N) TC->O(M*N*4)
//Experiment solving this using DFS too.

class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] vis = new boolean[row][col];
        int cnt = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && vis[i][j] == false) {
                    cnt++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return cnt;

    }

    public void bfs(int row, int col, boolean[][] vis, char[][] grid) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        vis[row][col] = true;
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int nrow = p.row;
            int ncol = p.col;

            // check for it's neighbours,
            // if the neighbours are unvisited, mark them visited and
            // add into the queue

            int[] rBuf = { -1, 0, 1, 0 };
            int[] cBuf = { 0, -1, 0, 1 };

            for (int i = 0; i < 4; i++) {
                int mrow = nrow + rBuf[i];
                int mcol = ncol + cBuf[i];
                if (inBound(mrow, mcol, grid.length, grid[0].length) && grid[mrow][mcol] == '1'
                        && vis[mrow][mcol] == false) {
                    vis[mrow][mcol] = true;
                    queue.add(new Pair(mrow, mcol));
                }

            }

        }
    }

    public boolean inBound(int r, int c, int tr, int tc) {
        if (r >= 0 && r < tr && c >= 0 && c < tc)
            return true;
        return false;
    }

    class Pair {
        int row;
        int col;

        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

}