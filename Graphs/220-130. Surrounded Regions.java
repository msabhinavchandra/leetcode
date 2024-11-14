class Solution {
    public void solve(char[][] board) {
        int rowL = board.length;
        int colL = board[0].length;
        boolean[][] visited = new boolean[rowL][colL];

        // circular traversal just one circle
        // 4 directions

        // left top to left bottom rowise
        for (int j = 0; j < rowL; j++) {
            if (board[j][0] == 'O' && visited[j][0] == false) {
                DFS(board, visited, j, 0);
            }
        }
        // left bottom to right bottom
        for (int j = 0; j < colL; j++) {
            if (board[rowL - 1][j] == 'O' && visited[rowL - 1][j] == false) {
                DFS(board, visited, rowL - 1, j);
            }
        }

        // right bottom to right top u can go top to down too no issues
        for (int j = 0; j < rowL; j++) {
            if (board[j][colL - 1] == 'O' && visited[j][colL - 1] == false) {
                DFS(board, visited, j, colL - 1);
            }
        }
        // right top to left top
        for (int j = 0; j < colL; j++) {
            if (board[0][j] == 'O' && visited[0][j] == false) {
                DFS(board, visited, 0, j);
            }
        }

        for (int i = 0; i < rowL; i++) {
            for (int j = 0; j < colL; j++) {
                if (board[i][j] == 'O' && visited[i][j] == false) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    // the fact that u called DFS itself means that it is being an unvisited node
    public void DFS(char[][] grid, boolean[][] vis, int row, int col) {
        vis[row][col] = true;
        // check for neighbours, if they are unvisited call dfs for them one by one
        int[] rowBuf = { 0, 1, 0, -1 };
        int[] colBuf = { 1, 0, -1, 0 };
        for (int i = 0; i < 4; i++) {
            int ni = row + rowBuf[i];
            int nj = col + colBuf[i];
            if (inBound(ni, nj, grid.length, grid[0].length) && vis[ni][nj] == false && grid[ni][nj] == 'O') {
                DFS(grid, vis, ni, nj);
            }
        }
    }

    public boolean inBound(int r, int c, int rl, int cl) {
        if (r >= 0 && c >= 0 && r < rl && c < cl)
            return true;
        return false;
    }

}