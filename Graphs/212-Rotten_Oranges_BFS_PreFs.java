class Solution {
    static class Pair {
        int row;
        int col;
        int tm;

        Pair(int r, int c, int t) {
            row = r;
            col = c;
            tm = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        // we are going to have a visited array;
        int rowSize = grid.length;
        int colSize = grid[0].length;
        boolean[][] rotten = new boolean[rowSize][colSize];
        int freshOr = 0;
        int result = 0;
        int rottenOr = 0;
        Queue<Pair> queue = new LinkedList<>();
        // 2 passes
        // 1 for adding the existing rotten oranges and the another is to
        // 1 counting the no of fresh oranges where to verify at the end
        // wheather all the fresh oranges are rotten or not

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rotten[i][j] = true;
                    queue.add(new Pair(i, j, 0));
                } else if (grid[i][j] == 1)
                    freshOr++;
            }
        }

        // this is the second pass, where we will actually perform BFS on 4
        // directions

        int[] rowBuf = {1, 0, -1, 0};
        int[] colBuf = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Pair ele = queue.poll();
            int nr = ele.row;
            int nc = ele.col;
            int tm = ele.tm;
            result = Math.max(result, tm);
            // the maximum time present in the rotten orange pair will be our
            // answer.

            for (int i = 0; i < 4; i++) {
                // checking for all the 4 directions
                int mrow = nr + rowBuf[i];
                int mcol = nc + colBuf[i];
                // now i will check if it in bounds and if it is will check is
                // it is rotten? it if is not rotten i will make it rotten and
                // push into queue mark it rotten and increment the rotten
                // counter by 1 to check at the end of the function wheather all
                // the fresh oranges became rotten or not.
                if (inBound(mrow, mcol, rowSize, colSize)
                    && rotten[mrow][mcol] == false && grid[mrow][mcol] == 1) {
                    rotten[mrow][mcol] = true;
                    // grid[mrow][mcol]=2;
                    queue.add(new Pair(mrow, mcol, tm + 1));
                    // explore in futute wheather you can do it wto changing
                    // grid to 2 or not? if works because we are using referring
                    // the rotten boolean matrix to refer wheather an array is
                    // rotten or not. things are independent of grid, we are
                    // just using grid as reference.

                    rottenOr++;
                }
            }
        }

        if (rottenOr != freshOr)
            return -1;

        return result;

    } // end of method rotten oranges

    public static boolean inBound(int r, int c, int totr, int totc) {
        if (r >= 0 && r < totr && c >= 0 && c < totc)
            return true;
        return false;
    }
}

//Revision
class Solution {
    class Pair {
        int row;
        int col;

        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    Queue<Pair> queue = new LinkedList<>();
    int[][] buf = { { 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 } };

    public int orangesRotting(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        boolean[][] vis = new boolean[R][C];
        int res = Integer.MAX_VALUE;
        boolean done = false;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 2) {

                    queue.add(new Pair(r, c));
                    vis[r][c] = true;

                }
            }

        }
        res = BFS(grid, vis);
        boolean two = false;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1 && vis[r][c] == false) {
                    // call bfs, it returns the
                    return -1;
                }
                if (grid[r][c] == 2)
                    two = true;
            }
        }
        if (!two)
            return 0;
        return res - 1;

    }

    public int BFS(int[][] grid, boolean[][] vis) {
        // queue.add(new Pair(r,c));
        int res = 0;

        int R = grid.length;
        int C = grid[0].length;
        while (!queue.isEmpty()) {

            int ntimes = queue.size();

            for (int i = 0; i < ntimes; i++) {

                Pair p = queue.poll();
                int row = p.row;
                int col = p.col;
                for (int k = 0; k < 4; k++) {
                    int nr = row + buf[k][0];
                    int nc = col + buf[k][1];
                    if (inBound(nr, nc, R, C) && vis[nr][nc] == false && grid[nr][nc] == 1) {
                        vis[nr][nc] = true;
                        queue.add(new Pair(nr, nc));
                    }
                }

            }
            res++;

        }
        return res;
    }

    public boolean inBound(int r, int c, int rl, int cl) {
        if (r >= 0 && r < rl && c >= 0 && c < cl)
            return true;
        return false;
    }

}