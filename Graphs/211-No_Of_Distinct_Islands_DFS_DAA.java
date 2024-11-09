//Refer time and space later



// User function Template for Java

class Solution {
    static class Pair {
        int row;
        int col;
        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    int countDistinctIslands(int[][] grid) {
        int rowsize = grid.length;
        int colsize = grid[0].length;
        Set<List<String>> set = new HashSet<>();
        boolean[][] vis = new boolean[rowsize][colsize];
        for (int r = 0; r < rowsize; r++) {
            for (int c = 0; c < colsize; c++) {
                if (grid[r][c] == 1 && vis[r][c] == false) {
                    // start the dfs
                    List<String> shape = new ArrayList<>();
                    dfs(grid, r, c, r, c, shape, vis); // we found an island
                    // initially the base and the curr rows are the same
                    // when the recursive calls work for the neighbours
                    // that's when the base remains the same and the
                    // curr rows and colums will change.
                    set.add(shape);
                }
            }
        }

        return set.size();
    }
    // we will traverse through that island and store the shape in the
    // form of a pair.
    public static void dfs(int[][] grid, int br, int bc, int curr, int curc,
        List<String> shape, boolean[][] vis) {
        // if it is unvisited add it into the List of pairs
        // and mark it visited.

        shape.add(conString(curr - br, curc - bc));
        vis[curr][curc] = true;

        // the start

        // implementing the dfs in a recursive way.

        // traversing it's neighbours

        int[] rowbuf = {-1, 0, 1, 0};
        int[] colbuf = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int mrow = curr + rowbuf[i];
            int mcol = curc + colbuf[i];

            // if the neighbour is unvisited apply dfs for it.
            // until you find a node where all it's neighbours are visited.

            if (inBound(mrow, mcol, grid.length, grid[0].length)
                && vis[mrow][mcol] == false && grid[mrow][mcol] == 1) {
                dfs(grid, br, bc, mrow, mcol, shape, vis);
            }
        }
    }

    public static String conString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    public static boolean inBound(int r, int c, int rsize, int csize) {
        if (r >= 0 && c >= 0 && r < rsize && c < csize) {
            return true;
        }
        return false;
    }
}
