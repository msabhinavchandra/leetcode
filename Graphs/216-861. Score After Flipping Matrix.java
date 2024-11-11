class Solution {
    public int matrixScore(int[][] grid) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        // maximize the leftmost bit across all the rows
        for (int row = 0; row < rowLength; row++) {
            // Matrix[row][column] must have format to remember
            // Over here we are checking the 1st column for every row so col=0
            if (grid[row][0] == 0)
                toggleRow(grid, row);
        }

        // calculate the 1s and 0s across all the columns one by one
        // of 0s > 1s then toggle that column
        for (int col = 1; col < colLength; col++) {
            // for every column u need to iterate through every row to calc 1s and 0s
            int ones = 0;
            int zeros = 0;
            for (int row = 0; row < rowLength; row++) {
                if (grid[row][col] == 1)
                    ones++;
                else
                    zeros++;
            }

            // after iterating and finding 1s and zeroes
            if (zeros > ones)
                toggleCol(grid, col);

        } // end of for - loop

        // yes it's that symbol

        // Now after the complete modification of the grid row-wise and the column-wise
        // the resultant grid will be the maximum possible value one now we need to
        // convert this
        // from the binary to decimal to calculate the final score.
        int result = 0;
        for (int row = 0; row < rowLength; row++) {
            result += convertBinaryToDecimal(grid[row]);
        }
        return result;
    }

    // function to toggle row
    public static void toggleRow(int[][] grid, int row) {
        for (int col = 0; col < grid[0].length; col++) {
            grid[row][col] = grid[row][col] == 0 ? 1 : 0;
        }
    }

    // function to toggle column
    public static void toggleCol(int[][] grid, int col) {
        // if you need to toggle a column u need to iterate through the grid row-wise
        // starting from the row 0 to the end of the row, till you reach the end for
        // that constant
        // common col value which is received from the argument
        for (int row = 0; row < grid.length; row++) {
            grid[row][col] = grid[row][col] == 0 ? 1 : 0;
        }
    }

    // function to convert from binary to decimal to calculate the whole score

    public static int convertBinaryToDecimal(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i] == 1 ? (int) Math.pow(2, arr.length - i - 1) : 0;
        }
        return result;
    }

}