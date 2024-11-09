/*
You are given an N×N grid that represents a maze. 
In this maze: Each cell contains either a 0 or 1.
 --1 indicates an open path where you can walk.
 --0 indicates a dead-end where you cannot pass.

You start at the top-left corner of the maze, i.e., position (0, 0).
Your target is to reach the bottom-right corner of the maze, i.e., position (N-1, N-1).
In the maze, you can move only right or down from each cell.

Objective: Determine if there exists a path from the start (0, 0) to the end (N-1, N-1) that passes only through cells marked 1. 
If such a path exists, return true; otherwise, return false.

Input Format:
-------------
Line-1: The first line contains an integer N, the size of the square grid.
Line 2 to N: The next N lines each contain N space-separated integers (either 0 or 1), representing the maze.

Output Format:
--------------
Line-1: Print true if a path exists from (0, 0) to (N-1, N-1), otherwise print false.

Constraints:
------------
* 1 ≤ N ≤ 100
* Each cell in the grid is either 0 or 1.

Sample Input-1:
---------------
4
1 0 0 0
1 1 0 1
0 1 0 0
1 1 1 1

Sample Output-1:
----------------
true

Explanation: There exists a path from (0, 0) to (3, 3).

Sample Input-2:
---------------
4
1 1 0 0
1 0 0 1
0 1 1 0
1 0 0 1

Sample Output-2:
----------------
false

Explanation: There is no valid path from (0, 0) to (3, 3).
 */

//get into tc and sc later

import java.util.*;

class Solution {
    class Pair {
        int row;
        int col;
        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no_rows = sc.nextInt();

        int[][] grid = new int[no_rows][no_rows];
        boolean[][] vis = new boolean[no_rows][no_rows];
        for (int i = 0; i < no_rows; i++) {
            for (int j = 0; j < no_rows; j++) {
                grid[i][j] = sc.nextInt();
            }
        }  // taking inputs done.

        System.out.println(DFS(grid, 0, 0, vis));
    }

    // this can be solved using dfs
    // i am going to implement dfs in a recursive manner.
   public static boolean DFS(int[][] grid, int strr, int strc, boolean[][] vis) {
        // base condition if the start row and coll reach the destination
        if (grid[grid.length - 1][grid[0].length - 1] == 0) return false;
        if (strr == grid.length - 1 && strc == grid[0].length - 1) {
            if (grid[strr][strc] == 1)
                return true;
            else
                return false;
        }
        vis[strr][strc] = true;
        // check for it's neighbours
        // You can only go right or down, no you can't go in
        //  4 directions.
        int[] rowBuf = {1, 0};
        int[] colBuf = {0, 1};

        for (int i = 0; i < 2; i++) {
            int nr = strr + rowBuf[i];
            int nc = strc + colBuf[i];
            // basic dfs if the neighbouring rows are unvisited visit them until
            // you reach a point where there are no more unvisted neighbours,
            // then come back and backtract and check for other neighbours
            if (inBound(nr, nc, grid.length, grid[0].length) &&
                vis[nr][nc] == false && grid[nr][nc] == 1) {
                System.out.println("calling dfs for row " + nr +
                                   " and col: " + nc);
                if (DFS(grid, nr, nc, vis)) return true;
                }
        }

        return false;
    }

   public static boolean inBound(int r, int c, int lr, int lc) {
        if (r >= 0 && r < lr && c >= 0 && c < lc) return true;
        return false;
    }
}
