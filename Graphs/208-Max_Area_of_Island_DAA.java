/*A static variable can only directly access other static variables or methods within the class.

Static methods cannot directly access instance variables or instance methods. To access an instance variable or instance method, they need an instance of the class. */

//Time complexity-> O(RxC) each cell is visited atmost once. 
//Space complexity-> O(RxC) for visited array, and 
// maximum depth of resursion stack in dfs entire grid could be one large island
// leading to recursion depth of O(RxC);

class Solution {
    // iniitializing the varibles which are needed to solve the
    // problem.
    int[][] grid;// to not change the input array
    // not needed actually.
    boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int result = 0;
        visited = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1)
                    result = Math.max(result, dfs(r, c));
            } // whenever i see a 1
              // i will apply dfs over there.
        } // And will maintain a max value
          // always.
        return result;
    }

    // let's solve this problem using dfs

    public int dfs(int r, int c) {

        // base case if we see a 0 or go out of bounds

        if (r < 0 || r >= visited.length || c < 0 || c >= visited[0].length
                || grid[r][c] == 0 || visited[r][c]) {
            return 0;// there's nothing u can do about it.
        }
        // if it is not visited or inside our range.
        visited[r][c] = true;
        // return 1 + adding up the possibilities of all 4 directions.
        return (1 + dfs(r + 1, c) + dfs(r - 1, c)
                + dfs(r, c - 1) + dfs(r, c + 1));

    }

}

//Checkout other ways of solving too.