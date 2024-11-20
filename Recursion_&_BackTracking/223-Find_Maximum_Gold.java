/*The Kolar Gold Fields (KGF) is in the form of a m*n grid,
Each field, contains some amount of Gold in it.
 
You can mine the gold in the KGF in the following way.
	- You can start at any position in the grid, never visit a cell with no gold.
	- each time you visit a cell, you will grab all the gold in it.
	- You can move one step to the left, right, up or down.
	- You can't visit the same cell more than once.
	- You can stop at any cell.
	
Your task is to find the maximum amount of gold you can collect.

Input Format:
-------------
Line-1: Two integers M and N size of the KGF grid.
Next M lines: N space separated integers, gold in each row of the grid.

Output Format:
--------------
Print an integer, maximum amount of gold.


Sample Input-1:
---------------
3 3
0 6 0
5 8 7
0 9 0

Sample Output-1:
----------------
24

Explanation:
-------------
You can grab the gold in KGF grid as follows:
You can obtain like as follows: 9 -> 8 -> 7.

Sample Input-2:
---------------
5 3
1 0 7
2 0 6
3 4 5
0 3 0
9 0 20

Sample Output-2:
----------------
28

Explanation:
-------------
You can grab the gold in KGF grid as follows:
You can obtain like as follows: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
*/

import java.util.*;

public class GetMaximumGold {
  public static int MaxGold(int[][] grid, int row, int col) {
    // because there is no start and the end in the grid to find the
    // maximum gold i will check the possibility of it for each every element
    int res = Integer.MIN_VALUE;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        // as i need to find the maximum of all the places
        // i will find the maximum gold for every single place
        // if i started from every single place
        // considering every single spot
        // and i will take the maximum gold i can find from all the
        // respective possibilities
        res = Math.max(res, dfs(grid, i, j));
      }
    }

    return res;
  }

  // this function calculates the maximum gold which can be found if we start
  // mining from the positions strow and stcol.
  public static int dfs(int[][] grid, int strow, int stcol) {
    // i will check if my coordinates in inBound
    // if it is in Bound i will follow to mine, if it is out of bounds i will
    // return 0, because there is no gold i can find at that co-ordinate.
    if (inB(grid, strow, stcol, grid.length, grid[0].length)) {
      // i can go mine from this spot.

      // remove the starting point,
      // what if i not pick it case
      int temp = grid[strow][stcol];
      grid[strow][stcol] = 0;
      // my subproblem starts with result 0, then i will eventually find the
      // result as the maximum of all the possibilities
      int res = 0;
      // check for all the neighbours case.

      int[] rowBuf = {0, 1, 0, -1};
      int[] colBuf = {1, 0, -1, 0};

      for (int i = 0; i < 4; i++) {
        int nr = strow + rowBuf[i];
        int nc = stcol + colBuf[i];
        // call dfs directly, it will take case of inB and out of bounds
        //  the case will be temp + possibilities because
        // i don't want the present curr to be recounted again
        // because dfs doesn't count it again, i am adding the temp
        // explicitly
        res = Math.max(res, temp + dfs(grid, nr, nc));
      }

      // once all the possibilites are explored
      // my result will be stored in the res if i had removed the temp.
      // so all my possibilities are explored when i removed that ele and
      // checked so i will put things back, to give scope for other spot to
      // fairly explore all the possibilites equally.
      grid[strow][stcol] = temp;

      return res;

    } // if in bound, if the things are out of bounds i will return 0

    return 0;
  }

  public static boolean inB(int[][] grid, int r, int c, int rl, int cl) {
    if (r >= 0 && r < rl && c >= 0 && c < cl && grid[r][c] != 0) {
      return true;
    }

    return false;
  }
}