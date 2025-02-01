import java.util.*;

public class OBSTRecursive {
    // A recursive function to calculate cost of optimal binary search tree
    static int optCost(int freq[], int i, int j) {
        // Base cases
        if (j < i) // no elements in this subarray
            return 0;
        if (j == i) // one element in this subarray
            return freq[i];
        // Get sum of freq[i], freq[i+1], ... freq[j]
        int sum = fsum(freq, i, j);
        // Initialize minimum value
        int min = Integer.MAX_VALUE;
        for (int r = i; r <= j; r++) {
            min = Math.min(optCost(freq, i, r - 1) + optCost(freq, r + 1, j), min);
        }
        // Return minimum value
        return min + sum;
    }

    static int optimalSearchTree(int keys[], int freq[], int n) {
        return optCost(freq, 0, n - 1);
    }

    // A utility function to get sum of array elements freq[i] to freq[j]
    static int fsum(int freq[], int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++)
            s += freq[k];
        return s;
    }

}

// memoization

// User function Template for Java

class Solution {
    static int optimalSearchTree(int keys[], int freq[], int n) {
        // code here

        int[][] dp = new int[n][n];

        for (int i = 0; i < keys.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return OBST(freq, 0, n - 1, dp);

    }

    static int OBST(int freq[], int i, int j, int dp[][]) {
        // if this function call is already computed return that value.

        if (j < i)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (i == j)
            return dp[i][j] = freq[i];

        // compute then

        int sum = fsum(freq, i, j);

        int min = Integer.MAX_VALUE;

        for (int r = i; r <= j; r++) {
            // checking for all the possibilities if all the nodes were
            // the parents
            min = Math.min(OBST(freq, i, r - 1, dp) + OBST(freq, r + 1, j, dp), min);

        }

        return dp[i][j] = min + sum;

    }

    static int fsum(int[] freq, int i, int j) {

        int sum = 0;

        for (int k = i; k <= j; k++) {
            sum += freq[k];
        }

        return sum;

    }

}

// tabulation

// User function Template for Java

class Solution2 {
    static int optimalSearchTree(int keys[], int freq[], int n) {
        // code here
        int[][] dp = new int[n][n];

        return Tabulation(freq, dp, n);

    }

    static int Tabulation(int[] freq, int[][] dp, int N) {

        for (int i = N - 1; i >= 0; i--) {

            for (int j = i; j <= N - 1; j++) {

                if (i == j) {
                    dp[i][j] = freq[i];
                    continue;
                }

                int sum = fsum(freq, i, j);

                int min = Integer.MAX_VALUE;

                // checking boundries for left

                for (int r = i; r <= j; r++) {
                    min = Math.min(
                        ((r - 1 >= i) ? dp[i][r - 1] : 0) + ((r + 1 <= j) ? dp[r + 1][j] : 0),
                            min);
                }

                dp[i][j] = min + sum;

            }

        }

        return dp[0][N - 1];

    }

    static int fsum(int[] freq, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += freq[k];
        }
        return sum;
    }

}
