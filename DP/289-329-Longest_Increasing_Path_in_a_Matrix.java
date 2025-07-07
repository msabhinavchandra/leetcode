import java.util.Arrays;

class Solution {
    int[] rowBuf = { 0, 1, -1, 0 };
    int[] colBuf = { 1, 0, 0, -1 };
    int[][] dp;
    int rl;
    int cl;
    int[][] matcopy;
    public int longestIncreasingPath(int[][] matrix) {
        // do it with the help of DFS along with DP
        this.rl = matrix.length;
        this.cl = matrix[0].length;
        this.matcopy = matrix;
        this.dp = new int[rl][cl];
        for (int i = 0; i < rl; i++) {
            Arrays.fill(dp[i], -1);
        }
        int result = 0;
        // call DFS for every cell in the matrix
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                // we will be calling for every single cell
                // and the maximum of all the possibilities will be
                // our answer
                result = Math.max(result, DFS(i, j, -1));
                // for every cell when we make the call
                // initially when we make the call, for the first time
                // the prev value we will set as -1
                // considering the constraint
                // 0 <= matrix[i][j] <= 2^31 - 1
                // our current value will always be greater than
                // this prev we passed so that we don't receive 0
                // directly when we make the call for that respective cell
            }
        }
        return result;
    }
    // every DFS call for a respective cell will return the
    // LIP relative that respective positon (r,c)
    // and that result will be stored in the DP[][] Array
    public int DFS(int r, int c, int prev) {
        // if it is out of bounds return 0
        // because no contribution from that func call
        // int rl = matrix.length;
        // int cl = matrix[0].length;
        if (!inBound(r, c, rl, cl) || !(matcopy[r][c] > prev))// base condition
            return 0;
        // if this is sth which is alr computed, it makes so sense
        // to write this first, for ur own understanding this is more
        // than best to write later after the whole logic is done writing
        if (dp[r][c] != -1)
            return dp[r][c]; 
        // considering this is the first call from the cell
        int lip = 1;// this is the least and the minimum for a cell
        // which is unvisited in itself even though
        // 1 if it's neighbours are out of bounds
        // 2 if it's neighbours are smaller than this
        // now later visited all these neighbours and make a DFS call
        // to every single of it's neighbour 4-directionally.
        // and the maximum path discovered across all the 4 directions
        // will finally be the result for this respective cell
        for (int k = 0; k < 4; k++) {
            int newRow = r + rowBuf[k];
            int newCol = c + colBuf[k];
            lip = Math.max(lip, 1 + DFS(newRow, newCol, matcopy[r][c]));
        }
        dp[r][c] = lip;
        return lip;
    }
    public boolean inBound(int r, int c, int rl, int cl) {
        if (r >= 0 && r < rl && c >= 0 && c < cl) {
            return true;
        }
        return false;
    }
}